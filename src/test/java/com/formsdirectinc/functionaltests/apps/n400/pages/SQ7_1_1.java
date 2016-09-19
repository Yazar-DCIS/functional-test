package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ7_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ7_1_1 extends WizardPage {

	private YesNo service;

	public SQ7_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ7_1_1 priorService(Properties copies, String answer) {
		if (!answer.equalsIgnoreCase("NA")) {

			service = new YesNo(driver, "militaryDetails.activeDuty");
			service.setYesOrNo(answer);
			if (answer.equalsIgnoreCase("No")) {
				CrimeDetails crimes=new CrimeDetails(driver);
				crimes.informationOnCrimeWithoutExplain("militaryDetails.dischargedHonorably", answer);
			}
			
			 clickContinueInSQ();
		}
		return this;
	}

}
