package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1 extends WizardPage {

	private YesNo certificateNumber;
	private AdditionalInfoFields number;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 intention_Number(String intention_Number, Properties data) {
		if (!intention_Number.equalsIgnoreCase("NA")) {
			certificateNumber = new YesNo(driver,
					"formSpecific.knowYourCertificateNumber");
			certificateNumber.setYesOrNo(intention_Number);
			if (intention_Number.equalsIgnoreCase("Yes")) {
				
				number = new AdditionalInfoFields(driver,
						"applicationData-formSpecific.certificateNumber");
				number.isStatusOther(data.getProperty("i94_2"));
			} 
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
