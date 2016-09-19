package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_4 extends WizardPage {

	private YesNo mistakeMadeByUSCIS;
	private AdditionalInfoFields explain;

	public SQ3_4(WebDriver driver) {
		super(driver);
	}

	public SQ3_4 incorrect_Document(String reason, Properties data) {
		if (!reason.equalsIgnoreCase("NA")) {
			mistakeMadeByUSCIS = new YesNo(driver,"formSpecific.mistakeMadeByUSCIS");
			mistakeMadeByUSCIS.setYesOrNo(reason);
			explain = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.explainWhyMistake");
			explain.normalText(data.getProperty("Reasons"));
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
