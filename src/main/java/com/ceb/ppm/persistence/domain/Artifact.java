package com.ceb.ppm.persistence.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Artifact extends Persistable {
	Date acceptedDate;

	@Column(columnDefinition = "TEXT")
	String description;
	String formattedId;
	@Column(columnDefinition = "TEXT")
	String name;
	@Column(columnDefinition = "TEXT")
	String notes;

	String owner;
	@Column(columnDefinition = "TEXT")
	String tags;
	double planEstimate;
	String priority;
	String scheduleState;
	String state;

}
