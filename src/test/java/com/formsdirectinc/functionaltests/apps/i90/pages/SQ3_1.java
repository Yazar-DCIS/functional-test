package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Application Type
 * @author Orina
 */

public class SQ3_1 extends WizardPage {

	private MultiRadioOptions cardStatus;
	
	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 applicationType(Properties data,String visitThisPage,String statusOfCard, 
			String birthDetails,String cardExpiration) {
		
		if (visitThisPage.equalsIgnoreCase("yes")) {
			
			String[] expiryValue=statusOfCard.split(",");
			
			cardStatus = new MultiRadioOptions(driver,
					"applicationData-formSpecific.cardStatus");
			
			if(expiryValue[0].equalsIgnoreCase("expired"))
			{
				cardStatus.selectOption(1);
				DateTag expiryDate=new DateTag(driver, "formSpecific.whenGreenCardExpire");
				expiryDate.calculateDate("future", Integer.parseInt(expiryValue[1]), 0, 0);
			}
			else if(expiryValue[0].equalsIgnoreCase("lost"))
			{
				cardStatus.selectOption(2);
			}
			else if(expiryValue[0].equalsIgnoreCase("neverReceived"))
			{
				cardStatus.selectOption(3);
			}
			else if(expiryValue[0].equalsIgnoreCase("mutilated"))
			{
				cardStatus.selectOption(4);
			}
			else if(expiryValue[0].equalsIgnoreCase("USCISerror"))
			{
				cardStatus.selectOption(5);
			}
			else if(expiryValue[0].equalsIgnoreCase("nameChanged"))
			{
				cardStatus.selectOption(6);
				
				Name_FirstMiddleLast legallyChangedName=new Name_FirstMiddleLast(driver, "applicationData", 
						"formSpecific.nameAppearedOnGC");
				legallyChangedName.setFirstNameField(data.getProperty("formSpecific.nameAppearedOnGC.first"));
				legallyChangedName.setMiddleNameField(data.getProperty("formSpecific.nameAppearedOnGC.middle"));
				legallyChangedName.setLastNameField(data.getProperty("formSpecific.nameAppearedOnGC.last"));
				
			}
			else if(expiryValue[0].equalsIgnoreCase("newCard"))
			{
				cardStatus.selectOption(7);
				
				MultiRadioOptions birthInfo=new MultiRadioOptions(driver, "applicationData-formSpecific.birthDetails");
				
				if(birthDetails.equalsIgnoreCase("withinPast30days"))
				{
					birthInfo.selectOption(1);
				}
				else if(birthDetails.equalsIgnoreCase("moreThanPast30days"))
				{
					birthInfo.selectOption(2);
				}
				
				else if(birthDetails.equalsIgnoreCase("celebratingSoon"))
				{
					birthInfo.selectOption(3);
				}
				
				MultiRadioOptions cardExpiryInfo=new MultiRadioOptions(driver, "applicationData-formSpecific.existingGreenCardExpireDate");
				if(cardExpiration.equalsIgnoreCase("after16thBDay"))
				{
					cardExpiryInfo.selectOption(1);
				}
				else if(cardExpiration.equalsIgnoreCase("before16thBDay"))
				{
					cardExpiryInfo.selectOption(2);
				}
			}
			else if(expiryValue[0].equalsIgnoreCase("commuterStatus"))
			{
				cardStatus.selectOption(8);
				
				SelectElement commutorCity=new SelectElement(driver,
						"applicationData-formSpecific.commuterPortOfEntry-portOfEntry");
				
				commutorCity.selectValueFromDropDownUsingElementID(data.getProperty(
						"formSpecific.commuterPortOfEntry-portOfEntry"));
				
			}
			else if(expiryValue[0].equalsIgnoreCase("takingActualResidence"))
			{
				cardStatus.selectOption(9);
			}
			else if(expiryValue[0].equalsIgnoreCase("replaceCard"))
			{
				cardStatus.selectOption(10);
			}
			
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}
