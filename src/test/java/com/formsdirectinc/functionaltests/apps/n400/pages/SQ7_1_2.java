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
 * Page model for SQ7_1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ7_1_2 extends WizardPage {

	public SQ7_1_2(WebDriver driver) {
		super(driver);

	}

	public SQ7_1_2 applicantInEligible(Properties copies, String flow)
			throws IOException {
		if (flow.equalsIgnoreCase("Yes")) {

			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(
					"src\\test\\resources\\images\\N400_SQ7_1_2.png"));
			 clickContinueInSQ();
		}
		return this;
	}

}
