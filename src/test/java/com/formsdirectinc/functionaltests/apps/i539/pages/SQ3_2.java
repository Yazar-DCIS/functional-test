package com.formsdirectinc.functionaltests.apps.i539.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {

	private DateTag extend_Date;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public void set_ExtendStatusBy(Properties data) {
		extend_Date = new DateTag(driver, "applicant.extendStatusBy");
		extend_Date.selectDate(data.getProperty("DOExp"));
	}

}
