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
 * Page model for SQ2_7 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_7 extends WizardPage {

	private MultiRadioOptions marital;

	public SQ2_7(WebDriver driver) {
		super(driver);
	}

	public SQ2_7 fianceMaritalStatus(Properties data,
			String fianceMaritalStatus, double fianceNoOfMarriages) {
		marital = new MultiRadioOptions(driver,
				"applicationData-foreignFiance.marriageStatus");
		if (fianceMaritalStatus.equalsIgnoreCase("single")) {
			marital.selectOption(1);
		}
		else if (fianceMaritalStatus.equalsIgnoreCase("widowed")) {
			marital.selectOption(2);
		}
		else if (fianceMaritalStatus.equalsIgnoreCase("divorced")) {
			marital.selectOption(3);
		}

		else if (fianceMaritalStatus.equalsIgnoreCase("WIDOWED")
				|| (fianceMaritalStatus.equalsIgnoreCase("DIVORCED"))) {
			for (int i = 0; i < fianceNoOfMarriages; i++) {
				Name_FirstMiddleLast name = new Name_FirstMiddleLast(driver,
						"applicationData", "foreignFiance.priorMarriageInfo["
								+ i + "].name");
				name.setFirstNameField(data.getProperty("FirstName0"));
				name.setMiddleNameField(data.getProperty("MiddleName0"));
				name.setLastNameField(data.getProperty("LastName0"));

				DateTag dob = new DateTag(driver,
						"foreignFiance.priorMarriageInfo[" + i
								+ "].dateOfBirth");
				dob.selectMonth(data.getProperty("DOB_Month"));
				dob.selectDay(data.getProperty("DOB_Day"));
				dob.selectYear(data.getProperty("DOB_Year"));

				DateTag dateOfMarriage = new DateTag(driver,
						"foreignFiance.priorMarriageInfo[" + i
								+ "].dateOfMarriage");
				dateOfMarriage.selectDateAsSingle(data
						.getProperty("dateOfMarriage"));

				AdditionalInfoFields marriageCity = new AdditionalInfoFields(
						driver,
						"applicationData-foreignFiance.priorMarriageInfo[" + i
								+ "].placeOfMarriage-city");
				marriageCity.normalText(data.getProperty("City"));

				Address marriageCountry = new Address(driver,

				"applicationData-foreignFiance.priorMarriageInfo[" + i
						+ "].placeOfMarriage.country");
				marriageCountry
						.setCountryDropDown(data.getProperty("I134_USA"));

				Address marriageState = new Address(driver,
						"applicationData-foreignFiance.priorMarriageInfo[" + i
								+ "].placeOfMarriage");
				marriageState.setState(data.getProperty("I134_StateDD"));

				DateTag dateMarraigeEnded = new DateTag(driver,
						"foreignFiance.priorMarriageInfo[" + i
								+ "].dateOfMarriageEnded");
				dateMarraigeEnded.selectDateAsSingle(data
						.getProperty("mrgEndDate"));

				AdditionalInfoFields marriageInfo = new AdditionalInfoFields(
						driver,
						"applicationData-foreignFiance.priorMarriageInfo[" + i
								+ "].placeOfMarriageEnded-city");
				marriageInfo.normalText(data.getProperty("City"));

				Address marriageEndedCountry = new Address(driver,

				"applicationData-foreignFiance.priorMarriageInfo[" + i
						+ "].placeOfMarriageEnded.country");
				marriageEndedCountry.setCountryDropDown(data
						.getProperty("I134_USA"));

				Address marriageEndedState = new Address(driver,

				"applicationData-foreignFiance.priorMarriageInfo[" + i
						+ "].placeOfMarriageEnded");
				marriageEndedState.setState(data.getProperty("I134_StateDD"));

				if (i < fianceNoOfMarriages - 1) {
					CommonInputClasses marriage = new CommonInputClasses(driver);
					marriage.addAnother();
				}
			}
		}
		saveScreenShot("i129f", "SQ2_7"); clickContinueInSQ();
		return this;
	}
}
