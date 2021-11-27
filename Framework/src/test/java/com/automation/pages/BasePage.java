package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.automation.utilities.BrowserRetriever;
import com.automation.utilities.ExcelDataProvider;

public class BasePage {

	public WebDriver driver;
	ExcelDataProvider excelDataProvider;

	@BeforeSuite
	public void setUpSuite() {
		excelDataProvider = new ExcelDataProvider();
	}

	@BeforeMethod
	public void setUp() {
		driver = BrowserRetriever.initiateBrowser(driver, "edge", "https://parabank.parasoft.com/parabank/index.htm");
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
