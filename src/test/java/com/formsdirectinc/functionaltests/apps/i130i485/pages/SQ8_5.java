package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Children;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ8_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ8_5 extends WizardPage {

	
	public SQ8_5(WebDriver driver) {
		super(driver);
	}

	public SQ8_5 relativeChildrenInfo(String haveChildren,int childCount) {

		String appname=Products.I130I485.name().toLowerCase();
		if(haveChildren.equalsIgnoreCase("Yes")||haveChildren.equalsIgnoreCase("no"))
		{
		
		YesNo haveAnyChildren=new YesNo(driver, "foreignRelative.haveAnyChildren");
		haveAnyChildren.setYesOrNo(haveChildren);
		if(haveChildren.equalsIgnoreCase("Yes"))
		{
			
			Children applicantChildInfo=new Children(driver);
			applicantChildInfo.setNumberOfChildren("foreignRelative.children", appname, childCount);
			
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
