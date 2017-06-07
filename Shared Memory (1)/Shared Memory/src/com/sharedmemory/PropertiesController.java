package com.sharedmemory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesController {

	Properties properties = new Properties();

	public PropertiesController() {
		try {
			InputStream inputStream = new FileInputStream("Config.properties");
			properties.load(inputStream);
		} catch (IOException e) {
			
		}
	}

	public  String getProperty(String key) {
		String val = properties.getProperty(key);
		return val;
	}

}
