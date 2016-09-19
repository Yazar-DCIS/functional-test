package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_1 extends WizardPage {

	private Address applicantAddress;
	private DateTag lastEntryDates;
	private YesNo i94Number;
	
	Sites site = Sites.valueOf(System.getProperty("site.name"));
	public SQ3_1(WebDriver driver) {
		super(driver);

	}

	public void lastEntryInformation(Properties data,String applicantType) {
		
		applicantAddress = new Address(driver,
				"applicationData-"+applicantType+"Applicant.immigrationStatus.placeOfEntry");
		applicantAddress.setCity(data.getProperty("City"));
		applicantAddress.setState(data.getProperty("State"));
		
		if(applicantType.equalsIgnoreCase("principal")){
			lastEntryDates = new DateTag(driver, applicantType+"Applicant.livedInUS");
			lastEntryDates.selectDate(data.getProperty("DOB"));
		}
		
		lastEntryDates = new DateTag(driver,
				applicantType+"Applicant.immigrationStatus.dateOfEntry");
		lastEntryDates.selectDate(data.getProperty("DOE"));
		
		if(applicantType.equalsIgnoreCase("principal")){
			i94Number = new YesNo(driver, applicantType+"Applicant.haveI94Number");
		}
		else
		{
			i94Number = new YesNo(driver, "beneficiaryApplicant.immigrationStatus.haveI94Number");
		}
		
		i94Number.no();

	

	}

}
