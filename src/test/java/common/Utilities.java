package common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yaml.snakeyaml.Yaml;

import test.BaseTest;
import test.DriverFactory;

public class Utilities {
	
	
	private WebDriver wdriver;
    private WebDriverWait wait;
    
	public Utilities(WebDriver driver) {
		wdriver = driver;
		wait = new WebDriverWait(driver, 15);
	}
	/*
	 * To take screenshot of app
	 */
	public String Getscreenshot(String screenShotName) throws IOException {
		File scrFile = ((TakesScreenshot) wdriver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("yyyy-MM-dd.HH-mm-ss-SSS").format(new Date());
		String dest = BaseTest.config.getString("screenshotLocation") + screenShotName + "-" + timestamp + ".png";
		File destination = new File(dest);
		FileUtils.copyFile(scrFile, destination);
		return dest.replace("./test-output/", "");
	}

	/*
	 * To wait for presence of element uses BY. Takes BY locator as input
	 */
	public  WebElement WaitForElement(By elm) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
		
		return DriverFactory.getDriver().findElement(elm);
	}
	
	public  List<WebElement> WaitForElements(By elm) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(elm));
		
		return DriverFactory.getDriver().findElements(elm);
	}
}
