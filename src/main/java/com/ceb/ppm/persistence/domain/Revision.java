package com.ceb.ppm.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Revision extends Persistable {
	@Column(columnDefinition = "TEXT")
	String description;
	long number;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

}
