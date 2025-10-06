package com.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import com.saucedemo.core.DriverFactory;

public class PageObjects {
    private WebDriver driver;

    private LoginPage loginPage;
    private InventoryPage inventoryPage;
    private CartPage cartPage;
    private CheckoutPage checkoutPage;
    private BasePage basePage;
    private MenuListComponent menuListComponent;

    public PageObjects() {
        this.driver = DriverFactory.getDriver();
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
    
    public BasePage getBasePage() {
        if (basePage == null) {
        	basePage = new BasePage(driver);
        }
        return basePage;
    }

    public InventoryPage getInventoryPage() {
        if (inventoryPage == null) {
            inventoryPage = new InventoryPage(driver);
        }
        return inventoryPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage(driver);
        }
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage(driver);
        }
        return checkoutPage;
    }
    
    public MenuListComponent getMenuListComponent() {
        if (menuListComponent == null) {
        	menuListComponent = new MenuListComponent(driver);
        }
        return menuListComponent;
    }
}