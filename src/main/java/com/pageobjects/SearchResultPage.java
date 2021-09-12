package com.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage {

	//Page Constructor
	public SearchResultPage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Locators
	@FindBy(css ="#sectionCard-0 .StyledText-sc-1sadyjn-0.facMnh")
	private WebElement partNo;
	
	@FindBy(id ="card-addtocard-0")
	private WebElement addToCartButton;
	
	//Page Actions
	public String getPartNo() {
		String strPartNo = partNo.getText();
		return strPartNo;
	}
	
	public void clickAddToCartButton() {
		addToCartButton.click();
	}
	
	


}
