package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	
	private DateTag lastEnterUS;
	private AdditionalInfoFields portOfEntry;
	private Address cityOfLastEntry;
	private AdditionalInfoFields stateOfLastEntry;

	public SQ3_1 lastEnterUS(Properties data) {

		lastEnterUS = new DateTag(driver, "formSpecific.lastEnterUS");
		lastEnterUS.selectDateAsSingle(data.getProperty("DateEntered"));

		portOfEntry = new AdditionalInfoFields(driver,
				"applicationData-formSpecific.portOfEntry");
		portOfEntry.normalText(data.getProperty("PortOfEntry"));

		cityOfLastEntry = new Address(driver, "applicationData-formSpecific");
		cityOfLastEntry.setCityPlaceOfEntry(data.getProperty("City765"));
		cityOfLastEntry.setMannerPlaceOfEntry(data.getProperty("POE_Manner"));

		stateOfLastEntry = new AdditionalInfoFields(driver,
				"applicationData-formSpecific.stateOfLastEntry-state");
		stateOfLastEntry.selectDDM(data.getProperty("POE_State"));

		saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();

		return this;
	}

}
