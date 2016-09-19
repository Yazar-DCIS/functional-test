package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_19 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_19 extends WizardPage {

	private YesNo workedPastFiveYears, currentlyWorking, presentJob;

	private Address emp_Address;

	private DateTag dateRangeFrom, dateRangeTo;

	private AdditionalInfoFields empName, empOccupation;

	public SQ1_19(WebDriver driver) {
		super(driver);

	}

	public SQ1_19 applicantEmploymentDetails(String country, String worked,
			String working, Properties data, String currentJob, int count) {

		if (!country.equalsIgnoreCase("na") && !worked.equalsIgnoreCase("na")
				&& !working.equalsIgnoreCase("na")
				&& !currentJob.equalsIgnoreCase("na") && count != -1) {

			workedPastFiveYears = new YesNo(driver,
					"applicant.workedPastFiveYears");
			if (worked.equalsIgnoreCase("Yes")) {
				workedPastFiveYears.yes();

				currentlyWorking = new YesNo(driver,"applicant.currentlyWorking");
				currentlyWorking.setYesOrNo(working);
				
				if (count > 0) {
					for (int i = 0; i < count; i++) {
						applicantEmploymentInfo(country, worked, working, data,
								currentJob, i);

						if ((i < count - 1)) {
							CommonInputClasses job = new CommonInputClasses(
									driver);
							job.addAnotherJob();
						}
					}

				}

			}

			else if (worked.equalsIgnoreCase("No")) {
				workedPastFiveYears.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public void applicantEmploymentInfo(String country, String worked,
			String working, Properties data, String currentJob, int count) {
		empName = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentInfo[" + count
						+ "].employerName");
		empName.normalText(data.getProperty("empName"));

		emp_Address = new Address(driver,
				"applicationData-applicant.employmentInfo[" + count
						+ "].employerAddress.country");
		if (country.equalsIgnoreCase("insideUS")) {
			emp_Address.setCountryDropDown(data.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			emp_Address.setCountryDropDown(data.getProperty("Country"));
		}

		emp_Address = new Address(driver,
				"applicationData-applicant.employmentInfo[" + count
						+ "].employerAddress");
		emp_Address.setStreet(data.getProperty("StreetName"));

		emp_Address.setCity(data.getProperty("City"));

		if (country.equalsIgnoreCase("insideUS")) {
			emp_Address.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			emp_Address.setStateText(data.getProperty("State"));
		}
		emp_Address.setZipcode(data.getProperty("Zipcode"));

		empOccupation = new AdditionalInfoFields(driver,
				"applicationData-applicant.employmentInfo[" + count
						+ "].occupation");
		empOccupation.normalText(data.getProperty("empOccupation"));

		presentJob = new YesNo(driver, "applicant.employmentInfo[" + count
				+ "].presentJob");
		if (currentJob.equalsIgnoreCase("Yes")) {
			presentJob.yes();
			dateRangeFrom = new DateTag(driver, "applicant.employmentInfo["
					+ count + "].dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

		}
		else if (currentJob.equalsIgnoreCase("No")) {
			presentJob.no();
			dateRangeFrom = new DateTag(driver, "applicant.employmentInfo["
					+ count + "].dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

			dateRangeTo = new DateTag(driver, "applicant.employmentInfo["
					+ count + "].dateRange.toDate");
			dateRangeTo.selectDate(data.getProperty("toDate"));

		}
	}

}
