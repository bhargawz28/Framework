package com.automation.pages;

import java.lang.reflect.Method;

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
	ConfigurationDataProvider configurationDataProvider;
	public static String testCaseName;
	Method method;

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
	public String[][] getData(Method method) {

		testCaseName = method.getName();

		int testCaseCount = excelDataProvider.getRowCount(testCaseName);
		int testDataCount = excelDataProvider.getCellCount(testCaseName, 1);

		String testCaseData[][] = new String[testCaseCount][testDataCount];

		for (int testCaseIterationId = 1; testCaseIterationId <= testCaseCount; testCaseIterationId++) {
			for (int testDataParameterId = 0; testDataParameterId < testDataCount; testDataParameterId++) {
				testCaseData[testCaseIterationId - 1][testDataParameterId] = excelDataProvider.getCellData(testCaseName,
						testCaseIterationId, testDataParameterId);
			}
		}
		return testCaseData;
	}

	@AfterMethod
	public void TearDown() {
		BrowserRetriever.closeBrowser(driver);
	}

}
