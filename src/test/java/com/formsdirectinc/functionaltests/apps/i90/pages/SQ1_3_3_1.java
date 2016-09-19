package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Immigrant Admission Date
 * @author Orina
 */

public class SQ1_3_3_1 extends WizardPage {

	private DateTag dateOfAdmission;

	public SQ1_3_3_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_3_1 setImmigrantAdmissionDate(Properties data,String visitThisPage) {
			
		if(visitThisPage.equalsIgnoreCase("yes"))
		{
		dateOfAdmission = new DateTag(driver,
						"formSpecific.immigrantAdmissionDate");
		dateOfAdmission.selectDate(data.getProperty("formSpecific.immigrantAdmissionDate"));
			
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}
		return this;
	}
}
