package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_1 extends WizardPage {

	private YesNo haveEducation;
	private MultiRadioOptions educationLevel;
	private Address applicantAddress;
	private AdditionalInfoFields applicantDetails;
	private DateTag dateGraduated, dateOfLastAttendance;
	private AdditionalInfoFields state;
	private SelectElement applicantAddress1;

	public SQ4_1(WebDriver driver) {
		super(driver);

	}

	public SQ4_1 applicantEducationStatus(String educated,
			String qualification, Properties data) throws Exception {

		if (!educated.equalsIgnoreCase("Skip")) {
			if (educated.equalsIgnoreCase("Yes")) {
				haveEducation = new YesNo(driver,
						"initialApplication.educationalDetails.currentlyInSchool");
				haveEducation.yes();

				if (qualification.equalsIgnoreCase("School")) {
					educationLevel = new MultiRadioOptions(driver,

					"applicationData-initialApplication.educationalDetails.appliesToYou");
					educationLevel.selectOption(1);

					applicantDetails = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.educationalDetails.educationStatus");
					applicantDetails.normalText(data.getProperty("City"));

					applicantDetails = new AdditionalInfoFields(
							driver,

							"applicationData-initialApplication.educationalDetails.nameOfSchoolCurrentlyAttending");
					applicantDetails.normalText(data.getProperty("City"));

					applicantAddress = new Address(
							driver,

							"applicationData-initialApplication.educationalDetails.cityStateSchoolCurrentlyAttending.country");
					applicantAddress.setCountry(data.getProperty("Country"));

					applicantAddress = new Address(
							driver,

							"applicationData-initialApplication.educationalDetails.cityStateSchoolCurrentlyAttending");
					applicantAddress.setCity(data.getProperty("City"));

					state = new AdditionalInfoFields(
							driver,

							"applicationData-initialApplication.educationalDetails.cityStateSchoolCurrentlyAttending.state-statetext");
					state.normalText(data.getProperty("State"));

					dateOfLastAttendance = new DateTag(driver,

					"initialApplication.educationalDetails.dateOfLastAttendance");
					dateOfLastAttendance.selectDate(data.getProperty("DOB"));

				}

				else if (qualification.equalsIgnoreCase("Graduated")) {
					educationLevel = new MultiRadioOptions(driver,

					"applicationData-initialApplication.educationalDetails.appliesToYou");
					educationLevel.selectOption(2);

					applicantDetails = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.educationalDetails.educationStatus");
					applicantDetails.normalText(data.getProperty("City"));

					applicantDetails = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.educationalDetails.nameOfSchool");
					applicantDetails.normalText(data.getProperty("City"));

					applicantAddress = new Address(driver,
							"applicationData-initialApplication.educationalDetails.cityStateSchool.country");
					applicantAddress.setCountry(data.getProperty("Country"));

					applicantAddress = new Address(driver,
							"applicationData-initialApplication.educationalDetails.cityStateSchool");
					applicantAddress.setCity(data.getProperty("City"));

					applicantAddress1 = new SelectElement(driver,

					"initialApplication_educationalDetails_cityStateSchool_state_statetext");
					applicantAddress1.sendValuesUsingElementName(data
							.getProperty("arrestedState2"));

					dateGraduated = new DateTag(driver,
							"initialApplication.educationalDetails.dateOfGraduation");
					dateGraduated.selectDate(data.getProperty("DOB"));

				}

				else if (qualification.equalsIgnoreCase("GED")) {
					educationLevel = new MultiRadioOptions(driver,

					"applicationData-initialApplication.educationalDetails.appliesToYou");
					educationLevel.selectOption(3);

					applicantDetails = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.educationalDetails.educationStatus");
					applicantDetails.normalText(data.getProperty("City"));

					applicantDetails = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.educationalDetails.nameOfSchool");
					applicantDetails.normalText(data.getProperty("City"));

					applicantAddress = new Address(driver,
							"applicationData-initialApplication.educationalDetails.cityStateSchool.country");
					applicantAddress.setCountry(data.getProperty("Country"));

					applicantAddress = new Address(driver,
							"applicationData-initialApplication.educationalDetails.cityStateSchool");
					applicantAddress.setCity(data.getProperty("City"));

					applicantAddress = new Address(driver,
							"applicationData-initialApplication.educationalDetails.cityStateSchool");
					applicantAddress.setState(data
							.getProperty("arrestedState2"));

					dateGraduated = new DateTag(driver,
							"initialApplication.educationalDetails.dateOfGraduation");
					dateGraduated.selectDate(data.getProperty("DOB"));

				}
			}

			else if (educated.equalsIgnoreCase("No")) {
				haveEducation = new YesNo(driver,
						"initialApplication.educationalDetails.currentlyInSchool");
				haveEducation.no();
			}

		}

		return this;

	}

}
