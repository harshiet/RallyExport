package com.ceb.ppm.export;

import com.ceb.ppm.persistence.domain.Iteration;
import com.ceb.ppm.persistence.domain.IterationCapacity;
import com.ceb.ppm.persistence.domain.Project;
import com.ceb.ppm.persistence.domain.Release;
import com.ceb.ppm.persistence.domain.Revision;
import com.ceb.ppm.persistence.domain.RevisionHistory;
import com.ceb.ppm.schema.mfw.IterationType;
import com.ceb.ppm.schema.mfw.ProjectType;
import com.ceb.ppm.schema.mfw.ReleaseType;
import com.ceb.ppm.schema.mfw.RevisionHistoryType;
import com.ceb.ppm.schema.mfw.RevisionType;
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
}
