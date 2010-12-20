package com.podio.integration.zendesk.ticket;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

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

	public static TicketType getById(int id) {
		for (TicketType status : values()) {
			if (status.getId() == id) {
				return status;
			}
		}

		return null;
	}

	public static class Deserializer extends JsonDeserializer<TicketType> {

		@Override
		public TicketType deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return getById(jp.getIntValue());
		}
	}
}
