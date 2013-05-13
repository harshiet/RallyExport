package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Defect extends Artifact {

	Date closedDate;
	String category;
	String rootCause;
	String environment;
	Date openedDate;
	String resolution;
	String severity;
	
	Double taskEstimateTotal;
	Double taskActualTotal;
	Double taskRemainingTotal;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "defect_id", referencedColumnName = "id")
	List<Task> tasks = new ArrayList<Task>();
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "defect_id", referencedColumnName = "id")
	List<TestCase> testCases = new ArrayList<TestCase>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "defect_id", referencedColumnName = "id")
	List<Attachment> attachments = new ArrayList<Attachment>();

	public Date getClosedDate() {
		return closedDate;
	}

	public void setClosedDate(Date closedDate) {
		this.closedDate = closedDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getRootCause() {
		return rootCause;
	}

	public void setRootCause(String rootCause) {
		this.rootCause = rootCause;
	}

	public String getEnvironment() {
		return environment;
	}

	public void setEnvironment(String environment) {
		this.environment = environment;
	}

	public Date getOpenedDate() {
		return openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public List<TestCase> getTestCases() {
		return testCases;
	}


	public List<Attachment> getAttachments() {
		return attachments;
	}

	public void setAttachments(List<Attachment> attachments) {
		this.attachments = attachments;
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
