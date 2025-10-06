package com.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.utils.WaitUtil;

public class LoginPage {
	WaitUtil wait;

	@FindBy(id = "user-name")
	WebElement username;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(id = "login-button")
	WebElement loginBtn;

	@FindBy(css = "[data-test='error']")
	WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		wait = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void enterUserName(String userName) {
		wait.waitForElementVisible(username);
		username.sendKeys(userName);
	}

	public void enterPassword(String password) {
		wait.waitForElementVisible(this.password);
		this.password.sendKeys(password);
	}

	public void clickLoginButton() {
		wait.waitForElementClickable(loginBtn);
		loginBtn.click();
	}

	public void loginFormIsDisplayed() {
		username.isDisplayed();
		password.isDisplayed();
		loginBtn.isDisplayed();
	}

	public void hasErrorMessage(String errorMessage) {
		wait.waitForElementVisible(errorMsg);
		Assert.assertTrue(errorMsg.getText().contains(errorMessage));
	}
}