package com.ceb.ppm.export;

import java.util.Arrays;

import com.ceb.ppm.persistence.domain.Defect;
import com.ceb.ppm.persistence.domain.Iteration;
import com.ceb.ppm.persistence.domain.IterationCapacity;
import com.ceb.ppm.persistence.domain.Project;
import com.ceb.ppm.persistence.domain.Release;
import com.ceb.ppm.persistence.domain.Revision;
import com.ceb.ppm.persistence.domain.RevisionHistory;
import com.ceb.ppm.persistence.domain.Task;
import com.ceb.ppm.persistence.domain.TestCase;
import com.ceb.ppm.persistence.domain.UserStory;
import com.ceb.ppm.schema.mfw.DefectType;
import com.ceb.ppm.schema.mfw.HierarchicalRequirementType;
import com.ceb.ppm.schema.mfw.IterationType;
import com.ceb.ppm.schema.mfw.ProjectType;
import com.ceb.ppm.schema.mfw.ReleaseType;
import com.ceb.ppm.schema.mfw.RevisionHistoryType;
import com.ceb.ppm.schema.mfw.RevisionType;
import com.ceb.ppm.schema.mfw.TaskType;
import com.ceb.ppm.schema.mfw.TestCaseType;
import com.ceb.ppm.schema.mfw.UserIterationCapacityType;

public class Mapper {
	public static Project mapProject(ProjectType projectType) {
		Project project = new Project();
		project.setName(projectType.getName());
		project.setDescription(projectType.getDescription());
		project.setNotes(projectType.getNotes());
		project.setOwner(projectType.getOwner().getDisplayName());
		project.setState(projectType.getState());
		return project;

	}

	public static Release addRelease(Project project, ReleaseType releaseType, RevisionHistoryType revisionHistoryType) {
		Release release = new Release();
		project.getReleases().add(release);
		release.setName(releaseType.getName());
		release.setNotes(releaseType.getNotes());
		release.setReleaseDate(releaseType.getReleaseDate().toGregorianCalendar().getTime());
		release.setReleaseStartDate(releaseType.getReleaseStartDate().toGregorianCalendar().getTime());
		release.setState(releaseType.getState());
		release.setTheme(releaseType.getTheme());
		release.setVersion(releaseType.getVersion());
		release.setObjectId(releaseType.getObjectID());
		RevisionHistory revisionHistory = new RevisionHistory();
		release.setRevisionHistory(revisionHistory);

		for (RevisionType revisionType : revisionHistoryType.getRevisions().getRevision()) {
			Revision revision = new Revision();
			revision.setDescription(revisionType.getDescription());
			revision.setNumber(revisionType.getRevisionNumber());
			revisionHistory.getRevisions().add(revision);
		}
		return release;
	}

	public static Iteration addIteration(Project project, IterationType iterationType) {
		Iteration iteration = new Iteration();
		project.getIterations().add(iteration);
		iteration.setEndDate(iterationType.getEndDate().toGregorianCalendar().getTime());
		iteration.setName(iterationType.getName());
		iteration.setNotes(iterationType.getNotes());
		iteration.setStartDate(iterationType.getStartDate().toGregorianCalendar().getTime());
		iteration.setState(iterationType.getState());
		iteration.setTheme(iterationType.getTheme());
		iteration.setObjectId(iterationType.getObjectID());

		return iteration;
	}

	public static IterationCapacity addIterationCapacity(Iteration iteration, UserIterationCapacityType iterationCapacityType) {
		IterationCapacity iterationCapacity = new IterationCapacity();
		iteration.getIterationCapacities().add(iterationCapacity);
		iterationCapacity.setCapacity(iterationCapacityType.getCapacity());
		iterationCapacity.setLoad(iterationCapacityType.getLoad());
		iterationCapacity.setTaskEstimates(iterationCapacityType.getTaskEstimates());

		return iterationCapacity;

	}

	public static UserStory mapUserStory(HierarchicalRequirementType hierarchicalRequirementType) {
		UserStory userStory = new UserStory();
		userStory.setAcceptedDate(hierarchicalRequirementType.getAcceptedDate() == null ? null : hierarchicalRequirementType.getAcceptedDate().toGregorianCalendar().getTime());
		userStory.setDescription(hierarchicalRequirementType.getDescription());
		userStory.setFormattedId(hierarchicalRequirementType.getFormattedID());
		userStory.setName(hierarchicalRequirementType.getName());
		userStory.setNotes(hierarchicalRequirementType.getNotes());
		userStory.setOwner(hierarchicalRequirementType.getOwner().getDisplayName());
		userStory.setPlanEstimate(hierarchicalRequirementType.getPlanEstimate());
		userStory.setScheduleState(hierarchicalRequirementType.getScheduleState());
		userStory.setTags(Arrays.toString(hierarchicalRequirementType.getTags().getTag().toArray()));
		userStory.setTaskActualTotal(hierarchicalRequirementType.getTaskActualTotal());
		userStory.setTaskEstimateTotal(hierarchicalRequirementType.getTaskEstimateTotal());
		userStory.setTaskRemainingTotal(hierarchicalRequirementType.getTaskRemainingTotal());
		return userStory;
	}

	public static Task addTask(UserStory userStory, TaskType taskType) {
		Task task = new Task();
		task.setActuals(taskType.getActuals());
		task.setDescription(taskType.getDescription());
		task.setEstimate(taskType.getEstimate());
		task.setFormattedId(taskType.getFormattedID());
		task.setName(taskType.getName());
		task.setNotes(taskType.getNotes());
		task.setState(taskType.getState());
		task.setToDo(taskType.getToDo());
		userStory.getTasks().add(task);
		return task;
	}

	public static Defect addDefect(UserStory userStory, DefectType defectType) {
		Defect defect = new Defect();
		userStory.getDefects().add(defect);
		defect.setCategory(defectType.getDefectCategory());
		defect.setClosedDate(defectType.getClosedDate() == null ? null : defectType.getClosedDate().toGregorianCalendar().getTime());
		defect.setDescription(defectType.getDescription());
		defect.setEnvironment(defectType.getEnvironment());
		defect.setFormattedId(defectType.getFormattedID());
		defect.setName(defectType.getName());
		defect.setNotes(defectType.getNotes());
		defect.setOpenedDate(defectType.getOpenedDate() == null ? null : defectType.getOpenedDate().toGregorianCalendar().getTime());
		defect.setPlanEstimate(defectType.getPlanEstimate());
		defect.setPriority(defectType.getPriority());
		defect.setResolution(defectType.getResolution());
		defect.setRootCause(defectType.getDefectRootCause());
		defect.setScheduleState(defectType.getScheduleState());
		defect.setSeverity(defectType.getSeverity());
		defect.setState(defectType.getState());
		defect.setTaskActualTotal(defectType.getTaskActualTotal());
		defect.setTaskEstimateTotal(defectType.getTaskEstimateTotal());
		defect.setTaskRemainingTotal(defectType.getTaskRemainingTotal());
		return defect;
	}

	public static TestCase addTestCase(UserStory userStory, TestCaseType testCaseType) {
		TestCase testCase = new TestCase();
		userStory.getTestCases().add(testCase);
		testCase.setLastVerdict(testCaseType.getLastVerdict());
		testCase.setObjective(testCaseType.getObjective());
		testCase.setPostConditions(testCaseType.getPostConditions());
		testCase.setPreConditions(testCaseType.getPreConditions());
		testCase.setPriority(testCaseType.getPriority());
		testCase.setType(testCaseType.getType());
		testCase.setValidationExpectedResult(testCaseType.getValidationExpectedResult());
		testCase.setValidationInput(testCaseType.getValidationInput());
		return testCase;
	}
}
