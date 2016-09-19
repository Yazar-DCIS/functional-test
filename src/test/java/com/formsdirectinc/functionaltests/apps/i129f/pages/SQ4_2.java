package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_2 extends WizardPage {
	
	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_2 criminalRecord(Properties data, String domesticViolence,
			String crimes, String alcohol) {

		CrimeDetails crimeinfo=new CrimeDetails(driver);
		crimeinfo.informationOnCrimeWithoutExplain("applicant.personalHistory.domesticViolence", domesticViolence);
		crimeinfo.informationOnCrimeWithoutExplain("applicant.personalHistory.involvementInHomicide", crimes);
		crimeinfo.informationOnCrimeWithoutExplain("applicant.personalHistory.threeOrMoreAlcoholConvictions", alcohol);
		saveScreenShot("i129f", "SQ4_2"); clickContinueInSQ();
		return this;
	}
}
