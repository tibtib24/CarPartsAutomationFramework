package stepdefinitions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.managers.FileReaderManager;
import com.pageobjects.BasePage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.VehiclePage;
import com.utils.Waits;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okio.Timeout;
import pojo.VehicleDetails;

public class RefineSearchSteps {

	WebDriver driver;
	BasePage basePage;
	HeaderSection headerSection;
	HomePage homePage;
	VehiclePage vehiclePage;
	VehicleDetails vehicleDetails;

	
	String zipCode;
	String year;
	String make;
	String model;
	String subModel;
	String engine;
	String vehicle;
	List<WebElement> vehicleFilterList;
	ArrayList<String> addedVehicleList = new ArrayList<String>();
	WebDriverWait wait;

	public RefineSearchSteps(BasePage basePage) throws IOException {
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

	@Given("^user selects zip code \"(.*)\"$")
	public void user_selects_zip_code(String zipCode) {	
		this.zipCode = zipCode;
		
		headerSection.clearShipsOrderToZipCode();
		headerSection.clickShipsOrderToPopUpBoxTitle();
		headerSection.enterShipsOrderToZipCode(zipCode);
		headerSection.clickShipsOrderToApplyButton();
	}

	@Then("^zip code location is displayed$")
	public void zip_code_location_is_displayed() throws Throwable {

		Thread.sleep(5000);
		String getZipCode = headerSection.getHomePageZipCode();
		Assert.assertEquals(zipCode, getZipCode);
	}

	@Given("^user has not yet selected any vehicle$")
	public void user_has_not_yet_selected_any_vehicle() throws Throwable {
		homePage.checkSelectYourVehicleSectionIsDisplayed();
	}

	@When("^user selects initial vehicle$")
	public void user_selects_initial_vehicle() throws Throwable {
		Thread.sleep(2000);
		vehicleDetails = FileReaderManager.getInstance().getJsonDataReader().getVehicleDetail();
		year = vehicleDetails.getCarYear();
		make = vehicleDetails.getCarMake();
		model = vehicleDetails.getCarModel();
		subModel = vehicleDetails.getCarSubModel();
		engine = vehicleDetails.getCarEngine();

		homePage.clickYear();

		Thread.sleep(2000);
		
		homePage.selectYear(year);
		homePage.selectMake(make);
		homePage.selectModel(model);

		try {
			homePage.selectSubModel(subModel);
		} catch (NoSuchElementException e) {
			System.out.println("SubModel is not required or missing");
		}
		try {
			homePage.selectEngine(engine);
		} catch (NoSuchElementException e) {
			System.out.println("Engine is not required or missing");
		}
	}

	@Then("^vehicle is displayed in search bar$")
	public void vehicle_is_displayed_in_search_bar() throws Throwable {
		Boolean bool = vehiclePage.isCarDisplayed(year, make, model, subModel);
		Assert.assertEquals(bool, true);
	}

	@When("user add cars in vehicle filter {string} and {string} and {string} and {string} and {string}")
	public void user_add_cars_in_vehicle_filter_and_and_and_and(String strYear, String strMake, String strModel,
			String strSubModel, String strEngine) {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		year = strYear;
		make = strMake;
		model = strModel;
		subModel = strSubModel;
		engine = strEngine;
		
		headerSection.clickVehicleFilter();
		headerSection.clickAddVehicle();

		homePage.clickYear();
		homePage.selectYear(year);
		homePage.selectMake(make);
		homePage.selectModel(model);

		try {
			homePage.selectSubModel(subModel);
		} catch (NoSuchElementException e) {
			System.out.println("SubModel is not required or missing");
		}
		try {
			homePage.selectEngine(engine);
		} catch (NoSuchElementException e) {
			System.out.println("Engine is not required or missing");
		}
	}

	@Then("vehicle is selected as filter")
	public void vehicle_is_selected_as_filter() {
		vehicle = year + " " + make + " " + model + " " + subModel + " " + engine;
		String selectedVehicle = headerSection.getSelectedVehicleFilter();

		boolean result = vehicle.contains(selectedVehicle);
		Assert.assertTrue(result);

	}

	@When("user add multiple car in vehicle filter")
	public void user_add_multiple_car_in_vehicle_filter_and_and_and_and(DataTable dataTable) {
		List<Map<String, String>> carList = dataTable.asMaps(String.class, String.class);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (Map<String, String> e : carList) {
			year = e.get("Year");
			make = e.get("Make");
			model = e.get("Model");

			if (e.get("SubModel") != null) {
				subModel = e.get("SubModel");
			} else {
				subModel = "";
			}

			if (e.get("Engine") != null) {
				engine = e.get("Engine");
			} else {
				engine = "";
			}

			vehicle = year + " " + make + " " + model + " " + subModel + " " + engine;

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			headerSection.clickVehicleFilter();
			headerSection.clickAddVehicle();

			homePage.clickYear();
			homePage.selectYear(year);
			homePage.selectMake(make);
			homePage.selectModel(model);

			if (homePage.isSubModelFieldDisplayed()) {
				try {
					homePage.selectSubModel(subModel);
				} catch (NoSuchElementException e2) {
					System.out.println("SubModel is not required or missing");
				} catch (NullPointerException e2) {
					System.out.println("SubModel is not required or missing");
				}
			}
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			if (homePage.isEngineFieldDisplayed()) {
				try {
					homePage.selectEngine(engine);
				} catch (NoSuchElementException e1) {
					System.out.println("Engine is not required or missing");
				} catch (NullPointerException e1) {
					System.out.println("Engine is not required or missing");
				}
			}

			addedVehicleList.add(vehicle);
		}
	}

	@Then("vehicles are added in vehicle filter")
	public void vehicles_are_added_in_vehicle_filter() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		headerSection.clickVehicleFilter();

		for (int ctr = 0; ctr < addedVehicleList.size(); ctr++) {
			vehicle = addedVehicleList.get(ctr);
			vehicleFilterList = headerSection.getVehicleFilterList();


			for (int i = 0; i < vehicleFilterList.size(); i++) {
				String strVehicle = vehicleFilterList.get(i).getText();
				if (strVehicle.contains(vehicle)) {
					System.out.println("Vehicle: " + strVehicle + " was successfully added in the vehicle filter list");
					Assert.assertTrue(strVehicle.contains(vehicle));
					break;
				}
			}

		}
	}

	@Then("vehicle is added in vehicle filter")
	public void vehicle_is_added_in_vehicle_filter() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		headerSection.clickVehicleFilter();
		vehicleFilterList = headerSection.getVehicleFilterList();

		for (int i = 0; i < vehicleFilterList.size(); i++) {
			String strVehicle = vehicleFilterList.get(i).getText();
			if (strVehicle.contains(vehicle)) {
				System.out.println("Vehicle: " + strVehicle + " was successfully added in the vehicle filter list");
				Assert.assertTrue(strVehicle.contains(vehicle));
			}
		}

	}

}
