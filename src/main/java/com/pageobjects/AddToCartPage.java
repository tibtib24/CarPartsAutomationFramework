package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	//Page Constructor
	public AddToCartPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(css =".StyledText-sc-1sadyjn-0.fnOBIf")
	private WebElement partNo;
	
	//Page Actions
	public String getPartNo() {
		String strPartNo = partNo.getText();
		return strPartNo;
	}
}
