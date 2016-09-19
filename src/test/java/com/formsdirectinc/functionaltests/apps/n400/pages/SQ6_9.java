package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_9 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_9 extends WizardPage {

	
	public SQ6_9(WebDriver driver) {
		super(driver);

	}

	public SQ6_9 removalDetails(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("n400", "formSpecific.anyPendingAgainstYou", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.removedFromUS", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.removeOrder", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.appliedRelief", answers);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_9");
			 clickContinueInSQ();
		}
		return this;
	}

}
