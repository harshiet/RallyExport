package com.ceb.ppm.export;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import com.ceb.ppm.persistence.domain.Attachment;

public class ReadAttachment {
	EntityManager em;

	public ReadAttachment() {
		em = Persistence.createEntityManagerFactory("rally_export").createEntityManager();
	}

	public static void main(String[] args) throws IOException {
		new ReadAttachment().read();
	}

	private void read() throws IOException {

		Attachment attach = em.find(Attachment.class, 8811);
		File f = new File(attach.getName());
		FileOutputStream fos = new FileOutputStream(f);
		fos.write(attach.getContent());
		fos.close();

	}
}
