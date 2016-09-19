package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3_1 extends WizardPage {

	private CommonInputClasses applicantAddress;
	private DateTag dateMoved;
	private YesNo otherAddress;

	private AddAnotherField addotherAddress;

	public SQ2_3_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_3_1 applicantCurrentAddress(String otherAddresses, int count,
			Properties data) throws Exception {
		if (!otherAddresses.equalsIgnoreCase("Skip")) {
			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantAddressDetails(
					"applicationData-applicant.currentAddress", data);

			dateMoved = new DateTag(driver,
					"initialApplication.currentAddressDate");
			dateMoved.selectDateAsSingle(data.getProperty("DateEntered"));

			otherAddress = new YesNo(driver,
					"initialApplication.otherAddressResidence");
			otherAddress.setYesOrNo(otherAddresses);
			if (otherAddresses.equalsIgnoreCase("Yes")) {
				addotherAddress = new AddAnotherField(driver);
				addotherAddress.addAnotherAddress(count, data,
						"initialApplication");
			}

		}
		return this;

	}

}
