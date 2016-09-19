package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ10_1 extends WizardPage {

	private YesNo accommodation;

	public SQ10_1(WebDriver driver) {
		super(driver);

	}

	public void requestAccommodation(Properties data) {
		accommodation = new YesNo(driver,
				"formSpecific.disabilities.requestAccomdation");
		accommodation.no();

	}

}
