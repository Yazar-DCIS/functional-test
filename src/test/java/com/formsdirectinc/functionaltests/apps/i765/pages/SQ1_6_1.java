package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Numbers;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6_1 extends WizardPage {

	private YesNo arrivalDepartureRecord;
	
	public SQ1_6_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_6_1 arrivalDepartureRecord(Properties data,
			String havArrivalDepartureRecord) throws Exception {
		if (!havArrivalDepartureRecord.equalsIgnoreCase("NA")) {
			
			arrivalDepartureRecord = new YesNo(driver,"formSpecific.haveArrivalDepartureRecord");
			arrivalDepartureRecord.setYesOrNo(havArrivalDepartureRecord);
			
			if (havArrivalDepartureRecord.equalsIgnoreCase("Yes")) {
			
				Numbers arrivalNumber=new Numbers(driver, "formSpecific.arrivalNo");
				arrivalNumber.setArrivalRecordNumber(data.getProperty("i94_1"), data.getProperty("i94_2"));
				
			}
			

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
