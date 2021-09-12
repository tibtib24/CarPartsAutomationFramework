package com.pageobjects;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	BasePage basepage;

	//Page Constructor
	public HomePage (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//Locators
	
	//select vehicle
	@FindBy(id ="vehicle-selector")
	private WebElement selectYourVehicleSection;
	
	@FindBy(id = "select-year")
	private WebElement selectYear;
	
	@FindBy(css =".StyledButton-sc-323bzc-0.UOSqN.SelectContainer__SelectOption-sc-1wi0ul8-1.defaCL")
	private List<WebElement> yearDropDownList;
	
	@FindBy(id="select-year")
	private WebElement yearDropDown;
	
	@FindBy(id = "select-make__input")
	private WebElement selectMake;
	
	@FindBy(css = ".StyledText-sc-1sadyjn-0.gNNfTw")
	private List<WebElement> makeDropDownList;
	
	
	@FindBy(id = "select-model__input")
	private WebElement selectModel;
	
	@FindBy(css =".StyledText-sc-1sadyjn-0.gNNfTw")
	private List<WebElement> modelDropDownList;
	
	
	@FindBy(id = "select-submodel__input")
	private WebElement selectSubmodel;
	
	@FindBy(css=".StyledText-sc-1sadyjn-0.gNNfTw")
	private List<WebElement> submodelDropDownList;
	
	@FindBy(id = "select-engine__input")
	private WebElement selectEngine;	
	

	//Page Actions
	public String getHomePageTitle() throws IOException {
		String homePageTitle = basepage.getPageTitle();
		return homePageTitle;
	}
	
	//Select Vehicle
	public boolean checkSelectYourVehicleSectionIsDisplayed() {
		boolean isDisplayed = selectYourVehicleSection.isDisplayed();
		if(isDisplayed) {
			System.out.println("Vehicle Section is displayed");
		}else {
			System.out.println("Vehicle Section is not displayed");
		}
		return isDisplayed;
	}
	
	public void clickYear() {
		int atempt = 0;
		while (atempt<2) {
			try{
				selectYear.click();
				if(!yearDropDown.isDisplayed()) {
					System.out.println(yearDropDown.isDisplayed());
					selectYear.click();
				}else {
					break;
				}
			} catch(StaleElementReferenceException e) {
				System.out.println(e);
			}
			atempt++;
		}
	}
	
	public void selectYear(String year) {
		int size = yearDropDownList.size();
		for(int i=0; i<size; i++) {
			String strYear = yearDropDownList.get(i).getText();
			if(year.equals(strYear)) {
				yearDropDownList.get(i).click();
				break;
			}
		}
	}
	
	public void selectMake(String make) {
		int size = makeDropDownList.size();
		for(int i=0; i<size; i++) {
			String strMake = makeDropDownList.get(i).getText();
			if(make.equals(strMake)) {
				makeDropDownList.get(i).click();
				break;
			}
		}	
	}
	
	public void selectModel(String model) {
		int size = modelDropDownList.size();
		for(int i=0; i<size; i++) {
			String strModel = modelDropDownList.get(i).getText();
			if(model.equals(strModel)) {
				modelDropDownList.get(i).click();
				break;
			}
		}	
	}
	
	public void selectSubModel(String subModel) {
		int size = submodelDropDownList.size();
		for(int i=0; i<size; i++) {
			String strSubModel = submodelDropDownList.get(i).getText();
			if(subModel.equals(strSubModel)) {
				submodelDropDownList.get(i).click();
				break;
			}
		}	
	}
	
	
	
}
