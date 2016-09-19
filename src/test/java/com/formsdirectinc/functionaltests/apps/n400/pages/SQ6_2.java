package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_2 extends WizardPage {

	public SQ6_2(WebDriver driver) {
		super(driver);

	}

	public SQ6_2 generalQuestions(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationRelatedToCrime("n400", "formSpecific.oweOverDueDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.titleOfNobilityDetails", answers);
			crimes.informationRelatedToCrime("n400", "formSpecific.incompetentLast5YearsDetails", answers);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_2");
			 clickContinueInSQ();
		
		}
		return this;
	}

}
