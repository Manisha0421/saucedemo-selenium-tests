Feature: Testing SauceDemo core functionality

  Scenario: Standard user is able to login with valid credentials
    Given user is on SauceDemo login page
    When enter username "standard_user" and password "secret_sauce"
    And click login button
    Then inventory page is visible

  Scenario: Locked user is not able to perform login
    Given user is on SauceDemo login page
    When enter username "locked_out_user" and password "secret_sauce"
    And click login button
    Then error message "Epic sadface: Sorry, this user has been locked out." is displayed

  Scenario: Standard user is not able to perform login with invalid password
    Given user is on SauceDemo login page
    When enter username "standard_user" and password "invalid_pass"
    And click login button
    Then error message "Epic sadface: Username and password do not match any user" is displayed

  Scenario: Logout from the home page
    Given user is on SauceDemo login page
    When enter username "standard_user" and password "secret_sauce"
    And click login button
    And inventory page is visible
    And user log out from the site
    Then user is on SauceDemo login page

  Scenario: Sort products by Price
    Given user is logged in with username "standard_user" and password "secret_sauce"
    And inventory page is visible
    When sort the products "Price (low to high)" filter
    Then products should be sorted accordingly

  Scenario Outline: User is able to complete purchase of order
    Given user is logged in with username "<username>" and password "<password>"
    And inventory page is visible
    When add product "<product>" to the shopping cart
    And navigate to the shopping cart page
    And the "<product>" product should be on the shopping cart
    And click on the checkout button
    And enter first name "<firstName>", last name "<lastName>" and postal code "<postalCode>" on the checkout data form
    And click continue button
    And user see a summary page
    And click Finish button
    Then "<confirmationMessage>" message is displayed on the screen

    Examples: 
      | username                | password     | product               | firstName | lastName | postalCode | confirmationMessage       |
      | standard_user           | secret_sauce | Sauce Labs Backpack   | Test      | User     |       4544 | Thank you for your order! |
      | performance_glitch_user | secret_sauce | Sauce Labs Bike Light | Test New  | User New |       1234 | Thank you for your order! |
