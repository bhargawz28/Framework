package com.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.pages.RegistrationPage;
import com.automation.helpers.Helpers;
import com.automation.pages.AccountServicesPage;

public class RegistrationTests extends BasePage {

	@Test
	public void verify_Registration_Successful() {

		extentTestLogger = extentReports.createTest("Verify User is able to get Registered successfully");

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyIsPageLoaded(homePage.heading_CustomerLogin));
		extentTestLogger.info("Home page loaded successfully");

		RegistrationPage registrationPage = homePage.clickOnRegister(driver);
		Assert.assertTrue(registrationPage.verifyIsPageLoaded(registrationPage.heading_SigningUpIsEasy));
		extentTestLogger.info("Registration page got loaded");

		registrationPage.setFirstName(Helpers.generateRandomString(7, "alphabet"));
		registrationPage.setLastName(Helpers.generateRandomString(7, "alphabet"));
		registrationPage.setUserName(Helpers.generateRandomString(7, "alphabet"));
		registrationPage.setPassword(Helpers.generateRandomString(7, "alphabet"));

		AccountServicesPage accountServicesPage = registrationPage.fillFormAndGetRegistered(
				registrationPage.getFirstName(), registrationPage.getLastName(),
				Helpers.generateRandomString(7, "alphabet"), Helpers.generateRandomString(2, "alphabet"),
				Helpers.generateRandomString(5, "numeric"), Helpers.generateRandomString(10, "numeric"),
				Helpers.generateRandomString(10, "numeric"), registrationPage.getUserName(),
				registrationPage.getPassword(), registrationPage.getPassword(), driver);
		Assert.assertTrue(accountServicesPage.verifyIsPageLoaded(accountServicesPage.heading_AccountServices));
		extentTestLogger.pass("User is able to get Registered successfully");
	}
}
