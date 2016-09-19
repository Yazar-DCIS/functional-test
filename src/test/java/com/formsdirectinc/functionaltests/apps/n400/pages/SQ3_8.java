package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_8 extends WizardPage {

	private MultiRadioOptions spouseCtznShip;
	private DateTag ctznshipDate;

	public SQ3_8(WebDriver driver) {
		super(driver);

	}

	public SQ3_8 spouseCitizenshipDetails(Properties copies, Properties data,
			String spouseBecomeUSCitizen) {
		if (!spouseBecomeUSCitizen.equalsIgnoreCase("NA")) {

			spouseCtznShip = new MultiRadioOptions(driver,
					"applicationData-currentSpouse.spouseBecomeUSCitizen");

			if (spouseBecomeUSCitizen.equalsIgnoreCase("atBirth")) {
				spouseCtznShip.selectOption(1);
			}
			else if (spouseBecomeUSCitizen.equalsIgnoreCase("other")) {
				spouseCtznShip.selectOption(2);

				ctznshipDate = new DateTag(driver,
						"currentSpouse.dateOfCitizenship");
				ctznshipDate.selectDate(data.getProperty("ctznShipDate"));
			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_8");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
