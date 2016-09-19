package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_7 extends WizardPage {

	private YesNo fatherInfo, motherInfo, mrgDate;
	private DateTag fatherDOB, motherDOB;
	private Name_FirstMiddleLast parentName;
	private Country parentCountry;

	SelectElement checkPageHeader;

	public SQ1_7(WebDriver driver) {
		super(driver);

	}

	public SQ1_7 parentsDetails(Properties n400copies, Properties data,
			String fatherUSCtzn, String motherUSCtzn, String knowMrgDate) {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		try {

			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.7.pageheader"));
			copyValidation.verifyPageLabelText(
					n400copies.getProperty("SQ-1.7.pagetext.1") + " "
							+ n400copies.getProperty("label-ExplainThis"),
					"section-1.7.1");
			copyValidation.verifyExplainThisText(n400copies
					.getProperty("control.explainthis.help.fatherUSCitizen"),
					"section-1.7.1", "fatherUSCitizen");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		fatherInfo = new YesNo(driver, "personalDetails.fatherUSCitizen");
		if (fatherUSCtzn.equalsIgnoreCase("Yes")) {

			fatherInfo.yes();

			try {

				copyValidation.verifyPageMultiSectionHeader(
						n400copies.getProperty("SQ-1.7.instructiontext1"),
						"section-1.7.2", 0);

				copyValidation.verifyPageMultiSectionHeader(
						n400copies.getProperty("SQ-1.7.pagetext.2"),
						"section-1.7.2", 1);

				for (int i = 0; i <= 3; i++) {
					copyValidation
							.verifyMultipleLabelText(n400copies
									.getProperty("SQ-1.7.fatherdetails." + i),
									"section-1.7.2", i);
				}
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.7.fatherdetails.4"),
						"section-1.7.2", 5);

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			parentName = new Name_FirstMiddleLast(driver, "applicationData",
					"personalDetails.fatherCurrentLegalName");
			parentName.setFirstNameField(data.getProperty("FatherName"));
			parentName.setLastNameField(data.getProperty("MiddleName"));

			parentCountry = new Country(driver,
					"applicationData-personalDetails.fatherCountryOfBirth");
			parentCountry.setCountryDDM(data.getProperty("Country"));

			fatherDOB = new DateTag(driver, "personalDetails.fatherDateOfBirth");
			fatherDOB.selectDate(data.getProperty("fatherDOB"));

		}

		else if (fatherUSCtzn.equalsIgnoreCase("No")) {
			fatherInfo.no();
		}

		try {

			copyValidation.verifyPageLabelText(
					n400copies.getProperty("SQ-1.7.pagetext.5") + " "
							+ n400copies.getProperty("label-ExplainThis"),
					"section-1.7.3");
			copyValidation.verifyExplainThisText(n400copies
					.getProperty("control.explainthis.help.motherUSCitizen"),
					"section-1.7.3", "motherUSCitizen");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		motherInfo = new YesNo(driver, "personalDetails.motherUSCitizen");

		if (motherUSCtzn.equalsIgnoreCase("Yes")) {
			motherInfo.yes();

			try {

				copyValidation.verifyPageMultiSectionHeader(
						n400copies.getProperty("SQ-1.7.instructiontext2"),
						"section-1.7.4", 0);

				copyValidation.verifyPageMultiSectionHeader(
						n400copies.getProperty("SQ-1.7.pagetext.7"),
						"section-1.7.4", 1);

				for (int i = 0; i <= 3; i++) {
					copyValidation
							.verifyMultipleLabelText(n400copies
									.getProperty("SQ-1.7.motherdetails." + i),
									"section-1.7.4", i);
				}
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.7.motherdetails.4"),
						"section-1.7.4", 5);
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			parentName = new Name_FirstMiddleLast(driver, "applicationData",
					"personalDetails.motherCurrentLegalName");
			parentName.setFirstNameField(data.getProperty("MotherName"));
			parentName.setLastNameField(data.getProperty("MiddleName"));

			parentCountry = new Country(driver,
					"applicationData-personalDetails.motherCountryOfBirth");
			parentCountry.setCountryDDM(data.getProperty("Country"));

			motherDOB = new DateTag(driver, "personalDetails.motherDateOfBirth");
			motherDOB.selectDate(data.getProperty("motherDOB"));

		}

		else if (motherUSCtzn.equalsIgnoreCase("No")) {
			motherInfo.no();
		}

		try {
			copyValidation.verifyMultipleLabelText(
					n400copies.getProperty("SQ-1.7.pagetext.6"),
					"section-1.7.5", 0);
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		mrgDate = new YesNo(driver, "personalDetails.parentsMarriedDate");
		mrgDate.setYesOrNo(knowMrgDate);

		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_7");
		
		 clickContinueInSQ();
		return this;
	}

}
