package com.automation.pages;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;
	ArrayList<String> tabs;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[text()='Login']")
	public WebElement btn_Login;

	public boolean verifyIsPageLoaded(WebElement webElement) {
		boolean elementExists = false;
		if (webElement.isDisplayed())
			elementExists = true;
		return elementExists;
	}

	// Services
	public LoginPage clickOnLogin(WebDriver driver) {
		btn_Login.click();
		tabs = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs.get(1));
		return new LoginPage(driver);
	}
}
