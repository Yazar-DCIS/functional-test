package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.Address;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Adjustment Of Status
 *	@author Orina
 */

public class SQ1_3_2 extends WizardPage {

	
	public SQ1_3_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_2 adjustmentOfStatus(Properties data, String visitThisPage) {
		
		if(visitThisPage.equalsIgnoreCase("Yes"))
		{
			
			Address immigrationLocation=new Address(driver, "applicationData-formSpecific");
			immigrationLocation.setCityLivedAdjustmentOfStatus(data.getProperty("formSpecific.cityLivedAdjustmentOfStatus"));
			immigrationLocation.setUSCISOfficeCity(data.getProperty("formSpecific.uscisOffice"));
				
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}
