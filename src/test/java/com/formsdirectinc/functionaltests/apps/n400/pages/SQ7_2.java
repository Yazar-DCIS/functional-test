package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_2 extends WizardPage {

	public SQ7_2(WebDriver driver) {
		super(driver);

	}

	public SQ7_2 honorableService(Properties copies, Properties keys,
			Properties data, String answer) {
		if (!answer.equalsIgnoreCase("NA")) {

			CrimeDetails honorableService=new CrimeDetails(driver);
			honorableService.informationRelatedToCrime("n400", "militaryDetails.leftUS", answer);
			honorableService.informationRelatedToCrime("n400", "militaryDetails.appliedExemption", answer);
			honorableService.informationRelatedToCrime("n400", "militaryDetails.desertedArmedForces", answer);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ7_2");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
