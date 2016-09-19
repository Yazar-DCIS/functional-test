package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1_1 extends WizardPage {
	private CommonInputClasses homeAddress, mailingAddress, armedForceAddress;
	private Address countrySelect;
	private YesNo inCare, selectMailingAddress, armedForces;
	private AdditionalInfoFields careOfName;
	private DateTag date;

	public SQ1_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_1 address(Properties data, String movedToYourCurrentAddress,
			String mailingAddSameAsCurrentAdd, String servedInArmedForces,
			String armedForcesCountry) {
		homeAddress = new CommonInputClasses(driver);
		homeAddress.applicantAddressDetails(
				"applicationData-applicant.homeAddress", data);

		if (movedToYourCurrentAddress.equalsIgnoreCase("lessThan5Years")) {
			date = new DateTag(driver, "applicant.dateEnteredCurrentAddr");
			date.selectDateAsSingle(lessThanFiveYears());
		}
		else if (movedToYourCurrentAddress.equalsIgnoreCase("greaterThan5Years")) {
			date = new DateTag(driver, "applicant.dateEnteredCurrentAddr");
			date.selectDateAsSingle(greaterThanFiveYears());
		}
		selectMailingAddress = new YesNo(driver, "applicant.haveMailingAddress");
		if (mailingAddSameAsCurrentAdd.equalsIgnoreCase("Yes")) {
			selectMailingAddress.yes();
		}
		else if (mailingAddSameAsCurrentAdd.equalsIgnoreCase("No")) {
			selectMailingAddress.no();
			mailingAddress = new CommonInputClasses(driver);
			mailingAddress.applicantAddressDetails(
					"applicationData-applicant.mailingAddress", data);
		}

		inCare = new YesNo(driver, "applicant.mailingAddress.hasInCareOfAgent");
		inCare.yes();
		careOfName = new AdditionalInfoFields(driver,
				"applicationData-applicant.mailingAddress.inCareOfAgentName");
		careOfName.normalText(data.getProperty("CareOfName"));

		armedForces = new YesNo(driver, "applicant.servingOverseas");
		if (servedInArmedForces.equalsIgnoreCase("Yes")) {
			armedForces.yes();
			if (armedForcesCountry.equalsIgnoreCase("USA")) {
				countrySelect = new Address(driver,
						"applicationData-applicant.overseasMailingAddr.country");
				countrySelect.setCountryDropDown(data.getProperty("I134_USA"));

				armedForceAddress = new CommonInputClasses(driver);
				armedForceAddress.applicantAddressDetails(
						"applicationData-applicant.overseasMailingAddr", data);
			}
			else if (armedForcesCountry.equalsIgnoreCase("outSideUSA")) {
				countrySelect = new Address(driver,
						"applicationData-applicant.overseasMailingAddr.country");
				countrySelect.setCountryDropDown(data
						.getProperty("I134_Country"));

				armedForceAddress = new CommonInputClasses(driver);
				armedForceAddress.applicantOtherAddressDetails(
						"applicationData-applicant.overseasMailingAddr", data);
			}
		}
		else if (servedInArmedForces.equalsIgnoreCase("No")) {
			armedForces.no();
		}
		saveScreenShot("i129f", "SQ1_1_1"); clickContinueInSQ();
		return this;
	}

	public String lessThanFiveYears() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -2);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());
		return Date;
	}

	public String greaterThanFiveYears() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -6);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());
		return Date;
	}
}
