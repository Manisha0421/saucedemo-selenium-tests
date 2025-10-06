package com.saucedemo.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.saucedemo.utils.WaitUtil;

public class InventoryPage {
	WebDriver driver;
	WaitUtil wait;

	@FindBy(className = "product_sort_container")
	WebElement sortDropdown;

	@FindBy(className = "shopping_cart_link")
	WebElement cartIcon;

	@FindBy(className = "inventory_item")
	List<WebElement> productList;
	
	public InventoryPage(WebDriver driver) {
		this.driver = driver;
		wait = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this);
	}

	private static final String PRODUCT_NAME = "inventory_item_name";
	private static final String PRODUCT_DESCRIPTION = "inventory_item_desc";
	private static final String PRODUCT_PRICE = "inventory_item_price";
	private static final String ADD_TO_CART_DYNAMIC = "//div[contains(text(), '%s')]/ancestor::div[@class='inventory_item']//button[contains(@id, 'add-to-cart')]";
	
	public void sortBy(String option) {
		wait.waitForElementVisible(sortDropdown);
		new Select(sortDropdown).selectByVisibleText(option);
	}

	public void addProductToCart(String productName) {
		WebElement addToCartForProduct = driver.findElement(By.xpath(String.format(ADD_TO_CART_DYNAMIC, productName)));
		wait.waitForElementClickable(addToCartForProduct);
		addToCartForProduct.click();
	}

	public void goToCart() {
		wait.waitForElementClickable(cartIcon);
		cartIcon.click();
	}

	public void inventoryPageIsDisplayed() {
		Assert.assertTrue(driver.getCurrentUrl().contains("inventory"));
	}

	public List<Product> fetchProducts() {
		List<Product> products = new ArrayList<>();
		for (WebElement product : productList) {
			String name = product.findElement(By.className(PRODUCT_NAME)).getText();
			String description = product.findElement(By.className(PRODUCT_DESCRIPTION)).getText();
			String priceInString = product.findElement(By.className(PRODUCT_PRICE)).getText().replace("$", "");
			Double price = Double.parseDouble(priceInString);

			products.add(new Product(name, description, price));
		}
		return products;
	}

	public void verifySort() {
		List<Product> products = fetchProducts();
		Assert.assertFalse("Product list is empty", products.isEmpty());
		List<Double> actualPrices = products.stream()
									  . map(Product::getPrice)
									  .collect(Collectors.toList());
		List<Double> expectedPrices=new ArrayList<>(actualPrices);
		Collections.sort(expectedPrices);
		Assert.assertEquals("Prices are not sorted from low to high",expectedPrices, actualPrices);
	}
}