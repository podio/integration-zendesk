package com.podio.zendesk;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestUtil {

	public static APIFactory getAPIFactory() throws IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream("config.properties"));

		return new APIFactory("hoist.zendesk.com", 80, false,
				properties.getProperty("username"),
				properties.getProperty("password"));
	}
}
