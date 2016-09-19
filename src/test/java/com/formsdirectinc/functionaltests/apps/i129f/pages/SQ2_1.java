package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Gender;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_1 extends WizardPage {

	private Name_FirstMiddleLast name;
	private YesNo haveMaidenName, language;
	private Gender gender;
	private DateTag dob;
	
	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 fianceInformation(String usedOtherNames,int otherNameCount,String genderIs,
			String fianceLangNonRomanAlphabet) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty("i129f");
		
		name = new Name_FirstMiddleLast(driver, "applicationData",
				"foreignFiance.name");
		name.setFirstNameField(data.getProperty("foreignFiance.name.first"));
		name.setMiddleNameField(data.getProperty("foreignFiance.name.middle"));
		name.setLastNameField(data.getProperty("foreignFiance.name.last"));

		haveMaidenName = new YesNo(driver, "foreignFiance.usedOtherNames");
		if (usedOtherNames.equalsIgnoreCase("Yes")) {
			haveMaidenName.yes();
			
			for(int i=0;i<otherNameCount;i++)
			{
			name = new Name_FirstMiddleLast(driver, "applicationData",
					"foreignFiance.usedOtherNamesHistory["+i+"].usedOtherNames");
			name.setFirstNameField(data.getProperty("foreignFiance.usedOtherNames.first"));
			name.setMiddleNameField(data.getProperty("foreignFiance.usedOtherNames.middle"));
			name.setLastNameField(data.getProperty("foreignFiance.usedOtherNames.last"));
			
			if(i<otherNameCount-1)
			{
				AddAnotherField anotherName=new AddAnotherField(driver);
				anotherName.addAnother();
			}
			
			}
		}
		else if (usedOtherNames.equalsIgnoreCase("No")) {
			haveMaidenName.no();
		}

		gender = new Gender(driver, "applicationData-foreignFiance.sex");
		if(genderIs.equalsIgnoreCase("Male"))
		{
			gender.setGenderAsMale();
		}
		else if(genderIs.equalsIgnoreCase("Female"))
		{
			gender.setGenderAsFemale();
		}
		
		
		dob = new DateTag(driver, "foreignFiance.birth.dateOfBirth");
		dob.selectMonth(data.getProperty("foreignFiance.birth.dateOfBirth.month"));
		dob.selectDay(data.getProperty("foreignFiance.birth.dateOfBirth.day"));
		dob.selectYear(data.getProperty("foreignFiance.birth.dateOfBirth.year"));

		
		Address placeOfBirth=new Address(driver, "applicationData-foreignFiance.placeOfBirth");
		placeOfBirth.setCity(data.getProperty("foreignFiance.placeOfBirth.city"));	
		placeOfBirth.setBirthState(data.getProperty("foreignFiance.placeOfBirth.state"));
		placeOfBirth.setCountryField(data.getProperty("foreignFiance.placeOfBirth.country"));

		Country birthCountry=new Country(driver, "applicationData-foreignFiance");
		birthCountry.setBirthCountry(data.getProperty("foreignFiance.countryOfBirth"));
		
		language = new YesNo(driver, "foreignFiance.nonRomanAlphabeticLang");
		language.setYesOrNo(fianceLangNonRomanAlphabet);
		saveScreenShot("i129f", "SQ2_1"); clickContinueInSQ();
		return this;
	}
}
