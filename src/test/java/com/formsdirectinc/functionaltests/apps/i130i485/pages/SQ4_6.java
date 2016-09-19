package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ4_6 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ4_6 extends WizardPage {

	

	public SQ4_6(WebDriver driver) {
		super(driver);
	}

	public SQ4_6 citizenshipThroughParents(String certificateofCitizenshipInOwnName,
			String currentlyHaveCertificateofCitizenship,String havePassport) {
		
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(certificateofCitizenshipInOwnName.equalsIgnoreCase("Yes")||certificateofCitizenshipInOwnName.equalsIgnoreCase("no"))
		{
		YesNo obtainedCertificateofCitizenship= new YesNo(driver, "applicant.citizenshipParents.haveObtained");
		
		if(certificateofCitizenshipInOwnName.equalsIgnoreCase("Yes"))
		{
			obtainedCertificateofCitizenship.yes();
			
			
			
			if(currentlyHaveCertificateofCitizenship.equalsIgnoreCase("Yes"))
			{
				MultiRadioOptions certificateOfCitizenship=new MultiRadioOptions(driver, "applicationData-applicant.certificateofCitizenship");
				certificateOfCitizenship.selectOption(1);
				AdditionalInfoFields citizenshipInfo= new AdditionalInfoFields(driver,"applicant.citizenshipParents");
				citizenshipInfo.setNumber(i130i485.getProperty("applicant.citizenshipParents.number"));
				citizenshipInfo.setIssuedDate(i130i485.getProperty("applicant.citizenshipParents.issuedDate"));
				
				Address placeIssued=new Address(driver,"applicationData-applicant.citizenshipParents.placeIssued");
				placeIssued.setCity(i130i485.getProperty("applicant.citizenshipParents.placeIssued.city"));
				placeIssued.setState(i130i485.getProperty("applicant.citizenshipParents.placeIssued.state"));
								
				
			}
			else if(currentlyHaveCertificateofCitizenship.equalsIgnoreCase("no"))
			{
				MultiRadioOptions certificateOfCitizenship=new MultiRadioOptions(driver, "applicationData-applicant.certificateofCitizenship");
				certificateOfCitizenship.selectOption(2);
				
				YesNo passport= new YesNo(driver, "applicant.usPassport");
				passport.setYesOrNo(havePassport);
			}
			
		}
		
		else if(certificateofCitizenshipInOwnName.equalsIgnoreCase("no"))
		{
			obtainedCertificateofCitizenship.no();
		
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
