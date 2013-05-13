package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Release extends Persistable {
	String name;
	String notes;
	Date releaseDate;
	Date releaseStartDate;
	String state;
	String theme;
	String version;
	String objectId;

	@OneToOne
	RevisionHistory revisionHistory;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "release_id", referencedColumnName = "id")
	List<UserStory> userStories = new ArrayList<UserStory>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "release_id", referencedColumnName = "id")
	List<Defect> defects = new ArrayList<Defect>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "release_id", referencedColumnName = "id")
	List<Iteration> iterations = new ArrayList<Iteration>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Date getReleaseStartDate() {
		return releaseStartDate;
	}

	public void setReleaseStartDate(Date releaseStartDate) {
		this.releaseStartDate = releaseStartDate;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public RevisionHistory getRevisionHistory() {
		return revisionHistory;
	}

	public void setRevisionHistory(RevisionHistory revisionHistory) {
		this.revisionHistory = revisionHistory;
	}

	public List<UserStory> getUserStories() {
		return userStories;
	}

	public List<Defect> getDefects() {
		return defects;
	}

	public List<Iteration> getIterations() {
		return iterations;
	}

	public String getObjectId() {
		return objectId;
	}

	public void setObjectId(String objectId) {
		this.objectId = objectId;
	}

}
