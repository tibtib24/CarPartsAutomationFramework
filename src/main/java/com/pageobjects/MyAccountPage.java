package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPage {
	public MyAccountPage(WebDriver driver) {
		PageFactory.initElements(driver, this);	
	}
	
	@FindBy(partialLinkText = "myaccount/setPersonalInfo")
	private WebElement loginDetails;
	
	public void clickLoginDetails() {
		loginDetails.click();
	}
	
}
