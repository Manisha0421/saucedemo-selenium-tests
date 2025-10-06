package com.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.WaitUtil;

public class BasePage {
	WaitUtil wait;

	@FindBy(css = "[data-test='title']")
	WebElement pageTitle;

	public BasePage(WebDriver driver) {
		wait = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void hasTitle(String title) {
		wait.waitForElementVisible(pageTitle);
		Assert.assertEquals("Title does not match", title, pageTitle.getText().trim());
	}
}
