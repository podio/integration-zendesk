package com.podio.zendesk.user;

import java.io.IOException;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JsonValue;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public enum UserRole {

	END_USER(0),
	ADMINISTRATOR(2),
	AGENT(4);

	private final int id;

	private UserRole(int id) {
		this.id = id;
	}

	@JsonValue
	public int getId() {
		return id;
	}

	public static UserRole getById(int id) {
		for (UserRole role : values()) {
			if (role.getId() == id) {
				return role;
			}
		}

		return null;
	}

	public static class Deserializer extends JsonDeserializer<UserRole> {

		@Override
		public UserRole deserialize(JsonParser jp, DeserializationContext ctxt)
				throws IOException, JsonProcessingException {
			return getById(jp.getIntValue());
		}
	}
}
