package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserRetriever {

	public static WebDriver initiateBrowser(WebDriver driver, String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver = new ChromeDriver();

		} else {
			System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/Drivers/msedgedriver.exe");
			driver = new EdgeDriver();

		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		return driver;
	}

	public static void closeBrowser(WebDriver driver) {

		driver.quit();
	}
}
