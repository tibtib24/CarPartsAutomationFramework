package com.managers;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

	private WebDriver driver;

	public WebDriver createDriver() throws IOException {
		String browser = ConfigFileReaderManager.getConfigFileReaderManager().getConfigFileReader().getBrowser();
		
	
		switch(browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", ConfigFileReaderManager.getConfigFileReaderManager().getConfigFileReader().getDriverPath(browser));
			if (driver == null) {
				driver = new ChromeDriver();
			}
			break;
		case "firefox":		
			System.setProperty("webdriver.gecko.driver", ConfigFileReaderManager.getConfigFileReaderManager().getConfigFileReader().getDriverPath(browser));
			if (driver == null) {
			driver = new FirefoxDriver();
			}
			break;
		default:
			System.out.println("Please set a valid browser and driverpath in your configuration.properties file");
			}
			return driver;
	}

	public void quitDriver() {
		driver.quit();
	}

	public String getPageTitle() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

}
