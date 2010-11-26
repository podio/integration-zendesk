package com.podio.zendesk.ticket;

import java.util.List;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;

public class TicketAPI {

	// 2010/11/24 21:42:50 +0100

	private final WebResource rootResource;

	public TicketAPI(WebResource rootResource) {
		super();
		this.rootResource = rootResource;
	}

	public Ticket getTicket(int id) {
		return rootResource.path("/tickets/" + id + ".json")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Ticket.class);
	}

	public List<Ticket> getTickets(int viewId, Integer page) {
		WebResource resource = rootResource.path("/rules/" + viewId + ".json");
		if (page != null) {
			resource = resource.queryParam("page", page.toString());
		}

		return resource.accept(MediaType.APPLICATION_JSON_TYPE).get(
				new GenericType<List<Ticket>>() {
				});
	}
}
