package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.automation.utilities.BrowserRetriever;

public class BasePage {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		driver = BrowserRetriever.initiateBrowser(driver, "edge", "https://phptravels.com/demo/");
	}

	@AfterClass
	public void TearDown() {
		BrowserRetriever.closeBrowser(driver);
	}

}
