package com.saucedemo.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver initializeDriver() {
		if (driver == null) {
			WebDriverManager.chromedriver().clearDriverCache().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized");
			options.addArguments("--disable-blink-features=AutomationControlled");
			options.addArguments("--disable-password-manager-reauthentication");
			options.addArguments("--disable-save-password-bubble");
			options.addArguments("--disable-features=PasswordLeakDetectionEnabled");
			options.addArguments("--password-store=basic");
			options.addArguments("--incognito");
			driver = new ChromeDriver(options);
		}
		return driver;
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}