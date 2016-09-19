package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_20 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_20 extends WizardPage {

	private DateTag relativeLastEnteredUS, I94ExpiryDate;
	private MultiRadioOptions i94Valid;

	public SQ2_20(WebDriver driver) {
		super(driver);

	}

	public SQ2_20 relativeLastEnteredInUS_Info(Properties data,
			String isRelativeI94Valid) {

		if (isRelativeI94Valid.equalsIgnoreCase("yes")||isRelativeI94Valid.equalsIgnoreCase("no")) {
			relativeLastEnteredUS = new DateTag(driver, "relative.lastEntered");
			relativeLastEnteredUS.selectDate(data.getProperty("fromDate"));

			i94Valid = new MultiRadioOptions(driver,
					"applicationData-relative.statusI94");
			if (isRelativeI94Valid.equalsIgnoreCase("Yes")) {
				i94Valid.selectOption(1);
			}
			else if (isRelativeI94Valid.equalsIgnoreCase("no")) {
				i94Valid.selectOption(2);
				I94ExpiryDate = new DateTag(driver, "relative.expiredDate");
				I94ExpiryDate.selectDate(data.getProperty("expDate_i94"));
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;

	}

}
