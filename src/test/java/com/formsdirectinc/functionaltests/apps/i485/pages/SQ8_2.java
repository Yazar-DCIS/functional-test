package com.formsdirectinc.functionaltests.apps.i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ8_2 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ8_2 extends WizardPage {

	private YesNo travelPlans;

	public SQ8_2(WebDriver driver) {
		super(driver);

	}

	public void plannedTravel(Properties data) {
		travelPlans = new YesNo(driver, "travelDocument.intendToTravel");
		travelPlans.no();

	}

}
