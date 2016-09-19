package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ7_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_5 extends WizardPage {

	private YesNo haveSSN;

	public SQ7_5(WebDriver driver) {
		super(driver);
	}

	public SQ7_5 relativeSSN(String haveSSNumber,int ssncount) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		haveSSN = new YesNo(driver, "foreignRelative.haveSsnNumber");
		haveSSN.setYesOrNo(haveSSNumber);
		if(haveSSNumber.equalsIgnoreCase("yes"))
		{
						
			for(int i=0;i<ssncount;i++)
			{
			Numbers ssnumber=new Numbers(driver, "applicationData-foreignRelative.ssnNumber["+i+"]");
			ssnumber.setSocialSecurityNumber(i130i485.getProperty("foreignRelative.ssnNumber["+i+"]-ssn1"), 
												i130i485.getProperty("foreignRelative.ssnNumber["+i+"]-ssn2"), 
													i130i485.getProperty("foreignRelative.ssnNumber["+i+"]-ssn3"));
			
			
			if (i < ssncount - 1) {
				CommonInputClasses addAnotherSSN=new CommonInputClasses(driver);
				addAnotherSSN.addAnother();
			}
			}
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}
