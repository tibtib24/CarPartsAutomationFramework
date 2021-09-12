package stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pageobjects.BasePage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.VehiclePage;
import com.utils.Wait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SetupSearchCriteriaSteps {
	
	WebDriver driver;
	BasePage basePage;
	HeaderSection headerSection;
	HomePage homePage;
	VehiclePage vehiclePage;
	
	String year = "2007";
	String make = "Honda";
	String model = "Civic";
	String submodel = "Si";
	String engine;
	
	public SetupSearchCriteriaSteps(BasePage basePage) throws IOException {
		this.basePage = basePage;
		driver = basePage.getWebDriverManager().createDriver();
		headerSection = basePage.getPageObjectManager().getHeaderSection();
		homePage = basePage.getPageObjectManager().getHomePage();
		vehiclePage = basePage.getPageObjectManager().getVehiclePage();
	}
	
	@When("^user clicks shipping to button$")
	public void user_clicks_shipping_to() throws Throwable {

		headerSection.clickShippingTo();
		
		String popUpBoxTitle = headerSection.getShipsOrderToPopUpBoxTitle();
		System.out.println("Pop up box title is: '" + popUpBoxTitle + "'");
		Assert.assertTrue(popUpBoxTitle.equalsIgnoreCase("Ship Orders to:"));
		
	}

	@When("^user selects zip code$")
	public void user_selects_zip_code() throws Throwable {

		headerSection.clearShipsOrderToZipCode();
		headerSection.clickShipsOrderToPopUpBoxTitle();
		headerSection.enterShipsOrderToZipCode("35815");
		headerSection.clickShipsOrderToApplyButton();
		
	}

	@Then("^zip code location is displayed$")
	public void zip_code_location_is_displayed() throws Throwable {

		Thread.sleep(5000);
		String zipCode = headerSection.getHomePageZipCode();
		Assert.assertEquals("35815", zipCode);
	}
	
	
	
	@Given("^user has not yet selected any vehicle$")
	public void user_has_not_yet_selected_any_vehicle() throws Throwable {
		homePage.checkSelectYourVehicleSectionIsDisplayed();
	}


	@When("^user selects vehicle$")
	public void user_selects_vehicle() throws Throwable {
		Thread.sleep(2000);
		homePage.clickYear();
		homePage.selectYear(year);
		homePage.selectMake(make);
		homePage.selectModel(model);
		homePage.selectSubModel(submodel);
	}

	@Then("^vehicle is displayed in search bar$")
	public void vehicle_is_displayed_in_search_bar() throws Throwable {
		Boolean bool = vehiclePage.isCarDisplayed(year, make, model, submodel);
		Assert.assertEquals(bool, true);
	}

	
}
