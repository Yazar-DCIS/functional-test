package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_8 extends WizardPage {

	private YesNo citizenCertificate, citizenPassport;
	private AdditionalInfoFields certificateDetails;
	private Address certAddress;

	public SQ1_8(WebDriver driver) {
		super(driver);

	}

	public SQ1_8 applicantNaturalizationCertificate(String citizenCertificates,
			String knowCertificateDetails, Properties data, String country) {

		if (!citizenCertificates.equalsIgnoreCase("na")
				&& !knowCertificateDetails.equalsIgnoreCase("na")
				&& !country.equalsIgnoreCase("na")) {
			citizenCertificate = new YesNo(driver,
					"applicant.haveCertificateOfNaturalization");

			if (citizenCertificates.equalsIgnoreCase("Yes")) {
				citizenCertificate.yes();

				certificateDetails = new AdditionalInfoFields(driver,
						"applicationData-applicant.naturalizationNumber");
				certificateDetails.normalText(data.getProperty("ARN"));

				DateTag certificateDates = new DateTag(driver,
						"applicant.citizenshipIssuedDate");
				certificateDates.selectDate(data.getProperty("fromDate"));

				certAddress = new Address(driver,
						"applicationData-applicant.citizenshipIssuedPlace.country");

				if (country.equalsIgnoreCase("insideUS")) {
					certAddress.setCountryDropDown(data
							.getProperty("DACA_Country"));
				}
				else if (country.equalsIgnoreCase("outsideUS")) {
					certAddress.setCountryDropDown(data.getProperty("Country"));
				}

				certAddress = new Address(driver,
						"applicationData-applicant.citizenshipIssuedPlace");

				certAddress.setCity(data.getProperty("City"));

				if (country.equalsIgnoreCase("insideUS")) {
					certAddress.setState(data.getProperty("tripState"));
				}
				else if (country.equalsIgnoreCase("outsideUS")) {
					certAddress.setStateText(data.getProperty("State"));
				}

			}

			else if (citizenCertificates.equalsIgnoreCase("No")) {
				citizenCertificate.no();

				citizenPassport = new YesNo(driver,
						"applicant.haveUSPassportNaturalization");
				citizenPassport.setYesOrNo(knowCertificateDetails);
				
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}
