package com.formsdirectinc.functionaltests.apps.i485multi.pages;

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
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_1 extends WizardPage {

	private YesNo adjustmentOfStatus;
	private MultiRadioOptions relation, dependency;
	private Name_FirstMiddleLast spouseName;
	private DateTag spouseDOB;
	private Address spouseAddress;
	private Country spouseCtznCountry;

	public SQ5_1(WebDriver driver) {
		super(driver);

	}

	public void spouseDetails(Properties data) {
		
		relation = new MultiRadioOptions(driver,
				"applicationData-principalFamilyMembers.spouseInfo.relation");
		relation.selectOption(1);

		spouseName = new Name_FirstMiddleLast(driver, "applicationData", "");
		spouseName.setFirstNameField(data.getProperty("FirstName0"));
		spouseName.setLastNameField(data.getProperty("LastName0"));

		spouseDOB = new DateTag(driver,
				"principalFamilyMembers.spouseInfo.birth.dateOfBirth");
		spouseDOB.selectDate(data.getProperty("spouseDOB"));

		
		spouseAddress = new Address(driver,
					"applicationData-principalFamilyMembers.spouseInfo.spousePlaceOfBirth");
		spouseAddress.setCountryField("United States of America");
		spouseAddress.setCity("testCity");
			//For USA state is mandatory 
		spouseAddress.setState("AL");
		

		spouseCtznCountry = new Country(driver,
				"applicationData-principalFamilyMembers.spouseInfo.countryOfCitizenship");
		spouseCtznCountry.setCountryDDM(data.getProperty("Country"));

		spouseCtznCountry = new Country(driver,
				"applicationData-principalFamilyMembers.spouseInfo.countryOfCitizenship");
		spouseCtznCountry.setCountryDDM(data.getProperty("Country"));
		
		adjustmentOfStatus = new YesNo(driver,
				"principalFamilyMembers.spouseInfo.applyingAOS");
		adjustmentOfStatus.yes();

		dependency = new MultiRadioOptions(driver,
				"applicationData-principalFamilyMembers.spouseInfo.financialObligations");
		dependency.selectOption(1);

	}

	public void spouseMaidenName(Properties data) {
		AdditionalInfoFields maidenName = new AdditionalInfoFields(driver,
				"applicationData-beneficiaryFamilyMembers.spouseInfo.maidenName");
		maidenName.normalText(data.getProperty("LastName2"));
	}

}
