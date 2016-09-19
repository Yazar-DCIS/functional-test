package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Children;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ8_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ8_6 extends WizardPage {

	
	public SQ8_6(WebDriver driver) {
		super(driver);
	}

	public SQ8_6 relativeOtherChildrenInfo(String haveChildren,int childCount) {

		String appname=Products.I130I485.name().toLowerCase();
		if(haveChildren.equalsIgnoreCase("Yes")||haveChildren.equalsIgnoreCase("no"))
		{
		YesNo haveChildrenOtherThanApplicant=new YesNo(driver, "foreignRelative.haveChildrenOtherThanApplicant");
		haveChildrenOtherThanApplicant.setYesOrNo(haveChildren);
		if(haveChildren.equalsIgnoreCase("Yes"))
		{
			Children applicantChildInfo=new Children(driver);
			applicantChildInfo.setNumberOfChildren("foreignRelative.childrenOtherThanApplicant", appname, childCount);
			
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
