package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_6 extends WizardPage {

	private DateTag spouseDateOfMarriage;

	public SQ3_6(WebDriver driver) {
		super(driver);

	}

	public SQ3_6 spouseMarriageDetails(Properties copies, Properties data,
			String visit) {
		if (visit.equalsIgnoreCase("Yes")) {

			spouseDateOfMarriage = new DateTag(driver,
					"currentSpouse.marriedDate");
			spouseDateOfMarriage.selectDateAsSingle(data
					.getProperty("spouseDOM"));
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_6");
			
			 clickContinueInSQ();
		}

		return this;
	}

}
