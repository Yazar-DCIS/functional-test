package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {

	private YesNo ageAtleast21;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 ageAtleast21(String atleastTwentyOne) {
		
		if(atleastTwentyOne.equalsIgnoreCase("Yes")||atleastTwentyOne.equalsIgnoreCase("no"))
		{
		ageAtleast21 = new YesNo(driver, "applicant.atleastTwentyOne");
		ageAtleast21.setYesOrNo(atleastTwentyOne);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
