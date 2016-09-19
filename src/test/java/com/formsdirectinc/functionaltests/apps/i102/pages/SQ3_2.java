package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_2 extends WizardPage {

	private AdditionalInfoFields immigrantStatus;
	private YesNo classOfAdmission;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 currentNonImmigrantStatus(Properties data,
			String classOfAdmissionStamped) {

		if (!(classOfAdmissionStamped.equalsIgnoreCase("Skip"))) {

			immigrantStatus = new AdditionalInfoFields(driver,

			"applicationData-statusInfo.currentStatus");
			immigrantStatus.isStatusOther(data.getProperty("City"));

			classOfAdmission = new YesNo(driver,"statusInfo.confirmClassOfAdmission");
			classOfAdmission.setYesOrNo(classOfAdmissionStamped);

			saveScreenShot("I102", "SQ3_2"); clickContinueInSQ();

		}

		return this;
	}

}
