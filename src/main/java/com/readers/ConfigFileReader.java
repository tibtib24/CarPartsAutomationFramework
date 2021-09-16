package com.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Literals;
import com.utils.ExceptionHandler;

public class ConfigFileReader {
	
	/**
	 *This method is used to load properties from configuration.properties file
	 *@return it returns Properties properties object
	 */
	static final String configFilePath = Literals.CONFIG_PROPERTY_FILE_PATH;
	private Properties properties;
	
	public ConfigFileReader() {
		try (BufferedReader reader = new BufferedReader(new FileReader(configFilePath))){
		properties = new Properties();
		properties.load(reader);
		}catch(FileNotFoundException e){
			e.printStackTrace(); 
			throw new RuntimeException("Configuration.properties file is not found");
		}catch(IOException e) {
			ExceptionHandler.genericExceptionHandler(e);
		}
		
	}	
	
	public String getBrowser() {
		String browser = properties.getProperty("browser");
		return browser;
	}
	
	public String getDriverPath(String browser) {
		String driverPath = properties.getProperty(browser+"DriverPath");
		if (driverPath == null) {
			ExceptionHandler.variableNotInConfigFile(driverPath);
		}
		return driverPath;
	}
	
	public String getUrl() {
		String url = properties.getProperty("webURL");
		return url;
	}
	
	public String getTestDataPath() {
		String testDataPath = properties.getProperty("testDataPath");
		return testDataPath;
	}
	
	public long getImplicitWait() {
		String implicitWait = properties.getProperty("implicitWait");
		if (implicitWait != null) {
			try {
				return Long.parseLong(implicitWait);
			}catch (NumberFormatException e) {
				ExceptionHandler.numberFormatHandler(implicitWait);
			}
		}
		return 20;
	}
	
	public Boolean isMaximize() {
		String maximize = properties.getProperty("windowMaximize");
		if (maximize != null) {
			return Boolean.valueOf(maximize);
		} else {
			return true;
		}
	}
	
}
	


