package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_2_3 extends WizardPage {

	private YesNo otherMailingAddress;

	public SQ2_2_3(WebDriver driver) {
		super(driver);

	}

	public void otherMailingAddress() {

		otherMailingAddress = new YesNo(driver,
				"principalFormSpecific.haveMailingAddress");
		otherMailingAddress.no();

		YesNo hasInCareOfAgent = new YesNo(driver,
						"principalApplicant.mailingAddress.hasInCareOfAgent");
		hasInCareOfAgent.no();
		
	}

}
