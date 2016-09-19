package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_0 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_0 extends WizardPage {

	private MultiRadioOptions reasonForRequest;

	private DateTag new_user_Entered;

	public SQ1_0(WebDriver driver) {
		super(driver);

	}

	public SQ1_0 applyingDACAForFirstTime(String reason_for_request,
			Properties data) throws Exception {

		if (!reason_for_request.equalsIgnoreCase("Skip")) {

			reasonForRequest = new MultiRadioOptions(driver,
					"applicationData-reasonForApplying");

			if (reason_for_request.equalsIgnoreCase("First_Time_DACA")) {
				reasonForRequest.selectOption(1);
			} else if (reason_for_request.equalsIgnoreCase("Recently_Expired")) {
				reasonForRequest.selectOption(2);
				new_user_Entered = new DateTag(driver,
						"renewalApplication.dacaArrivalExpires");
				new_user_Entered.selectDateAsSingle(data
						.getProperty("DACA_Expire"));

			} else if (reason_for_request
					.equalsIgnoreCase("ExpiredOver_1yearago")) {
				reasonForRequest.selectOption(3);
			}

		}
		return this;
	}

	public SQ1_0 continueToNext(String continueToNext,String page) {
		if (!continueToNext.equalsIgnoreCase("skip")) {

			saveScreenShot("i821d", page); clickContinueInSQ();

		}
		return this;
	}
}
