package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_7 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_7 extends WizardPage {

	private DateTag lastEntry;
	private Address addressDetails;
	private Numbers i94Number;
	private Name_FirstMiddleLast nameInI94Document;
	
	
	public SQ7_7(WebDriver driver) {
		super(driver);
	}

	public SQ7_7 entryIntoUSInfo(String documentType) {

		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		lastEntry = new DateTag(driver,"foreignRelative.entryIntoUS.dateLastEntry");
		lastEntry.selectDate(i130i485.getProperty("foreignRelative.entryIntoUS.dateLastEntry"));

		addressDetails = new Address(driver,
				"applicationData-foreignRelative.entryIntoUS.placeLastEntry");
		addressDetails.setCity(i130i485.getProperty("foreignRelative.entryIntoUS.placeLastEntry.city"));
		addressDetails.setState(i130i485.getProperty("foreignRelative.entryIntoUS.placeLastEntry.state"));

		i94Number=new Numbers(driver, "foreignRelative.entryIntoUS.i94Number");
		i94Number.setArrivalRecordNumber(i130i485.getProperty("foreignRelative.entryIntoUS.i94Number.adn1"), 
				i130i485.getProperty("foreignRelative.entryIntoUS.i94Number.adn2"));
		
		nameInI94Document=new Name_FirstMiddleLast(driver, "applicationData", "foreignRelative.entryIntoUS.nameOnI94Form");
		nameInI94Document.setFirstNameField(i130i485.getProperty("foreignRelative.entryIntoUS.nameOnI94Form.first"));
		nameInI94Document.setLastNameField(i130i485.getProperty("foreignRelative.entryIntoUS.nameOnI94Form.last"));
		nameInI94Document.setMiddleNameField(i130i485.getProperty("foreignRelative.entryIntoUS.nameOnI94Form.middle"));
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}
