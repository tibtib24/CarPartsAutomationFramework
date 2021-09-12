package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VehiclePage {

	
	public VehiclePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (css=".sc-1la47pe-1.gmairC")
	private WebElement filteredCar;
	
	@FindBy (css=".StyledText-sc-1sadyjn-0.fjhrpA")
	private WebElement selectedVehicle;
	
	
	public Boolean isCarDisplayed(String year, String make, String model, String submodel) {
		String car = (year + ' ' + make + ' ' + model + ' ' + submodel);
		String displayedVehicle = selectedVehicle.getText();
		
		System.out.println(car);
		System.out.println(displayedVehicle);
		
		if(displayedVehicle.contains(car)) {
			return true;
		}
		return false;
	}
	
	
			

}
