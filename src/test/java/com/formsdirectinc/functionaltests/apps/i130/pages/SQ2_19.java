package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_19 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_19 extends WizardPage {

	
	public SQ2_19(WebDriver driver) {
		super(driver);

	}

	public SQ2_19 relativeArrivalNo(Properties data, String visitPage) {
		if (visitPage.equalsIgnoreCase("yes")) {
			
			Numbers i94Number=new Numbers(driver,"relative.arrivalNo");
			i94Number.setArrivalRecordNumber(data.getProperty("i94_1"), data.getProperty("i94_2"));
			
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
