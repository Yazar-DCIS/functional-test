package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_7 extends WizardPage {


	public SQ6_7(WebDriver driver) {
		super(driver);

	}

	public SQ6_7 otherOffences(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("n400", "crimeDetails.habitualDrunkard", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.prostitution", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.smuggled", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.marriedMoreThanOne", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.marriedInOrderToImmigrationBenefit", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.helpedIllegallyEntry", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.gambledIllegally", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.failedToSupportDependents", answers);
			crimes.informationRelatedToCrime("n400", "crimeDetails.misreperesentForPublicBenefit", answers);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_7");
			
			 clickContinueInSQ();
		}

		return this;
	}

}
