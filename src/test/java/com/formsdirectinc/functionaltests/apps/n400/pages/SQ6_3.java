package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_3 extends WizardPage {


	public SQ6_3(WebDriver driver) {
		super(driver);

	}

	public SQ6_3 affiliationsQuestions(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("n400", "formSpecific.communistPartyDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.totalitarianPartyDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.terroristOrgDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.advocatedGovernmentDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.persecutedAnyPersonDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.workInNaziGermanyDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.workInNaziAreaDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.workInNaziRelatedUnitDetails", answers);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_3");
			
			 clickContinueInSQ();
			
		}
		return this;
	}

}
