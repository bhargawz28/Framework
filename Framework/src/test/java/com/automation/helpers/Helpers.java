package com.automation.helpers;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

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

	/*
	 * 
	 */
	public static String generateRandomString(int length, String typeOfString) {

		StringBuilder stringBuilder = new StringBuilder();
		Random random = new Random();
		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		String numeric = "0123456789";
		String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";

		switch (typeOfString) {

		case "alphanumeric":

			for (int iniatilizer = 0; iniatilizer < length; iniatilizer++) {

				int index = random.nextInt(alphanumeric.length());
				char randomcharacter = alphanumeric.charAt(index);
				stringBuilder.append(randomcharacter);
			}

			break;

		case "numeric":

			for (int iniatilizer = 0; iniatilizer < length; iniatilizer++) {

				int index = random.nextInt(numeric.length());
				char randomcharacter = numeric.charAt(index);
				stringBuilder.append(randomcharacter);
			}

			break;

		default:

			for (int iniatilizer = 0; iniatilizer < length; iniatilizer++) {

				int index = random.nextInt(alphabet.length());
				char randomcharacter = alphabet.charAt(index);
				stringBuilder.append(randomcharacter);
			}

		}

		return stringBuilder.toString();
	} 

}
