package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Parents: information about your parents
 
 * @author Orina <br> Date: 3/10/16
 
 * Revision: $Rev$
 */
public class Parents extends BaseTag {

	private DateTag fatherDOB,motherDOB;
	private Address fatherBirthPlace,fatherPlaceOfResidence,motherBirthPlace,motherPlaceOfResidence;
	private Name_FirstMiddleLast fatherName,motherName;
	private YesNo fatherAlive,motherAlive;

	public Parents(WebDriver driver) {
		super(driver);
	}

	public Parents parentsInformation(String appname,String elementProperty,String fatherStillAlive,String motherStillAlive) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);

		fatherName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+".fatherInfo.name");
		fatherName.setFirstNameField(appName.getProperty(elementProperty+".fatherInfo.name.first"));
		fatherName.setLastNameField(appName.getProperty(elementProperty+".fatherInfo.name.last"));
		
		fatherDOB = new DateTag(driver, elementProperty+".fatherInfo.dateOfBirth");
		fatherDOB.selectDate(appName.getProperty(elementProperty+".fatherInfo.dateOfBirth"));
		
		fatherBirthPlace = new Address(driver, "applicationData-"+elementProperty+".fatherInfo.placeOfBirth");
		fatherBirthPlace.setCityField(appName.getProperty(elementProperty+".fatherInfo.placeOfBirth.city"));
		fatherBirthPlace.setCountryField(appName.getProperty(elementProperty+".fatherInfo.placeOfBirth.country"));
		
		fatherAlive=new YesNo(driver, elementProperty+".fatherInfo.stillAlive");
		if(fatherStillAlive.equalsIgnoreCase("Yes"))
		{
			fatherAlive.yes();
			fatherPlaceOfResidence = new Address(driver, "applicationData-"+elementProperty+".fatherInfo.placeOfResidence");
			fatherPlaceOfResidence.setCityField(appName.getProperty(elementProperty+".fatherInfo.placeOfResidence.city"));
			fatherPlaceOfResidence.setCountryField(appName.getProperty(elementProperty+".fatherInfo.placeOfResidence.country"));
			
		}
		else if(fatherStillAlive.equalsIgnoreCase("No"))
		{
			fatherAlive.no();
		}
		
		
		motherName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+".motherInfo.name");
		motherName.setFirstNameField(appName.getProperty(elementProperty+".motherInfo.name.first"));
		motherName.setLastNameField(appName.getProperty(elementProperty+".motherInfo.name.last"));
		
		motherDOB = new DateTag(driver, elementProperty+".motherInfo.dateOfBirth");
		motherDOB.selectDate(appName.getProperty(elementProperty+".motherInfo.dateOfBirth"));
		
		motherBirthPlace = new Address(driver, "applicationData-"+elementProperty+".motherInfo.placeOfBirth");
		motherBirthPlace.setCityField(appName.getProperty(elementProperty+".motherInfo.placeOfBirth.city"));
		motherBirthPlace.setCountryField(appName.getProperty(elementProperty+".motherInfo.placeOfBirth.country"));
		
		motherAlive=new YesNo(driver, elementProperty+".motherInfo.stillAlive");
		if(motherStillAlive.equalsIgnoreCase("Yes"))
		{
			motherAlive.yes();
			motherPlaceOfResidence = new Address(driver, "applicationData-"+elementProperty+".motherInfo.placeOfResidence");
			motherPlaceOfResidence.setCityField(appName.getProperty(elementProperty+".motherInfo.placeOfResidence.city"));
			motherPlaceOfResidence.setCountryField(appName.getProperty(elementProperty+".motherInfo.placeOfResidence.country"));
			
		}
		else if(motherStillAlive.equalsIgnoreCase("No"))
		{
			motherAlive.no();
		}
	
		return this;
	}

}
