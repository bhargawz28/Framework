package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationDataProvider {

	Properties properties;

	public ConfigurationDataProvider() {

		File sourceFile = new File(System.getProperty("user.dir") + "/Configuration/Configuration.properties");
		try {
			FileInputStream fileInputStream = new FileInputStream(sourceFile);
			properties = new Properties();
			properties.load(fileInputStream);
		} catch (IOException e) {
			System.out.println("Unable to Open Properties File" + e.getMessage());
		}
	}

	public String getBrowser() {
		return properties.getProperty("browser");
	}

	public String getURL() {
		return properties.getProperty("url");
	}

	public String getValueForAttribute(String attribute) {
		return properties.getProperty(attribute);
	}

}
