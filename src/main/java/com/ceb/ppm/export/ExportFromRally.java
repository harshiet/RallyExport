package com.ceb.ppm.export;

import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
import com.ceb.ppm.persistence.domain.Task;
import com.ceb.ppm.persistence.domain.TestCase;
import com.ceb.ppm.persistence.domain.UserStory;
import com.ceb.ppm.schema.mfw.AttachmentContentType;
import com.ceb.ppm.schema.mfw.AttachmentType;
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
	long timeStart = 0;

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
		List<DomainObjectType> objects = findAll("project");
		for (DomainObjectType o : objects) {
			ProjectType projectType = findOne(o, ProjectType.class);
			Query qP = em
					.createQuery("select p from Project p where p.objectId = :objectId and migrationComplete = true");
			qP.setParameter("objectId", projectType.getObjectID());
			try {
				qP.getSingleResult();
				continue;
			} catch (NoResultException nre) {
			}

			List<DomainObjectType> userStoriesAll = findAll("hierarchicalrequirement", "(Project.ObjectID = "
					+ projectType.getObjectID() + ")");
			List<DomainObjectType> defectsAll = findAll("defect", "(Project.ObjectID = " + projectType.getObjectID()
					+ ")");
			totalArtifacts = userStoriesAll.size() + defectsAll.size();
			artifactIndex = 0;
			userStoriesAll = null;
			defectsAll = null;
			System.gc();
			em.getTransaction().begin();
			Project project = Mapper.mapProject(projectType);
			Map<String, Release> projectReleases = new HashMap<String, Release>();
			em.persist(project);
			em.getTransaction().commit();
			for (ReleaseType releaseType : projectType.getReleases().getRelease()) {
				Release release;
				Query q = em.createQuery("select rel from Release rel where rel.objectId = :objectId");
				q.setParameter("objectId", releaseType.getObjectID());
				try {
					release = (Release) q.getSingleResult();
				} catch (NoResultException nre) {
					em.getTransaction().begin();
					releaseType = findOne(releaseType, ReleaseType.class);
					RevisionHistoryType revisionHistoryType = findOne(releaseType.getRevisionHistory(),
							RevisionHistoryType.class);
					release = Mapper.addRelease(project, releaseType, revisionHistoryType);
					em.persist(release);
					em.getTransaction().commit();
				}

				projectReleases.put(releaseType.getRef(), release);

			}
			timeStart = System.currentTimeMillis();

			for (IterationType iterationType : projectType.getIterations().getIteration()) {

				Query q = em.createQuery("select i from Iteration i where i.objectId = :objectId");
				q.setParameter("objectId", iterationType.getObjectID());
				try {
					Iteration i = (Iteration) q.getSingleResult();
					if (i.isMigrationComplete()) {
						continue;
					} else {
						em.getTransaction().begin();
						em.remove(i);
						em.getTransaction().commit();
					}

				} catch (NoResultException nre) {
				}

				System.gc();

				em.getTransaction().begin();
				iterationType = findOne(iterationType, IterationType.class);
				Iteration iteration = Mapper.addIteration(project, iterationType);
				for (UserIterationCapacityType iterationCapacityType : iterationType.getUserIterationCapacities()
						.getUserIterationCapacity()) {
					iterationCapacityType = findOne(iterationCapacityType, UserIterationCapacityType.class);
					Mapper.addIterationCapacity(iteration, iterationCapacityType);
				}
				List<DomainObjectType> userStories = findAll("hierarchicalrequirement", "(((Project.ObjectID = "
						+ projectType.getObjectID() + ") AND (Iteration.ObjectID = " + iterationType.getObjectID()
						+ ")) AND (Parent = NULL))");
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
				iteration.setMigrationComplete(true);
				em.persist(iteration);
				em.getTransaction().commit();
			}

			em.getTransaction().begin();
			migrateNonIterationItems(projectType, project, projectReleases);
			project.setMigrationComplete(true);
			em.persist(project);
			em.getTransaction().commit();
			return;
		}
	}

	private void migrateNonIterationItems(ProjectType projectType, Project project, Map<String, Release> projectReleases)
			throws JAXBException, UnsupportedEncodingException {
		List<DomainObjectType> userStories = findAll("hierarchicalrequirement",
				"(((Project.ObjectID = " + projectType.getObjectID() + ") AND (Iteration = NULL)) AND (Parent = NULL))");
		userStories.addAll(findAll("hierarchicalrequirement", "(((Project.ObjectID = " + projectType.getObjectID()
				+ ") AND (Parent != NULL)) AND (Parent.Project.ObjectID != " + projectType.getObjectID() + "))"));
		for (DomainObjectType oUS : userStories) {
			HierarchicalRequirementType hierarchicalRequirementType = findOne(oUS, HierarchicalRequirementType.class);
			checkAndPersistUserStory(project, projectReleases, hierarchicalRequirementType);
		}
		List<DomainObjectType> defects = findAll("defect", "(((Project.ObjectID = " + projectType.getObjectID()
				+ ") AND (Iteration = NULL)) AND (Requirement = NULL))");
		defects.addAll(findAll("defect", "((Project.ObjectID = " + projectType.getObjectID()
				+ ") AND (Requirement.Project.ObjectID != " + projectType.getObjectID() + "))"));
		for (DomainObjectType oD : defects) {
			DefectType defectType = findOne(oD, DefectType.class);
			checkAndPersistDefect(project, projectReleases, defectType);
		}

	}

	private void checkAndPersistDefect(Project project, Map<String, Release> projectReleases, DefectType defectType)
			throws JAXBException {
		Defect d;
		Query q = em.createQuery("select d from Defect d where d.objectId = :objectId");
		q.setParameter("objectId", defectType.getObjectID());
		try {
			d = (Defect) q.getSingleResult();
			if (d.isMigrationComplete()) {
				return;
			} else {
				em.getTransaction().begin();
				em.remove(d);
				em.getTransaction().commit();
			}
		} catch (NoResultException nre) {

		}

		d = persistDefect(project, projectReleases, defectType, null, null);
		em.getTransaction().begin();
		d.setMigrationComplete(true);
		em.persist(d);
		em.getTransaction().commit();

	}

	private void checkAndPersistUserStory(Project project, Map<String, Release> projectReleases,
			HierarchicalRequirementType hierarchicalRequirementType) throws JAXBException {
		UserStory us;
		Query q = em.createQuery("select us from UserStory us where us.objectId = :objectId");
		q.setParameter("objectId", hierarchicalRequirementType.getObjectID());
		try {
			us = (UserStory) q.getSingleResult();
			if (us.isMigrationComplete()) {
				return;
			} else {
				em.getTransaction().begin();
				em.remove(us);
				em.getTransaction().commit();
			}
		} catch (NoResultException nre) {

		}

		us = persistUserStory(project, projectReleases, hierarchicalRequirementType, null);
		em.getTransaction().begin();
		us.setMigrationComplete(true);
		em.persist(us);
		em.getTransaction().commit();
	}

	private UserStory persistUserStory(Project project, Map<String, Release> projectReleases,
			HierarchicalRequirementType hierarchicalRequirementType, Iteration iteration) throws JAXBException {
		UserStory userStory = Mapper.mapUserStory(hierarchicalRequirementType);
		for (TaskType taskType : hierarchicalRequirementType.getTasks().getTask()) {
			taskType = persistTask(userStory, null, taskType);
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
			testCaseType = persistTestCase(userStory, null, testCaseType);
		}
		for (AttachmentType attachmentType : hierarchicalRequirementType.getAttachments().getAttachment()) {
			persistAttachment(userStory, null, null, null, attachmentType);
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

	private TestCaseType persistTestCase(UserStory userStory, Defect defect, TestCaseType testCaseType)
			throws JAXBException {
		testCaseType = findOne(testCaseType, TestCaseType.class);
		TestCase testCase = Mapper.addTestCase(userStory, defect, testCaseType);
		for (AttachmentType attachmentType : testCaseType.getAttachments().getAttachment()) {
			persistAttachment(null, null, null, testCase, attachmentType);
		}

		return testCaseType;
	}

	private void persistAttachment(UserStory userStory, Defect defect, Task task, TestCase testCase,
			AttachmentType attachmentType) throws JAXBException {
		persistAttachmentInner(userStory, defect, task, testCase, attachmentType);
		System.gc();
	}

	private AttachmentType persistAttachmentInner(UserStory userStory, Defect defect, Task task, TestCase testCase,
			AttachmentType attachmentType) throws JAXBException {
		attachmentType = findOne(attachmentType, AttachmentType.class);
		byte[] content = findOne(attachmentType.getContent(), AttachmentContentType.class).getContent();
		Mapper.addAttachment(userStory, defect, task, testCase, attachmentType, content);
		return attachmentType;
	}

	private TaskType persistTask(UserStory userStory, Defect defect, TaskType taskType) throws JAXBException {
		taskType = findOne(taskType, TaskType.class);
		Task task = Mapper.addTask(userStory, defect, taskType);
		for (AttachmentType attachmentType : taskType.getAttachments().getAttachment()) {
			persistAttachment(null, null, task, null, attachmentType);
		}

		return taskType;
	}

	private Defect persistDefect(Project project, Map<String, Release> projectReleases, DefectType defectType,
			Iteration iteration, UserStory userStory) throws JAXBException {
		Defect defect = Mapper.addDefect(userStory, defectType);
		for (TaskType taskType : defectType.getTasks().getTask()) {
			taskType = persistTask(null, defect, taskType);
		}
		for (TestCaseType testCaseType : defectType.getTestCases().getTestCase()) {
			testCaseType = persistTestCase(null, defect, testCaseType);
		}
		for (AttachmentType attachmentType : defectType.getAttachments().getAttachment()) {
			persistAttachment(null, defect, null, null, attachmentType);
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
		em.persist(defect);
		return defect;
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

	private void progressIndicator() {
		artifactIndex++;
		int percentage = (artifactIndex * 100) / totalArtifacts;
		long timeRemaining = -1;
		timeRemaining = ((((System.currentTimeMillis() - timeStart)) / artifactIndex) * (totalArtifacts - artifactIndex))
				/ (1000 * 60);
		System.out.println("Progress: [" + percentage + "%] [Elapsed:" + (System.currentTimeMillis() - timeStart)
				/ (1000 * 60) + ", Remaining: " + timeRemaining + "]" + "[" + artifactIndex + "/" + totalArtifacts
				+ "] ");
	}

}
