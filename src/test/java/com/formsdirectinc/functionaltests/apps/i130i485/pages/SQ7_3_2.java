package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ7_3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_3_2 extends WizardPage {

	public SQ7_3_2(WebDriver driver) {
		super(driver);
	}

	public SQ7_3_2 optionalContactInfo(String acceptedForProcessing)
	{
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		PhoneNumber optionalContactNumber=new PhoneNumber(driver, "applicationData-foreignRelative.cellPhone");
		optionalContactNumber.setPhoneCode(i130i485.getProperty("foreignRelative.cellPhone-phone1"));
		optionalContactNumber.setPhoneNumber(i130i485.getProperty("foreignRelative.cellPhone-phone2"));
		
		EMailAddress optionalEmail=new EMailAddress(driver, "applicationData-foreignRelative");
		optionalEmail.setEMailAddress(i130i485.getProperty("foreignRelative.emailAddress"));
		
		
			YesNo receiveNotification=new YesNo(driver, "applicant.acceptedForProcessing");
			receiveNotification.setYesOrNo(acceptedForProcessing);
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
		
	}
	
}
