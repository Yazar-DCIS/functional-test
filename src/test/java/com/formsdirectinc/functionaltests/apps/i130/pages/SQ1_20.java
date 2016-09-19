package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_20 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_20 extends WizardPage {

	private YesNo workedOutsideUS, presentJob;

	private Address emp_Address;

	private DateTag dateRangeFrom, dateRangeTo;

	private AdditionalInfoFields empName, empOccupation;

	public SQ1_20(WebDriver driver) {
		super(driver);

	}

	public SQ1_20 applicantEmploymentDetailsOutsideUS(String worked,
			Properties data, String currentJob) {
		if (!worked.equalsIgnoreCase("na")
				&& !currentJob.equalsIgnoreCase("na")) {
			workedOutsideUS = new YesNo(driver, "applicant.workedOutsideUS");
			if (worked.equalsIgnoreCase("Yes")) {
				workedOutsideUS.yes();

				applicantEmploymentInfo(worked, data, currentJob);
			}

			else if (worked.equalsIgnoreCase("No")) {
				workedOutsideUS.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void applicantEmploymentInfo(String worked, Properties data,
			String currentJob) {
		empName = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentOutsideUS.employerName");
		empName.normalText(data.getProperty("empName"));

		emp_Address = new Address(driver,
				"applicationData-applicant.employmentOutsideUS.employerAddress.country");
		emp_Address.setCountryDropDown(data.getProperty("Country"));

		emp_Address = new Address(driver,
				"applicationData-applicant.employmentOutsideUS.employerAddress");
		emp_Address.setStreet(data.getProperty("StreetName"));

		emp_Address.setCity(data.getProperty("City"));

		emp_Address.setBirthState(data.getProperty("State"));

		emp_Address.setZipcode(data.getProperty("Zipcode"));

		empOccupation = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentOutsideUS.occupation");
		empOccupation.normalText(data.getProperty("empOccupation"));

		presentJob = new YesNo(driver,
				"applicant.employmentOutsideUS.presentJob");
		if (currentJob.equalsIgnoreCase("Yes")) {
			presentJob.yes();
			dateRangeFrom = new DateTag(driver,
					"applicant.employmentOutsideUS.dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

		}
		else if (currentJob.equalsIgnoreCase("No")) {
			presentJob.no();
			dateRangeFrom = new DateTag(driver,
					"applicant.employmentOutsideUS.dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

			dateRangeTo = new DateTag(driver,
					"applicant.employmentOutsideUS.dateRange.toDate");
			dateRangeTo.selectDate(data.getProperty("toDate"));

		}
	}

}
