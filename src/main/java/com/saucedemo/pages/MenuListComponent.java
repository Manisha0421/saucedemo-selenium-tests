package com.saucedemo.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.saucedemo.utils.WaitUtil;

public class MenuListComponent {
	WaitUtil wait;

    @FindBy(id = "react-burger-menu-btn")
    WebElement menuBtn;

    @FindBy(id = "logout_sidebar_link")
    WebElement logoutLink;

    public MenuListComponent(WebDriver driver) {
        wait = new WaitUtil(driver, 10);
        PageFactory.initElements(driver, this);
    }

    public void openMenuList() {
        wait.waitForElementClickable(menuBtn);
        menuBtn.click();
    }

    public void clickLogout() {
        wait.waitForElementClickable(logoutLink);
        logoutLink.click();
    }
}