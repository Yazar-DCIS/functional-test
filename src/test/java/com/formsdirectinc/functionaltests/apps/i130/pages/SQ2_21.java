package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_21 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_21 extends WizardPage {

	private YesNo relativeAdjOfStatus;

	private Address statusCity_State, statusCountry;

	public SQ2_21(WebDriver driver) {
		super(driver);

	}

	public SQ2_21 relativeAdjustmentOfStatus_Info(Properties data,
			String appliedAdjOfStatus) {

		if (!appliedAdjOfStatus.equalsIgnoreCase("na")) {

			relativeAdjOfStatus = new YesNo(driver,
					"relative.applyAdjustmentOfStatus");
			if (appliedAdjOfStatus.equalsIgnoreCase("Yes")) {
				relativeAdjOfStatus.yes();

				statusCity_State = new Address(driver,
						"applicationData-relative.uscisOfficeLocation");
				statusCity_State.setCity(data.getProperty("City"));

				statusCity_State.setState(data.getProperty("tripState"));

				statusCity_State = new Address(driver,
						"applicationData-relative.notEligible");
				statusCity_State.setCity(data.getProperty("City"));

				statusCountry = new Address(driver,
						"applicationData-relative.notEligible.country");
				statusCountry.setCountryDropDown(data.getProperty("Country"));

			}
			else if (appliedAdjOfStatus.equalsIgnoreCase("NO")) {
				relativeAdjOfStatus.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
