package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_5_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5_3 extends WizardPage {

	private YesNo sameAddress, careOfName;
	private DateTag dateMoved;
	private CommonInputClasses applicantAddress;
	private Address state, applicantAddresses;
	private AdditionalInfoFields inCareName;

	public SQ1_5_3(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_3 applicantResidenceDetails(Properties n400copies,
			Properties data, String resideYears, String liveInSameAddr,
			String reqCareOf) {
		if ((resideYears.equalsIgnoreCase("moreThan5") || resideYears
				.equalsIgnoreCase("lessThan5"))
				&& (liveInSameAddr.equalsIgnoreCase("yes") || liveInSameAddr
						.equalsIgnoreCase("no"))
				&& (reqCareOf.equalsIgnoreCase("yes") || reqCareOf
						.equalsIgnoreCase("no"))) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			try {

				copyValidation.verifyPageTableHeader(n400copies
						.getProperty("SQ-1.5.3.pageheader"));
				copyValidation.verifyPageSectionHeader(
						n400copies.getProperty("SQ-1.5.3.pagetext.2"),
						"section-1.5.3.1");

				for (int i = 0; i <= 6; i++) {
					copyValidation.verifyMultipleLabelText(n400copies
							.getProperty("SQ-1.5.3.addresslabel." + i),
							"section-1.5.3.1", i);
				}

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			dateMoved = new DateTag(driver,
					"formSpecific.dateOfMoveToCurrentAddressInternationalUSGovt");
			if (resideYears.equalsIgnoreCase("moreThan5")) {
				dateMoved.selectDate(data.getProperty("resideMoreThan5Yrs"));
			}
			else if (resideYears.equalsIgnoreCase("lessThan5")) {
				dateMoved.selectDate(data.getProperty("resideLessThan5Yrs"));
			}

			applicantAddress = new CommonInputClasses(driver);
			applicantAddress
					.ForeignAddress(
							"applicationData-personalDetails.addressInternationalUSGovt",
							data);

			try {

				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.5.3.pagetext.6"),
						"section-1.5.3.4", 0);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			state = new Address(driver,
					"applicationData-formSpecific.interviewState");
			state.setBirthState(data.getProperty("State"));

			sameAddress = new YesNo(driver,
					"formSpecific.sameMailingAddressInternationalUSGovt");
			if (liveInSameAddr.equalsIgnoreCase("Yes")) {
				sameAddress.yes();
			}
			else if (liveInSameAddr.equalsIgnoreCase("No")) {
				sameAddress.no();

				try {

					copyValidation.verifyMultipleLabelText(
							n400copies.getProperty("SQ-1.5.2.pagetext.3a"),
							"section-1.5.3.2", 0);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				careOfName = new YesNo(driver,
						"mailingAddress.mailingAddressInternationalUSGovt.hasInCareOfAgent");
				if (reqCareOf.equalsIgnoreCase("Yes")) {
					careOfName.yes();
					try {
						copyValidation
								.verifyMultipleLabelText(
										n400copies
												.getProperty("SQ-1.5.2.pagetext.3b"),
										"section_applicationData_mailingAddress_mailingAddressInternationalUSGovt-careof",
										0);
					} catch (Exception e) {
						System.out.println(e.getStackTrace());
					}
					inCareName = new AdditionalInfoFields(driver,

					"applicationData-mailingAddress.mailingAddressInternationalUSGovt-careof");
					inCareName.normalText(data.getProperty("LastName"));
				}
				else if (reqCareOf.equalsIgnoreCase("No")) {
					careOfName.no();
				}

				try {
					copyValidation.verifyPageMultiSectionHeader(
							n400copies.getProperty("SQ-1.5.2.pagetext.4"),
							"section-1.5.3.2", 0);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				applicantAddresses = new Address(driver,
						"applicationData-mailingAddress.mailingAddressInternationalUSGovt.country");
				applicantAddresses.setCountryDropDown(data
						.getProperty("Country"));

				applicantAddresses = new Address(driver,
						"applicationData-mailingAddress.mailingAddressInternationalUSGovt");
				applicantAddresses.setStreet(data.getProperty("StreetName"));
				applicantAddresses.setCity(data.getProperty("City"));

			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_3");
			
			 clickContinueInSQ();
		}

		return this;
	}

}
