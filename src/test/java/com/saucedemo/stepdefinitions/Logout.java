package com.saucedemo.stepdefinitions;

import com.saucedemo.pages.MenuListComponent;
import com.saucedemo.pages.PageObjects;

import io.cucumber.java.en.And;

public class Logout {

	PageObjects pageObjects = new PageObjects();
	MenuListComponent menuListComponent = pageObjects.getMenuListComponent();

	@And("user log out from the site")
	public void performLogout() {
		menuListComponent.openMenuList();
		menuListComponent.clickLogout();
	}
}
