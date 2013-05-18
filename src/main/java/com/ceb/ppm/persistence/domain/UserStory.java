package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "objectid" }))
@Entity
public class UserStory extends Artifact {

	Double taskEstimateTotal;
	Double taskActualTotal;
	Double taskRemainingTotal;
	Boolean hasParent;
	Boolean amParent;
	boolean migrationComplete = false;
	long objectId;

	public long getObjectId() {
		return objectId;
	}

	public void setObjectId(long objectId) {
		this.objectId = objectId;
	}

	public boolean isMigrationComplete() {
		return migrationComplete;
	}

	public void setMigrationComplete(boolean migrationComplete) {
		this.migrationComplete = migrationComplete;
	}

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "parent_id", referencedColumnName = "id")
	List<UserStory> childUserStories = new ArrayList<UserStory>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_story_id", referencedColumnName = "id")
	List<Task> tasks = new ArrayList<Task>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_story_id", referencedColumnName = "id")
	List<Defect> defects = new ArrayList<Defect>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_story_id", referencedColumnName = "id")
	List<TestCase> testCases = new ArrayList<TestCase>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_story_id", referencedColumnName = "id")
	List<Attachment> attachments = new ArrayList<Attachment>();

	public List<UserStory> getChildUserStories() {
		return childUserStories;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public List<Defect> getDefects() {
		return defects;
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public Double getTaskEstimateTotal() {
		return taskEstimateTotal;
	}

	public void setTaskEstimateTotal(Double taskEstimateTotal) {
		this.taskEstimateTotal = taskEstimateTotal;
	}

	public Double getTaskActualTotal() {
		return taskActualTotal;
	}

	public void setTaskActualTotal(Double taskActualTotal) {
		this.taskActualTotal = taskActualTotal;
	}

	public Double getTaskRemainingTotal() {
		return taskRemainingTotal;
	}

	public void setTaskRemainingTotal(Double taskRemainingTotal) {
		this.taskRemainingTotal = taskRemainingTotal;
	}

	public Boolean getHasParent() {
		return hasParent;
	}

	public void setHasParent(Boolean hasParent) {
		this.hasParent = hasParent;
	}

	public Boolean getAmParent() {
		return amParent;
	}

	public void setAmParent(Boolean amParent) {
		this.amParent = amParent;
	}

}
