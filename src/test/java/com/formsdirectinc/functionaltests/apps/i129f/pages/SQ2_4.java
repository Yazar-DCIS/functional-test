package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ2_4 extends WizardPage {
	private YesNo usAddress;
	private CommonInputClasses selectAddress;

	public SQ2_4(WebDriver driver) {
		super(driver);
	}

	public SQ2_4 fianceIntendedUsAddress(Properties data,
			String fianceLiveInSameAddress) {
		usAddress = new YesNo(driver, "foreignFiance.liveWithPetitioner");
		if (fianceLiveInSameAddress.equalsIgnoreCase("Yes")) {
			usAddress.yes();
		}
		else if (fianceLiveInSameAddress.equalsIgnoreCase("No")) {
			usAddress.no();
			selectAddress = new CommonInputClasses(driver);
			selectAddress.applicantAddressDetails(
					"applicationData-foreignFiance.addrIntendingToLive", data);
		}
		saveScreenShot("i129f", "SQ2_4"); clickContinueInSQ();
		return this;
	}
}