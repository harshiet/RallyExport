package com.ceb.ppm.persistence.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class RevisionHistory extends Persistable {

	@OneToOne(mappedBy = "revisionHistory")
	Release release;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "rev_hist_id", referencedColumnName = "id")
	List<Revision> revisions = new ArrayList<Revision>();

	public Release getRelease() {
		return release;
	}

	public void setRelease(Release release) {
		this.release = release;
	}

	public List<Revision> getRevisions() {
		return revisions;
	}

}
