package com.ceb.ppm.persistence.domain;

import javax.persistence.Entity;

@Entity
public class IterationCapacity extends Persistable {
	double capacity;
	double load;
	double taskEstimates;

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}

	public double getLoad() {
		return load;
	}

	public void setLoad(double load) {
		this.load = load;
	}

	public double getTaskEstimates() {
		return taskEstimates;
	}

	public void setTaskEstimates(double taskEstimates) {
		this.taskEstimates = taskEstimates;
	}

}
