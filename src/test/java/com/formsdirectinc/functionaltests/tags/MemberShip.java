package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Membership Details: Membership Details
 
 * @author Orina <br> Date: 3/14/16
 
 * Revision: $Rev$
 */
public class MemberShip extends BaseTag {


	protected String nameOfOrganizationExpression="%s.nameOfOrganization";
	protected String typeOfOrganizationExpression="%s.typeOfOrganization";
	WebElement membershipInfo;
	
	public MemberShip(WebDriver driver) {
		super(driver);
	}
	
	public MemberShip(WebDriver driver,String property) {
		super(driver,property);
	}
	
	public MemberShip setNameOfOrganization(String nameOfOrganisation) {
		membershipInfo = driver.findElement(By.id(String.format(
				nameOfOrganizationExpression, property)));
		membershipInfo.sendKeys(nameOfOrganisation);
		return this;
	}
	
	public MemberShip setTypeOfOrganization(String typeOfOrganisation) {
		membershipInfo = driver.findElement(By.id(String.format(
				typeOfOrganizationExpression, property)));
		membershipInfo.sendKeys(typeOfOrganisation);
		return this;
	}

	public MemberShip setMembershipInformation(String elementProperty,String appname,int membershipCount) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<membershipCount;i++)
		{
		
		MemberShip memberInformation =new MemberShip(driver, "applicationData-"+ elementProperty+"["+i+"]");
		memberInformation.setNameOfOrganization(data.getProperty(elementProperty+"["+i+"].nameOfOrganization"));
		memberInformation.setTypeOfOrganization(data.getProperty(elementProperty+"["+i+"].typeOfOrganization"));
			
		Address membershipLocation = new Address(driver, "applicationData-"+elementProperty+"["+i+"].location");
		membershipLocation.setCity(data.getProperty(elementProperty+"["+i+"].location.city"));
		membershipLocation.setCountryField(data.getProperty(elementProperty+"["+i+"].location.country"));
		
		DateTag membershipFromDate = new DateTag(driver, elementProperty+"["+i+"].dateRange.fromDate");
		membershipFromDate.selectDate(data.getProperty(elementProperty+"["+i+"].dateRange.fromDate"));
		
		DateTag membershipToDate = new DateTag(driver, elementProperty+"["+i+"].dateRange.toDate");
		membershipToDate.selectDate(data.getProperty(elementProperty+"["+i+"].dateRange.toDate"));
	
		if (i < membershipCount - 1) {
			CommonInputClasses addAnotherSpouse=new CommonInputClasses(driver);
			addAnotherSpouse.addAnother();
		}
		
		}
		return this;
	}

}
