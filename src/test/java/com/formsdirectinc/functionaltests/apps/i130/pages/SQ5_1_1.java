package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_1_1 extends WizardPage {

	public SQ5_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ5_1_1 stopApplication() throws IOException {

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"src\\test\\resources\\images\\I130_SQ5_1_1.png"));

		return this;

	}

}
