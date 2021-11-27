package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Customer Login']")
	public WebElement heading_CustomerLogin;

	@FindBy(xpath = "//input[@name='username']")
	public WebElement input_Username;

	@FindBy(xpath = "//input[@name='password']")
	public WebElement input_Password;

	@FindBy(xpath = "//input[@value='Log In']")
	public WebElement btn_LogIn;

	public boolean verifyIsPageLoaded(WebElement webElement) {
		boolean elementExists = false;
		if (webElement.isDisplayed())
			elementExists = true;
		return elementExists;
	}

	public void enterUserName(String userName) {
		input_Username.sendKeys(userName);
	}

	public void enterPassword(String password) {
		input_Password.sendKeys(password);
	}

	public void clickLogin() {
		btn_LogIn.click();
	}

	// Services
	public AccountServicesPage doLogin(String userName, String password, WebDriver driver) {
		enterUserName(userName);
		enterPassword(password);
		clickLogin();
		return new AccountServicesPage(driver);
	}
}
