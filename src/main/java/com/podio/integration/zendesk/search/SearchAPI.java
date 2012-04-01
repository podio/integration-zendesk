package com.podio.integration.zendesk.search;

import java.util.Map;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;

public class SearchAPI {
	
	private final WebResource rootResource;

	public SearchAPI(WebResource rootResource) {
		super();
		this.rootResource = rootResource;
	}

	public SearchResult search(Map<String, String> parameters) {
		WebResource resource = rootResource.path("/rules/search.json");
		
		for (Map.Entry<String, String> entry : parameters.entrySet()) {
			resource = resource.queryParam(entry.getKey(), entry.getValue()); 
		}
		
		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				SearchResult.class);
	}
}
