package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_3 extends WizardPage {
	private YesNo priorAffidavit;
	private Name_FirstMiddleLast name;
	private DateTag doa;

	public int i = 0;

	public SQ4_3(WebDriver driver) {
		super(driver);
	}

	public SQ4_3 haveSubmittedAffidavit(Properties data,String answer) {
		priorAffidavit = new YesNo(driver,
				"formSpecific.haveSubmittedAffidavit");
		priorAffidavit.setYesOrNo(answer);
		
		if(answer.equalsIgnoreCase("yes"))
		{
			name = new Name_FirstMiddleLast(driver, "applicationData",
					"formSpecific.priorAffidavit[0].sponsorName");
			name.setFirstNameField(data.getProperty("FirstName"));
			name.setMiddleNameField(data.getProperty("MiddleName"));
			name.setLastNameField(data.getProperty("LastName"));

			doa = new DateTag(driver,
					"formSpecific.priorAffidavit[0].dateAffidavitSubmitted");
			doa.selectMonth(data.getProperty("DOB_Month"));
			doa.selectDay(data.getProperty("DOB_Day"));
			doa.selectYear(data.getProperty("DOB_Year"));
		}
		
		return this;
	}

	

	
}
