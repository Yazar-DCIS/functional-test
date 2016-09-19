package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Browser Options- A common class to use the driver, across all classes.
 * 
 * @author:Orina<br> Updated: 16- Nov-2015
 */
public class BrowserOptions {

	public WebDriver localDriver(Capabilities capabilities) {
		String browserType = capabilities.getBrowserName();
		if (browserType.equalsIgnoreCase("firefox"))
			return new FirefoxDriver(capabilities);
		if (browserType.equalsIgnoreCase("internet explorer"))
			return new InternetExplorerDriver(capabilities);
		if (browserType.equalsIgnoreCase("chrome"))
			return new ChromeDriver(capabilities);
		throw new Error("Unrecognized browser type: " + browserType);
	}

}