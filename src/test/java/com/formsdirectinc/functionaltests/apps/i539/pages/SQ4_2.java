package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_2 extends WizardPage {

	private CommonInputClasses f_name;
	private DateTag f_DateOfBirth;
	private YesNo f_I94Status;
	private DateTag f_LastArrived;
	private MultiRadioOptions usEntry;
	private AdditionalInfoFields passport;
	private Address passport_Issued;
	private DateTag passportExpireOn;
	private Country countryOfCitizenship;
	private Country countryOfBirth;

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	public void set_F_Member_Name(Properties data) {
		f_name = new CommonInputClasses(driver);
		f_name.applicantNameDetails("applicant.familyMembers[0].name", data);
	}

	public void set_F_Member_DateOfBirth(Properties data) {
		f_DateOfBirth = new DateTag(driver,
				"applicant.familyMembers[0].dateOfBirth");
		f_DateOfBirth.selectDate(data.getProperty("DOE"));
	}

	public void set_F_Member_SSN(Properties data) {
		f_name.applicantSSNDetails(
				"applicationData-applicant.familyMembers[0].SSN", data);
	}

	public void set_F_Member_i94_No() {
		f_I94Status = new YesNo(driver, "applicant.familyMembers[0].havei94");
		f_I94Status.no();

	}

	public void set_i94Updates(Properties data) {

		f_LastArrived = new DateTag(driver,
				"applicant.familyMembers[0].lastArrivedOn");
		f_LastArrived.selectDate(data.getProperty("DOE"));

		usEntry = new MultiRadioOptions(driver,
				"applicationData-applicant.familyMembers[0].indefinite");
		usEntry.selectOption(1);

	}

	public void set_Last_Arrived(Properties data) {
		f_LastArrived = new DateTag(driver,
				"applicant.familyMembers[0].lastArrivedOn");
		f_LastArrived.selectDate(data.getProperty("DOE"));
		f_LastArrived = new DateTag(driver,
				"applicant.familyMembers[0].statusExpireOn");
		f_LastArrived.selectDate(data.getProperty("DOExp"));
	}

	public void set_Passport_No(Properties data) {
		passport = new AdditionalInfoFields(driver,
				"applicationData-applicant.familyMembers[0]");
		passport.passportNumber(data.getProperty("PassportNumber"));
		passport_Issued = new Address(driver,
				"applicationData-applicant.familyMembers[0].passportIssueCountry");
		passport_Issued.setCountry(data.getProperty("Country"));
		passportExpireOn = new DateTag(driver,
				"applicant.familyMembers[0].passportExpireOn");
		passportExpireOn.selectDate(data.getProperty("DOExp"));
	}

	public void set_F_Member_ARN(Properties data) {
		f_name.applicantARNDetails(
				"applicationData-applicant.familyMembers[0].ARN", data);
	}

	public void set_UsEntryDocument(Properties data) {
		usEntry = new MultiRadioOptions(driver,
				"applicationData-applicant.familyMembers[0].usEntryDocument");
		usEntry.selectOption(1);
	}

	public void set_countryOfBirth(Properties data) {
		countryOfBirth = new Country(driver,
				"applicationData-applicant.familyMembers[0].countryOfBirth");
		countryOfBirth.setCountryDDM(data.getProperty("Country"));
	}

	public void set_countryOfCitizenship(Properties data) {
		countryOfCitizenship = new Country(driver,
				"applicationData-applicant.familyMembers[0].countryOfCitizenship");
		countryOfCitizenship.setCountryDDM(data.getProperty("Country"));
	}

}
