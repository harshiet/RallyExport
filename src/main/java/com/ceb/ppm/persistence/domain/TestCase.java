package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class TestCase extends Persistable {
	String lastVerdict;

	@Column(columnDefinition = "TEXT")
	String objective;

	@Column(columnDefinition = "TEXT")
	String postConditions;

	@Column(columnDefinition = "TEXT")
	String preConditions;

	String priority;
	String type;
	@Column(columnDefinition = "TEXT")
	String validationExpectedResult;
	@Column(columnDefinition = "TEXT")
	String validationInput;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_case_id", referencedColumnName = "id")
	List<Attachment> attachments = new ArrayList<Attachment>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "test_case_id", referencedColumnName = "id")
	List<TestCaseStep> steps = new ArrayList<TestCaseStep>();

	public String getLastVerdict() {
		return lastVerdict;
	}

	public void setLastVerdict(String lastVerdict) {
		this.lastVerdict = lastVerdict;
	}

	public String getObjective() {
		return objective;
	}

	public void setObjective(String objective) {
		this.objective = objective;
	}

	public String getPostConditions() {
		return postConditions;
	}

	public void setPostConditions(String postConditions) {
		this.postConditions = postConditions;
	}

	public String getPreConditions() {
		return preConditions;
	}

	public void setPreConditions(String preConditions) {
		this.preConditions = preConditions;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getValidationExpectedResult() {
		return validationExpectedResult;
	}

	public void setValidationExpectedResult(String validationExpectedResult) {
		this.validationExpectedResult = validationExpectedResult;
	}

	public String getValidationInput() {
		return validationInput;
	}

	public void setValidationInput(String validationInput) {
		this.validationInput = validationInput;
	}

	public List<Attachment> getAttachments() {
		return attachments;
	}

	public List<TestCaseStep> getSteps() {
		return steps;
	}

}
