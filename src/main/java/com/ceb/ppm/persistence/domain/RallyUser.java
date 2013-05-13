package com.ceb.ppm.persistence.domain;

import javax.persistence.Entity;

@Entity
public class RallyUser extends Persistable {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
