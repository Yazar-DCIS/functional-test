package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_4 extends WizardPage {

	private YesNo liveInSameAddr, provideSupport, knowSpouseAddr;
	private Address spouseAddr;
	private Country spouseCountry;
	private AdditionalInfoFields reasons;

	public SQ3_4(WebDriver driver) {
		super(driver);

	}

	public SQ3_4 spouseAddressDetails(Properties copies, Properties data,
			String spouseAddressSameAsYours, String knowSpouseAddress,String status,String livedTogether) {

		if (!spouseAddressSameAsYours.equalsIgnoreCase("NA")
				&& !knowSpouseAddress.equalsIgnoreCase("NA")) {

			liveInSameAddr = new YesNo(driver,
					"currentSpouse.spouseAddressSameAsYours");

			if (spouseAddressSameAsYours.equalsIgnoreCase("Yes")) {
				
				liveInSameAddr.yes();
				
				if (status.equalsIgnoreCase("US_National")) {
					YesNo livedTogetherlast3Years = new YesNo(driver,
							"currentSpouse.livedTogetherThreeYears");
					livedTogetherlast3Years.setYesOrNo(livedTogether);
					
				}
				
			}

			else if (spouseAddressSameAsYours.equalsIgnoreCase("No")) {
				liveInSameAddr.no();
				provideSupport = new YesNo(driver,
						"currentSpouse.financialSupportSpouse");

				if (knowSpouseAddress.equalsIgnoreCase("BothYes")) {
					provideSupport.yes();
					knowSpouseAddr = new YesNo(driver,
							"currentSpouse.knowYourSpouseAddress");
					knowSpouseAddr.yes();

					spouseCountry = new Country(driver,
							"applicationData-currentSpouse.currentSpouseAddress.country");
					spouseCountry.setCountryDDM(data.getProperty("Country"));

					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					spouseAddr = new Address(driver,
							"applicationData-currentSpouse.currentSpouseAddress");
					spouseAddr.setStreet(data.getProperty("StreetName"));
					spouseAddr.setCity(data.getProperty("City"));
					spouseAddr.setStateText(data.getProperty("State"));
					spouseAddr.setZipcode(data.getProperty("Zipcode"));

				}

				else if (knowSpouseAddress.equalsIgnoreCase("bothNo")) {
					provideSupport.no();
					knowSpouseAddr = new YesNo(driver,
							"currentSpouse.knowYourSpouseAddress");
					knowSpouseAddr.no();

					reasons = new AdditionalInfoFields(driver,

					"applicationData-currentSpouse.explainSpouseAddress");
					reasons.normalText(data.getProperty("Reasons"));
				}

				else if (knowSpouseAddress.equalsIgnoreCase("Yes")) {
					provideSupport.yes();
				}

				else if (knowSpouseAddress.equalsIgnoreCase("No")) {
					provideSupport.no();
				}

			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_4");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
