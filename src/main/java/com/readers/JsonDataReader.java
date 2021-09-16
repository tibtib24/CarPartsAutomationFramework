package com.readers;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import com.managers.FileReaderManager;
import com.utils.ExceptionHandler;

import io.cucumber.messages.internal.com.google.gson.Gson;
import pojo.VehicleDetails;

public class JsonDataReader <T> {
	private final String testDataFilePath = FileReaderManager.getInstance().getConfigFileReader().getTestDataPath();
	
	@SuppressWarnings ("unchecked")
	public VehicleDetails getVehicleDetail() {
		return (VehicleDetails) getJsonData((Class<T>) VehicleDetails.class, testDataFilePath + "VehicleDetails.json");
	}
	
	private T getJsonData(Class<T> theClass, String filePath) {
		Gson gson = new Gson();
		T data = null;
		
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath));){
			data = gson.fromJson(reader, theClass);
		}catch (FileNotFoundException e){
			ExceptionHandler.fileNotFoundHandler(filePath);			
		}catch (IOException e) {
			ExceptionHandler.genericExceptionHandler(e);
		}
		
		return data;
		
	}
		

}
