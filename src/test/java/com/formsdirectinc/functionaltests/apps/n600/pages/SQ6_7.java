
package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_7 extends WizardPage {

	protected YesNo currentSpouse;
	protected MultiRadioOptions dischargeType;
	protected AdditionalInfoFields marriageCount, marriageStatus,
			explainations;
	protected Name_FirstMiddleLast spouseName;
	protected DateTag spouseDOB;
	protected Country spouseCountry;
	protected Address spouseAddress;

	public SQ6_7(WebDriver driver) {
		super(driver);

	}

	public SQ6_7 motherMaritalInfo(Properties data, int mrgCount,
			String maritalType, String presentSpouse, String motherDeceased,
			String birthCountry) {

		if ((mrgCount != -1) && !maritalType.equalsIgnoreCase("NA")
				&& !presentSpouse.equalsIgnoreCase("NA")
				&& !motherDeceased.equalsIgnoreCase("NA"))

		{

			marriageCount = new AdditionalInfoFields(driver,
					"applicationData-applicant.motherInfo.maritalStatus.howManyTimesMarried");
			marriageCount.selectDDM_Number(mrgCount);

			if ((motherDeceased.equalsIgnoreCase("No")) && (mrgCount >= 1)) {
				System.out.println(maritalType);

				marriageStatus = new AdditionalInfoFields(driver,

				"applicationData-applicant.motherInfo.maritalStatus.currentlyMarried");
				marriageStatus.selectDDM(maritalType);

				if (maritalType.equalsIgnoreCase(data
						.getProperty("status_Married"))) {

					spouseName = new Name_FirstMiddleLast(driver,
							"applicationData",

							"applicant.motherInfo.maritalStatus.spouseDetails.name");
					spouseName.setFirstNameField(data.getProperty("FirstName"));
					spouseName.setLastNameField(data.getProperty("LastName"));

					spouseDOB = new DateTag(driver,
							"applicant.motherInfo.maritalStatus.spouseDetails.dateOfBirth");
					spouseDOB.selectDate(data.getProperty("DOB"));

					spouseCountry = new Country(
							driver,

							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.countryOfBirth");
					spouseCountry.setCountryDDM(data.getProperty("Country"));

					spouseCountry = new Country(driver,
							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.nationality");
					spouseCountry.setCountryDDM(data.getProperty("Country"));

					spouseCountry = new Country(driver,
							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.homeAddress");
					if (birthCountry.equalsIgnoreCase("isUS")) {
						spouseCountry.setCountry(data
								.getProperty("DACA_Country"));
					}
					else if (birthCountry.equalsIgnoreCase("notUS")) {
						spouseCountry.setCountry(data.getProperty("Country"));
					}
					saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();

					spouseAddress = new Address(driver,
							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.homeAddress");
					if (birthCountry.equalsIgnoreCase("isUS")) {
						spouseAddress.setState(data.getProperty("State"));
					}
					spouseAddress.setStreet(data.getProperty("StreetName"));
					spouseAddress.setCity(data.getProperty("City"));
					spouseAddress.setZipcode(data.getProperty("Zipcode"));

					spouseDOB = new DateTag(driver,
							"applicant.motherInfo.maritalStatus.spouseDetails.dateOfMarriage");
					spouseDOB.selectDate(data.getProperty("dateOfMarriage"));

					spouseCountry = new Country(
							driver,

							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.placeOfMarriage");
					spouseCountry.setCountry(data.getProperty("DACA_Country"));

					spouseAddress = new Address(
							driver,

							"applicationData-applicant.motherInfo.maritalStatus.spouseDetails.placeOfMarriage");
					spouseAddress.setCity(data.getProperty("City"));
					spouseAddress.setState(data.getProperty("State"));

					currentSpouse = new YesNo(driver,
							"applicant.motherInfo.maritalStatus.spouseDetails.spouseYourFather");
					if (presentSpouse.equalsIgnoreCase("Yes")) {
						currentSpouse.yes();
					}
					else if (presentSpouse.equalsIgnoreCase("No")) {
						currentSpouse.no();
					}

				}
				else if (maritalType.equalsIgnoreCase(data
						.getProperty("status_Other"))) {
					explainations = new AdditionalInfoFields(driver,

					"applicationData-applicant.motherInfo.maritalStatus.explainOtherMarriage");
					explainations.normalText(data.getProperty("status_Other"));

				}
			}
			saveScreenShot("n600", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

}
