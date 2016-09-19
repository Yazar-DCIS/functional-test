package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_8 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_8 extends WizardPage {

	private MultiRadioOptions marital;

	public SQ1_8(WebDriver driver) {
		super(driver);
	}

	public SQ1_8 applicantMaritalStatus(Properties data, String maritalStatus,
			int noOfMarriages) {
		marital = new MultiRadioOptions(driver,
				"applicationData-applicant.maritalInfo");
		if (maritalStatus.equalsIgnoreCase("single")) {
			marital.selectOption(1);
		}
		else if (maritalStatus.equalsIgnoreCase("widowed")) {
			marital.selectOption(2);
		}
		else if (maritalStatus.equalsIgnoreCase("divorced")) {
			marital.selectOption(3);
		}

		if (maritalStatus.equalsIgnoreCase("WIDOWED")
				|| (maritalStatus.equalsIgnoreCase("DIVORCED"))) {
			for (int i = 0; i < noOfMarriages; i++) {
				Name_FirstMiddleLast name = new Name_FirstMiddleLast(driver,
						"applicationData", "applicant.priorSpouseInfo[" + i
								+ "].name");
				name.setFirstNameField(data.getProperty("FirstName0"));
				name.setMiddleNameField(data.getProperty("MiddleName0"));
				name.setLastNameField(data.getProperty("LastName0"));

				DateTag dob = new DateTag(driver, "applicant.priorSpouseInfo["
						+ i + "].dateOfBirth");
				dob.selectMonth(data.getProperty("DOB_Month"));
				dob.selectDay(data.getProperty("DOB_Day"));
				dob.selectYear(data.getProperty("DOB_Year"));

				DateTag dateOfMarriage = new DateTag(driver,
						"applicant.priorSpouseInfo[" + i + "].dateOfMarriage");
				dateOfMarriage.selectDateAsSingle(data
						.getProperty("dateOfMarriage"));

				AdditionalInfoFields marriageCity = new AdditionalInfoFields(
						driver, "applicationData-applicant.priorSpouseInfo["
								+ i + "].placeOfMarriage-city");
				marriageCity.normalText(data.getProperty("City"));

				Address marriageCountry = new Address(driver,

				"applicationData-applicant.priorSpouseInfo[" + i
						+ "].placeOfMarriage.country");
				marriageCountry
						.setCountryDropDown(data.getProperty("I134_USA"));

				Address marriageState = new Address(driver,
						"applicationData-applicant.priorSpouseInfo[" + i
								+ "].placeOfMarriage");
				marriageState.setState(data.getProperty("I134_StateDD"));

				DateTag dateMarraigeEnded = new DateTag(driver,
						"applicant.priorSpouseInfo[" + i
								+ "].dateOfMarriageEnded");
				dateMarraigeEnded.selectDateAsSingle(data
						.getProperty("mrgEndDate"));

				AdditionalInfoFields marriageInfo = new AdditionalInfoFields(
						driver, "applicationData-applicant.priorSpouseInfo["
								+ i + "].placeOfMarriageEnded-city");
				marriageInfo.normalText(data.getProperty("City"));

				Address marriageEndedCountry = new Address(driver,

				"applicationData-applicant.priorSpouseInfo[" + i
						+ "].placeOfMarriageEnded.country");
				marriageEndedCountry.setCountryDropDown(data
						.getProperty("I134_USA"));

				Address marriageEndedState = new Address(driver,

				"applicationData-applicant.priorSpouseInfo[" + i
						+ "].placeOfMarriageEnded");
				marriageEndedState.setState(data.getProperty("I134_StateDD"));

				if (i < noOfMarriages - 1) {
					CommonInputClasses marriage = new CommonInputClasses(driver);
					marriage.addAnother();
				}
			}
		}
		saveScreenShot("i129f", "SQ1_8"); clickContinueInSQ();
		return this;
	}
}
