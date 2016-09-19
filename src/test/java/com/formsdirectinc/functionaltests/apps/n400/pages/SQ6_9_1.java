package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ6_9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_9_1 extends WizardPage {

	public SQ6_9_1(WebDriver driver) {
		super(driver);

	}

	public SQ6_9_1 crimeDetails(Properties copies, Properties keys,
			Properties data, String answer) {
		if (!answer.equalsIgnoreCase("NA")) {

			
			CrimeDetails crimeDetails=new CrimeDetails(driver);
			for (int i = 1; i < 16; i++) {
				crimeDetails.informationRelatedToCrime("n400", keys.getProperty("n400Crimes" + i), answer);
				
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_9_1");
			 clickContinueInSQ();
		}
		return this;
	}

}
