package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_4_1 extends WizardPage {

	public SQ3_4_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_4_1 applicantInEligible(Properties copies, String flow)
			throws IOException

	{
		if (flow.equalsIgnoreCase("Yes")) {

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"src\\test\\resources\\images\\N400\\SQ3_4_1.png"));

		}
		return this;
	}

}
