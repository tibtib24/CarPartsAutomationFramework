package com.pageobjects;

import com.managers.PageObjectManager;
import com.managers.WebDriverManager;

public class BasePage {
private WebDriverManager webDriverManager;
private PageObjectManager pageObjectManager;
	
	public BasePage() {
		webDriverManager = new WebDriverManager();	
		pageObjectManager = new PageObjectManager(webDriverManager.createDriver());
	}
	
	public WebDriverManager getWebDriverManager(){
		return webDriverManager;	
	}
	
	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}
	
	public String getPageTitle() {
		String pageTitle = webDriverManager.getPageTitle();
		return pageTitle;
	}
	
}


