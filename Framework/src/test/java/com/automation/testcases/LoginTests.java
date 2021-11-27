package com.automation.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automation.pages.BasePage;
import com.automation.pages.HomePage;
import com.automation.pages.LoginPage;

public class LoginTests extends BasePage{

	@Test
	public void verify_Is_Login_Successful() {

		HomePage homePage = new HomePage(driver);
		Assert.assertTrue(homePage.verifyIsPageLoaded(homePage.btn_Login));

		LoginPage loginPage = homePage.clickOnLogin(driver);
		Assert.assertTrue(loginPage.verifyIsPageLoaded(loginPage.btn_Login));
	}

}
