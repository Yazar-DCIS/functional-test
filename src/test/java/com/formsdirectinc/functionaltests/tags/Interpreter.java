package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Interpreter Details: Interpreter Details
 
 * @author Orina <br> Date: 3/14/16
 
 * Revision: $Rev$
 */
public class Interpreter extends BaseTag {


	protected String languageCommunicateExpression="%s.languageCommunicate";
	protected String nameOfOrganizationExpression="%s.organizationName";
	protected String languageOfinterpreterExpression="%s.languageOfinterpreter";
	protected String businessNameOfinterpreterExpression="%s.businessNameOfinterpreter";
	WebElement interpreterInfo;
	
	public Interpreter(WebDriver driver) {
		super(driver);
	}
	
	public Interpreter(WebDriver driver,String property) {
		super(driver,property);
	}
	
	public Interpreter setLanguageCommunicate(String interpreterLanguage) {
		interpreterInfo = driver.findElement(By.id(String.format(
				languageCommunicateExpression, property)));
		interpreterInfo.sendKeys(interpreterLanguage);
		return this;
	}
	
	public Interpreter setLanguageOfInterpreter(String interpreterLanguage) {
		interpreterInfo = driver.findElement(By.id(String.format(
				languageOfinterpreterExpression, property)));
		interpreterInfo.sendKeys(interpreterLanguage);
		return this;
	}
	
	public Interpreter setBusinessNameOfInterpreter(String nameOfOrganization) {
		interpreterInfo = driver.findElement(By.id(String.format(
				businessNameOfinterpreterExpression, property)));
		interpreterInfo.sendKeys(nameOfOrganization);
		return this;
	}
	
	public Interpreter setOrganizationName(String nameOfOrganization) {
		interpreterInfo = driver.findElement(By.id(String.format(
				nameOfOrganizationExpression, property)));
		interpreterInfo.sendKeys(nameOfOrganization);
		return this;
	}
	
	public Interpreter setInterpreterInformation(String elementProperty,String appname) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);
		
		Interpreter memberInformation =new Interpreter(driver, "applicationData-"+ elementProperty);
		memberInformation.setLanguageCommunicate(data.getProperty(elementProperty+".languageCommunicate"));
			
		Name_FirstMiddleLast interpreterName=new Name_FirstMiddleLast(driver, "applicationData", 
				elementProperty+".nameOfInterpreter");
		interpreterName.setFirstNameField(data.getProperty(elementProperty+".nameOfInterpreter.first"));
		interpreterName.setMiddleNameField(data.getProperty(elementProperty+".nameOfInterpreter.middle"));
		interpreterName.setLastNameField(data.getProperty(elementProperty+".nameOfInterpreter.last"));
		
		PhoneNumber interpreterNumber=new PhoneNumber(driver, "applicationData-"+ elementProperty+".telephoneOfInterpreter");
		interpreterNumber.setPhoneCode(data.getProperty(elementProperty+".telephoneOfInterpreter.phone1"));
		interpreterNumber.setPhoneNumber(data.getProperty(elementProperty+".telephoneOfInterpreter.phone2"));
	
		if(elementProperty.equalsIgnoreCase("uscitizenPetitioner"))
		{
			Address interpreterAddress=new Address(driver,"applicationData-"+elementProperty);
			interpreterAddress.setStreet(data.getProperty(elementProperty+".homeAddress.street"));
			interpreterAddress.setCity(data.getProperty(elementProperty+".homeAddress.city"));
			interpreterAddress.setState(data.getProperty(elementProperty+".homeAddress.state"));
			interpreterAddress.setZipcode(data.getProperty(elementProperty+".homeAddress.zipcode"));
			
			memberInformation.setOrganizationName(data.getProperty(elementProperty+".nameOfOrganization"));
			
			EMailAddress interpreterEMail=new EMailAddress(driver, "applicationData-"+elementProperty);
			interpreterEMail.setEMailAddress(data.getProperty(elementProperty+".emailAddress"));
		}
		
		
		return this;
	}

}
