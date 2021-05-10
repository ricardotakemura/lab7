package com.sensedia.api.platform.util;

import java.util.Properties;

public class AppProperties {

	private static AppProperties instance;
	
	private Properties properties;
	
	private AppProperties() {
		properties = new Properties();
		try {
			properties.load(getClass().getResourceAsStream("/application.properties"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static AppProperties getInstance() {
		if (instance == null) {
			instance = new AppProperties();
		}
		return instance;
	}

	public String getProperty(String property) {
		return properties.getProperty(property);
	}

	public String[] getPropertyAsArray(String property) {
		String value = getProperty(property);
		return value != null ? value.split(",") : new String[0];
	}
}
