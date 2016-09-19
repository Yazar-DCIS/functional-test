package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ8_1 extends WizardPage {

	private YesNo currentActivity;
	private MultiRadioOptions employmentType;
	private Country applicantCountry;
	private CommonInputClasses applicantAddress;
	private DateTag workingDate;
	private AdditionalInfoFields employerName, occupation;

	public SQ8_1(WebDriver driver) {
		super(driver);

	}

	public SQ8_1 activityDetails(Properties copies, int count, Properties data,
			String empType, String currentEmp) {

		if (!empType.equalsIgnoreCase("NA")
				&& !currentEmp.equalsIgnoreCase("NA") && count != -1) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					activity(copies, i, data, empType, currentEmp);
					if (i < count - 1) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherActivity();
					}
				}
				CaptureScreen myscreen=new CaptureScreen(driver);
				myscreen.takeScreenShot("n400", "SQ8_1");
				 clickContinueInSQ();
			}
		}

		return this;

	}

	public SQ8_1 activity(Properties copies, int count, Properties data,
			String empType, String currentEmp) {

		employmentType = new MultiRadioOptions(driver,
				"applicationData-applicant.activity[" + count
						+ "].activitySelection");

		if (empType.equalsIgnoreCase("Employed")) {
			employmentType.selectOption(1);

			employerName = new AdditionalInfoFields(driver,
					"applicationData-applicant.activity[" + count
							+ "].employmentDetails.employerName");
			employerName.normalText(data.getProperty("NewFirstName0"));

			applicantCountry = new Country(driver,
					"applicationData-applicant.activity[" + count
							+ "].employmentDetails.employerAddress.country");
			applicantCountry
					.setCountryDDM(data.getProperty("EmplCountry"));

			/*applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantOtherAddressDetails(
					"applicationData-applicant.activity[" + count
							+ "].employmentDetails.employerAddress", data);*/
			Address testAddress=new Address(driver, "applicationData-applicant.activity[" + count+ "].employmentDetails.employerAddress");
			testAddress.setStreet("4009 Miranda Ave");
			testAddress.setCity("Palo Alto");
			testAddress.setState("CA");
			testAddress.setZipcode("94304");


			occupation = new AdditionalInfoFields(driver,
					"applicationData-applicant.activity[" + count
							+ "].employmentDetails.occupationEmp-occupationDDM");
			occupation.selectDDM(data.getProperty("occupation0"));

			currentActivity = new YesNo(driver, "applicant.activity[" + count
					+ "].employmentDetails.presentPeriod");
			if (currentEmp.equalsIgnoreCase("Yes")) {
				currentActivity.yes();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].employmentDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

			}
			else if (currentEmp.equalsIgnoreCase("No")) {
				currentActivity.no();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].employmentDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].employmentDetails.dateRange.toDate");
				workingDate.selectDate(data.getProperty("empEndDate0"));
			}

		}

		

		else if (empType.equalsIgnoreCase("SelfEmployed")) {
			employmentType.selectOption(2);
		}
		else if (empType.equalsIgnoreCase("Unemployed")) {
			employmentType.selectOption(3);
		}

		else if (empType.equalsIgnoreCase("Retired")) {
			employmentType.selectOption(4);
		}

		else if (empType.equalsIgnoreCase("Homemaker")) {
			employmentType.selectOption(5);
		}

		else if ((empType.equalsIgnoreCase("SelfEmployed"))
				|| (empType.equalsIgnoreCase("Unemployed"))
				|| (empType.equalsIgnoreCase("Retired"))
				|| (empType.equalsIgnoreCase("Homemaker"))) {
			applicantCountry = new Country(driver,
					"applicationData-applicant.activity[" + count
							+ "].otherDetails.employerAddress.country");
			applicantCountry.setCountryDDM(data.getProperty("Country"));

			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantOtherAddressDetails(
					"applicationData-applicant.activity[" + count
							+ "].otherDetails.employerAddress", data);

			currentActivity = new YesNo(driver, "applicant.activity[" + count
					+ "].otherDetails.presentPeriod");
			if (currentEmp.equalsIgnoreCase("Yes")) {
				currentActivity.yes();
				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));
			}

			else if (currentEmp.equalsIgnoreCase("No")) {
				currentActivity.no();
				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.toDate");
				workingDate.selectDate(data.getProperty("empEndDate0"));
			}
		}

		

		else if (empType.equalsIgnoreCase("Student")) {
			employmentType.selectOption(6);

			employerName = new AdditionalInfoFields(driver,
					"applicationData-applicant.activity[" + count
							+ "].educationDetails.employerName");
			employerName.normalText(data.getProperty("NewFirstName0"));

			applicantCountry = new Country(driver,
					"applicationData-applicant.activity[" + count
							+ "].educationDetails.employerAddress.country");
			applicantCountry
					.setCountryDDM(data.getProperty("arrestedCountry0"));

			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantOtherAddressDetails(
					"applicationData-applicant.activity[" + count
							+ "].educationDetails.employerAddress", data);

			currentActivity = new YesNo(driver, "applicant.activity[" + count
					+ "].educationDetails.presentPeriod");
			if (currentEmp.equalsIgnoreCase("Yes")) {
				currentActivity.yes();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].educationDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

			}
			else if (currentEmp.equalsIgnoreCase("No")) {
				currentActivity.no();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].educationDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].educationDetails.dateRange.toDate");
				workingDate.selectDate(data.getProperty("empEndDate0"));
			}

		}

		else if (empType.equalsIgnoreCase("Other")) {
			employmentType.selectOption(7);

			employerName = new AdditionalInfoFields(driver,
					"applicationData-applicant.activity[" + count
							+ "].typeOfActivity");
			employerName.normalText(data.getProperty("NewFirstName0"));

			applicantCountry = new Country(driver,
					"applicationData-applicant.activity[" + count
							+ "].otherDetails.employerAddress.country");
			applicantCountry
					.setCountryDDM(data.getProperty("arrestedCountry0"));

			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantOtherAddressDetails(
					"applicationData-applicant.activity[" + count
							+ "].otherDetails.employerAddress", data);

			currentActivity = new YesNo(driver, "applicant.activity[" + count
					+ "].otherDetails.presentPeriod");
			if (currentEmp.equalsIgnoreCase("Yes")) {
				currentActivity.yes();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

			}
			else if (currentEmp.equalsIgnoreCase("No")) {
				currentActivity.no();

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.fromDate");
				workingDate.selectDate(data.getProperty("empStartDate0"));

				workingDate = new DateTag(driver, "applicant.activity[" + count
						+ "].otherDetails.dateRange.toDate");
				workingDate.selectDate(data.getProperty("empEndDate0"));
			}

		}

		return this;
	}

}
