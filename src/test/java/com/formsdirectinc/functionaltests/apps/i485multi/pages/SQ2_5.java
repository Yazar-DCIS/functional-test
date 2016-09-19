package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_5 extends WizardPage {

	private YesNo ssnStatus;
	public SQ2_5(WebDriver driver) {
		super(driver);

	}

	public void ssnStatus(String type,String haveSSN) {

		ssnStatus = new YesNo(driver, type+"FormSpecific.haveSSN");
		if(haveSSN.equalsIgnoreCase("yes"))
		{
			ssnStatus.yes();
			Numbers ssn=new Numbers(driver, "applicationData-principalApplicant.SSN");
			ssn.setSocialSecurityNumber("123", "45", "6789");
		}
		if(haveSSN.equalsIgnoreCase("no"))
		{
			ssnStatus.no();
		}

	}

}
