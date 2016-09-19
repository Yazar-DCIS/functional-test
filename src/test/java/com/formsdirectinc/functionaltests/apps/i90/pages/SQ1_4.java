package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.Address;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90: Place of Initial Entry into the U.S.
 * @author Orina
 * Revision: $Rev$
 */

public class SQ1_4 extends WizardPage {


	public SQ1_4(WebDriver driver) {
		super(driver);
	}

	public SQ1_4 setPlaceOfEntry(Properties data, String visitThisPage) {
		
		if (visitThisPage.equalsIgnoreCase("yes")) {
			
			Address placeOfEntry=new Address(driver, "applicationData-formSpecific");
			placeOfEntry.setDestinationCity(data.getProperty("formSpecific.desitinationCity"));
			placeOfEntry.setPortOfEntryCity(data.getProperty("formSpecific.portOfEntry.name"));
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
			
		}

		return this;
	}
}
