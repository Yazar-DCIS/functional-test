package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_8 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_8 extends WizardPage {

	private CommonInputClasses abroadaddress;

	public SQ2_8(WebDriver driver) {
		super(driver);
	}

	public void set_AbroadAddress(Properties data) {
		abroadaddress = new CommonInputClasses(driver);
		abroadaddress.ForeignAddress("applicationData-applicant.abroadAddress",
				data);
	}

}
