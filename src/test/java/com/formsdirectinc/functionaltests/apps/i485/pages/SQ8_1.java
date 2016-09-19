package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ8_1 extends WizardPage {

	private YesNo travelDocument;

	public SQ8_1(WebDriver driver) {
		super(driver);

	}

	public void priorTravel(Properties data) {
		travelDocument = new YesNo(driver, "travelDocument.issuedDocBefore");
		travelDocument.no();

	}

}
