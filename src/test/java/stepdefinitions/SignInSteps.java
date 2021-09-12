package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pageobjects.BasePage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.SignInPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInSteps {

	WebDriver driver;
	BasePage basePage;
	HeaderSection headerSection;
	HomePage homePage;
	SignInPage signInPage;
	
	String email;
	String password;
	
	public SignInSteps(BasePage basePage) throws IOException {
		this.basePage = basePage;
		driver = basePage.getWebDriverManager().createDriver();
		headerSection = basePage.getPageObjectManager().getHeaderSection();
		homePage = basePage.getPageObjectManager().getHomePage();
		signInPage = basePage.getPageObjectManager().getSignInPage();
		
	}
	
	@Given("^User has a valid login credentials$")
	public void user_has_a_valid_login_credentials() throws Throwable {
		email = "sbardies@gmail.com";
		password = "Test1234$";
		headerSection.clickSignInBtn();
		
	}

	@When("^User enters credentials$")
	public void user_enters_credentials() throws Throwable {
		
		signInPage.enterLoginEmail(email);
		signInPage.enterLoginPassword(password);
		signInPage.clickShowLoginPassword();
		signInPage.clickSignIn();
	}

	@Then("^User is successfully logged in$")
	public void user_is_successfully_logged_in() throws Throwable {
		
		String user = headerSection.signedInUser();
		Assert.assertEquals("Steven", user);
	}
}
