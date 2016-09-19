package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ4_4 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ4_4 extends WizardPage {
	private YesNo priorVisaPetition;
	private Name_FirstMiddleLast name;
	private AdditionalInfoFields relationShip;
	private DateTag date;

	public SQ4_4(WebDriver driver) {
		super(driver);
	}

	public SQ4_4 submittedIVPetition(Properties data,String answer) {
		priorVisaPetition = new YesNo(driver,
				"formSpecific.submittedIVPetition");
		priorVisaPetition.setYesOrNo(answer);
		
		if(answer.equalsIgnoreCase("yes"))
		{
			name = new Name_FirstMiddleLast(driver, "applicationData",
					"formSpecific.priorVisaPetition[0].IVPetitioner");
			name.setFirstNameField(data.getProperty("FirstName"));
			name.setMiddleNameField(data.getProperty("MiddleName"));
			name.setLastNameField(data.getProperty("LastName"));

			relationShip = new AdditionalInfoFields(driver,
					"applicationData-formSpecific.priorVisaPetition[0].personRelationship");
			relationShip.isStatusOther(data.getProperty("I134_Relation"));

			date = new DateTag(driver,
					"formSpecific.priorVisaPetition[0].datePetitionSubmitted");
			date.selectMonth(data.getProperty("DOB_Month"));
			date.selectDay(data.getProperty("DOB_Day"));
			date.selectYear(data.getProperty("DOB_Year"));
		}
		return this;
	}

	

}
