package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ9_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ9_1 extends WizardPage {

	private YesNo haveEmployed;

	public SQ9_1(WebDriver driver) {
		super(driver);
	}

	public SQ9_1 relativeEmployment(String workedPastFiveYears,int employmentCount,String isThisCurrentOccupation,
			String occupationCountry) {

		String appname=Products.I130I485.name().toLowerCase();
		
		haveEmployed = new YesNo(driver,"foreignRelative.employmentInfo.workedPastFiveYears");
		haveEmployed.setYesOrNo(workedPastFiveYears);
		
		if(workedPastFiveYears.equalsIgnoreCase("Yes"))
		{
			
			for(int i=0;i<employmentCount;i++)
			{
			Employment employmentInfo=new Employment(driver);
			employmentInfo.employmentInformation("foreignRelative.employmentInfo.usEmployment"+"["+i+"]", appname, 
					isThisCurrentOccupation, occupationCountry);
			
			if (i < employmentCount - 1) {
				CommonInputClasses addAnotherEmployment=new CommonInputClasses(driver);
				addAnotherEmployment.addAnother();
			}
			
			}
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}
