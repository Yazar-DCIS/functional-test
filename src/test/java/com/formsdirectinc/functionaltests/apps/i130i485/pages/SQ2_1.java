package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ2_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_1 extends WizardPage {

	private MultiRadioOptions citizenshipMeans;

	public SQ2_1(WebDriver driver) {
		super(driver);
	}

	public SQ2_1 obtainedCitizenshipThru(String citizenshipMode) {
		citizenshipMeans = new MultiRadioOptions(driver,
				"applicationData-applicant.obtainCitizenship");
		
		if(citizenshipMode.equalsIgnoreCase("Naturalization"))
		{
			citizenshipMeans.selectOption(1);
		}
		else if(citizenshipMode.equalsIgnoreCase("Parents"))
		{
			citizenshipMeans.selectOption(2);
		}
		else if(citizenshipMode.equalsIgnoreCase("BirthInUS"))
		{
			citizenshipMeans.selectOption(3);
		}
		else if(citizenshipMode.equalsIgnoreCase("notUS_Citizen"))
		{
			citizenshipMeans.selectOption(4);
		}
	
		return this;
	}

}
