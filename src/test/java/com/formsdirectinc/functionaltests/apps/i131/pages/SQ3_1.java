package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {
	private YesNo issuedDocBefore;
	private DateTag dateIssued;
	private AdditionalInfoFields disposition;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 docIssued(Properties data, String issuedReEntryPermit) {
		if (!issuedReEntryPermit.equalsIgnoreCase("NA")) {
			
			issuedDocBefore = new YesNo(driver, "applicant.issuedDocBefore");
			issuedDocBefore.setYesOrNo(issuedReEntryPermit);
			if (issuedReEntryPermit.equalsIgnoreCase("Yes")) {
				
				dateIssued = new DateTag(driver, "applicant.dateIssued");
				dateIssued.selectDateAsSingle(data
						.getProperty("I131_DateIssued"));

				disposition = new AdditionalInfoFields(driver,

				"applicationData-applicant.disposition");
				disposition.normalText("lost");
			}
			
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
