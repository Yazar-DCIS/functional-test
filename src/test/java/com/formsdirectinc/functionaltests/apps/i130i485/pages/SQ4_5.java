package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ4_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_5 extends WizardPage {

	

	public SQ4_5(WebDriver driver) {
		super(driver);
	}

	public SQ4_5 citizenshipThroughNaturization(String haveCertificateofNaturalization,
			String havePassport) {
		
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(haveCertificateofNaturalization.equalsIgnoreCase("Yes")||haveCertificateofNaturalization.equalsIgnoreCase("no"))
		{
		
		YesNo certificateofNaturalization= new YesNo(driver, "applicant.certificateofNaturalization");
		
		if(haveCertificateofNaturalization.equalsIgnoreCase("Yes"))
		{
			certificateofNaturalization.yes();
			
			AdditionalInfoFields naturalizationInfo= new AdditionalInfoFields(driver, 
					"applicant.citizenshipNaturalization");
			naturalizationInfo.setNumber(i130i485.getProperty("applicant.citizenshipNaturalization.number"));
			naturalizationInfo.setIssuedDate(i130i485.getProperty("applicant.citizenshipNaturalization.issuedDate"));
			naturalizationInfo.setIssuedPlace(i130i485.getProperty("applicant.citizenshipNaturalization.issuedPlace"));
			
		}
		
		else if(haveCertificateofNaturalization.equalsIgnoreCase("no"))
		{
			certificateofNaturalization.no();
			
			YesNo passport= new YesNo(driver, "applicant.havePassport");
			passport.setYesOrNo(havePassport);
						
			
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
