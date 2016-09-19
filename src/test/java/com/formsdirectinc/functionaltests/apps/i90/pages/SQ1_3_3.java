package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Status Adjustment Date
 * @author Orina
 */

public class SQ1_3_3 extends WizardPage {

	private DateTag dateOfAdmission;

	public SQ1_3_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_3 setStatusAdjustmentDate(Properties data, String visitThisPage) {
		
		if(visitThisPage.equalsIgnoreCase("yes"))
		{
		dateOfAdmission = new DateTag(driver,
						"formSpecific.statusAdjustmentDate");
		dateOfAdmission.selectDate(data.getProperty("formSpecific.statusAdjustmentDate"));

		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}
		return this;
	}
}
