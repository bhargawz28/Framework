package com.automation.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.automation.pages.BasePage;

public class Helpers {

	/**
	 * @param driver
	 */
	public static String captrueScreenshot(WebDriver driver) {
		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/Screenshots/" + BasePage.testCaseName + "_"
				+ Helpers.getCurrentDateAndTime() + ".png";
		File destinationPath = new File(destination);
		try {
			FileHandler.copy(sourceFile, destinationPath);
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}

		return destination;
	}

	/**
	 * @return
	 */
	public static String getCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return simpleDateFormat.format(date);

	}

}
