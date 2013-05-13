package com.ceb.ppm.persistence.domain;

import java.util.Date;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Artifact extends Persistable {
	Date acceptedDate;

	String description;
	String formattedId;
	String name;
	String notes;
	String owner;
	String tags;
	double planEstimate;
	String priority;
	String scheduleState;
	String state;


}
