package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.automation.utilities.BrowserRetriever;
import com.automation.utilities.ConfigurationDataProvider;
import com.automation.utilities.ExcelDataProvider;

public class BasePage {

	public WebDriver driver;
	ExcelDataProvider excelDataProvider;
	public ConfigurationDataProvider configurationDataProvider;

	@BeforeSuite
	public void setUpSuite() {
		configurationDataProvider = new ConfigurationDataProvider();
		excelDataProvider = new ExcelDataProvider();
	}

	@BeforeMethod
	public void setUp() {
		
		// No need to pass driver object and initialize again to driver
		driver = BrowserRetriever.initiateBrowser(driver, configurationDataProvider.getBrowser(),
				configurationDataProvider.getURL());
	}

	@DataProvider
	public String[][] getData() {

		int testCaseCount = excelDataProvider.getRowCount("verify_Login_Successful");
		int testDataCount = excelDataProvider.getCellCount("verify_Login_Successful", 1);

		String testCaseData[][] = new String[testCaseCount][testDataCount];

		for (int testCaseIterationId = 1; testCaseIterationId <= testCaseCount; testCaseIterationId++) {
			for (int testDataParameterId = 0; testDataParameterId < testDataCount; testDataParameterId++) {
				testCaseData[testCaseIterationId - 1][testDataParameterId] = excelDataProvider
						.getCellData("verify_Login_Successful", testCaseIterationId, testDataParameterId);
			}
		}
		return testCaseData;
	}

	@AfterMethod
	public void TearDown() {
		BrowserRetriever.closeBrowser(driver);
	}

}
