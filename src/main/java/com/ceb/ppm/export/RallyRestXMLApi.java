package com.ceb.ppm.export;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.Base64;

public class RallyRestXMLApi {

	protected String server;
	protected Client client;
	protected String auth;

	public RallyRestXMLApi(String server, String username, String password) {
		this.server = server;

		auth = new String(Base64.encode(username + ":" + password));
		client = Client.create();
	}

	public String doGet(String url) {
		url = server + url;
		System.out.println("doGet: " + url);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource
				.header("Authorization", "Basic " + auth)
				.type("text/xml").accept("text/xml")
				.get(ClientResponse.class);
		return response.getEntity(String.class);

	}

	public String doGetRef(String url) {
		url = url + "?fetch=true";
		System.out.println("doGetRef: " + url);
		WebResource webResource = client.resource(url);
		ClientResponse response = webResource
				.header("Authorization", "Basic " + auth)
				.type("text/xml").accept("text/xml")
				.get(ClientResponse.class);
		return response.getEntity(String.class);

	}

	public String doPost(String url, String data) {
		System.out.println("doPost: " + server + url);
		WebResource webResource = client.resource(server + url);
		ClientResponse response = webResource
				.header("Authorization", "Basic " + auth)
				.type("text/xml").accept("text/xml")
				.post(ClientResponse.class, data);

		return response.getEntity(String.class);

	}

}
