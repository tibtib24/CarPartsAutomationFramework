package com.pageobjects;

import java.util.List;
import java.util.function.Function;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderSection {

	public HeaderSection(WebDriver driver){
		PageFactory.initElements(driver, this);
	}
	
	//search
	@FindBy(id = "searchBox")
	private WebElement searchBox;
	
	public WebElement getSearchBox() {
		return searchBox;
	}

	@FindBy(id = "iconSearch" )
	private WebElement iconSearch;
	
	@FindBy(id ="selVeh")
	private WebElement vehicleFilter;
	
	@FindBy(css= ".StyledText-sc-1sadyjn-0.lmCHeZ")
	private WebElement selectVehicleFilter;
	
	@FindBy(id = "addVehicle")
	private WebElement addVehicle;
	
	@FindBy(css = ".StyledText-sc-1sadyjn-0.kQVovg")
	private List<WebElement> carListFilter;
	
	//SignIn
	@FindBy(id = "signIn")
	private WebElement signInBtn;
	
	public WebElement getSignInBtn() {
		return signInBtn;
	}

	public void setSignInBtn(WebElement signInBtn) {
		this.signInBtn = signInBtn;
	}
	
	@FindBy(partialLinkText="myaccount")
	private WebElement myAccountBtn;

	@FindBy(css =".StyledText-sc-1sadyjn-0.beEJuh")
	private WebElement signedInHello;
	
	@FindBy(css =".StyledText-sc-1sadyjn-0.fhQirM")
	private WebElement signedInName;
	
	//SetupShipping
	@FindBy(id = "location")
	private WebElement locationButton;
	
	@FindBy(css =".StyledHeading-sc-1rdh4aw-0.hERgFn")
	private WebElement shipsOrderToPopUpBoxTitle;
	
	@FindBy(css =".StyledTextInput-sc-1x30a0s-0.cZzNgu")
	private WebElement shipsOrderToZipCodeTextBox;
	
	@FindBy(css =".StyledButton-sc-323bzc-0.ignnRb") 
	private WebElement shipsOrderToApplyButton;
	
	@FindBy(css =".sc-81w3h-0.gzKbTX")
	private WebElement homePageZipCode;
	
	
	//Search
		public void enterSearchItem(String item) {
			searchBox.sendKeys(item);
		}
				
		public void enterSearchItemDelayed(String item, int delay) throws InterruptedException {
			for(int i = 0; i < item.length(); i++) {
				searchBox.sendKeys(item.substring(i,i+1));
				Thread.sleep(delay*1000);
			}
			searchBox.sendKeys(Keys.ENTER);
		}
		
		public void clickIconSearch() {
			iconSearch.click();
		}
		
		public void clickShippingTo() {
			locationButton.click();
		}
		
		public void clickVehicleFilter() {
			vehicleFilter.click();
		}
		
		public void clickAddVehicle() {
			addVehicle.click();
		}
		
		public String getSelectedVehicleFilter() {
			String selectedVehicle = selectVehicleFilter.getText();
			return selectedVehicle;
		}
		
		public boolean isSelectedVehicleFitlerDispalyed() {
			boolean result = selectVehicleFilter.isDisplayed();
			return result;
		}
		
		public void selectVehicle(String carYear, String carMake, String carModel, String carSubModel) {
			int size = carListFilter.size();
			
			for (int i=0; i<size;i++) {
				String car = carYear + " " + carMake + " " + carModel + " " + carSubModel;
				if(car.contains(carListFilter.get(i).getText())) {
					carListFilter.get(i).click();
				}	
			}
		}
		
		public List<WebElement> getVehicleFilterList() {
			return carListFilter;
		}
		
		
		//SignIn
		public void clickSignInBtn() {
			signInBtn.click();
		}
		
		public void helloIsDisplayed() {
			signedInHello.isDisplayed();
		}
		
		public String signedInUser() {
			String user = signedInName.getText();
			return user;
		}
		
		public void clickMyAccount() {
			myAccountBtn.click();
		}
		
		//Change Location
		public String getShipsOrderToPopUpBoxTitle() {
			String popUpBoxTitle = shipsOrderToPopUpBoxTitle.getText();
			return popUpBoxTitle;
		}
		
		public void clickShipsOrderToPopUpBoxTitle() {
			shipsOrderToPopUpBoxTitle.click();
		}
		
		public void clickShipsOrderToZipCode() {
			shipsOrderToZipCodeTextBox.click();
		}
		
		public void clearShipsOrderToZipCode() {
			shipsOrderToZipCodeTextBox.clear();
		}
		
		public void enterShipsOrderToZipCode(String zipCode) {
			shipsOrderToZipCodeTextBox.sendKeys(zipCode);
		}
		
		
		public void clickShipsOrderToApplyButton() {
			shipsOrderToApplyButton.click();
		}
		
		public String getHomePageZipCode() {
			String zipCode = homePageZipCode.getText();
			return zipCode;
		}

		public WebElement getIconSearch() {
			return iconSearch;
		}
		
	
	

}
