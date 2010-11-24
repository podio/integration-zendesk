package com.podio.zendesk.ticket;

import javax.ws.rs.core.MediaType;

import com.sun.jersey.api.client.WebResource;

public class TicketAPI {

	private final WebResource rootResource;

	public TicketAPI(WebResource rootResource) {
		super();
		this.rootResource = rootResource;
	}

	public Ticket getTicket(int id) {
		return rootResource.path("/tickets/#" + id + ".json")
				.accept(MediaType.APPLICATION_JSON_TYPE).get(Ticket.class);
	}

}
