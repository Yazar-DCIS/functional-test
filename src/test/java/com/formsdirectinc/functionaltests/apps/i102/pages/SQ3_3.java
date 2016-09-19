package com.formsdirectinc.functionaltests.apps.i102.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_3 extends WizardPage {

	private MultiRadioOptions checkStatus;
	private DateTag immigrationStatusExpiry;

	public SQ3_3(WebDriver driver) {
		super(driver);
	}

	public SQ3_3 expirationOfCurrentStatus(Properties data,
			String immigrationStatusIndefinite) {

		if (!(immigrationStatusIndefinite.equalsIgnoreCase("skip"))) {

			checkStatus = new MultiRadioOptions(driver,
					"applicationData-statusInfo.statusI94");

			if (immigrationStatusIndefinite.equalsIgnoreCase("Yes"))

			{

				checkStatus.selectOption(1);
			}

			else if (immigrationStatusIndefinite.equalsIgnoreCase("No")) {
				checkStatus.selectOption(2);

				immigrationStatusExpiry = new DateTag(driver,

				"statusInfo.expirationDateOfCurrentStatus");
				immigrationStatusExpiry.selectDate(data.getProperty("DOE"));
			}

			saveScreenShot("I102", "SQ3_3"); clickContinueInSQ();

		}
		return this;
	}

}
