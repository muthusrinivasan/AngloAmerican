package stepdefs;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.relevantcodes.extentreports.ExtentTest;

import common.Utilities;
import common.ReportHelper;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.CartPage;
import pages.HomePage;
import test.DriverFactory;

public class StepDefs {

	
	HomePage hp;
	CartPage cp;
	
	public StepDefs(GetPageObjects getPageObj) {
		cp = getPageObj.getCartPageObject();
		hp = getPageObj.getHomePageObject();
	}

	static ExtentTest logger;

	@Given("^Add sale product \"(.*)\"")
	public void addProducts(String pName) throws IOException {		
		hp.clickSpecials();
		hp.addProduct(pName);
		cp.clickCart();	
	}
	
	@Then("^verify the total amount is \"(.*)\"$")
	public void verifyTotalAmount(String amount) {
		cp.verifyCartTotal(amount);
	}
	
	@Given("^I select \"(.*)\" from search field$")
	public void selectCategory(String category) throws IOException {	
		hp.clickSearchBox();
		hp.selectCategory(category);
	}
	
	@Then("^I enter \"(.*)\" in it and search$")
	public void searchProduct(String product) throws IOException {		
		hp.inputSearchTextAndSearch(product);
	}
	
	@And("^I verify (\\d+) products in search result$")
	public void verifyNumberOfProduct(int counts) {
		hp.verifySearchResultCount(counts);
	}
	
	@Then("All product should have \"(.*)\" in its name$")
	public void verifyProduNames(String name) {
		hp.verifyNames(name);
	}

	@SuppressWarnings("deprecation")
	@After
	public void embedsc(Scenario scn) throws Exception {
		if (scn.isFailed()) {
			try {
				byte[] screenshot = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.BYTES);
				scn.embed(screenshot, "image/png");
			} catch (WebDriverException wde) {
				System.err.println(wde.getMessage());
			} catch (ClassCastException cce) {
				cce.printStackTrace();
			}

		}
	}
}
