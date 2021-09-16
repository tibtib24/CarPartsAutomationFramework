package com.managers;

import com.readers.ConfigFileReader;
import com.readers.JsonDataReader;

public class FileReaderManager {
	private static FileReaderManager fileReaderManager;
	private static ConfigFileReader configFileReader;
	private static JsonDataReader<?> jsonDataReader;
	
	public static FileReaderManager getInstance() {
		fileReaderManager = (fileReaderManager == null) ? new FileReaderManager(): fileReaderManager;
		return fileReaderManager;
	}
	
	public ConfigFileReader getConfigFileReader() {
		configFileReader = (configFileReader == null) ? new ConfigFileReader(): configFileReader;
		return configFileReader;
	}
	
	public JsonDataReader<?> getJsonDataReader() {
		jsonDataReader = (jsonDataReader==null) ? new JsonDataReader<>(): jsonDataReader;
		return jsonDataReader;		
	}

}
