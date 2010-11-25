package com.podio.zendesk.ticket;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public enum TicketVia {

	WEB_FORM(0),
	MAIL(4),
	WEB_SERVICE(5),
	GET_SATISFACTION(16),
	DROPBOX(17),
	RECOVERED(21),
	FORUM(24);

	private final int id;

	private TicketVia(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	public static TicketVia getById(int id) {
		for (TicketVia viaType : values()) {
			if (viaType.getId() == id) {
				return viaType;
			}
		}

		return null;
	}

	public static class Deserializer extends JsonDeserializer<TicketVia> {

		@Override
		public TicketVia deserialize(JsonParser jp,
				DeserializationContext ctxt) throws IOException,
				JsonProcessingException {
			return getById(jp.getIntValue());
		}
	}
}
