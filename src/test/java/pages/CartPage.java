package pages;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import common.Utilities;

public class CartPage {
	Utilities utilObj;
	
	public CartPage(WebDriver driver, Utilities utilObj) {
		PageFactory.initElements(driver, this);
		this.utilObj = utilObj;	
	}
	
	@FindBy(id = "guestFrm_firstname") WebElement firstName;
	@FindBy(id = "guestFrm_lastname") WebElement lastName;
	@FindBy(id = "guestFrm_email") WebElement email;
	@FindBy(id = "guestFrm_address_1") WebElement address1;
	@FindBy(id = "guestFrm_city") WebElement city;
	@FindBy(id = "guestFrm_postcode") WebElement postCode;
	@FindBy(id = "checkout_btn") WebElement checkOut;
	
	By cartButton = By.xpath(".//ul[@id='main_menu_top']//span[@class='menu_text'][.='Cart']");
	By totalAmount = By.xpath(".//span[@class='bold totalamout']");
	By checkoutButton = By.xpath(".//a[@id='cart_checkout2']");
	By continueButton = By.xpath(".//button[@title='Continue']");
	By country = By.id("guestFrm_country_id");
	By region = By.id("guestFrm_zone_id");

	
	public void clickCart() {
		utilObj.WaitForElement(cartButton).click();
	}
	
	public void verifyCartTotal(String amt) {
		Assert.assertEquals(utilObj.WaitForElement(totalAmount).getText(), amt);
	}
	
	public void clickCheckout() {
		utilObj.WaitForElement(checkoutButton).click();
	}

	public void chooseUser(String user) {
		By userLocator = By.xpath(".//input[@value='"+user+"']");
		utilObj.WaitForElement(userLocator).click();
	}
	
	public void clickContinue() {
		utilObj.WaitForElement(continueButton).click();
	}
	
	public void fillUserDetails(Map<String, String> data) {
		firstName.sendKeys(data.get("firstName"));
		lastName.sendKeys(data.get("lastName"));
		email.sendKeys(data.get("email"));
		address1.sendKeys(data.get("address"));
		city.sendKeys(data.get("city"));
		postCode.sendKeys(data.get("postCode"));
		selectDropDown(data.get("country"), country);
		selectDropDown(data.get("region"), region);
	}
	
	public void selectDropDown(String value, By elm) {
		utilObj.WaitForElementClickable(elm).click();
		Select drpCountry = new Select(utilObj.WaitForElement(elm));
		drpCountry.selectByVisibleText(value);
	}
	
	public void checkout() {
		checkOut.click();
	}
	
	public void verifyConfirmMessage(String message) {
		By elm = By.xpath(".//span[@class='maintext'][.='"+message+"']");
		Assert.assertTrue(utilObj.WaitForElement(elm).isDisplayed(), "Order was not success");
		
	}
}
