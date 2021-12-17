package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.pages.AccountServicesPage;

public class HomePageTests extends BasePage {

	@Test(dataProvider = "getData")
	public void verify_Login_Successful(String userName, String password) {

		extentTestLogger = extentReports.createTest("Verify Registered User is able to Login successfully");

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyIsPageLoaded(homePage.heading_CustomerLogin));
		extentTestLogger.info("Home page loaded successfully");

		AccountServicesPage accountServicesPage = homePage.doLogin(userName, password, driver);
		Assert.assertTrue(accountServicesPage.verifyIsPageLoaded(accountServicesPage.heading_AccountServices));
		extentTestLogger.pass("Registered User is able to Login successfully");
	}
}
