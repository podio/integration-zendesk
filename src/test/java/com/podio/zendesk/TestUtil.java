package com.podio.zendesk;

import java.io.FileInputStream;
import java.util.Properties;

public class TestUtil {

	public static APIFactory getAPIFactory() {
		Properties properties = new Properties();
		properties.load(new FileInputStream("config.properties"));
	}
}
