package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Children: Children Informations
 
 * @author Orina <br> Date: 3/14/16
 
 * Revision: $Rev$
 */
public class Children extends BaseTag {

	private DateTag childDOB;
	private Address childBirthCountry;
	private Name_FirstMiddleLast childName;
	private Numbers childARNumber;
		
	public Children(WebDriver driver) {
		super(driver);
	}

	public Children setNumberOfChildren(String elementProperty,String appname,int childCount) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<childCount;i++)
		{
		
			childName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+"["+i+"].name");
			childName.setFirstNameField(data.getProperty(elementProperty+"["+i+"].name.first"));
			childName.setLastNameField(data.getProperty(elementProperty+"["+i+"].name.last"));
		
			childDOB = new DateTag(driver, elementProperty+"["+i+"].birth.dateOfBirth");
			childDOB.selectDate(data.getProperty(elementProperty+"["+i+"].birth.dateOfBirth"));
		
			childARNumber=new Numbers(driver, elementProperty+"["+i+"].ARN");
			childARNumber.setAlienRegistrationNumber(data.getProperty(elementProperty+"["+i+"].arn"));
			
			childBirthCountry = new Address(driver, "applicationData-"+elementProperty+"["+i+"].birth.countryOfBirth");
			childBirthCountry.setCountry(data.getProperty(elementProperty+"["+i+"].birth.countryOfBirth.country"));
		
		
		if (i < childCount - 1) {
			CommonInputClasses addAnotherChild=new CommonInputClasses(driver);
			addAnotherChild.addAnother();
		}
		
		}
		return this;
	}

}
