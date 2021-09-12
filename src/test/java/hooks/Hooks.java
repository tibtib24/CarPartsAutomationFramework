package hooks;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.managers.ConfigFileReaderManager;
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
		String url = ConfigFileReaderManager.getConfigFileReaderManager().getConfigFileReader().getUrl();
		
		System.out.println("Test is running using Driver: " + driver);
		System.out.println("URL being tested: " + url);
		
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(url);	
	
	}
	
	@After (order = 0)
	public void afterSteps() {
		//driver.quit();
	}
	
	@After (order = 1)
	public void afterScenario(io.cucumber.java.Scenario scenario) throws IOException {
		
		if (scenario.isFailed()) {
			String screenshotName = scenario.getName().replaceAll(" ", "_");
			
			//takes a screenshot from the driver
			byte[] sourcePath= ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			
			// Building up the destination path for the screenshot to save
			// Make sure to create a folder 'screenshots' with in the cucumber-reports folder
			//File destinationPath = new File(System.getProperty("user.dir") + "/target/cucumber-reports/screenshots/" + screenshotName + ".jpg");
			
			// Copy taken screenshot from source location to destination location
			//Files.copy(sourcePath, destinationPath);
			
			scenario.attach(sourcePath, "image/png", screenshotName);
			
			//Attach the specified screenshot to the test
			//Reporter.addScreenCaptureFromPath(destinationPath.toString());		
		}
	}
	
	

}
