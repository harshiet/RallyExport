package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Task extends Artifact {

	double actuals;
	double estimate;
	double toDo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id", referencedColumnName = "id")
	List<Attachment> attachments = new ArrayList<Attachment>();

	public double getActuals() {
		return actuals;
	}

	public void setActuals(double actuals) {
		this.actuals = actuals;
	}

	public double getEstimate() {
		return estimate;
	}

	public void setEstimate(double estimate) {
		this.estimate = estimate;
	}

	public double getToDo() {
		return toDo;
	}

	public void setToDo(double toDo) {
		this.toDo = toDo;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

}
