package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_5 extends WizardPage {

	
	

	private YesNo haveChildren;

	public SQ5_5(WebDriver driver) {
		super(driver);

	}

	public void haveChild(String haveChild,String applicantType) {

		haveChildren = new YesNo(driver, applicantType+"FamilyMembers.haveChildren");
		haveChildren.setYesOrNo(haveChild);
		

	}


}
