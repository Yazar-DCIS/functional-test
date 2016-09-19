package com.formsdirectinc.functionaltests.apps.i130.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_5 extends WizardPage {

	private YesNo relativeLivingInUS;
	private Address relativeAddress;

	public SQ2_5(WebDriver driver) {
		super(driver);

	}

	public SQ2_5 familyMemberAddress(Properties data, String livingInUS,
			String country) {

		if (!livingInUS.equalsIgnoreCase("na")
				&& !country.equalsIgnoreCase("na")) {

			relativeLivingInUS = new YesNo(driver,
					"relative.currentlyLivingInUS");

			if (livingInUS.equalsIgnoreCase("Yes")) {
				relativeLivingInUS.yes();

				relativeAddress = new Address(driver,
						"applicationData-relative.usAddress");

				relativeAddress.setStreet(data.getProperty("StreetName"));

				relativeAddress.setCity(data.getProperty("City"));

				relativeAddress.setState(data.getProperty("tripState0"));

				relativeAddress.setZipcode(data.getProperty("Zipcode"));
			}

			else if (livingInUS.equalsIgnoreCase("No")) {
				relativeLivingInUS.no();
			}
			saveScreenShot("i130", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
