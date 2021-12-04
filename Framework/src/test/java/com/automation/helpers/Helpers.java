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

	public static void captrueScreenshot(WebDriver driver) {
		TakesScreenshot takesScreenshot = ((TakesScreenshot) driver);
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		File destinationPath = new File(System.getProperty("user.dir") + "/Screenshots/" + BasePage.testCaseName + "_"
				+ Helpers.getCurrentDateAndTime() + ".png");
		try {
			FileHandler.copy(sourceFile, destinationPath);
		} catch (Exception e) {
			System.out.println("Unable to capture screenshot" + e.getMessage());
		}
	}

	public static String getCurrentDateAndTime() {
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd_MM_yyyy_HH_mm_ss");
		return simpleDateFormat.format(date);

	}

}
