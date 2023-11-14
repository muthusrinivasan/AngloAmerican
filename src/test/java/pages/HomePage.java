package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import common.Utilities;


public class HomePage {
	Utilities utilObj;
	
	public HomePage(WebDriver driver, Utilities utilObj) {
		this.utilObj = utilObj;	
	}
	
	By specialButton = By.xpath(".//ul[@id='main_menu_top']//span[.='Specials']");

	By saleProduct1 = By.xpath(".//a[@class='productcart']");
	
	By searchBox = By.xpath(".//input[@name='filter_keyword']");
	
	By searchButton = By.xpath(".//div[@title='Go']");
	
	By searchResultCount = By.xpath(".//div[@class='col-md-3 col-sm-6 col-xs-12']");
	
	By searchResultNames = By.xpath(".//div[@class='col-md-3 col-sm-6 col-xs-12']//a[@class='prdocutname']");
	
	public void clickSpecials() {
		utilObj.WaitForElement(specialButton).click();
	}
	
	public void addProduct(String nameOfProduct) {	
		By elmPath = By.xpath(".//a[@title='"+nameOfProduct+"']/ancestor::div[@class='fixed_wrapper']/following-sibling::div//a[@class='productcart']");	
		utilObj.WaitForElement(elmPath).click();

	}
	
	public void clickSearchBox() {
		utilObj.WaitForElement(searchBox).click();
	}
	
	
	public void selectCategory(String category) {
		utilObj.WaitForElement(By.xpath(".//a[.='"+category+"']")).click();
	}
	
	public void inputSearchTextAndSearch(String search) {
		utilObj.WaitForElement(searchBox).sendKeys(search);
		utilObj.WaitForElement(searchButton).click();
	}
	
	public void verifySearchResultCount(int actualCount) {
		int counts = utilObj.WaitForElements(searchResultCount).size();
		Assert.assertEquals(actualCount, counts);
	}
	
	public void verifyNames(String name) {
		List<WebElement> elms = utilObj.WaitForElements(searchResultNames);
		for(int i = 0 ; i <= elms.size()-1 ; i++) {
			Assert.assertTrue(elms.get(i).getText().contains(name), "Expected text \""+name+"\" but not found in result product name.");
		}
	}
}
