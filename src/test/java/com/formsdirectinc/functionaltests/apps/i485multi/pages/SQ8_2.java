package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ8_2 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ8_2 extends WizardPage {

	private YesNo travelPlans;

	public SQ8_2(WebDriver driver) {
		super(driver);

	}

	public void travelDocumentIntendToTravel(Properties data,String answer) {
		travelPlans = new YesNo(driver, "principalFormSpecific.travelDocument.hasIntendToTravel");
		if(answer.equalsIgnoreCase("yes"))
		{
			travelPlans.yes();
			SelectElement purposeOfTravel=new SelectElement(driver, "principalFormSpecific.travelDocument.purposeOfTravel");
			purposeOfTravel.sendValuesUsingElementName("VACATION");
			
			Country visitingCountry=new Country(driver, "applicationData-principalFormSpecific.travelDocument.travelledCountry[0]");
			visitingCountry.setCountry("India");
			
			DateTag intendedDepartureDate=new DateTag(driver, "principalFormSpecific.travelDocument.intendedDepartureDate");
			intendedDepartureDate.selectDate(data.getProperty("expDate_i94"));
			
			SelectElement expectedTravelDuration=new SelectElement(driver, "principalFormSpecific.travelDocument.expectedTravelDuration");
			expectedTravelDuration.sendValuesUsingElementName("1");
		}
		else if(answer.equalsIgnoreCase("no"))
		{
			travelPlans.no();
		}
	}

}
