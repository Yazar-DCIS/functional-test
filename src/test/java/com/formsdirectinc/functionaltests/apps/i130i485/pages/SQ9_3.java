package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.Employment;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ9_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ9_3 extends WizardPage {

	private YesNo appliedEmploymentAuthorization;

	public SQ9_3(WebDriver driver) {
		super(driver);
	}

	public SQ9_3 employmentAuthorization(String haveAuthorization,int workAuthorizationCount) {

		String appname=Products.I130I485.name().toLowerCase();
		
		appliedEmploymentAuthorization = new YesNo(driver,
				"foreignRelative.employmentInfo.appliedEmploymentAuthorization");
		appliedEmploymentAuthorization.setYesOrNo(haveAuthorization);
		
		if(haveAuthorization.equalsIgnoreCase("Yes"))
		{
			
			Employment workAuthorizationInfo=new Employment(driver);
			workAuthorizationInfo.employmentAuthorizationInformation("foreignRelative.employmentInfo.workAuthorization", appname, workAuthorizationCount);
		}
		
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}
