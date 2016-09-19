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
 * Page model for SQ1_5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5_2 extends WizardPage {

	private YesNo sameAddress, wantCareOf;
	private DateTag dateMoved;

	private CommonInputClasses applicantAddress;
	private AdditionalInfoFields careOfName;

	public SQ1_5_2(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_2 applicantResidenceDetails(Properties n400copies,
			String resideYears, Properties data, String residentInfo,
			String reqCareOfName) {

		if ((resideYears.equalsIgnoreCase("moreThan5") || resideYears
				.equalsIgnoreCase("lessThan5"))
				&& (residentInfo.equalsIgnoreCase("yes") || residentInfo
						.equalsIgnoreCase("no"))
				&& (reqCareOfName.equalsIgnoreCase("yes") || reqCareOfName
						.equalsIgnoreCase("no"))) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			try {

				copyValidation.verifyPageTableHeader(n400copies
						.getProperty("SQ-1.5.2.pageheader"));
				copyValidation.verifyPageSectionHeader(
						n400copies.getProperty("SQ-1.5.2.pagetext.2"),
						"section-1.5.2.1");

				for (int i = 0; i <= 8; i++) {
					copyValidation.verifyMultipleLabelText(n400copies
							.getProperty("SQ-1.5.2.addresslabel." + i),
							"section-1.5.2.1", i);
				}

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			/*applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantAddressDetails(
					"applicationData-applicant.homeAddress", data);*/
			
			Address testAddress=new Address(driver, "applicationData-applicant.homeAddress");
			testAddress.setStreet("123 Main Street");
			testAddress.setCity("San Francisco");
			testAddress.setState("CA");
			testAddress.setZipcode("91234");

			dateMoved = new DateTag(driver,
					"formSpecific.dateOfMoveToCurrentAddress");

			if (resideYears.equalsIgnoreCase("moreThan5")) {
				dateMoved.selectDate(data.getProperty("resideMoreThan5Yrs"));
			}

			else if (resideYears.equalsIgnoreCase("lessThan5")) {
				/*dateMoved.selectDate(data.getProperty("resideLessThan5Yrs"));*/
				dateMoved.selectDate("04-14-2015");
				
			}

			sameAddress = new YesNo(driver, "formSpecific.sameMailingAddress");

			if (residentInfo.equalsIgnoreCase("Yes")) {
				sameAddress.yes();

			}

			else if (residentInfo.equalsIgnoreCase("NO")) {
				sameAddress.no();

				try {

					copyValidation.verifyMultipleLabelText(
							n400copies.getProperty("SQ-1.5.2.pagetext.3a"),
							"section-1.5.2.2", 0);
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}
				wantCareOf = new YesNo(driver, "mailingAddress.mailingAddress.hasInCareOfAgent");

				if (reqCareOfName.equalsIgnoreCase("Yes")) {
					wantCareOf.yes();

					try {
						copyValidation.verifyMultipleLabelText(
								n400copies.getProperty("SQ-1.5.2.pagetext.3b"),
								"divCareOf", 0);
					} catch (Exception e) {
						System.out.println(e.getStackTrace());
					}
					careOfName = new AdditionalInfoFields(driver,

					"applicationData-mailingAddress.mailingAddress-inCareOfAgentName");
					careOfName.normalText(data.getProperty("LastName"));
				}
				else if (reqCareOfName.equalsIgnoreCase("NO")) {
					wantCareOf.no();
				}

				try {
					copyValidation.verifyPageMultiSectionHeader(
							n400copies.getProperty("SQ-1.5.2.pagetext.4"),
							"section-1.5.2.2", 0);
					for (int i = 0; i <= 5; i++) {
						copyValidation.verifyMultipleLabelText(
								n400copies.getProperty("SQ-1.5.2.addresslabel."
										+ i), "section-1.5.2.2", i + 1);
					}

				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				applicantAddress = new CommonInputClasses(driver);
				applicantAddress.applicantAddressDetails(
						"applicationData-mailingAddress.mailingAddress", data);

			}

			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_2");
			
			 clickContinueInSQ();
		}

		return this;
	}

}
