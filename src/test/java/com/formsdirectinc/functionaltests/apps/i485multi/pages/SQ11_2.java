package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ11_2 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ11_2 extends WizardPage {

	
	

	private CheckBox certification;

	public SQ11_2(WebDriver driver) {
		super(driver);

	}

	public void certification(String type) {

		certification = new CheckBox(
				driver,

				"applicationData-"+ type+ "FormSpecific.statement.acknowledgement.optionList[1].value-1");
		certification.check();

	}

}
