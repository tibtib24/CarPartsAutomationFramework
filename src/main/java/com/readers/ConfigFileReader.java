package com.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	/**
	 *This method is used to load properties from configuration.properties file
	 *@return it returns Properties properties object
	 */
	static final String configFilePath = "configurations//configuration.properties";
	private Properties properties;
	
	public ConfigFileReader() throws IOException {
		try (BufferedReader reader = new BufferedReader(new FileReader(configFilePath))){
		properties = new Properties();
		properties.load(reader);
		
		
		}catch(FileNotFoundException e){
			e.printStackTrace(); 
			throw new RuntimeException("Configuration.properties file is not found");
		}
		
	}	
	
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public String getDriverPath(String browser) {
		String driverPath = properties.getProperty(browser+"DriverPath");
		return driverPath;
	}
	
	public String getUrl() {
		String url = properties.getProperty("webURL");
		return url;
	}
}
	


