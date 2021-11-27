package com.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	public WebElement input_Username;

	@FindBy(name = "password")
	public WebElement input_Password;

	@FindBy(id = "login")
	public WebElement btn_Login;

	@FindBy(id = "recaptcha-anchor")
	public WebElement chkbox_Recaptcha;

	public boolean verifyIsPageLoaded(WebElement webElement) {
		boolean elementExists = true;
		if (! webElement.isDisplayed()) 
			throw new NoSuchElementException("WebElement is not displayed on the Window");
		return elementExists;
	}
	
	// Operations
	public void enterEmailAddress(String userName) {
		input_Username.sendKeys(userName);
	}

	public void enterPassword(String passWord) {
		input_Password.sendKeys(passWord);
	}

	// Services
	public void login(String userName, String passWord) {
		enterEmailAddress(userName);
		enterPassword(passWord);
		btn_Login.click();
	}

	
}
