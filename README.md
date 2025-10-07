# SauceDemo E2E Test Suite

This project is a complete end-to-end test automation suite for [SauceDemo](https://www.saucedemo.com/) built using:

- Java 11
- Selenium WebDriver
- Cucumber (BDD)
- PageFactory
- Page Object Model (POM)
- WaitUtil for synchronization
- DriverFactory for driver lifecycle managed by WebDriverManager along
  with Cucumber Hooks
- ConfigReader for environment configuration


*********************************************************

# Configuration

# `config.properties`

*********************************************************

How to Run
1. Install Dependencies
Make sure you have:
- Java 11+
- Maven
- Chrome browser

To run test
1. Run pom.xml as Maven test
2. Run TestRunner.java as JUnit Test
2. using bash - mvn test

*********************************************************
TEST SCENARIOS INCLUDED

Scenario: Standard user is able to login with valid credentials

Scenario: Locked user is not able to perform login

Scenario: Standard user is not able to perform login with invalid password

Scenario: Logout from the home page

Scenario: Sort products by Price

Scenario: User is able to complete purchase of order

*********************************************************

Reports
After running tests, view the HTML report:
target/cucumber-report.html

 Notes
- All page interactions use explicit waits via WaitUtil.
- WebDriver is managed by DriverFactory using WebDriverManager.
- Page objects are implemented using POM with PageFactory.
- Configuration are loaded from config.properties
