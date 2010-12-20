package com.podio.integration.zendesk.user;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;

public class UserAPI {

	// 2010/11/24 21:42:50 +0100

	private final WebResource rootResource;

	public UserAPI(WebResource rootResource) {
		super();
		this.rootResource = rootResource;
	}

	public User getCurrentUser() {
		return rootResource.path("/users/current.json")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(User.class);
	}

	public User getUser(int id) {
		return rootResource.path("/users/" + id + ".json")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(User.class);
	}
}
