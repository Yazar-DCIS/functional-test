package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * PreviousSpouse: Prior marriages
 
 * @author Orina <br> Date: 3/10/16
 
 * Revision: $Rev$
 */
public class PreviousSpouse extends BaseTag {

	private DateTag previousSpouseDOB,previousSpouseDOM,previousSpouseDateMrgEnded;
	private Address spouseMarriageOccuredPlace,spouseMarriageEndedPlace;
	private Name_FirstMiddleLast previousSpouseName;
		
	public PreviousSpouse(WebDriver driver) {
		super(driver);
	}

	public PreviousSpouse priorMarriageInformation(String elementProperty,String appname,int previousMrgCount) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<previousMrgCount;i++)
		{
		
		previousSpouseName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+"["+i+"].name");
		previousSpouseName.setFirstNameField(data.getProperty(elementProperty+"["+i+"].name.first"));
		previousSpouseName.setLastNameField(data.getProperty(elementProperty+"["+i+"].name.last"));
		
		previousSpouseDOB = new DateTag(driver, elementProperty+"["+i+"].dateOfBirth");
		previousSpouseDOB.selectDate(data.getProperty(elementProperty+"["+i+"].dateOfBirth"));
		
		previousSpouseDOM = new DateTag(driver, elementProperty+"["+i+"].dateOfMarriage");
		previousSpouseDOM.selectDate(data.getProperty(elementProperty+"["+i+"].dateOfMarriage"));
		
		spouseMarriageOccuredPlace = new Address(driver, "applicationData-"+elementProperty+"["+i+"].placeOfMarriage");
		spouseMarriageOccuredPlace.setCity(data.getProperty(elementProperty+"["+i+"].placeOfMarriage.city"));
		spouseMarriageOccuredPlace.setState(data.getProperty(elementProperty+"["+i+"].placeOfMarriage.state"));
		spouseMarriageOccuredPlace.setCountryField(data.getProperty(elementProperty+"["+i+"].placeOfMarriage.country"));
		
		previousSpouseDateMrgEnded = new DateTag(driver, elementProperty+"["+i+"].dateOfMarriageEnded");
		previousSpouseDateMrgEnded.selectDate(data.getProperty(elementProperty+"["+i+"].dateOfMarriageEnded"));
		
		spouseMarriageEndedPlace = new Address(driver, "applicationData-"+elementProperty+"["+i+"].placeOfMarriageEnded");
		spouseMarriageEndedPlace.setCity(data.getProperty(elementProperty+"["+i+"].placeOfMarriageEnded.city"));
		spouseMarriageEndedPlace.setState(data.getProperty(elementProperty+"["+i+"].placeOfMarriageEnded.state"));
		spouseMarriageEndedPlace.setCountryField(data.getProperty(elementProperty+"["+i+"].placeOfMarriageEnded.country"));
		
		if (i < previousMrgCount - 1) {
			CommonInputClasses addAnotherSpouse=new CommonInputClasses(driver);
			addAnotherSpouse.addAnother();
		}
		
		}
		return this;
	}

}
