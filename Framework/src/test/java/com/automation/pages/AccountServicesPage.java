package com.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountServicesPage {

	public WebDriver driver;

	public AccountServicesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[text()='Account Services']")
	public WebElement heading_AccountServices;

	@FindBy(xpath = "//a[text()='Open New Account']")
	public WebElement lnk_OpenNewAccount;

	@FindBy(xpath = "//a[text()='Accounts Overview']")
	public WebElement lnk_AccountsOverview;

	@FindBy(xpath = "//a[text()='Log Out']")
	public WebElement lnk_logOut;

	public boolean verifyIsPageLoaded(WebElement webElement) {
		boolean elementExists = true;
		if (!webElement.isDisplayed())
			throw new NoSuchElementException("WebElement is not displayed on the Window");
		return elementExists;
	}

	public void clickOnOpenNewAccount() {
		lnk_OpenNewAccount.click();
	}
	
	public OpenNewAccount navigateToNewAccount(WebDriver driver) {
		clickOnOpenNewAccount();
		return new OpenNewAccount(driver);
	}

}
