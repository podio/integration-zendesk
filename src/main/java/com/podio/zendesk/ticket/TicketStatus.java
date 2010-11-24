package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TicketStatus {

	NEW(0),
	OPEN(1),
	PENDING(2),
	SOLVED(3),
	CLOSED(4);

	private final int id;

	private TicketStatus(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	@JsonCreator
	public static TicketStatus getById(int id) {
		for (TicketStatus status : values()) {
			if (status.getId() == id) {
				return status;
			}
		}

		return null;
	}
}
