package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {
	private YesNo travelDocToCurrentAddress;
	private MultiRadioOptions sendDocOptions;
	private AdditionalInfoFields UsEmbassyCity, OverseaCity;
	private Address UsEmbassyCountry, OverseaCountry;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 travelDocToCurrentAddress(Properties data,
			String toCurrentAddress, String sendDocumentTo) {
		if (!toCurrentAddress.equalsIgnoreCase("NA")) {
			
			travelDocToCurrentAddress = new YesNo(driver,
					"applicant.travelDocToCurrentAddress");
			if (toCurrentAddress.equalsIgnoreCase("Yes")) {
				travelDocToCurrentAddress.yes();
			}
			else if (toCurrentAddress.equalsIgnoreCase("No")) {
				travelDocToCurrentAddress.no();
				if (!sendDocumentTo.equalsIgnoreCase("NA")) {
					if (sendDocumentTo.equalsIgnoreCase("UsEmbassy")) {
						sendDocOptions = new MultiRadioOptions(driver,

						"applicationData-applicant.wantMyDocSent");
						sendDocOptions.selectOption(1);

						UsEmbassyCity = new AdditionalInfoFields(driver,

						"applicationData-applicant.embassyCity");
						UsEmbassyCity.normalText(data
								.getProperty("I131_EmbassyCity"));
						UsEmbassyCountry = new Address(driver,

						"applicationData-applicant.embassyCountry");
						UsEmbassyCountry.setCountryDropDown(data
								.getProperty("I131_EmbassyCountry"));
					}
					else if (sendDocumentTo.equalsIgnoreCase("OverseasOffice")) {
						sendDocOptions = new MultiRadioOptions(driver,

						"applicationData-applicant.wantMyDocSent");
						sendDocOptions.selectOption(2);

						OverseaCity = new AdditionalInfoFields(driver,

						"applicationData-applicant.embassyCity1");
						OverseaCity.normalText(data
								.getProperty("I131_EmbassyCity"));
						OverseaCountry = new Address(driver,
								"applicationData-applicant.embassyCountry1");
						OverseaCountry.setCountryDropDown(data
								.getProperty("I131_EmbassyCountry"));
					}
				}
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}
}
