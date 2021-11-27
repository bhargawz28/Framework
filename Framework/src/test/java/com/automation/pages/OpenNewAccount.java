package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OpenNewAccount {

	public WebDriver driver;

	public OpenNewAccount(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

}
