package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_2 extends WizardPage {

	private YesNo immigrationHistory;

	public SQ4_2(WebDriver driver) {
		super(driver);

	}

	public void immigrationHistory(String type) {

		immigrationHistory = new YesNo(driver, type
				+ "Applicant.immigrationStatus.appliedPRStatus");
		immigrationHistory.no();

	}

}
