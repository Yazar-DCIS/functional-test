package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Class of Admission
 * @author Orina
 */

public class SQ1_3_4 extends WizardPage {

	public SQ1_3_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_3_4 classOfAdmission(Properties data) {
		
		SelectElement setClassOfAdmission=new SelectElement(driver, "pdf.classOfAdmission");
		setClassOfAdmission.selectValueFromDropDownUsingElementID(data.getProperty("pdf.classOfAdmission"));
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		
		return this;
	}
}
