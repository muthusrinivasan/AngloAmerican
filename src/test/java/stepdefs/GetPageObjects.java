package stepdefs;

import common.Utilities;
import pages.CartPage;
import pages.HomePage;
import test.DriverFactory;

public class GetPageObjects {

	private HomePage homePage;
	private Utilities uObj;
	private CartPage cartPage;

	public GetPageObjects() {
		uObj = new Utilities(DriverFactory.getDriver());
	}

	public HomePage getHomePageObject() {
		if (homePage == null) {
			homePage = new HomePage(DriverFactory.getDriver(), uObj);
		}
		return homePage;
	}
	
	public CartPage getCartPageObject() {
		if (cartPage == null) {
			cartPage = new CartPage(DriverFactory.getDriver(), uObj);
		}
		return cartPage;
	}

}
