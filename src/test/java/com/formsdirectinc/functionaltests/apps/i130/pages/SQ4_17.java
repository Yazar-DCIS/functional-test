package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ4_17 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_17 extends WizardPage {

	private DateTag relativeLastEnteredUS, I94ExpiryDate;
	private MultiRadioOptions i94Valid;

	public SQ4_17(WebDriver driver) {
		super(driver);

	}

	public SQ4_17 spouseLastEnteredInUS_Info(Properties data,
			String isRelativeI94Valid) {
		if (isRelativeI94Valid.equalsIgnoreCase("yes")||isRelativeI94Valid.equalsIgnoreCase("no")) {

			relativeLastEnteredUS = new DateTag(driver,
					"spouseInfo.lastEntered");
			relativeLastEnteredUS.selectDate(data.getProperty("fromDate"));

			i94Valid = new MultiRadioOptions(driver,
					"applicationData-spouseInfo.statusI94");
			if (isRelativeI94Valid.equalsIgnoreCase("Yes")) {
				i94Valid.selectOption(1);
			}
			else if (isRelativeI94Valid.equalsIgnoreCase("no")) {
				i94Valid.selectOption(2);
				I94ExpiryDate = new DateTag(driver, "spouseInfo.expiredDate");
				I94ExpiryDate.selectDate(data.getProperty("expDate_i94"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}
