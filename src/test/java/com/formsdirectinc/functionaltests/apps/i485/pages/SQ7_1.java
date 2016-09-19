package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ7_1 extends WizardPage {

	private YesNo employment;

	public SQ7_1(WebDriver driver) {
		super(driver);

	}

	public void priorEmployment(Properties data) {
		employment = new YesNo(driver,
				"employmentAuthorization.appliedEmploymentAuthorization");
		employment.no();

	}

}
