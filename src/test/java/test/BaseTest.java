package test;

import java.io.IOException;

import org.apache.commons.configuration.Configuration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.ConfigurationFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import common.ReportHelper;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest extends AbstractTestNGCucumberTests {

	public  static Configuration config = null;

	/*
	 * Browser Launch
	 */

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public  void InitiateBrowser(String browser)
			throws ConfigurationException, IOException, InterruptedException {

		ConfigurationFactory factory = new ConfigurationFactory("config/config.xml");
		config = factory.getConfiguration();
		if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			driver.manage().window().maximize();
			DriverFactory.addDriver(driver,browser);
			
		} else if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			DriverFactory.addDriver(driver,browser);
		}
		DriverFactory.getDriver().get(config.getString("applicationURL"));

	}

	@AfterMethod(alwaysRun = true)
	public void CloseSession() {
		  DriverFactory.removeDriver();
	}

	@AfterSuite
	public void EndReport() {
		ReportHelper.closeReport();
	}

}
