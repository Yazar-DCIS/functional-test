package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_7_1 extends WizardPage {

	private YesNo passedFiveYearsAsLPR;

	public SQ2_7_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_7_1 passedFiveYearsAsLPR(String passedFiveYearsAsLPRStatus) {
		
		if(passedFiveYearsAsLPRStatus.equalsIgnoreCase("Yes")||passedFiveYearsAsLPRStatus.equalsIgnoreCase("no"))
		{
		passedFiveYearsAsLPR=new YesNo(driver,  "applicant.passedFiveYearsAsLPR");
		
		if(passedFiveYearsAsLPRStatus.equalsIgnoreCase("Yes"))
		{
			passedFiveYearsAsLPR.yes();
		}
		else if(passedFiveYearsAsLPRStatus.equalsIgnoreCase("no"))
		{
			passedFiveYearsAsLPR.no();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
