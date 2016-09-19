package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ2_6_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_6_2 extends WizardPage {

	private AdditionalInfoFields number;
	private YesNo haveELIS;

	public SQ2_6_2(WebDriver driver) {
		super(driver);

	}

	public void haveELIS(Properties data, String answer) {
		haveELIS = new YesNo(driver, "applicant.haveUscisElisaNumber");

		if (answer.equalsIgnoreCase("Yes")) {
			haveELIS.yes();
			number = new AdditionalInfoFields(driver,
					"applicationData-applicant.uscisElisaNumber");
			number.normalText(data.getProperty("ELIS"));
		}

		if (answer.equalsIgnoreCase("No")) {
			haveELIS.no();
		}
	}

}
