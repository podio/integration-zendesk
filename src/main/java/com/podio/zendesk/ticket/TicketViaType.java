package com.podio.zendesk.ticket;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonValue;

public enum TicketViaType {

	WEB_FORM(0),
	MAIL(4),
	WEB_SERVICE(5),
	GET_SATISFACTION(16),
	DROPBOX(17),
	RECOVERED(21),
	FORUM(24);

	private final int id;

	private TicketViaType(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	@JsonCreator
	public static TicketViaType getById(String id) {
		int intId = Integer.parseInt(id);
		for (TicketViaType viaType : values()) {
			if (viaType.getId() == intId) {
				return viaType;
			}
		}

		return null;
	}
}
