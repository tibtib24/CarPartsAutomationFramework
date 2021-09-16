package stepdefinitions;

import java.io.IOException;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.constants.Literals;
import com.pageobjects.BasePage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.LoginDetailsPage;
import com.pageobjects.MyAccountPage;
import com.pageobjects.SignInPage;
import com.utils.Waits;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class SignInSteps {

	WebDriver driver;
	BasePage basePage;
	HeaderSection headerSection;
	HomePage homePage;
	SignInPage signInPage;
	MyAccountPage myAccountPage;
	LoginDetailsPage loginDetailsPage;
	Waits wait;
	
	String email;
	String password;
	
	public SignInSteps(BasePage basePage) throws IOException {
		this.basePage = basePage;
		driver = basePage.getWebDriverManager().createDriver();
		headerSection = basePage.getPageObjectManager().getHeaderSection();
		homePage = basePage.getPageObjectManager().getHomePage();
		signInPage = basePage.getPageObjectManager().getSignInPage();
	}
	
	@Given("User is in sign in page")
	public void user_is_in_sign_in_page() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		headerSection.clickSignInBtn();
	}

	@When("User sign in using credentials {string} and {string}")
	public void user_sign_in_using_credentials_and(String email, String password) {
		this.email = email;
		this.password = password;
		
		signInPage.enterLoginEmail(email);
		signInPage.enterLoginPassword(password);
		signInPage.clickShowLoginPassword();
		signInPage.clickSignIn();
	}

	@When("User goes to My Account")
	public void user_goes_to_my_account() {
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		headerSection.clickMyAccount();		
	}

	@When("User goes to sign in details")
	public void user_goes_to_sign_in_details() {
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		myAccountPage.clickLoginDetails();
	}

	@When("User verify email address")
	public void user_verify_email_address() {
		String strEmail = loginDetailsPage.getEmailAddress();
		Assert.assertEquals(email, strEmail);
	}
	
	
	@Then("^User is successfully signed in$")
	public void user_is_successfully_signed_in() throws Throwable {
		
		String user = headerSection.signedInUser();
		Assert.assertEquals("Steven", user);
	}
	
	@Then("User gets verification failed message")
	public void user_gets_verification_failed_message() {
		String eMsg = signInPage.getVericationFailedMessage();
		Assert.assertEquals(Literals.LOGIN_VERIFCATION_ERROR_MESSAGE, eMsg);
	}
	
	@Then("User gets sign in error message")
	public void user_gets_sign_in_error_message() {
		System.out.println("Failed to sign in using email: " + email + " pass: " + password);
		
	}


}
