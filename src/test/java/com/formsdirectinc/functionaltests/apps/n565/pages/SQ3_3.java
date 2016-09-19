package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {

	private YesNo usCitizenship;

	private AdditionalInfoFields explanation;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 abt_YourUSCitizenship(String citizen, Properties data) {
		if (!citizen.equalsIgnoreCase("NA")) {
			usCitizenship = new YesNo(driver,
					"formSpecific.haveLostUSCitizenship");
			usCitizenship.setYesOrNo(citizen);
			if (citizen.equalsIgnoreCase("Yes")) {
				
				explanation = new AdditionalInfoFields(driver,

				"applicationData-formSpecific.explanationForLost");
				explanation.normalText(data.getProperty("Income"));
			} 
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
