package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_18 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_18 extends WizardPage {

	private YesNo relativeAdjOfStatus;

	private Address statusCity_State, statusCountry;

	public SQ4_18(WebDriver driver) {
		super(driver);

	}

	public SQ4_18 spouseAdjustmentOfStatus_Info(Properties data,
			String appliedAdjOfStatus) {
		if (!appliedAdjOfStatus.equalsIgnoreCase("na")) {
			relativeAdjOfStatus = new YesNo(driver,
					"spouseInfo.applyAdjustmentOfStatus");
			if (appliedAdjOfStatus.equalsIgnoreCase("Yes")) {
				relativeAdjOfStatus.yes();

				statusCity_State = new Address(driver,
						"applicationData-spouseInfo.uscisOfficeLocation");
				statusCity_State.setCity(data.getProperty("City"));

				statusCity_State.setState(data.getProperty("tripState"));

				statusCity_State = new Address(driver,
						"applicationData-spouseInfo.notEligible");
				statusCity_State.setCity(data.getProperty("City"));

				statusCountry = new Address(driver,
						"applicationData-spouseInfo.notEligible.country");
				statusCountry.setCountryDropDown(data.getProperty("Country"));

			}
			else if (appliedAdjOfStatus.equalsIgnoreCase("no")) {
				relativeAdjOfStatus.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
