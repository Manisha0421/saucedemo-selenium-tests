package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.CartPage;
import com.saucedemo.pages.PageObjects;

import io.cucumber.java.en.And;

public class Cart {

	PageObjects pageObjects = new PageObjects();
	CartPage cartPage = pageObjects.getCartPage();

	@And("the {string} product should be on the shopping cart")
	public void verifyProductOnCart(String productName) {
		cartPage.hasProductOnCart(productName);
	}

	@And("click on the checkout button")
	public void goToCheckout() {
		cartPage.proceedToCheckout();
	}
}
