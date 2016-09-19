package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ3_12 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_12 extends WizardPage {

	private MultiRadioOptions howMrgEnded, immigrationStatus;
	private Country spouseBirthCountry, spouseNationalityCountry;
	private Name_FirstMiddleLast spouseName;
	private DateTag mrgEndDate, mrgStartDate, dateOfBirth;
	private AdditionalInfoFields reasons;

	public SQ3_12(WebDriver driver) {
		super(driver);

	}

	public SQ3_12 otherSpouseMoreDetails(Properties copies, Properties data,
			String mrgEndReason, String immigrationType, int count) {

		if ((count != -1) && (!mrgEndReason.equalsIgnoreCase("NA"))
				&& (!immigrationType.equalsIgnoreCase("NA"))) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					otherSpouseDetails(copies, data, i, mrgEndReason,
							immigrationType);
					if (i < count - 1) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnother();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_12");
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ3_12 otherSpouseDetails(Properties copies, Properties data, int i,
			String mrgEndReason, String immigrationType) {

		spouseName = new Name_FirstMiddleLast(driver, "applicationData",
				"currentSpouse.priorSpouse[" + i + "].name");
		spouseName.setFirstNameField(data.getProperty("FirstName"));
		spouseName.setLastNameField(data.getProperty("LastName"));

		dateOfBirth = new DateTag(driver, "currentSpouse.priorSpouse[" + i
				+ "].spouseDateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"));

		spouseBirthCountry = new Country(driver,
				"applicationData-currentSpouse.priorSpouse[" + i
						+ "].spouseCountryOfBirth");
		spouseBirthCountry.setCountryDDM(data.getProperty("Country"));

		spouseNationalityCountry = new Country(driver,
				"applicationData-currentSpouse.priorSpouse[" + i
						+ "].spouseCountryOfCitizenship");
		spouseNationalityCountry.setCountryDDM(data.getProperty("Country"));

		mrgStartDate = new DateTag(driver, "currentSpouse.priorSpouse[" + i
				+ "].dateOfMarriage");
		mrgStartDate.selectDateAsSingle(data.getProperty("mrgStartDate"));

		mrgEndDate = new DateTag(driver, "currentSpouse.priorSpouse[" + i
				+ "].dateMarriageEnded");
		mrgEndDate.selectDateAsSingle(data.getProperty("mrgEndDate"));

		howMrgEnded = new MultiRadioOptions(driver,
				"applicationData-currentSpouse.priorSpouse[" + i
						+ "].howMarriageEnded");

		if (mrgEndReason.equalsIgnoreCase("Annulled")) {
			howMrgEnded.selectOption(1);
		}
		else if (mrgEndReason.equalsIgnoreCase("Divorced")) {
			howMrgEnded.selectOption(2);
		}
		else if (mrgEndReason.equalsIgnoreCase("Widowed")) {
			howMrgEnded.selectOption(3);
		}
		else if (mrgEndReason.equalsIgnoreCase(" Other")) {
			howMrgEnded.selectOption(4);

			reasons = new AdditionalInfoFields(driver,
					"applicationData-currentSpouse.priorSpouse[" + i
							+ "].whyMarriageEnded");
			reasons.normalText(data.getProperty("mrgEndedReason"));
		}

		immigrationStatus = new MultiRadioOptions(driver,
				"applicationData-currentSpouse.priorSpouse[" + i
						+ "].immigrationStatus");

		if (immigrationType.equalsIgnoreCase("US_Citizen")) {
			immigrationStatus.selectOption(1);

		}

		else if (immigrationType.equalsIgnoreCase("permanentResident")) {
			immigrationStatus.selectOption(2);

		}

		else if (immigrationType.equalsIgnoreCase("Other")) {
			immigrationStatus.selectOption(3);

			reasons = new AdditionalInfoFields(driver,
					"applicationData-currentSpouse.priorSpouse[" + i
							+ "].otherImmigrationStatus");
			reasons.normalText(data.getProperty("mrgEndedReason"));
		}

		return this;
	}

}
