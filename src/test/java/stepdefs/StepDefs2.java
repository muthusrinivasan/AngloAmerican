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

public class StepDefs2 {

	
	HomePage hp;
	CartPage cp;
	Utilities uObj;
	public StepDefs2(GetPageObjects getPageObj) {
		cp = getPageObj.getCartPageObject();
		hp = getPageObj.getHomePageObject();
		uObj = getPageObj.getUobj();
	}


	@Given("^Add product \"(.*)\" and checkout")
	public void addProducts(String pName) throws IOException {		
		hp.addProduct(pName);
		cp.clickCart();	
		cp.clickCheckout();
	}
	
	@Then("^I choose continue as \"(.*)\"")
	public void selectGuest(String user) throws IOException {		
		cp.chooseUser(user);
		cp.clickContinue();
	}

	@Then("^I fill the user details$")
	public void fillUserDetails() {
		cp.fillUserDetails(uObj.getData());
		cp.clickContinue();
	}
	
	@And("I confirm order")
	public void confirmOrder() {
		cp.checkout();
	}
	
	@Then("^verify the confirm message \"(.*)\"$")
	public void verifyConfirmMessage(String message) {
		cp.verifyConfirmMessage(message);
	}
	

}
