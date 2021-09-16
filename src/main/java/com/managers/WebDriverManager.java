package com.managers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

	private WebDriver driver;

	public WebDriver createDriver() {
		String browser = FileReaderManager.getInstance().getConfigFileReader().getBrowser();

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver",
					FileReaderManager.getInstance().getConfigFileReader().getDriverPath(browser));
			driver = (driver == null) ? new ChromeDriver() : driver;
			break;

		case "firefox":
			System.setProperty("webdriver.gecko.driver",
					FileReaderManager.getInstance().getConfigFileReader().getDriverPath(browser));
			driver = (driver == null) ? new FirefoxDriver() : driver;
			break;

		default:
			System.out.println("Please set a valid browser and driverpath in your configuration.properties file");
		}

		// setup driver
		long implicitWait = FileReaderManager.getInstance().getConfigFileReader().getImplicitWait();
		driver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);

		if (FileReaderManager.getInstance().getConfigFileReader().isMaximize()) {
			driver.manage().window().maximize();
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
