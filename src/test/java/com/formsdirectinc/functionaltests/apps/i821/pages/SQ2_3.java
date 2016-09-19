package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_3 extends WizardPage {

	public SQ2_3(WebDriver driver) {
		super(driver);
	}

	

	private CommonInputClasses mailingAddress;
	private YesNo hasInCareOfAgent;
	private AdditionalInfoFields inCareOfAgentName;
	private YesNo sameAddress;
	
	public SQ2_3 address_Detail(String incareof, Properties data,
			String addressstatus) {
		if (!incareof.equalsIgnoreCase("NA")) {

			mailingAddress = new CommonInputClasses(driver);
			mailingAddress.applicantAddressDetails(
					"applicationData-applicant.mailingAddress", data);

			hasInCareOfAgent = new YesNo(driver,
					"applicant.mailingAddress.hasInCareOfAgent");
			if (incareof.equalsIgnoreCase("Yes")) {

				hasInCareOfAgent.yes();
				inCareOfAgentName = new AdditionalInfoFields(driver,

				"applicationData-applicant.mailingAddress.inCareOfAgentName");
				inCareOfAgentName.normalText(data.getProperty("NewFirstName3"));

			}
			else if (incareof.equalsIgnoreCase("No")) {

				hasInCareOfAgent.no();
			}

			sameAddress = new YesNo(driver, "applicant.sameAddress");
			if (addressstatus.equalsIgnoreCase("Yes")) {

				sameAddress.yes();

			} else if (addressstatus.equalsIgnoreCase("No")) {
				sameAddress.no();
				mailingAddress.applicantAddressDetails(
						"applicationData-applicant.currentAddress", data);
			}

			PhoneNumber contactNumber = new PhoneNumber(driver,
					"applicationData-applicant.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));

			// e-mail address
			EMailAddress email = new EMailAddress(driver,
					"applicationData-applicant.contactMethods");
			email.setEMail(data.getProperty("Mail"));

			
			YesNo uscisNotification = new YesNo(driver,
					"applicant.uscisNotification");
			uscisNotification.no();
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
