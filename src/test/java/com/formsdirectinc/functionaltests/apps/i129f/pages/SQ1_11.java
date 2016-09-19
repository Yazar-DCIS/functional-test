package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_11 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_11 extends WizardPage {

	private YesNo workStatus, currentOccup;
	private AdditionalInfoFields empName, empOccupation;
	private Address selectCountry;
	private DateTag workedFrom, workedTo;
	private CommonInputClasses selectAddress;

	public SQ1_11(WebDriver driver) {
		super(driver);
	}

	public SQ1_11 employmentAbroad(Properties data, String workedOutSideUS,
			String currentOccupation) {
		if (!workedOutSideUS.equalsIgnoreCase("NA")) {
			workStatus = new YesNo(driver, "applicant.workedOutOfUS");
			if (workedOutSideUS.equalsIgnoreCase("Yes")) {
				workStatus.yes();

				empName = new AdditionalInfoFields(driver,
						"applicationData-applicant.emplOutOfUS.employerName");
				empName.normalText(data.getProperty("I134_EmployerName"));

				selectCountry = new Address(driver,
						"applicationData-applicant.emplOutOfUS.employerAddress.country");
				selectCountry.setCountryDropDown(data
						.getProperty("I134_Country"));

				selectAddress = new CommonInputClasses(driver);
				selectAddress
						.applicantOtherAddressDetails(
								"applicationData-applicant.emplOutOfUS.employerAddress",
								data);

				empOccupation = new AdditionalInfoFields(driver,

				"applicationData-applicant.emplOutOfUS.occupation");
				empOccupation.normalText(data.getProperty("I134_Occupation"));

				currentOccup = new YesNo(driver,
						"applicant.emplOutOfUS.presentJob");
				if (currentOccupation.equalsIgnoreCase("Yes")) {
					currentOccup.yes();
				}
				else if (currentOccupation.equalsIgnoreCase("No")) {
					currentOccup.no();

					workedTo = new DateTag(driver,
							"applicant.emplOutOfUS.dateRange.toDate");
					workedTo.selectDate(data.getProperty("toDate"));
				}
				workedFrom = new DateTag(driver,
						"applicant.emplOutOfUS.dateRange.fromDate");
				workedFrom.selectDate(data.getProperty("fromDate"));

			}
			else if (workedOutSideUS.equalsIgnoreCase("No")) {
				workStatus.no();
			}
			saveScreenShot("i129f", "SQ1_11"); clickContinueInSQ();
		}
		return this;
	}
}
