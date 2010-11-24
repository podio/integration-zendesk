package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TicketType {

	NONE(0),
	QUESTION(1),
	INCIDENT(2),
	PROBLEM(3),
	TASK(4);

	private final int id;

	private TicketType(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	@JsonCreator
	public static TicketType getById(String id) {
		int intId = Integer.parseInt(id);
		for (TicketType status : values()) {
			if (status.getId() == intId) {
				return status;
			}
		}

		return null;
	}
}
