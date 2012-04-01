package com.podio.integration.zendesk;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Properties;

import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.deser.CustomDeserializerFactory;
import org.codehaus.jackson.map.deser.StdDeserializerProvider;
import org.codehaus.jackson.map.ser.CustomSerializerFactory;
import org.joda.time.DateTime;

import com.podio.integration.zendesk.search.SearchAPI;
import com.podio.integration.zendesk.serialize.DateTimeDeserializer;
import com.podio.integration.zendesk.serialize.DateTimeSerializer;
import com.podio.integration.zendesk.ticket.TicketAPI;
import com.podio.integration.zendesk.user.UserAPI;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;

public class APIFactory {

	private final WebResource rootResource;

	public APIFactory(String domain, boolean ssl, String username,
			String password) {
		ClientConfig config = new DefaultClientConfig();
		config.getSingletons().add(getJsonProvider());
		Client client = Client.create(config);

		this.rootResource = client.resource(getURI(domain, ssl));
		this.rootResource
				.addFilter(new HTTPBasicAuthFilter(username, password));
	}

	private URI getURI(String domain, boolean ssl) {
		try {
			return new URI(ssl ? "https" : "http", null, domain
					+ ".zendesk.com", ssl ? 443 : 80, null, null, null);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		}
	}

	private JacksonJsonProvider getJsonProvider() {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		mapper.configure(
				DeserializationConfig.Feature.READ_ENUMS_USING_TO_STRING, true);
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

	public SearchAPI getSearchAPI() {
		return new SearchAPI(rootResource);
	}

	public UserAPI getUserAPI() {
		return new UserAPI(rootResource);
	}

	public static APIFactory getFromConfig() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("config.properties"));

		return new APIFactory(properties.getProperty("domain"),
				Boolean.parseBoolean(properties.getProperty("ssl")),
				properties.getProperty("username"),
				properties.getProperty("password"));
	}
}
