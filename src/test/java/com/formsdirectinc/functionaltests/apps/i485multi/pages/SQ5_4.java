package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ5_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ5_4 extends WizardPage {

	private YesNo spouseARN;
	private AdditionalInfoFields arnValue;

	public SQ5_4(WebDriver driver) {
		super(driver);

	}

	public void spouseARNInformations(String haveARN, Properties data) {
	
		spouseARN = new YesNo(driver,
				"principalFamilyMembers.spouseInfo.haveARN");

		if (haveARN.equalsIgnoreCase("Yes")) {
			spouseARN.yes();
			arnValue = new AdditionalInfoFields(driver,
					"applicationData-principalFamilyMembers.spouseInfo.ARN.arn");
			arnValue.normalText(data.getProperty("ARN"));

		} else {
			spouseARN.no();
		}

		YesNo spouseSSN = new YesNo(driver,
					"principalFamilyMembers.spouseInfo.haveSSN");
		spouseSSN.no();
		
		
		
		
	}

}
