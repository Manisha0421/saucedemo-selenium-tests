package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.CheckoutPage;
import com.saucedemo.pages.PageObjects;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Checkout {

	PageObjects pageObjects = new PageObjects();
	CheckoutPage checkoutPage = pageObjects.getCheckoutPage();
	BasePage basePage = pageObjects.getBasePage();

	private static final String CHECKOUT_OVERVIEW = "Checkout: Overview";

	@And("enter first name {string}, last name {string} and postal code {string} on the checkout data form")
	public void fillPersonalDetails(String firstName, String lastName, String postalCode) {
		checkoutPage.fillForm(firstName, lastName, postalCode);
	}

	@And("click continue button")
	public void continueCheckout() {
		checkoutPage.clickContinue();
	}

	@And("click Finish button")
	public void finishCheckout() {
		checkoutPage.clickFinish();
	}

	@And("user see a summary page")
	public void verifySummaryPage() {
		basePage.hasTitle(CHECKOUT_OVERVIEW);
	}

	@Then("{string} message is displayed on the screen")
	public void verifyOrderConfirmation(String confirmationMessage) {
		checkoutPage.hasConfirmation(confirmationMessage);
	}
}
