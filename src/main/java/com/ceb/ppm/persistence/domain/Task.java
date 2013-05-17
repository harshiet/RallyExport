package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "user_story_id", "formattedId" }),
		@UniqueConstraint(columnNames = { "defect_id", "formattedId" }) })
@Entity
public class Task extends Artifact {

	Double actuals;
	Double estimate;
	Double toDo;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "task_id", referencedColumnName = "id")
	List<Attachment> attachments = new ArrayList<Attachment>();

	public Double getActuals() {
		return actuals;
	}

	public void setActuals(Double actuals) {
		this.actuals = actuals;
	}

	public Double getEstimate() {
		return estimate;
	}

	public void setEstimate(Double estimate) {
		this.estimate = estimate;
	}

	public Double getToDo() {
		return toDo;
	}

	public void setToDo(Double toDo) {
		this.toDo = toDo;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

}
