package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import common.Utilities;

public class CartPage {
	Utilities utilObj;
	
	public CartPage(WebDriver driver, Utilities utilObj) {
		this.utilObj = utilObj;	
	}
	
	By cartButton = By.xpath(".//ul[@id='main_menu_top']//span[@class='menu_text'][.='Cart']");
	By totalAmount = By.xpath(".//span[@class='bold totalamout']");
	
	public void clickCart() {
		utilObj.WaitForElement(cartButton).click();
	}
	
	public void verifyCartTotal(String amt) {
		Assert.assertEquals(utilObj.WaitForElement(totalAmount).getText(), amt);
	}

}
