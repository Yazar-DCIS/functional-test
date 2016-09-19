package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MaritalInfo;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_4 extends WizardPage {

	
	

	private MaritalInfo maritalStatus;
	private YesNo beneficiaryDetails;

	public SQ2_4(WebDriver driver) {
		super(driver);

	}

	public void maritalInformation(Properties data,String maritalstatus) {

		maritalStatus = new MaritalInfo(driver,
				"applicationData-principalApplicant.maritalStatus");
		maritalStatus.setMarriageStatus(data.getProperty("status_"+maritalstatus));
		

	}

	public void beneficiaryMaritalInformation() {

		beneficiaryDetails = new YesNo(driver,
				"beneficiaryApplicant.hasMarriedEverBefore");
		beneficiaryDetails.no();

	}

}
