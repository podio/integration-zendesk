package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TicketPriority {

	NONE(0),
	LOW(1),
	NORMAL(2),
	HIGH(3),
	URGENT(4);

	private final int id;

	private TicketPriority(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	@JsonCreator
	public static TicketPriority getById(int id) {
		for (TicketPriority priority : values()) {
			if (priority.getId() == id) {
				return priority;
			}
		}

		return null;
	}
}
