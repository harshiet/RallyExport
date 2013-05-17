package com.ceb.ppm.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@MappedSuperclass
public abstract class Artifact extends Persistable {
	Date acceptedDate;

	@Column(columnDefinition = "TEXT")
	protected String description;
	String formattedId;
	@Column(columnDefinition = "TEXT")
	String name;
	@Column(columnDefinition = "TEXT")
	String notes;

	String owner;
	@Column(columnDefinition = "TEXT")
	String tags = ";";
	Double planEstimate;
	String priority;
	String scheduleState;
	String state;
	
	public Date getAcceptedDate() {
		return acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFormattedId() {
		return formattedId;
	}

	public void setFormattedId(String formattedId) {
		this.formattedId = formattedId;
	}

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

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getScheduleState() {
		return scheduleState;
	}

	public void setScheduleState(String scheduleState) {
		this.scheduleState = scheduleState;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Double getPlanEstimate() {
		return planEstimate;
	}

	public void setPlanEstimate(Double planEstimate) {
		this.planEstimate = planEstimate;
	}

}
