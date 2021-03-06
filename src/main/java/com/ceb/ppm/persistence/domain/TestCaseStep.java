package com.ceb.ppm.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class TestCaseStep extends Persistable {
	@Column(columnDefinition = "TEXT")
	String expectedResult;

	@Column(columnDefinition = "TEXT")
	String input;

	long stepIndex;

	public String getExpectedResult() {
		return expectedResult;
	}

	public void setExpectedResult(String expectedResult) {
		this.expectedResult = expectedResult;
	}

	public String getInput() {
		return input;
	}

	public void setInput(String input) {
		this.input = input;
	}

	public long getStepIndex() {
		return stepIndex;
	}

	public void setStepIndex(long stepIndex) {
		this.stepIndex = stepIndex;
	}

}
