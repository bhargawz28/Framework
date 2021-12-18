package com.automation.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

	public WebDriver driver;

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private String firstName;
	private String lastName;
	private String userName;
	private String password;

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	@FindBy(xpath = "//h1[text()='Signing up is easy!']")
	public WebElement heading_SigningUpIsEasy;

	@FindBy(id = "customer.firstName")
	public WebElement input_FirstName;

	@FindBy(id = "customer.lastName")
	public WebElement input_LastName;

	@FindBy(id = "customer.address.street")
	public WebElement input_Address;

	@FindBy(id = "customer.address.city")
	public WebElement input_City;

	@FindBy(id = "customer.address.state")
	public WebElement input_State;

	@FindBy(id = "customer.address.zipCode")
	public WebElement input_ZipCode;

	@FindBy(id = "customer.phoneNumber")
	public WebElement input_PhoneNumber;

	@FindBy(id = "customer.ssn")
	public WebElement input_SSN;

	@FindBy(id = "customer.username")
	public WebElement input_UserName;

	@FindBy(id = "customer.password")
	public WebElement input_Password;

	@FindBy(id = "repeatedPassword")
	public WebElement input_Confirm;

	@FindBy(xpath = "//*[@value='Register']")
	public WebElement button_Register;

	public boolean verifyIsPageLoaded(WebElement webElement) {
		boolean elementExists = true;
		if (!webElement.isDisplayed())
			throw new NoSuchElementException("WebElement is not displayed on the Window");
		return elementExists;
	}

	/*
	 * 
	 */
	public void enterFirstName(String firstName) {
		input_FirstName.sendKeys(firstName);
	}

	/*
	 * 
	 */
	public void enterLastName(String lastName) {
		input_LastName.sendKeys(lastName);
	}

	/*
	 * 
	 */
	public void enterAddress(String address) {
		input_Address.sendKeys(address);
	}

	/*
	 * 
	 */
	public void enterCity(String city) {
		input_City.sendKeys(city);
	}

	/*
	 * 
	 */
	public void enterState(String state) {
		input_State.sendKeys(state);
	}

	/*
	 * 
	 */
	public void enterZipCode(String zipCode) {
		input_ZipCode.sendKeys(zipCode);
	}

	/*
	 * 
	 */
	public void enterPhoneNumber(String phoneNumber) {
		input_PhoneNumber.sendKeys(phoneNumber);
	}

	/*
	 * 
	 */
	public void enterSSN(String ssNumber) {
		input_SSN.sendKeys(ssNumber);
	}

	/*
	 * 
	 */
	public void enterUserName(String userName) {
		input_UserName.sendKeys(userName);
	}

	/*
	 * 
	 */
	public void enterPassword(String password) {
		input_Password.sendKeys(password);
	}

	/*
	 * 
	 */
	public void enterConfirmPassword(String password) {
		input_Confirm.sendKeys(password);
	}

	/*
	 * 
	 */
	public void clickOnRegsiter() {
		button_Register.click();
	}

	/*
	 * 
	 */
	public AccountServicesPage fillFormAndGetRegistered(String firstName, String lastName, String address, String city,
			String state, String zipCode, String phoneNumber, String ssNumber, String userName, String password,
			WebDriver driver) {

		enterFirstName(firstName);
		enterLastName(lastName);
		enterAddress(address);
		enterCity(city);
		enterState(state);
		enterZipCode(zipCode);
		enterPhoneNumber(phoneNumber);
		enterSSN(ssNumber);
		enterUserName(userName);
		enterPassword(password);
		enterConfirmPassword(password);
		clickOnRegsiter();

		return new AccountServicesPage(driver);
	}
}
