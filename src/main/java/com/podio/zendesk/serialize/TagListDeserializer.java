package com.podio.zendesk.serialize;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class TagListDeserializer extends JsonDeserializer<List<String>> {

	@Override
	public List<String> deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		return Arrays.asList(jp.getText().split(" "));
	}
}
