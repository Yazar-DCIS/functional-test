package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for SQ2_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_2 extends WizardPage {


	private CheckBox reasonForApplication;
	
	public SQ2_2(WebDriver driver) {
		super(driver);
	}

	public SQ2_2 reasonforApplying(Properties data,String visitThisPage, String reasonValues,
			String nameChangeReason,String dobChangeReason,String genderChangeReasons) {
		
		if (visitThisPage.equalsIgnoreCase("yes")) {
			
			
				String reasonOptions=reasonValues;
				
				for(String reasonTypeSelect:reasonOptions.split(",")){
					
					reasonForApplication=new CheckBox(driver, "formSpecific.reasonForApplying");
					reasonForApplication.multipleCheckbox(Integer.parseInt(reasonTypeSelect));
					
					if(reasonTypeSelect.contains("1"))
					{
						SelectElement lostLocation=new SelectElement(driver, 
								"applicationData-formSpecific.explainWhenWhereHowLost");
						lostLocation.sendValuesUsingElementID("explainWhenWhereHowLost");
					}
					else if(reasonTypeSelect.contains("4"))
					{

						MultiRadioOptions reasonForNameChange=new MultiRadioOptions(driver, 
														"applicationData-formSpecific.reasonForNameChange");
						if(nameChangeReason.equalsIgnoreCase("CourtOrder")){
							reasonForNameChange.selectOption(1);
						}
						else if(nameChangeReason.equalsIgnoreCase("Marriage")){
							reasonForNameChange.selectOption(2);
						}
					
						DateTag nameChangedDate=new DateTag(driver, "formSpecific.dateOfNameChange");
						nameChangedDate.selectDate("10-11-2000");
						
					} 
					else if(reasonTypeSelect.contains("5"))
					{
						MultiRadioOptions reasonForDOBChange=new MultiRadioOptions(driver, 
								"applicationData-formSpecific.reasonForDOBChange");
						if(dobChangeReason.equalsIgnoreCase("CourtOrder")){
							reasonForDOBChange.selectOption(1);
						}
						else if(dobChangeReason.equalsIgnoreCase("StateIssued")){
							reasonForDOBChange.selectOption(2);
						}
						
						DateTag nameChangedDate=new DateTag(driver, "formSpecific.dateOfDOBChange");
						nameChangedDate.selectDate("10-11-2000");
					} 
					
					else if(reasonTypeSelect.contains("6"))
					{
						String genderOptions=genderChangeReasons;
						
						for(String genderTypeSelect:genderOptions.split(",")){
							
							CheckBox reasonForGenderChange=new CheckBox(driver, "formSpecific.reasonForGenderChange");
							reasonForGenderChange.multipleCheckbox(Integer.parseInt(genderTypeSelect));
						}
					}
				}
				
			
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
