package com.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.utils.WaitUtil;

public class CartPage {
	WebDriver driver;
	WaitUtil wait;

	@FindBy(className = "inventory_item_name")
	WebElement productTitle;

	@FindBy(id = "checkout")
	WebElement checkoutBtn;

	public CartPage(WebDriver driver) {
		wait = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void proceedToCheckout() {
		wait.waitForElementVisible(checkoutBtn);
		checkoutBtn.click();
	}

	public void hasProductOnCart(String productName) {
		wait.waitForElementVisible(productTitle);
		Assert.assertEquals("The product is not present on cart page", productName, productTitle.getText());
	}
}