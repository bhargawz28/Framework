package com.automation.pages;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.automation.helpers.Helpers;
import com.automation.utilities.BrowserRetriever;
import com.automation.utilities.ConfigurationDataProvider;
import com.automation.utilities.ExcelDataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class BasePage {

	public WebDriver driver;
	ExcelDataProvider excelDataProvider;
	ConfigurationDataProvider configurationDataProvider;
	public static String testCaseName;
	public ExtentReports extentReports;
	public ExtentTest extentTestLogger;
	Method method;

	@BeforeSuite
	public void setUpSuite() {
		configurationDataProvider = new ConfigurationDataProvider();
		excelDataProvider = new ExcelDataProvider();
		ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")
				+ "/Reports/" + configurationDataProvider.getValueForAttribute("executionreportfilename")
				+ Helpers.getCurrentDateAndTime() + ".html"));
		extentReports = new ExtentReports();
		extentReports.attachReporter(extentHtmlReporter);

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
	public void TearDown(ITestResult iTestResult) throws IOException {

		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			extentTestLogger.fail("Test Failed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpers.captrueScreenshot(driver)).build());
		} else {
			extentTestLogger.pass("Test Passed",
					MediaEntityBuilder.createScreenCaptureFromPath(Helpers.captrueScreenshot(driver)).build());
		}
		BrowserRetriever.closeBrowser(driver);
		extentReports.flush();

	}

}
