package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Page model for SQ7_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_6 extends WizardPage {

	private YesNo haveARN;

	public SQ7_6(WebDriver driver) {
		super(driver);
	}

	public SQ7_6 relativeARN(String haveArn) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		
		
		haveARN = new YesNo(driver, "foreignRelative.haveArnNumber");
		haveARN.setYesOrNo(haveArn);
		if(haveArn.equalsIgnoreCase("yes"))
		{
			
			Numbers arn=new Numbers(driver, "applicationData-foreignRelative.arnNumber");
			arn.setAlienRegistrationNumber(i130i485.getProperty("foreignRelative.arnNumber.arn"));
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}
