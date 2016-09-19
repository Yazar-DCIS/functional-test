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
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_10 extends WizardPage {

	private MultiRadioOptions howMrgEnded, immigrationStatus;
	private Country spouseBirthCountry, spouseNationalityCountry;
	private Name_FirstMiddleLast spouseName;
	private DateTag mrgEndDate, mrgStartDate, dateOfBirth;
	private AdditionalInfoFields reasons;

	public SQ3_10(WebDriver driver) {
		super(driver);

	}

	public SQ3_10 otherSpouseMoreDetails(Properties copies, Properties data,
			String mrgEndReason, String immigrationType, int count,String financialSupport) {

		if ((count != -1) && (!mrgEndReason.equalsIgnoreCase("NA"))
				&& (!immigrationType.equalsIgnoreCase("NA"))) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					otherSpouseDetails(copies, data, i, mrgEndReason,
							immigrationType,financialSupport);
					if (i < count - 1) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnother();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_10");
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ3_10 otherSpouseDetails(Properties copies, Properties data, int i,
			String mrgEndReason, String immigrationType,String financialSupport) {

		spouseName = new Name_FirstMiddleLast(driver, "applicationData",
				"priorSpouse[" + i + "].name");
		spouseName.setFirstNameField(data.getProperty("FirstName"+i));
		spouseName.setLastNameField(data.getProperty("LastName"+i));

		dateOfBirth = new DateTag(driver, "priorSpouse[" + i
				+ "].spouseDateOfBirth");
		dateOfBirth.selectDate(data.getProperty("DOB"+i));

		spouseBirthCountry = new Country(driver, "applicationData-priorSpouse["
				+ i + "].spouseCountryOfBirth");
		//spouseBirthCountry.setCountryDDM(data.getProperty("Country"));
		spouseBirthCountry.setCountryDDM("Belgium");

		spouseNationalityCountry = new Country(driver,
				"applicationData-priorSpouse[" + i
						+ "].spouseCountryOfCitizenship");
		spouseNationalityCountry.setCountryDDM("Belgium");
		//spouseNationalityCountry.setCountryDDM(data.getProperty("Country"));

		mrgStartDate = new DateTag(driver, "priorSpouse[" + i
				+ "].dateOfMarriage");
		mrgStartDate.selectDateAsSingle(data.getProperty("mrgStartDate"+i));

		mrgEndDate = new DateTag(driver, "priorSpouse[" + i
				+ "].dateMarriageEnded");
		mrgEndDate.selectDateAsSingle(data.getProperty("mrgEndDate"+i));

		howMrgEnded = new MultiRadioOptions(driver,
				"applicationData-priorSpouse[" + i + "].howMarriageEnded");

		if (mrgEndReason.equalsIgnoreCase("Annulled")) {
			howMrgEnded.selectOption(1);
		}
		else if (mrgEndReason.equalsIgnoreCase("Divorced")) {
			howMrgEnded.selectOption(2);
			
			YesNo provideSupport=new YesNo(driver, "priorSpouse[" + i + "].provideFinancial");
			if(financialSupport.equalsIgnoreCase("Yes"))
			{
				provideSupport.yes();
			}
			else if(financialSupport.equalsIgnoreCase("No"))
			{
				provideSupport.no();
			}
			
		}
		else if (mrgEndReason.equalsIgnoreCase("Widowed")) {
			howMrgEnded.selectOption(3);
		}
		else if (mrgEndReason.equalsIgnoreCase("Other")) {
			howMrgEnded.selectOption(4);

			reasons = new AdditionalInfoFields(driver,
					"applicationData-priorSpouse[" + i + "].whyMarriageEnded");
			reasons.normalText(data.getProperty("mrgEndedReason"));
		}

		immigrationStatus = new MultiRadioOptions(driver,
				"applicationData-priorSpouse[" + i + "].immigrationStatus");

		if (immigrationType.equalsIgnoreCase("US_Citizen")) {
			immigrationStatus.selectOption(1);

		}

		else if (immigrationType.equalsIgnoreCase("permanentResident")) {
			immigrationStatus.selectOption(2);

		}

		else if (immigrationType.equalsIgnoreCase("Other")) {
			immigrationStatus.selectOption(3);

			reasons = new AdditionalInfoFields(driver,
					"applicationData-priorSpouse[" + i
							+ "].otherImmigrationStatus");
			reasons.normalText(data.getProperty("mrgEndedReason"));
		}

		return this;
	}

}
