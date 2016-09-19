package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ7_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_6_1 extends WizardPage {

	private YesNo elis;

	public SQ7_6_1(WebDriver driver) {
		super(driver);
	}

	public SQ7_6_1 elisDetails(String haveELISNumber) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		
		elis = new YesNo(driver,"applicant.uscisHaveElectronicImmigrationSystem");
		elis.setYesOrNo(haveELISNumber);
		if(haveELISNumber.equalsIgnoreCase("yes"))
		{
			
			Numbers elis=new Numbers(driver, "applicationData-applicant");
			elis.setUSCISElisAccountNumber(i130i485.getProperty("applicant.uscisElisAccountNumber"));
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}
