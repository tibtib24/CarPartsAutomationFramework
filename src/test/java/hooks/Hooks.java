package hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.managers.FileReaderManager;
import com.pageobjects.BasePage;

import io.cucumber.java.After;
import io.cucumber.java.Before;



public class Hooks {
	private WebDriver driver;
	
	public Hooks (BasePage basePage) throws IOException {
		driver = basePage.getWebDriverManager().createDriver();
	}
	
	
	@Before(order = 0)
	public void beforeSteps() throws IOException {
		String url = FileReaderManager.getInstance().getConfigFileReader().getUrl();
		
		System.out.println("Test is running using Driver: " + driver);
		System.out.println("URL being tested: " + url);
		driver.get(url);	
	
	}
	
	@After (order = 0)
	public void afterSteps() {
		driver.quit();
	}
	
	@After (order = 1)
	public void afterScenario(io.cucumber.java.Scenario scenario) throws IOException {
		
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");

			byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenshotName);

		}
	}
	
	

}
