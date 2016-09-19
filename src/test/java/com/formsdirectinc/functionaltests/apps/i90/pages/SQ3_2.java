package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * I-90: Correction
 * @author Orina
 */

public class SQ3_2 extends WizardPage {


	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 corrections(Properties data, String visitThisPage,String greenCardIncorrectData,String errorType,String reasonForIncorrectName,
			String reasonForIncorrectBirthCountry,String reasonForIncorrectBirthDate,String reasonForIncorrectGender) {
	
		if (visitThisPage.equalsIgnoreCase("yes")){
			
			YesNo greenCardIncorrect = new YesNo(driver, "formSpecific.greenCardIncorrect");

			if (greenCardIncorrectData.equalsIgnoreCase("yes")) {
				
				greenCardIncorrect.yes();
				
				String errorInValues=errorType;
				
				for(String errorTypeSelect:errorInValues.split(",")) {
					
					MultiRadioOptions greenCardError = new MultiRadioOptions(driver,
							"applicationData-formSpecific.informationIncorrect.optionList["+errorTypeSelect+"].value");
					
					greenCardError.selectOption(Integer.parseInt(errorTypeSelect));
				
					
					if(errorTypeSelect.contains("1"))
					{
						
						MultiRadioOptions incorrectNameReason=new MultiRadioOptions(driver, "applicationData-formSpecific.hasNameChanged");
						if(reasonForIncorrectName.equalsIgnoreCase("namelegallyChanged")){
							incorrectNameReason.selectOption(1);
							Name_FirstMiddleLast changedName = new Name_FirstMiddleLast(driver, "applicationData",
									"formSpecific.nameAppearedOnGC");
							changedName.setFirstNameField(data.getProperty("formSpecific.nameAppearedOnGC.first"));
							changedName.setMiddleNameField(data.getProperty("formSpecific.nameAppearedOnGC.middle"));
							changedName.setLastNameField(data.getProperty("formSpecific.nameAppearedOnGC.last"));
						}
						else if(reasonForIncorrectName.equalsIgnoreCase("uscisError")){
							incorrectNameReason.selectOption(2);
						}
						else if(reasonForIncorrectName.equalsIgnoreCase("mistakeDoneByuser")){
							incorrectNameReason.selectOption(3);
						}
						
						
					}
					else if(errorTypeSelect.contains("2"))
					{
						//Do Nothing
					}
					else if(errorTypeSelect.contains("3"))
					{
						MultiRadioOptions incorrectCountryOfBirthReason=new MultiRadioOptions(driver, 
								"applicationData-formSpecific.countrtyIncorrect");
						if(reasonForIncorrectBirthCountry.equalsIgnoreCase("countryOfBirthChanged")){
							incorrectCountryOfBirthReason.selectOption(1);
							
						}
						else if(reasonForIncorrectBirthCountry.equalsIgnoreCase("uscisError")){
							incorrectCountryOfBirthReason.selectOption(2);
						}
						else if(reasonForIncorrectBirthCountry.equalsIgnoreCase("mistakeDoneByuser")){
							incorrectCountryOfBirthReason.selectOption(3);
						}
					}
					else if(errorTypeSelect.contains("4"))
					{
						MultiRadioOptions incorrectDateOfBirthReason=new MultiRadioOptions(driver, 
								"applicationData-formSpecific.birthIncorrect");
						if(reasonForIncorrectBirthDate.equalsIgnoreCase("dateOfBirthChanged")){
							incorrectDateOfBirthReason.selectOption(1);
							
						}
						else if(reasonForIncorrectBirthDate.equalsIgnoreCase("uscisError")){
							incorrectDateOfBirthReason.selectOption(2);
						}
						else if(reasonForIncorrectBirthDate.equalsIgnoreCase("mistakeDoneByuser")){
							incorrectDateOfBirthReason.selectOption(3);
						}
					}
					else if(errorTypeSelect.contains("5"))
					{
						MultiRadioOptions incorrectGenderReason=new MultiRadioOptions(driver, 
								"applicationData-formSpecific.sexIncorrect");
						if(reasonForIncorrectGender.equalsIgnoreCase("genderChanged")){
							incorrectGenderReason.selectOption(1);
							
						}
						else if(reasonForIncorrectGender.equalsIgnoreCase("uscisError")){
							incorrectGenderReason.selectOption(2);
						}
						else if(reasonForIncorrectGender.equalsIgnoreCase("mistakeDoneByuser")){
							incorrectGenderReason.selectOption(3);
						}
					}
					
				}
				
				
			}

			if (greenCardIncorrectData.equalsIgnoreCase("no")) {
				greenCardIncorrect.no();
			}

			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
		}

		return this;
	}
}
