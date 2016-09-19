package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_1 extends WizardPage {

	
	public SQ6_1(WebDriver driver) {
		super(driver);

	}

	public SQ6_1 generalQuestions(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("n400", "formSpecific.claimDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.registeredToVoteDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.votedInElectionsDetails", answers);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_1");
			 clickContinueInSQ();
			
		}
		return this;
	}

}
