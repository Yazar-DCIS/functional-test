package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ9_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ9_2 extends WizardPage {

	private YesNo haveEmployed;

	public SQ9_2(WebDriver driver) {
		super(driver);
	}

	public SQ9_2 relativeEmploymentAbroad(String workedOutside,String isThisCurrentOccupation,String occupationCountry) {

		String appname=Products.I130I485.name().toLowerCase();
		if(workedOutside.equalsIgnoreCase("Yes")||workedOutside.equalsIgnoreCase("no"))
		{
		haveEmployed = new YesNo(driver,"foreignRelative.employmentInfo.workedOutside");
		haveEmployed.setYesOrNo(workedOutside);
		if(workedOutside.equalsIgnoreCase("Yes"))
		{
			
			Employment employmentInfo=new Employment(driver);
			employmentInfo.employmentInformation("foreignRelative.employmentInfo.outsideEmployment",
					appname, isThisCurrentOccupation,occupationCountry);
			
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}
