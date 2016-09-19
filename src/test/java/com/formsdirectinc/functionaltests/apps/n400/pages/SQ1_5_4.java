package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5_4 extends WizardPage {

	private YesNo sameAddress, careOfName;
	private DateTag dateMoved;
	private Address applicantAddress;
	private AdditionalInfoFields inCareName;

	public SQ1_5_4(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_4 applicantResidenceDetails(Properties n400copies,
			Properties data, String resideYears, String liveInSameAddr,
			String careName) {

		if ((resideYears.equalsIgnoreCase("moreThan5") || resideYears
				.equalsIgnoreCase("lessThan5"))
				&& (liveInSameAddr.equalsIgnoreCase("yes") || liveInSameAddr
						.equalsIgnoreCase("no"))
				&& (careName.equalsIgnoreCase("yes") || careName
						.equalsIgnoreCase("no"))) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			try {

				copyValidation.verifyPageTableHeader(n400copies
						.getProperty("SQ-1.5.4.pageheader"));
				copyValidation.verifyPageSectionHeader(
						n400copies.getProperty("SQ-1.5.3.pagetext.2"),
						"section-1.5.4.1");

				for (int i = 0; i <= 4; i++) {
					copyValidation.verifyMultipleLabelText(n400copies
							.getProperty("SQ-1.5.3.addresslabel." + i),
							"section-1.5.4.1", i);
				}

				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.5.3.addresslabel.5"),
						"section-1.5.4.1", 6);
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.5.3.addresslabel.6"),
						"section-1.5.4.1", 7);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			applicantAddress = new Address(driver,
					"applicationData-personalDetails.addressInternationalMilitaryDuty");
			applicantAddress.setStreet(data.getProperty("StreetName"));
			applicantAddress.setCity(data.getProperty("City"));
			applicantAddress.setZipcode(data.getProperty("Zipcode"));
			applicantAddress = new Address(driver,
					"applicationData-personalDetails.addressInternationalMilitaryDuty.country");
			applicantAddress.setCountryDropDown(data.getProperty("Country"));

			dateMoved = new DateTag(driver,
					"formSpecific.dateOfMoveToCurrentAddressInternationalMilitaryDuty");
			if (resideYears.equalsIgnoreCase("moreThan5")) {
				dateMoved.selectDate(data.getProperty("resideMoreThan5Yrs"));
			}
			else if (resideYears.equalsIgnoreCase("lessThan5")) {
				dateMoved.selectDate(data.getProperty("resideLessThan5Yrs"));
			}

			sameAddress = new YesNo(driver,
					"formSpecific.sameMailingAddressInternationalMilitaryDuty");
			if (liveInSameAddr.equalsIgnoreCase("Yes")) {
				sameAddress.yes();
			}
			else if (liveInSameAddr.equalsIgnoreCase("No")) {
				sameAddress.no();

				try {

					copyValidation.verifyMultipleLabelText(
							n400copies.getProperty("SQ-1.5.2.pagetext.3a"),
							"section-1.5.4.2", 0);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				careOfName = new YesNo(driver,
						"mailingAddress.mailingAddressInternationalMilitaryDuty.hasInCareOfAgent");

				if (careName.equalsIgnoreCase("Yes")) {
					careOfName.yes();
					try {
						copyValidation.verifyMultipleLabelText(
								n400copies.getProperty("SQ-1.5.2.pagetext.3b"),
								"section-1.5.4.2", 1);
					} catch (Exception e) {
						System.out.println(e.getStackTrace());
					}
					inCareName = new AdditionalInfoFields(driver,

					"applicationData-mailingAddress.mailingAddressInternationalMilitaryDuty-careof");
					inCareName.normalText(data.getProperty("LastName"));
				}
				else if (careName.equalsIgnoreCase("No")) {
					careOfName.no();
				}

				try {
					copyValidation.verifyPageMultiSectionHeader(
							n400copies.getProperty("SQ-1.5.2.pagetext.4"),
							"section-1.5.4.2", 0);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				applicantAddress = new Address(
						driver,

						"applicationData-mailingAddress.mailingAddressInternationalMilitaryDuty.country");
				applicantAddress
						.setCountryDropDown(data.getProperty("Country"));

				applicantAddress = new Address(driver,
						"applicationData-mailingAddress.mailingAddressInternationalMilitaryDuty");
				applicantAddress.setStreet(data.getProperty("StreetName"));
				applicantAddress.setCity(data.getProperty("City"));
				applicantAddress.setZipcode(data.getProperty("Zipcode"));

			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_4");
			
			 clickContinueInSQ();

		}
		return this;
	}

}
