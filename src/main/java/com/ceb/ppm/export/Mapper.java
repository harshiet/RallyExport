package com.ceb.ppm.export;

import java.util.Date;

import com.ceb.ppm.persistence.domain.Project;
import com.ceb.ppm.persistence.domain.Release;
import com.ceb.ppm.persistence.domain.Revision;
import com.ceb.ppm.persistence.domain.RevisionHistory;
import com.ceb.ppm.schema.mfw.ProjectType;
import com.ceb.ppm.schema.mfw.ReleaseType;
import com.ceb.ppm.schema.mfw.RevisionHistoryType;
import com.ceb.ppm.schema.mfw.RevisionType;

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

	public static void addRelease(Project project, ReleaseType releaseType,RevisionHistoryType revisionHistoryType) {
		Release release = new Release();
		project.getReleases().add(release);
		release.setName(releaseType.getName());
		release.setNotes(releaseType.getNotes());
		release.setReleaseDate(new Date(releaseType.getReleaseDate().getMillisecond()));
		release.setReleaseStartDate(new Date(releaseType.getReleaseStartDate().getMillisecond()));
		release.setState(releaseType.getState());
		release.setTheme(releaseType.getTheme());
		release.setVersion(releaseType.getVersion());
		RevisionHistory revisionHistory = new RevisionHistory();
		release.setRevisionHistory(revisionHistory);

		for (RevisionType revisionType : revisionHistoryType.getRevisions().getRevision()) {
			Revision revision = new Revision();
			revision.setDescription(revisionType.getDescription());
			revision.setNumber(revisionType.getRevisionNumber());
			revisionHistory.getRevisions().add(revision);
		}
	}
}
