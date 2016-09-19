package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {

	public SQ4_2(WebDriver driver) {
		super(driver);
	}

	
	private YesNo livingInSameAddress;
	private Address spouseAddress;
	private CommonInputClasses spouseaddress;

	public SQ4_2 spouse_Address(String address, Properties data) {
		if (!address.equalsIgnoreCase("NA")) {
			livingInSameAddress = new YesNo(driver,
					"currentSpouseDetails.livingInSameAddress");
			if (address.equalsIgnoreCase("Yes")) {
				livingInSameAddress.yes();
			} else if (address.equalsIgnoreCase("No")) {

				livingInSameAddress.no();
				spouseAddress = new Address(driver,
						"applicationData-currentSpouseDetails.spouseAddress.country");
				spouseAddress.setCountryDropDown(data
						.getProperty("DOB_Country"));
				spouseaddress = new CommonInputClasses(driver);
				spouseaddress.applicantOtherAddressDetails(
						"applicationData-currentSpouseDetails.spouseAddress",
						data);
			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
