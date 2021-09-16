package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginDetailsPage {
	public LoginDetailsPage(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	String email;
	
	@FindBy(id = "emailAddress")
	private WebElement emailAddress;
	
	public String getEmailAddress() {
		email = emailAddress.getText();
		return email;
	}
	
}

