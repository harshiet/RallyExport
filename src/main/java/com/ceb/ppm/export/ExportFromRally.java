package com.ceb.ppm.export;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
			em.getTransaction().begin();
			Project project = Mapper.mapProject(projectType);
			Map<String, Release> projectReleases = new HashMap<String, Release>();
			Map<String, Iteration> projectIterations = new HashMap<String, Iteration>();
			em.persist(project);
			for (ReleaseType releaseType : projectType.getReleases().getRelease()) {
				releaseType = findOne(releaseType, ReleaseType.class);
				RevisionHistoryType revisionHistoryType = findOne(releaseType.getRevisionHistory(),
						RevisionHistoryType.class);
				Release release = Mapper.addRelease(project, releaseType, revisionHistoryType);
				em.persist(release);
				projectReleases.put(releaseType.getRef(), release);
			}
			for (IterationType iterationType : projectType.getIterations().getIteration()) {
				iterationType = findOne(iterationType, IterationType.class);
				Iteration iteration = Mapper.addIteration(project, iterationType);
				for (UserIterationCapacityType iterationCapacityType : iterationType.getUserIterationCapacities()
						.getUserIterationCapacity()) {
					iterationCapacityType = findOne(iterationCapacityType, UserIterationCapacityType.class);
					Mapper.addIterationCapacity(iteration, iterationCapacityType);
				}
				em.persist(iteration);
				projectIterations.put(iterationType.getRef(), iteration);
				List<DomainObjectType> userStories = findAll("hierarchicalrequirement", "(((Project.ObjectID = "
						+ projectType.getObjectID() + ") AND (Iteration.ObjectID = " + iterationType.getObjectID()
						+ ")) AND (IsParent = false))");
				for (DomainObjectType oUS : userStories) {
					HierarchicalRequirementType hierarchicalRequirementType = findOne(oUS,
							HierarchicalRequirementType.class);
					persistUserStory(project, projectReleases, hierarchicalRequirementType, iteration);
				}
				List<DomainObjectType> defects = findAll("defect", "(((Project.ObjectID = " + projectType.getObjectID()
						+ ") AND (Iteration.ObjectID = " + iterationType.getObjectID() + ")) AND (Requirement = NULL))");
				for (DomainObjectType oD : defects) {
					DefectType defectType = findOne(oD, DefectType.class);
					persistDefect(project, projectReleases, defectType, iteration, null);
				}
				em.persist(iteration);
				em.flush();
				i++;
				if (i == 4) {
					break;
				}
			}
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
			persistDefect(project, projectReleases, defectType, iteration,userStory);
		}
		for (TestCaseType testCaseType : hierarchicalRequirementType.getTestCases().getTestCase()) {
			testCaseType = findOne(testCaseType, TestCaseType.class);
			Mapper.addTestCase(userStory, null, testCaseType);
		}

		em.persist(userStory);
		project.getUserStories().add(userStory);
		Release release = findProjectReleaseForUserStory(projectReleases, hierarchicalRequirementType);
		if (release != null) {
			release.getUserStories().add(userStory);
		}
		iteration.getUserStories().add(userStory);
		if (hierarchicalRequirementType.isHasParent()) {
			HierarchicalRequirementType parentUserStoryType = hierarchicalRequirementType.getParent();
			parentUserStoryType = findOne(parentUserStoryType, HierarchicalRequirementType.class);
			Query q = em.createQuery("select u from UserStory u where u.formattedId=?1");
			q.setParameter(1, parentUserStoryType.getFormattedID());
			List result = q.getResultList();
			UserStory parentUserStory = null;
			if (result.size() > 0) {
				parentUserStory = (UserStory) result.get(0);
			} else {
				parentUserStory = persistUserStory(project, projectReleases, parentUserStoryType, iteration);
			}
			parentUserStory.getChildUserStories().add(userStory);
		}

		em.persist(userStory);
		return userStory;
	}

	private void persistDefect(Project project, Map<String, Release> projectReleases, DefectType defectType,
			Iteration iteration, UserStory userStory) throws JAXBException {
		Defect defect = Mapper.addDefect(null, defectType);
		for (TaskType taskType : defectType.getTasks().getTask()) {
			taskType = findOne(taskType, TaskType.class);
			Mapper.addTask(defect, taskType);
		}
		for (TestCaseType testCaseType : defectType.getTestCases().getTestCase()) {
			testCaseType = findOne(testCaseType, TestCaseType.class);
			Mapper.addTestCase(null, defect, testCaseType);
		}
		em.persist(defect);
		project.getDefects().add(defect);
		Release release = findProjectReleaseForDefecty(projectReleases, defectType);
		if (release != null) {
			release.getDefects().add(defect);
		}
		iteration.getDefects().add(defect);
		if(userStory != null){
			userStory.getDefects().add(defect);
		}
	}

	private Release findProjectReleaseForDefecty(Map<String, Release> projectReleases, DefectType defectType) {
		ReleaseType releaseType = defectType.getRelease();
		if (releaseType != null) {
			return projectReleases.get(releaseType.getRef());
		}
		return null;
	}

	private Iteration findProjectIterationForDefect(Map<String, Iteration> projectIterations, DefectType defectType) {
		IterationType iterationType = defectType.getIteration();
		if (iterationType != null) {
			return projectIterations.get(iterationType.getRef());
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
		String response = rally.doGet(objectType, query);
		StringBuffer xmlStr = new StringBuffer(response);
		QueryResultType results = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())),
				QueryResultType.class).getValue();

		List<DomainObjectType> objects = results.getResults().getObject();
		return objects;
	}

	private <T> T findOne(WSObject o, Class<T> objectClass) throws JAXBException {
		String response = rally.doGetRef(o.getRef());
		StringBuffer xmlStr = new StringBuffer(response);
		T object = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())), objectClass).getValue();

		return object;
	}
}
