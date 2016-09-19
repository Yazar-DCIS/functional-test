package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_16 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_16 extends WizardPage {

	public SQ4_16(WebDriver driver) {
		super(driver);

	}

	public SQ4_16 spouseArrivalNo(Properties data, String visitPage) {
		if (visitPage.equalsIgnoreCase("yes")) {
			
			Numbers arivalNo=new Numbers(driver, "applicationData-spouseInfo.arrivalNo");
			arivalNo.setArrivalRecordNumber(data.getProperty("i94_1"), data.getProperty("i94_2"));
					
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
