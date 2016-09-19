package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_3 extends WizardPage {
	private Address countrySelect;
	private AdditionalInfoFields careOfName;
	private CommonInputClasses address;
	private YesNo careOf;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 notificationAddress(Properties data,
			String notificationCountry, String careOfSomeOne) {
		if (!notificationCountry.equalsIgnoreCase("NA")) {
			if (notificationCountry.equalsIgnoreCase("USA")) {

				
				countrySelect = new Address(driver,
						"applicationData-applicant.notifyingAddress.country");
				countrySelect.setCountryDropDown("United States of America");

				address = new CommonInputClasses(driver);
				address.applicantAddressDetails(
						"applicationData-applicant.notifyingAddress", data);

				
			}
			else if (notificationCountry.equalsIgnoreCase("Others")) {

				
				countrySelect = new Address(driver,
						"applicationData-applicant.notifyingAddress.country");
				countrySelect.setCountryDropDown("India");

				address = new CommonInputClasses(driver);
				address.applicantOtherAddressDetails(
						"applicationData-applicant.notifyingAddress", data);

				
			}

			careOf = new YesNo(driver,"applicant.notifyingAddress.hasInCareOfAgent");
			careOf.setYesOrNo(careOfSomeOne);
			
			if (careOfSomeOne.equalsIgnoreCase("Yes")) {
				
				careOfName = new AdditionalInfoFields(driver,
							"applicationData-applicant.notifyingAddress.inCareOfAgentName");
				careOfName.normalText(data.getProperty("CareOfName"));
			}
			
			PhoneNumber phoneNo = new PhoneNumber(driver,
					"applicationData-applicant.notifyingPhoneNumber");
			phoneNo.setPhoneCode(data.getProperty("Phone1"));
			phoneNo.setPhoneNumber(data.getProperty("Phone2"));
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
