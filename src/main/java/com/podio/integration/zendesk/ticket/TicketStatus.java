package com.podio.integration.zendesk.ticket;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

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

	public static TicketStatus getById(int id) {
		for (TicketStatus status : values()) {
			if (status.getId() == id) {
				return status;
			}
		}

		return null;
	}

	public static class Deserializer extends JsonDeserializer<TicketStatus> {

		@Override
		public TicketStatus deserialize(JsonParser jp,
				DeserializationContext ctxt) throws IOException,
				JsonProcessingException {
			return getById(jp.getIntValue());
		}
	}
}
