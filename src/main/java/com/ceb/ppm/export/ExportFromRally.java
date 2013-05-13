package com.ceb.ppm.export;

import java.io.StringReader;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.stream.StreamSource;

import com.ceb.ppm.persistence.domain.Project;
import com.ceb.ppm.schema.mfw.DomainObjectType;
import com.ceb.ppm.schema.mfw.ProjectType;
import com.ceb.ppm.schema.mfw.QueryResultType;
import com.ceb.ppm.schema.mfw.ReleaseType;
import com.ceb.ppm.schema.mfw.RevisionHistoryType;
import com.ceb.ppm.schema.mfw.WSObject;

public class ExportFromRally {
	JAXBContext jc;
	Unmarshaller u;
	RallyRestXMLApi rally;
	EntityManager em;

	public static void main(String args[]) throws JAXBException {

		new ExportFromRally().export();

	}

	public ExportFromRally() throws JAXBException {
		jc = JAXBContext.newInstance("com.ceb.ppm.schema.mfw");
		u = jc.createUnmarshaller();
		rally = new RallyRestXMLApi("https://rally1.rallydev.com/slm/webservice/1.43/", "hagarwal@executiveboard.com", "harshag12");
		em = Persistence.createEntityManagerFactory("rally_export").createEntityManager();
	}

	private void export() throws JAXBException {
		List<DomainObjectType> objects = findAll("project");
		for (DomainObjectType o : objects) {
			em.getTransaction().begin();
			ProjectType projectType = findOne(o, ProjectType.class);
			Project project = Mapper.mapProject(projectType);
			for (ReleaseType releaseType : projectType.getReleases().getRelease()) {
				releaseType = findOne(releaseType, ReleaseType.class);
				RevisionHistoryType revisionHistoryType = findOne(releaseType.getRevisionHistory(), RevisionHistoryType.class);
				Mapper.addRelease(project, releaseType, revisionHistoryType);
			}
			
			em.persist(project);
			em.getTransaction().commit();
		}
	}

	private List<DomainObjectType> findAll(String objectType) throws JAXBException {
		String response = rally.doGet(objectType);
		StringBuffer xmlStr = new StringBuffer(response);
		QueryResultType results = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())), QueryResultType.class).getValue();

		List<DomainObjectType> objects = results.getResults().getObject();
		return objects;
	}

	private <T> T findOne(WSObject o, Class<T> objectClass) throws JAXBException {
		String response = rally.doGetRef(o.getRef());
		StringBuffer xmlStr = new StringBuffer(response);
		T object = u.unmarshal(new StreamSource(new StringReader(xmlStr.toString())), objectClass).getValue();

		return object;
	}
}
