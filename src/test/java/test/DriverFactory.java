package test;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;

public final class DriverFactory {

	private static ThreadLocal<WebDriver> drivers = new ThreadLocal<>();
	private static ThreadLocal<String> browserName = new ThreadLocal<>();

	// To quit the drivers and browsers at the end only.
	private static List<WebDriver> storedDrivers = new ArrayList<>();

	static {
		Runtime.getRuntime().addShutdownHook(new Thread() {
			public void run() {
				storedDrivers.forEach(WebDriver::quit);
			}
		});
	}

	private DriverFactory() {}

	public static WebDriver getDriver() {
		return drivers.get();
	}
	
	public static String getBrowserName() {
		return browserName.get();
	}

	public static void addDriver(WebDriver driver,String name) {
		storedDrivers.add(driver);
		drivers.set(driver);
		browserName.set(name);
	}

	public static void removeDriver() {
		drivers.get().quit();
		storedDrivers.remove(drivers.get());
		drivers.remove();
		browserName.remove();
	}
}
