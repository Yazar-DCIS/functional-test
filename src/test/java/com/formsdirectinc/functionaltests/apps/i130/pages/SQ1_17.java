package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_17 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_17 extends WizardPage {

	private Name_FirstMiddleLast priorSpouseInfo;
	private DateTag dateOfBirth;
	private DateTag dateOfMarriage;
	private Address placeOfMarriage;
	private DateTag dateOfMarriageEnded;
	private Address placeOfMarriageEnded;

	public SQ1_17(WebDriver driver) {
		super(driver);

	}

	public SQ1_17 applicantPriorMarriages(Properties data, int countAnswer, String answerForCountry) {

		if (countAnswer != -1 && !answerForCountry.equalsIgnoreCase("na")) {

			if (countAnswer > 0) {
				for (int i = 0; i < countAnswer; i++) {
					set_PriorSpouseInfo(data, i);
					set_DateOfBirth(data, i);
					set_DateOfMarriage(data, i);
					set_PlaceOfMarriage(data, i, answerForCountry);
					set_DateOfMarriageEnded(data, i);
					set_PlaceOfMarriageEnded(data, i, answerForCountry);
					if ((i < countAnswer - 1)) {
						CommonInputClasses priorInfo = new CommonInputClasses(
								driver);
						priorInfo.addAnother();
					}
				}

			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void set_PriorSpouseInfo(Properties data, int count) {
		priorSpouseInfo = new Name_FirstMiddleLast(driver, "applicationData",
				"applicant.priorSpouseInfo[" + count + "].name");
		priorSpouseInfo.setFirstNameField(data.getProperty("FirstName"));
		priorSpouseInfo.setMiddleNameField(data.getProperty("MiddleName"));
		priorSpouseInfo.setLastNameField(data.getProperty("LastName"));

	}

	public void set_DateOfBirth(Properties data, int count) {
		dateOfBirth = new DateTag(driver, "applicant.priorSpouseInfo[" + count
				+ "].dateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));
	}

	public void set_DateOfMarriage(Properties data, int count) {
		dateOfMarriage = new DateTag(driver, "applicant.priorSpouseInfo["
				+ count + "].dateOfMarriage");
		dateOfMarriage.selectDate(data.getProperty("fromDate"));

	}

	public void set_PlaceOfMarriage(Properties data, int count, String country) {
		placeOfMarriage = new Address(driver,
				"applicationData-applicant.priorSpouseInfo[" + count
						+ "].placeOfMarriage.country");
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriage
					.setCountryDropDown(data.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriage.setCountryDropDown(data.getProperty("Country"));
		}
		placeOfMarriage = new Address(driver,
				"applicationData-applicant.priorSpouseInfo[" + count
						+ "].placeOfMarriage");
		placeOfMarriage.setCity(data.getProperty("City"));
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriage.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriage.setStateText(data.getProperty("State"));
		}
	}

	public void set_DateOfMarriageEnded(Properties data, int count) {
		dateOfMarriageEnded = new DateTag(driver, "applicant.priorSpouseInfo["
				+ count + "].dateOfMarriageEnded");
		dateOfMarriageEnded.selectMonth(data.getProperty("mrgEndMonth"));
		dateOfMarriageEnded.selectDay(data.getProperty("DayLeft"));
		dateOfMarriageEnded.selectYear(data.getProperty("mrgEndYear"));
	}

	public void set_PlaceOfMarriageEnded(Properties data, int count,
			String country) {
		placeOfMarriageEnded = new Address(driver,
				"applicationData-applicant.priorSpouseInfo[" + count
						+ "].placeOfMarriageEnded.country");
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriageEnded.setCountryDropDown(data
					.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriageEnded
					.setCountryDropDown(data.getProperty("Country"));
		}
		placeOfMarriageEnded = new Address(driver,
				"applicationData-applicant.priorSpouseInfo[" + count
						+ "].placeOfMarriageEnded");
		placeOfMarriageEnded.setCity(data.getProperty("City"));
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriageEnded.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriageEnded.setStateText(data.getProperty("State"));
		}

	}

}
