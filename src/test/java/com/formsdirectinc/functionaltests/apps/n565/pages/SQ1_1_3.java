package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.PhysicalTraits;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ1_1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_1_3 extends WizardPage {

	private DateTag dateOfBirth;
	private Address countryOfBirth;
	private Gender gender;
	private PhysicalTraits english;
	private MaritalInfo maritalStatus;

	public SQ1_1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_3 personal_Information(String genderIs, Properties data) {

			PhoneNumber contactNumber = new PhoneNumber(driver,
					"applicationData-applicant.contactMethods");
			contactNumber.setDayTimeNumber(data.getProperty("Phone1"),
					data.getProperty("Phone2"));

			// e-mail address
			EMailAddress email = new EMailAddress(driver,
					"applicationData-applicant.contactMethods");
			email.setEMail(data.getProperty("Mail"));

			// DOB
			dateOfBirth = new DateTag(driver, "applicant.birth.dateOfBirth");
			dateOfBirth.selectDate(data.getProperty("DOB"));
			// Birth DDM
			countryOfBirth = new Address(driver,
					"applicationData-applicant.birth.countryOfBirth");
			countryOfBirth.setCountry(data.getProperty("DOB_Country"));
			// gender
			gender = new Gender(driver, "applicationData-applicant.sex");
			gender.setGender(genderIs);
			
			// height
			english = new PhysicalTraits(driver, "applicationData",
					"applicant.height");
			english.selectHeightinFeet(data.getProperty("HeightinFeet"));
			english.selectHeightinInches(data.getProperty("HeightinInches"));
			// marital Status
			maritalStatus = new MaritalInfo(driver,
					"applicationData-applicant.maritalStatus");
			maritalStatus.setMarriageStatus(data.getProperty("maritalStatus"));

			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;

	}

}
