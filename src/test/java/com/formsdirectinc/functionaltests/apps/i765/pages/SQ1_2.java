package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {

	private YesNo otherNames;
	private AdditionalInfoFields names;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 hasOtherNames(Properties data, String haveOtherName)
			throws Exception {
		
		otherNames = new YesNo(driver, "formSpecific.haveUsedOtherNames");
		otherNames.setYesOrNo(haveOtherName);
		
		if (haveOtherName.equalsIgnoreCase("Yes")) {
			
			names = new AdditionalInfoFields(driver,
					"applicationData-formSpecific.otherNames");
			names.normalText(data.getProperty("I765_OtherName"));
		}
		
		saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		return this;
	}

}