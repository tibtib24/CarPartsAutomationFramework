package com.managers;

import java.io.IOException;

import com.readers.ConfigFileReader;

public class ConfigFileReaderManager {
	private static ConfigFileReaderManager configFileReaderManager;
	private static ConfigFileReader configFileReader;
	
	public static ConfigFileReaderManager getConfigFileReaderManager() {
		if (configFileReaderManager == null) {
			configFileReaderManager = new ConfigFileReaderManager();
		}
		return configFileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() throws IOException {
		if(configFileReader == null) {
			configFileReader = new ConfigFileReader();
		}
		return configFileReader;
	}

}
