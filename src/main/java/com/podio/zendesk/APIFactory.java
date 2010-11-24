package com.podio.zendesk;

import java.net.URI;
import java.net.URISyntaxException;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;

import com.podio.zendesk.serialize.DateTimeDeserializer;
import com.podio.zendesk.serialize.DateTimeSerializer;
import com.podio.zendesk.ticket.TicketAPI;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class APIFactory {

	private final WebResource rootResource;

	public APIFactory(String hostname, int port, boolean ssl, String username,
			String password) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		Client client = Client.create(config);

		this.rootResource = client.resource(getURI(hostname, port, ssl));
		this.rootResource
				.addFilter(new HTTPBasicAuthFilter(username, password));
	}

	private URI getURI(String hostname, int port, boolean ssl) {
		try {
			return new URI(ssl ? "https" : "http", null, hostname, port, null,
					null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private JacksonJsonProvider getJsonProvider() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);

		CustomSerializerFactory serializerFactory = new CustomSerializerFactory();
		serializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeSerializer());
		mapper.setSerializerFactory(serializerFactory);

		CustomDeserializerFactory deserializerFactory = new CustomDeserializerFactory();
		deserializerFactory.addSpecificMapping(DateTime.class,
				new DateTimeDeserializer());
		mapper.setDeserializerProvider(new StdDeserializerProvider(
				deserializerFactory));

		return new CustomJacksonJsonProvider(mapper);
	}

	public TicketAPI getTicketAPI() {
		return new TicketAPI(rootResource);
	}
}
