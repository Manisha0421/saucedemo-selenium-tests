package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.BasePage;
import com.saucedemo.pages.InventoryPage;
import com.saucedemo.pages.PageObjects;

import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class Inventory {
	PageObjects pageObjects = new PageObjects();
	InventoryPage inventoryPage = pageObjects.getInventoryPage();
	BasePage basePage = pageObjects.getBasePage();

	@Then("inventory page is visible")
	public void verifyInventoryPage() {
		basePage.hasTitle("Products");
	}

	@When("sort the products {string} filter")
	public void sortProducts(String option) {
		inventoryPage.sortBy(option);
	}

	@Then("products should be sorted accordingly")
	public void verifyProductSorting() {
		inventoryPage.verifySort();
	}

	@When("add product {string} to the shopping cart")
	public void selectItem(String productName) {
		inventoryPage.addProductToCart(productName);
	}

	@And("navigate to the shopping cart page")
	public void navigateToShoppingCart() {
		inventoryPage.goToCart();
	}
}
