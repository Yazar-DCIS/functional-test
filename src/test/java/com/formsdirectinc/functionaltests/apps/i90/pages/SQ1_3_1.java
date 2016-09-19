package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.Address;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Immigration Visa
 * @author Orina
 */

public class SQ1_3_1 extends WizardPage {

	
	public SQ1_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_1 setImmigrationVisaProcessingInfo(Properties data, String visitThisPage) {
		
		if(visitThisPage.equalsIgnoreCase("Yes"))
		{
			
			Address immigrationLocation=new Address(driver, "applicationData-formSpecific");
			immigrationLocation.setConsulateCity(data.getProperty("formSpecific.consulateVisaIssued"));
			immigrationLocation.setImmigrantCity(data.getProperty("formSpecific.cityLivedAsImmigrant"));
				
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}
		
		return this;
	}
}
