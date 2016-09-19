package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_9 extends WizardPage {

	private YesNo spousePrevoiuslyMarried;
	private Name_FirstMiddleLast spousename;
	private DateTag dateofbirth, spouseDateOfMarriage,
			spouseDateOfMarriageEnded;
	private Address placeOfMarriage, placeOfMarriageEnded;

	public SQ4_9(WebDriver driver) {
		super(driver);

	}

	public SQ4_9 spousePriorSpouseMarriageInfo(
			String relativeSpouseMarriedBefore, Properties data, int count,
			String country) {

		if (!relativeSpouseMarriedBefore.equalsIgnoreCase("na")
				&& !country.equalsIgnoreCase("na") && count != -1) {
			spousePrevoiuslyMarried = new YesNo(driver,
					"spouseInfo.previouslyMarried");

			if (relativeSpouseMarriedBefore.equalsIgnoreCase("Yes")) {
				spousePrevoiuslyMarried.yes();

				if (count > 0) {
					for (int i = 0; i < count; i++) {

						spousePriorSpouseName(data, i);
						spousePriorSpouseDateOfBirth(data, i);
						spousePriorSpouseDateOfMarriage(data, i);
						spousePriorSpousePlaceOfMarriage(data, i, country);
						spousePriorSpouseDateOfMarriageEnded(data, i);
						spousePriorSpousePlaceOfMarriageEnded(data, i, country);
						if ((i < count - 1)) {
							CommonInputClasses others = new CommonInputClasses(
									driver);
							others.addAnother();
						}
					}

				}

			}

			else if (relativeSpouseMarriedBefore.equalsIgnoreCase("No")) {
				spousePrevoiuslyMarried.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

	public void spousePriorSpouseName(Properties data, int count) {
		spousename = new Name_FirstMiddleLast(driver, "applicationData",
				"spouseInfo.priorSpouseInfo[" + count + "].name");
		spousename.setFirstNameField(data.getProperty("Spouse_Fname"));
		spousename.setMiddleNameField(data.getProperty("Spouse_Mname"));
		spousename.setLastNameField(data.getProperty("Spouse_Lname"));

	}

	public void spousePriorSpouseDateOfBirth(Properties data, int count) {
		dateofbirth = new DateTag(driver, "spouseInfo.priorSpouseInfo[" + count
				+ "].dateOfBirth");
		dateofbirth.selectMonth(data.getProperty("DOB_Month"));
		dateofbirth.selectDay(data.getProperty("DOB_Day"));
		dateofbirth.selectYear(data.getProperty("DOB_Year"));

	}

	public void spousePriorSpouseDateOfMarriage(Properties data, int count) {
		spouseDateOfMarriage = new DateTag(driver,
				"spouseInfo.priorSpouseInfo[" + count + "].dateOfMarriage");
		spouseDateOfMarriage.selectMonth(data.getProperty("fromMonth"));
		spouseDateOfMarriage.selectDay(data.getProperty("DOB_Day"));
		spouseDateOfMarriage.selectYear(data.getProperty("fromYear"));

	}

	public void spousePriorSpousePlaceOfMarriage(Properties data, int count,
			String country) {
		placeOfMarriage = new Address(driver,
				"applicationData-spouseInfo.priorSpouseInfo[" + count
						+ "].placeOfMarriage.country");
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriage
					.setCountryDropDown(data.getProperty("DACA_Country"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriage.setCountryDropDown(data.getProperty("Country"));
		}
		placeOfMarriage = new Address(driver,
				"applicationData-spouseInfo.priorSpouseInfo[" + count
						+ "].placeOfMarriage");
		placeOfMarriage.setCity(data.getProperty("City"));
		if (country.equalsIgnoreCase("insideUS")) {
			placeOfMarriage.setState(data.getProperty("tripState"));
		}
		else if (country.equalsIgnoreCase("outsideUS")) {
			placeOfMarriage.setStateText(data.getProperty("State"));
		}
	}

	public void spousePriorSpouseDateOfMarriageEnded(Properties data, int count) {
		spouseDateOfMarriageEnded = new DateTag(driver,
				"spouseInfo.priorSpouseInfo[" + count + "].dateOfMarriageEnded");
		spouseDateOfMarriageEnded.selectMonth(data.getProperty("toMonth"));
		spouseDateOfMarriageEnded.selectDay(data.getProperty("DOB_Day"));
		spouseDateOfMarriageEnded.selectYear(data.getProperty("toYear"));

	}

	public void spousePriorSpousePlaceOfMarriageEnded(Properties data,
			int count, String country) {
		placeOfMarriageEnded = new Address(driver,
				"applicationData-spouseInfo.priorSpouseInfo[" + count
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
				"applicationData-spouseInfo.priorSpouseInfo[" + count
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
