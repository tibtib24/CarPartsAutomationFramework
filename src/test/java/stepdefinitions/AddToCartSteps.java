package stepdefinitions;

import java.io.IOException;

import javax.lang.model.element.Element;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.pageobjects.AddToCartPage;
import com.pageobjects.BasePage;
import com.pageobjects.HeaderSection;
import com.pageobjects.HomePage;
import com.pageobjects.SearchResultPage;
import com.utils.Wait;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class AddToCartSteps {
	
	WebDriver driver;
	BasePage basePage;
	HeaderSection headerSection;
	HomePage homePage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	Wait element;
	
	
	public AddToCartSteps(BasePage basePage) throws IOException {
		this.basePage = basePage;
		driver = basePage.getWebDriverManager().createDriver();
		headerSection = basePage.getPageObjectManager().getHeaderSection();
		homePage = basePage.getPageObjectManager().getHomePage();
		searchResultPage = basePage.getPageObjectManager().getSearchResultPage();
		addToCartPage = basePage.getPageObjectManager().getAddToCartPage();
	}
	
	String actualItem1;

	@Given ("^that user is in carparts home page$")
	public void that_user_is_in_carparts_home_page() throws IOException, InterruptedException{
		
		String homePageTitle = driver.getTitle();
		System.out.println(homePageTitle);
		Assert.assertTrue(homePageTitle.equalsIgnoreCase("CarParts.com – Right Parts. Right Now."));
	}
	
	@When ("^user search for an item$")
	public void user_search_for_an_item() throws InterruptedException {

		//headerSection.enterSearchItemDelayed("Bumper", 1);
		//Thread.sleep(2000);
		headerSection.enterSearchItem("Bumper");
		headerSection.clickIconSearch();
	}
 
	@And ("^clicks add to cart$")
	public void clicks_add_to_cart() throws InterruptedException {
		
		
		String partNo = searchResultPage.getPartNo();
		actualItem1 = partNo.substring(partNo.lastIndexOf(":") + 1);
		System.out.println(actualItem1);
		
		searchResultPage.clickAddToCartButton();
		
	}
	
	@Then ("^an item is added to cart$")
	public void an_item_is_added_to_cart() throws InterruptedException {
		
		
		String partNo = addToCartPage.getPartNo();
		String expectedItem1 = partNo.substring(partNo.lastIndexOf(":") + 1);
		System.out.println(expectedItem1);
		
		
		Assert.assertEquals(actualItem1, expectedItem1);	
		basePage.getWebDriverManager().quitDriver();
		
		
	}
	
	

	

}
