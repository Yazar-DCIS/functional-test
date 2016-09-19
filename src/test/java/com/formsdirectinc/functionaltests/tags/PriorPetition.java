package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * PriorPetition: Prior Petition
 
 * @author Orina <br> Date: 3/10/16
 
 * Revision: $Rev$
 */
public class PriorPetition extends BaseTag {

	private DateTag previousPetitionDOF;
	private Address previousPetitionPlace;
	private Name_FirstMiddleLast previousPetitionName,otherPetitionerName;
	private MultiRadioOptions resultsOfFilling,relationshipFilling;
	private YesNo filedOnBehalf;
	
	public PriorPetition(WebDriver driver) {
		super(driver);
	}

	public PriorPetition priorPetitionInformation(String elementProperty,String appname,int previousPetitionCount,
			String petitionType,String wasItfiledOnBehalf) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<previousPetitionCount;i++)
		{

			System.out.println("Prior Petition----------->"+elementProperty+"["+i+"]");
			previousPetitionName =new Name_FirstMiddleLast(driver, "applicationData",elementProperty+"["+i+"].name");
			previousPetitionName.setFirstNameField(data.getProperty(elementProperty+"["+i+"].name.first"));
			previousPetitionName.setLastNameField(data.getProperty(elementProperty+"["+i+"].name.last"));

			previousPetitionDOF = new DateTag(driver, elementProperty+"["+i+"].date");
			previousPetitionDOF.selectDate(data.getProperty(elementProperty+"["+i+"].date"));


			previousPetitionPlace = new Address(driver, "applicationData-"+elementProperty+"["+i+"].place");
			previousPetitionPlace.setCity(data.getProperty(elementProperty+"["+i+"].place.city"));
			previousPetitionPlace.setState(data.getProperty(elementProperty+"["+i+"].place.state"));

			resultsOfFilling=new MultiRadioOptions(driver, "applicationData-"+elementProperty+"["+i+"].result");
			if(petitionType.equalsIgnoreCase("Approved"))
			{
				resultsOfFilling.selectOption(1);
			}
			else if(petitionType.equalsIgnoreCase("Denied"))
			{
				resultsOfFilling.selectOption(2);
			}
			else if(petitionType.equalsIgnoreCase("Withdrawn"))
			{
				resultsOfFilling.selectOption(3);
			}
			else if(petitionType.equalsIgnoreCase("Abandoned"))
			{
				resultsOfFilling.selectOption(4);
			}
			else if(petitionType.equalsIgnoreCase("Pending"))
			{
				resultsOfFilling.selectOption(5);
				filedOnBehalf=new YesNo(driver, elementProperty+"["+i+"].wasPendingPetition");

				if(wasItfiledOnBehalf.equalsIgnoreCase("Yes"))
				{
					filedOnBehalf.yes();	
				}
				else if(wasItfiledOnBehalf.equalsIgnoreCase("No"))
				{
					filedOnBehalf.no();
				}

			}

			if (i < previousPetitionCount - 1) {
				CommonInputClasses addAnotherPetition=new CommonInputClasses(driver);
				addAnotherPetition.addAnother();
			}

		}
		return this;
	}

	
	public PriorPetition otherPetitionInformation(String elementProperty,String appname,int otherPetitionCount,
			String relationShipType) {
		
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<otherPetitionCount;i++)
		{

			otherPetitionerName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+"["+i+"].name");
			otherPetitionerName.setFirstNameField(data.getProperty(elementProperty+"["+i+"].name.first"));
			otherPetitionerName.setLastNameField(data.getProperty(elementProperty+"["+i+"].name.last"));

			relationshipFilling=new MultiRadioOptions(driver, elementProperty+"["+i+"].relationShip");
			if(relationShipType.equalsIgnoreCase("Spouse"))
			{
				relationshipFilling.selectOption(1);
			}
			else if(relationShipType.equalsIgnoreCase("Parent"))
			{
				relationshipFilling.selectOption(2);
			}
			else if(relationShipType.equalsIgnoreCase("Child"))
			{
				relationshipFilling.selectOption(3);
			}
			else if(relationShipType.equalsIgnoreCase("Sibling"))
			{
				relationshipFilling.selectOption(4);
			}
			

			if (i < otherPetitionCount - 1) {
				CommonInputClasses addAnotherPetition=new CommonInputClasses(driver);
				addAnotherPetition.addAnother();
			}

		}
		return this;
	}

	public PriorPetition otherPetitionInformationSecondPart(String elementProperty,String appname,int otherPetitionCount,
			String relationShipType) {
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<otherPetitionCount;i++)
		{

			otherPetitionerName =new Name_FirstMiddleLast(driver, "applicationData", elementProperty+"["+i+"].name");
			otherPetitionerName.setFirstNameField(data.getProperty(elementProperty+"["+i+"].name.first"));
			otherPetitionerName.setLastNameField(data.getProperty(elementProperty+"["+i+"].name.last"));

			relationshipFilling=new MultiRadioOptions(driver, elementProperty+"["+i+"].relationShip");
			if(relationShipType.equalsIgnoreCase("Parent"))
			{
				relationshipFilling.selectOption(1);
			}
			else if(relationShipType.equalsIgnoreCase("Child"))
			{
				relationshipFilling.selectOption(2);
			}
			else if(relationShipType.equalsIgnoreCase("Sibling"))
			{
				relationshipFilling.selectOption(3);
			}
			

			if (i < otherPetitionCount - 1) {
				CommonInputClasses addAnotherPetition=new CommonInputClasses(driver);
				addAnotherPetition.addAnother();
			}

		}
		return this;
	}
}
