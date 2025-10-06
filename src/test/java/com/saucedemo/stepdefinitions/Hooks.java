package com.saucedemo.stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import com.saucedemo.core.DriverFactory;
import com.saucedemo.utils.ConfigReader;

public class Hooks {

	@Before
	public void setUp() {
		DriverFactory.initializeDriver();
		String baseUrl = ConfigReader.get("baseUrl");
		DriverFactory.getDriver().get(baseUrl);
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}