package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.LoginPage;
import com.saucedemo.pages.PageObjects;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Login {
	PageObjects pageObjects = new PageObjects();
	LoginPage loginPage = pageObjects.getLoginPage();
	InventoryPage inventoryPage = pageObjects.getInventoryPage();
	BasePage basePage = pageObjects.getBasePage();

	@Given("user is on SauceDemo login page")
	public void verifyLoginFormDisplayed() {
		loginPage.loginFormIsDisplayed();
	}

	@When("enter username {string} and password {string}")
	public void inputCredentials(String userName, String password) {
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
	}

	@And("click login button")
	public void clickLogin() {
		loginPage.clickLoginButton();
	}

	@Then("error message {string} is displayed")
	public void verifyErrorMessage(String errorMessage) {
		loginPage.hasErrorMessage(errorMessage);
	}

	@Given("user is logged in with username {string} and password {string}")
	public void performLogin(String userName, String password) {
		loginPage.loginFormIsDisplayed();
		loginPage.enterUserName(userName);
		loginPage.enterPassword(password);
		loginPage.clickLoginButton();
	}
}