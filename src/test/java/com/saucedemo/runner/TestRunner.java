package com.saucedemo.runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features",
                 glue = { "com.saucedemo.stepdefinitions" }, 
                 plugin = {
                		 "pretty", "html:target/cucumber-report.html",
						 "json:target/cucumber-report.json" }, 
                 monochrome = true,
                 dryRun = false)

public class TestRunner {
}