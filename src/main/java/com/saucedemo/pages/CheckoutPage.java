package com.saucedemo.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.saucedemo.utils.WaitUtil;

public class CheckoutPage {
	WaitUtil wait;

	@FindBy(id = "first-name")
	WebElement firstName;

	@FindBy(id = "last-name")
	WebElement lastName;

	@FindBy(id = "postal-code")
	WebElement postalCode;

	@FindBy(id = "continue")
	WebElement continueBtn;

	@FindBy(id = "finish")
	WebElement finishBtn;

	@FindBy(className = "complete-header")
	WebElement confirmation;

	public CheckoutPage(WebDriver driver) {
		wait = new WaitUtil(driver, 10);
		PageFactory.initElements(driver, this);
	}

	public void fillForm(String firstname, String lastname, String postalcode) {
		wait.waitForElementVisible(firstName);
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		postalCode.sendKeys(postalcode);
	}

	public void clickContinue() {
		wait.waitForElementClickable(continueBtn);
		continueBtn.click();
	}

	public void clickFinish() {
		wait.waitForElementVisible(finishBtn);
		finishBtn.click();
	}

	public void hasConfirmation(String message) {
		wait.waitForElementVisible(confirmation);
		Assert.assertEquals("Order is not placed", message, confirmation.getText());
	}
}