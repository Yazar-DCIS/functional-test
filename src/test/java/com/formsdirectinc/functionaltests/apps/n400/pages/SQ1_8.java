package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ1_8 extends WizardPage {

	private DateTag applicantDOB;
	private Country applicantBirthCountry, applicantNationality;
	private AdditionalInfoFields cityOfBirth;

	public SQ1_8(WebDriver driver) {
		super(driver);

	}

	public SQ1_8 applicantBirthDetails(Properties n400copies, Properties data,
			String age) {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);

		try {

			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.8.pageheader"));

			for (int i = 0; i <= 1; i++) {
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.8.pagetext." + i) + " "
								+ n400copies.getProperty("label-ExplainThis"),
						"section-1.8.1", i);
			}
			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.8.pagetext.2") + " "
							+ n400copies.getProperty("label-ExplainThis"),
					"section-1.8.1", 3);
			copyValidation
					.verifyMultipleExplainText(
							n400copies
									.getProperty("control.explainthis.title.dateOfBirth")
									+ "<br>"
									+ n400copies
											.getProperty("control.explainthis.help.dateOfBirth"),
							0, "dateOfBirth");
			copyValidation
					.verifyMultipleExplainText(
							n400copies
									.getProperty("control.explainthis.title.countryOfBirth")
									+ "<br>"
									+ n400copies
											.getProperty("control.explainthis.help.countryOfBirth"),
							1, "countryOfBirth");
			copyValidation
					.verifyMultipleExplainText(
							n400copies
									.getProperty("control.explainthis.title.nationality")
									+ "<br>"
									+ n400copies
											.getProperty("control.explainthis.help.nationality"),
							2, "nationality");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		applicantDOB = new DateTag(driver, "applicant.birth.dateOfBirth");

		if (age.equalsIgnoreCase("below18")) {
			applicantDOB.selectDate(data.getProperty("ageBelow18"));
		}

		else if (age.equalsIgnoreCase("above18")) {
			applicantDOB.selectDate(data.getProperty("ageAbove18"));
		}

		cityOfBirth = new AdditionalInfoFields(driver,
				"applicationData-applicant.cityOfBirth");
		cityOfBirth.normalText("Antwerp");

		applicantBirthCountry = new Country(driver,
				"applicationData-applicant.birth.countryOfBirth");
		applicantBirthCountry.setCountryDDM("Belgium");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		applicantNationality = new Country(driver,
				"applicationData-applicant.nationality");
		applicantNationality.setCountryDDM("Belgium");

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_8");
		
		 clickContinueInSQ();

		return this;
	}

}
