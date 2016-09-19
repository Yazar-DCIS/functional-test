package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DisabilitiesInfo;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ12_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ12_2 extends WizardPage {

	private MultiRadioOptions haveDisabilities;

	public SQ12_2(WebDriver driver) {
		super(driver);
	}

	public SQ12_2 relativeInformationOnDisability(String disablityType) {

		PropertyResource propertyFile=new PropertyResource();
		Properties i130i485 = propertyFile.loadProperty("i130i485");
		if(disablityType.equalsIgnoreCase("hearingImpaired")||
				disablityType.equalsIgnoreCase("sightDisability")||
				disablityType.equalsIgnoreCase("otherDisability"))
		{
		
		haveDisabilities = new MultiRadioOptions(driver,"applicationData-foreignRelative.accomodation.natureOfDisability");
		DisabilitiesInfo accomadationFor=new DisabilitiesInfo(driver, "applicationData-foreignRelative.accomodation");
		
		if(disablityType.equalsIgnoreCase("hearingImpaired"))
		{
			haveDisabilities.selectOption(1);
			accomadationFor.setHearingImpaired(i130i485.getProperty("foreignRelative.accomodation.hearingImpaired"));
			
		}
		else if(disablityType.equalsIgnoreCase("sightDisability"))
		{
			haveDisabilities.selectOption(2);
			accomadationFor.setSightDisability(i130i485.getProperty("foreignRelative.accomodation.sightDisability"));
		}
		
		else if(disablityType.equalsIgnoreCase("otherDisability"))
		{
			haveDisabilities.selectOption(3);
			accomadationFor.setOtherDisability(i130i485.getProperty("foreignRelative.accomodation.otherDisability"));
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}
