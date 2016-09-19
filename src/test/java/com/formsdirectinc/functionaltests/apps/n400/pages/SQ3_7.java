package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_7 extends WizardPage {

	private YesNo spouseCtznShip;

	public SQ3_7(WebDriver driver) {
		super(driver);

	}

	public SQ3_7 spouseCitizenshipDetails(Properties copies, Properties data,
			String isSpouseUSCitizen) {

		if (isSpouseUSCitizen.equalsIgnoreCase("yes")||isSpouseUSCitizen.equalsIgnoreCase("no")) {

			spouseCtznShip = new YesNo(driver, "currentSpouse.spouseUSCitizen");
			spouseCtznShip.setYesOrNo(isSpouseUSCitizen);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_7");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
