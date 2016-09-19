package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_2 extends WizardPage {
	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 otherAddress(int addressCount,String country,String currentAddress) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty("i129f");
		
		if (!country.equalsIgnoreCase("NA")) {
			
			for (int i = 0; i < addressCount; i++) {
								
				Address otherAddress=new Address(driver);
				otherAddress.setAddress("i129f", "applicant.residentialHistory["+i+"].address", country);
				
				if(currentAddress.equalsIgnoreCase("yes"))
				{
					CheckBox presentAddress=new CheckBox(driver, "applicant.residentialHistory["+i+"]-checkbox");
					presentAddress.check();
				}
				else if(currentAddress.equalsIgnoreCase("no"))
				{
					DateTag toDate=new DateTag(driver, "applicant.residentialHistory["+i+"].dateRange.toDate");
					toDate.selectDate(data.getProperty("residentialHistory.dateRange.toDate"));
				}
				
				DateTag fromDate=new DateTag(driver, "applicant.residentialHistory["+i+"].dateRange.fromDate");
				fromDate.selectDate(data.getProperty("residentialHistory.dateRange.fromDate"));
				
				if (i < addressCount - 1) {
					CommonInputClasses anotherAddress = new CommonInputClasses(
							driver);
					anotherAddress.addAnother();
				}
			}
			saveScreenShot("i129f", "SQ1_2"); clickContinueInSQ();
		}
		return this;
	}
}
