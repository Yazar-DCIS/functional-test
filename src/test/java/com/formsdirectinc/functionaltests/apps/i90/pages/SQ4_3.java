package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90:Accommodations for Individuals with Disabilities and Impairment
 * @author Orina
 */

public class SQ4_3 extends WizardPage {

	private YesNo disabilityOrImpairment;
	private MultiRadioOptions disabilityOptions;
	private AdditionalInfoFields explain;

	public SQ4_3(WebDriver driver) {
		super(driver);
	}

	public SQ4_3 accommodations(Properties data, String haveDisabilityOrImpairment,
			String disability) {
		
		disabilityOrImpairment = new YesNo(driver,"formSpecific.disabilityOrImpairment");

			if (haveDisabilityOrImpairment.equalsIgnoreCase("no")) {
				disabilityOrImpairment.no();
			}

			if (haveDisabilityOrImpairment.equalsIgnoreCase("yes")) {
				disabilityOrImpairment.yes();

				disabilityOptions = new MultiRadioOptions(driver,"applicationData-formSpecific.disabilityList");

					if (disability.equalsIgnoreCase("deaf")) {
					
						disabilityOptions.selectOption(1);
						explain = new AdditionalInfoFields(driver,"applicationData-formSpecific.hearingImpairedAccommodationDetail");
						explain.normalText(data.getProperty("formSpecific.hearingImpairedAccommodationDetail"));
					}

					if (disability.equalsIgnoreCase("blind")) {
						disabilityOptions.selectOption(2);
						explain = new AdditionalInfoFields(driver,"applicationData-formSpecific.sightImpairedAccomodationDetail");
						explain.normalText(data.getProperty("formSpecific.sightImpairedAccomodationDetail"));
					}

					if (disability.equalsIgnoreCase("other")) {
						disabilityOptions.selectOption(3);
						explain = new AdditionalInfoFields(driver,"applicationData-formSpecific.otherDisabilityAccomodationDetail");
						explain.normalText(data.getProperty("formSpecific.otherDisabilityAccomodationDetail"));
					}
				}
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		
		return this;
	}
}
