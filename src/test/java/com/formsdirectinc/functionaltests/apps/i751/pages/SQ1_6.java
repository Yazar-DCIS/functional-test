package com.formsdirectinc.functionaltests.apps.i751.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6 extends WizardPage {

	private CommonInputClasses arnInfo;
	private DateTag conPerResExpiry;

	public SQ1_6(WebDriver driver) {
		super(driver);

	}

	public SQ1_6 ARNDetails(Properties data) {

		arnInfo = new CommonInputClasses(driver);
		arnInfo.applicantARNDetails("applicationData-applicant.ARN", data);

		return this;
	}

	public void conditionalPermanentResidency(Properties data) {

		conPerResExpiry = new DateTag(driver,
				"formSpecific.conPermanentResExpire");

		conPerResExpiry.selectDate(data.getProperty("I751_DOE"));
	}

}
