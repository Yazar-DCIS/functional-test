package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_5 extends WizardPage {

	private DateTag spouseDateOfBirth;

	public SQ3_5(WebDriver driver) {
		super(driver);

	}

	public SQ3_5 spouseBirthDetails(Properties copies, Properties data,
			String visitPage) {
		if (visitPage.equalsIgnoreCase("Yes")) {

			spouseDateOfBirth = new DateTag(driver, "currentSpouse.dateOfBirth");
			spouseDateOfBirth.selectDate(data.getProperty("spouseDOB"));

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_5");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
