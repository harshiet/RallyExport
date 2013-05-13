package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class UserStory extends Artifact {

	Double taskEstimateTotal;
	Double taskActualTotal;
	Double taskRemainingTotal;
	
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
	

}
