package com.formsdirectinc.functionaltests.apps.i134.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5 extends WizardPage {

	private MultiRadioOptions becomeUSCitizen;
	private YesNo haveObtainedN600;
	private AdditionalInfoFields certificateOfCitizenshipNumber,certificateOfNaturalizationNumber;
	
	public SQ1_5(WebDriver driver) {
		super(driver);
	}

	public SQ1_5 becomeUSCitizen(Properties data,int option,String answer) {
		becomeUSCitizen = new MultiRadioOptions(driver,
				"applicationData-eligibility.becomeUSCitizen");
		becomeUSCitizen.selectOption(option);
		
		if(option==2)
		{
			haveObtainedN600 = new YesNo(driver, "eligibility.haveObtainedN600");
			haveObtainedN600.setYesOrNo(answer);
			if(answer.equalsIgnoreCase("yes"))
			{
				certificateOfCitizenshipNumber = new AdditionalInfoFields(driver,
						"applicationData-eligibility.certificateOfCitizenshipNumber");
						certificateOfCitizenshipNumber.isStatusOther(data
								.getProperty("I134_Number"));
			}

		}
		
		else if(option==3)
		{
			certificateOfNaturalizationNumber = new AdditionalInfoFields(driver,
				"applicationData-eligibility.certificateOfNaturalizationNumber");
					certificateOfNaturalizationNumber.isStatusOther(data.getProperty("I134_Number"));
		}
		return this;
	}

	
	

}
