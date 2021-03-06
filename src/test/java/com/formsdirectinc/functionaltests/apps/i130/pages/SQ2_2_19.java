package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_2_19 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2_19 extends WizardPage {

	public SQ2_2_19(WebDriver driver) {
		super(driver);

	}

	public SQ2_2_19 stopApplication() throws IOException {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"src\\test\\resources\\images\\I130_SQ2_2_19.png"));

		return this;

	}

}
