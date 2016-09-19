package com.formsdirectinc.functionaltests.apps.i134.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_3 extends WizardPage {
	private YesNo specificContibutions;
	private AdditionalInfoFields natureAndDurationOfContributions;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 YesSpecificContibutions() {
		specificContibutions = new YesNo(driver,
				"beneficiary.intendToMakeSpecificContribution");
		specificContibutions.yes();
		return this;
	}

	public SQ3_3 NoSpecificContibutions() {
		specificContibutions = new YesNo(driver,
				"beneficiary.intendToMakeSpecificContribution");
		specificContibutions.no();
		return this;
	}

	public SQ3_3 natureAndDurationOfContributions() {
		natureAndDurationOfContributions = new AdditionalInfoFields(driver,

		"applicationData-beneficiary.natureAndDurationOfContributions");
		natureAndDurationOfContributions.isStatusOther("Nature and Duration");
		return this;
	}

}
