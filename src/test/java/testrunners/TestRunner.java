package testrunners;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith (Cucumber.class)
@CucumberOptions (
		features = "src/test/resources/features",
		glue = {"stepdefinitions","hooks"},
		monochrome = true,
		plugin = {"pretty"
					,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
					},
		tags = "@RegressionTest"
		)

public class TestRunner {

}
