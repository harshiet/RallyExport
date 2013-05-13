package com.ceb.ppm.persistence.domain;

import javax.persistence.Entity;

@Entity
public class IterationCapacity extends Persistable {
	Double capacity;
	Double load;
	Double taskEstimates;

	public Double getCapacity() {
		return capacity;
	}

	public void setCapacity(Double capacity) {
		this.capacity = capacity;
	}

	public Double getLoad() {
		return load;
	}

	public void setLoad(Double load) {
		this.load = load;
	}

	public Double getTaskEstimates() {
		return taskEstimates;
	}

	public void setTaskEstimates(Double taskEstimates) {
		this.taskEstimates = taskEstimates;
	}

}
