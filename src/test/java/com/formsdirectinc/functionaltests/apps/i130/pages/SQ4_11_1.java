package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_11_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_11_1 extends WizardPage {

	private YesNo workedOutsideUS, presentJob;

	private Address emp_Address;

	private DateTag dateRangeFrom, dateRangeTo;

	private AdditionalInfoFields empName, empOccupation;

	public SQ4_11_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_11_1 spouseEmploymentDetailsOutsideUS(String worked,
			Properties data, String currentJob) {

		if (!worked.equalsIgnoreCase("na")
				&& !currentJob.equalsIgnoreCase("na")) {

			workedOutsideUS = new YesNo(driver, "spouseInfo.workedOutsideUS");
			workedOutsideUS.setYesOrNo(worked);
			if (worked.equalsIgnoreCase("Yes")) {
				
				spouseInfoEmploymentInfo(worked, data, currentJob);
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public void spouseInfoEmploymentInfo(String worked, Properties data,
			String currentJob) {
		empName = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.employmentOutsideUS.employerName");
		empName.normalText(data.getProperty("empName"));

		emp_Address = new Address(driver,
				"applicationData-spouseInfo.employmentOutsideUS.employerAddress.country");
		emp_Address.setCountryDropDown(data.getProperty("Country"));

		emp_Address = new Address(driver,
				"applicationData-spouseInfo.employmentOutsideUS.employerAddress");
		emp_Address.setStreet(data.getProperty("StreetName"));

		emp_Address.setCity(data.getProperty("City"));

		emp_Address.setBirthState(data.getProperty("State"));

		emp_Address.setZipcode(data.getProperty("Zipcode"));

		empOccupation = new AdditionalInfoFields(driver,
				"applicationData-spouseInfo.employmentOutsideUS.occupation");
		empOccupation.normalText(data.getProperty("empOccupation"));

		presentJob = new YesNo(driver,
				"spouseInfo.employmentOutsideUS.presentJob");
		if (currentJob.equalsIgnoreCase("Yes")) {
			presentJob.yes();
			dateRangeFrom = new DateTag(driver,
					"spouseInfo.employmentOutsideUS.dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

		}
		else if (currentJob.equalsIgnoreCase("No")) {
			presentJob.no();
			dateRangeFrom = new DateTag(driver,
					"spouseInfo.employmentOutsideUS.dateRange.fromDate");
			dateRangeFrom.selectDate(data.getProperty("fromDate"));

			dateRangeTo = new DateTag(driver,
					"spouseInfo.employmentOutsideUS.dateRange.toDate");
			dateRangeTo.selectDate(data.getProperty("toDate"));

		}
	}

}
