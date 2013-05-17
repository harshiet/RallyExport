package com.ceb.ppm.export;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.ceb.ppm.persistence.domain.Defect;
import com.ceb.ppm.persistence.domain.Iteration;
import com.ceb.ppm.persistence.domain.Project;
import com.ceb.ppm.persistence.domain.Release;
import com.ceb.ppm.persistence.domain.UserStory;
import com.ceb.ppm.schema.mfw.DefectType;
import com.ceb.ppm.schema.mfw.DomainObjectType;
import com.ceb.ppm.schema.mfw.HierarchicalRequirementType;
import com.ceb.ppm.schema.mfw.IterationType;
import com.ceb.ppm.schema.mfw.ProjectType;
import com.ceb.ppm.schema.mfw.QueryResultType;
import com.ceb.ppm.schema.mfw.ReleaseType;
import com.ceb.ppm.schema.mfw.RevisionHistoryType;
import com.ceb.ppm.schema.mfw.TaskType;
import com.ceb.ppm.schema.mfw.TestCaseType;
import com.ceb.ppm.schema.mfw.UserIterationCapacityType;
import com.ceb.ppm.schema.mfw.WSObject;

public class ExportFromRally {

	JAXBContext jc;
	Unmarshaller u;
	RallyRestXMLApi rally;
	EntityManager em;
	static int totalArtifacts = 0;
	static int artifactIndex = 0;

	public static void main(String args[]) throws JAXBException, UnsupportedEncodingException {

		new ExportFromRally().export();

	}

	public ExportFromRally() throws JAXBException {
		jc = JAXBContext.newInstance("com.ceb.ppm.schema.mfw");
		u = jc.createUnmarshaller();
		rally = new RallyRestXMLApi("https://rally1.rallydev.com/slm/webservice/1.43/", "hagarwal@executiveboard.com",
				"harshag12");
		em = Persistence.createEntityManagerFactory("rally_export").createEntityManager();
	}

	private void export() throws JAXBException, UnsupportedEncodingException {
		int i = 0;
		List<DomainObjectType> objects = findAll("project");
		for (DomainObjectType o : objects) {
			ProjectType projectType = findOne(o, ProjectType.class);
			if (!projectType.getRefObjectName().equals("Workspace")) {
				continue;
			}
			List<DomainObjectType> userStoriesAll = findAll("hierarchicalrequirement", "(Project.ObjectID = "
					+ projectType.getObjectID() + ")");
			List<DomainObjectType> defectsAll = findAll("defect", "(Project.ObjectID = " + projectType.getObjectID()
					+ ")");
			totalArtifacts = userStoriesAll.size() + defectsAll.size();
			artifactIndex = 0;
			em.getTransaction().begin();
			Project project = Mapper.mapProject(projectType);
			Map<String, Release> projectReleases = new HashMap<String, Release>();
			em.persist(project);
			em.getTransaction().commit();
			for (ReleaseType releaseType : projectType.getReleases().getRelease()) {
				em.getTransaction().begin();
				releaseType = findOne(releaseType, ReleaseType.class);
				RevisionHistoryType revisionHistoryType = findOne(releaseType.getRevisionHistory(),
						RevisionHistoryType.class);
				Release release = Mapper.addRelease(project, releaseType, revisionHistoryType);
				em.persist(release);
				projectReleases.put(releaseType.getRef(), release);
				em.getTransaction().commit();
			}

			for (IterationType iterationType : projectType.getIterations().getIteration()) {
				em.getTransaction().begin();
				iterationType = findOne(iterationType, IterationType.class);
				Iteration iteration = Mapper.addIteration(project, iterationType);
				for (UserIterationCapacityType iterationCapacityType : iterationType.getUserIterationCapacities()
						.getUserIterationCapacity()) {
					iterationCapacityType = findOne(iterationCapacityType, UserIterationCapacityType.class);
					Mapper.addIterationCapacity(iteration, iterationCapacityType);
				}
				em.persist(iteration);
				em.getTransaction().commit();

				List<DomainObjectType> userStories = findAll("hierarchicalrequirement", "(((Project.ObjectID = "
						+ projectType.getObjectID() + ") AND (Iteration.ObjectID = " + iterationType.getObjectID()
						+ ")) AND (Parent = NULL))");
				for (DomainObjectType oUS : userStories) {
					em.getTransaction().begin();
					HierarchicalRequirementType hierarchicalRequirementType = findOne(oUS,
							HierarchicalRequirementType.class);
					persistUserStory(project, projectReleases, hierarchicalRequirementType, iteration);
					em.getTransaction().commit();
				}
				List<DomainObjectType> defects = findAll("defect", "(((Project.ObjectID = " + projectType.getObjectID()
						+ ") AND (Iteration.ObjectID = " + iterationType.getObjectID() + ")) AND (Requirement = NULL))");
				for (DomainObjectType oD : defects) {
					em.getTransaction().begin();
					DefectType defectType = findOne(oD, DefectType.class);
					persistDefect(project, projectReleases, defectType, iteration, null);
					em.getTransaction().commit();
				}
				em.getTransaction().begin();
				em.persist(iteration);
				em.flush();
				em.getTransaction().commit();
			}
			em.getTransaction().begin();
			List<DomainObjectType> userStories = findAll("hierarchicalrequirement", "(((Project.ObjectID = "
					+ projectType.getObjectID() + ") AND (Iteration = NULL)) AND (Parent = NULL))");
			for (DomainObjectType oUS : userStories) {
				HierarchicalRequirementType hierarchicalRequirementType = findOne(oUS,
						HierarchicalRequirementType.class);
				persistUserStory(project, projectReleases, hierarchicalRequirementType, null);
			}
			em.getTransaction().commit();

			em.getTransaction().begin();
			List<DomainObjectType> defects = findAll("defect", "(((Project.ObjectID = " + projectType.getObjectID()
					+ ") AND (Iteration = NULL)) AND (Requirement = NULL))");
			for (DomainObjectType oD : defects) {
				DefectType defectType = findOne(oD, DefectType.class);
				persistDefect(project, projectReleases, defectType, null, null);
			}
			em.getTransaction().commit();

			em.getTransaction().begin();
			em.persist(project);
			em.getTransaction().commit();
			return;
		}
	}

	private UserStory persistUserStory(Project project, Map<String, Release> projectReleases,
			HierarchicalRequirementType hierarchicalRequirementType, Iteration iteration) throws JAXBException {
		UserStory userStory = Mapper.mapUserStory(hierarchicalRequirementType);
		for (TaskType taskType : hierarchicalRequirementType.getTasks().getTask()) {
			taskType = findOne(taskType, TaskType.class);
			Mapper.addTask(userStory, taskType);
		}
		for (DefectType defectType : hierarchicalRequirementType.getDefects().getDefect()) {
			defectType = findOne(defectType, DefectType.class);
			if (defectType.getRequirement() != null) {
				String reqRef = defectType.getRequirement().getRef();
				Long reqObjectID = Long.parseLong(reqRef.substring(reqRef.lastIndexOf('/') + 1));
				if (reqObjectID.equals(hierarchicalRequirementType.getObjectID())) {
					persistDefect(project, projectReleases, defectType, iteration, userStory);
				}
			}
		}
		for (TestCaseType testCaseType : hierarchicalRequirementType.getTestCases().getTestCase()) {
			testCaseType = findOne(testCaseType, TestCaseType.class);
			Mapper.addTestCase(userStory, null, testCaseType);
		}

		em.persist(userStory);
		progressIndicator();

		project.getUserStories().add(userStory);
		Release release = findProjectReleaseForUserStory(projectReleases, hierarchicalRequirementType);
		if (release != null) {
			release.getUserStories().add(userStory);
		}
		if (iteration != null) {
			iteration.getUserStories().add(userStory);
		}

		for (HierarchicalRequirementType childUserStoryType : hierarchicalRequirementType.getChildren()
				.getHierarchicalRequirement()) {
			childUserStoryType = findOne(childUserStoryType, HierarchicalRequirementType.class);
			persistUserStory(project, projectReleases, childUserStoryType, iteration);
		}
		em.persist(userStory);
		return userStory;
	}

	private void progressIndicator() {
		artifactIndex++;
		System.out.println("% Complete: " + artifactIndex + " / " + totalArtifacts + " : " + (artifactIndex * 100)
				/ totalArtifacts);
	}

	private void persistDefect(Project project, Map<String, Release> projectReleases, DefectType defectType,
			Iteration iteration, UserStory userStory) throws JAXBException {
		Defect defect = Mapper.addDefect(userStory, defectType);
		for (TaskType taskType : defectType.getTasks().getTask()) {
			taskType = findOne(taskType, TaskType.class);
			Mapper.addTask(defect, taskType);
		}
		for (TestCaseType testCaseType : defectType.getTestCases().getTestCase()) {
			testCaseType = findOne(testCaseType, TestCaseType.class);
			Mapper.addTestCase(null, defect, testCaseType);
		}
		em.persist(defect);
		progressIndicator();

		project.getDefects().add(defect);
		Release release = findProjectReleaseForDefecty(projectReleases, defectType);
		if (release != null) {
			release.getDefects().add(defect);
		}
		if (iteration != null) {
			iteration.getDefects().add(defect);
		}
	}

	private Release findProjectReleaseForDefecty(Map<String, Release> projectReleases, DefectType defectType) {
		ReleaseType releaseType = defectType.getRelease();
		if (releaseType != null) {
			return projectReleases.get(releaseType.getRef());
		}
		return null;
	}

	private Release findProjectReleaseForUserStory(Map<String, Release> projectReleases,
			HierarchicalRequirementType hierarchicalRequirementType) {
		ReleaseType releaseType = hierarchicalRequirementType.getRelease();
		if (releaseType != null) {
			return projectReleases.get(releaseType.getRef());
		}
		return null;
	}

	private List<DomainObjectType> findAll(String objectType) throws JAXBException, UnsupportedEncodingException {
		return findAll(objectType, null);
	}

	private List<DomainObjectType> findAll(String objectType, String query) throws JAXBException,
			UnsupportedEncodingException {
		List<DomainObjectType> allObjects = new ArrayList<DomainObjectType>();
		long startIndex = 1;
		int pageSize = 100;
		long remaining = pageSize;
		int pageNumber = 0;
		while (remaining > 0) {
			startIndex = pageSize * pageNumber + 1;
			String response = rally.doGet(objectType, query, startIndex, pageSize);
			StringBuffer xmlStr = new StringBuffer(response);
			QueryResultType results = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())),
					QueryResultType.class).getValue();
			List<DomainObjectType> objects = results.getResults().getObject();
			allObjects.addAll(objects);
			pageNumber++;
			remaining = results.getTotalResultCount() - pageSize * pageNumber;
		}
		return allObjects;
	}

	private <T> T findOne(WSObject o, Class<T> objectClass) throws JAXBException {
		String response = rally.doGetRef(o.getRef());
		StringBuffer xmlStr = new StringBuffer(response);
		T object = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())), objectClass).getValue();

		return object;
	}
}
