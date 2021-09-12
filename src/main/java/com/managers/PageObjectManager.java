package com.managers;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.pageobjects.AddToCartPage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.SearchResultPage;
import com.pageobjects.SignInPage;
import com.pageobjects.VehiclePage;

public class PageObjectManager {
	private WebDriver driver;
	
	HeaderSection headerSection;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	SignInPage signInPage;
	VehiclePage vehiclePage;
	
	
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HeaderSection getHeaderSection() throws IOException {
		if (headerSection == null) {
			headerSection = new HeaderSection(driver);
		}
		return headerSection;
	}

	public HomePage getHomePage() {
		homePage = (homePage==null)? new HomePage(driver):homePage;
		return homePage;
	}
	
	public SearchResultPage getSearchResultPage() {
		searchResultPage = (searchResultPage==null) ? new SearchResultPage(driver): searchResultPage;
		return searchResultPage;
	}
	
	public AddToCartPage getAddToCartPage() {
		addToCartPage = (addToCartPage==null) ? new AddToCartPage(driver): addToCartPage;
		return addToCartPage;
	}
	
	public SignInPage getSignInPage() {
		signInPage = (signInPage==null) ? new SignInPage(driver): signInPage;
		return signInPage;
	}
	
	public VehiclePage getVehiclePage() {
		vehiclePage = (vehiclePage==null) ?  new VehiclePage(driver): vehiclePage;
		return vehiclePage;
	}
	
}
