package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ5_2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2_1 extends WizardPage {

	private AdditionalInfoFields countryVisited;

	public SQ5_2_1(WebDriver driver) {
		super(driver);

	}

	public SQ5_2_1 tripsTakenOutsideUS(Properties copies, Properties data,
			String visitPage) {
		if (visitPage.equalsIgnoreCase("Yes")) {

			countryVisited = new AdditionalInfoFields(driver,

			"applicationData-travelHistory.explainNotSureDatesOfTravel");
			countryVisited.normalText(data.getProperty("tripCountryDate"));
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ5_2_1");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
