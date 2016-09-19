package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ8_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ8_3 extends WizardPage {

	private DateTag spouseDOB,spouseDOM;
	private MultiRadioOptions relatedAs;
	private Address spouseAddress,spouseMarriageAddress;
	private Name_FirstMiddleLast spouseName;
	
	
	public SQ8_3(WebDriver driver) {
		super(driver);
	}

	public SQ8_3 relativeSpouseInformation(String relationIs) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(relationIs.equalsIgnoreCase("husband")||relationIs.equalsIgnoreCase("wife"))
		{
		relatedAs=new MultiRadioOptions(driver, "applicationData-foreignRelative.spouseInfo.relationship");
		if(relationIs.equalsIgnoreCase("husband"))
		{
			relatedAs.selectOption(1);
		}
		else if(relationIs.equalsIgnoreCase("wife"))
		{
			relatedAs.selectOption(2);
			spouseName=new Name_FirstMiddleLast(driver, "applicationData", "foreignRelative.spouseInfo");
			spouseName.setMaidenNameField(i130i485.getProperty("foreignRelative.spouseInfo.maidenName"));
		}
		
		spouseName=new Name_FirstMiddleLast(driver, "applicationData", "foreignRelative.spouseInfo.name");
		spouseName.setFirstNameField(i130i485.getProperty("foreignRelative.spouseInfo.name.first"));
		spouseName.setLastNameField(i130i485.getProperty("foreignRelative.spouseInfo.name.last"));
		spouseName.setMiddleNameField(i130i485.getProperty("foreignRelative.spouseInfo.name.middle"));
		
		spouseDOB=new DateTag(driver, "foreignRelative.spouseInfo.dateOfBirth");
		spouseDOB.selectDate(i130i485.getProperty("foreignRelative.spouseInfo.dateOfBirth"));
		
		spouseAddress=new Address(driver, "applicationData-foreignRelative.spouseInfo.placeOfBirth");
		spouseAddress.setCity(i130i485.getProperty("foreignRelative.spouseInfo.placeOfBirth.city"));
		spouseAddress.setCountryField(i130i485.getProperty("foreignRelative.spouseInfo.placeOfBirth.country"));
		
		spouseDOM=new DateTag(driver, "foreignRelative.spouseInfo.dateOfMarriage");
		spouseDOM.selectDate(i130i485.getProperty("foreignRelative.spouseInfo.dateOfMarriage"));
		
		spouseMarriageAddress=new Address(driver, "applicationData-foreignRelative.spouseInfo.placeOfMarriage");
		spouseMarriageAddress.setCity(i130i485.getProperty("foreignRelative.spouseInfo.placeOfMarriage.city"));
		spouseMarriageAddress.setCountryField(i130i485.getProperty("foreignRelative.spouseInfo.placeOfMarriage.country"));
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
