package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_10 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_10 extends WizardPage {

	
	

	private YesNo assetsStatus;

	public SQ2_10(WebDriver driver) {
		super(driver);

	}

	public void assetsStatus() {

		assetsStatus = new YesNo(driver, "principalApplicant.hasLifeInsurance");
		assetsStatus.no();

		assetsStatus = new YesNo(driver, "principalApplicant.owningRealEstate");
		assetsStatus.no();

	}

}
