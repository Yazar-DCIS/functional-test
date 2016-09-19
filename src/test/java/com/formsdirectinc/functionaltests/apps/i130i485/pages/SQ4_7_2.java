package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ4_7_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_7_2 extends WizardPage {

	private YesNo elis;

	public SQ4_7_2(WebDriver driver) {
		super(driver);
	}

	public SQ4_7_2 elisDetails(String haveELISNumber) {
		
		PropertyResource propertyFile = new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		elis = new YesNo(driver, "applicant.haveElectronicImmigrationSystem");
		elis.setYesOrNo(haveELISNumber);
		if(haveELISNumber.equalsIgnoreCase("Yes"))
		{
		
			Numbers elisNumber= new Numbers(driver, "applicationData-applicant");
			elisNumber.setElisAccountNumber(i130i485.getProperty("applicant.elisAccountNumber"));
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		
		return this;
	}

}
