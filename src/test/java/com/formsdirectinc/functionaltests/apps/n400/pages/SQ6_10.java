package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_10 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_10 extends WizardPage {

	private YesNo oath;
	private AdditionalInfoFields reasons;

	public SQ6_10(WebDriver driver) {
		super(driver);

	}

	public SQ6_10 oathRequirements(Properties copies, Properties keys,
			Properties data, String answer,String oathCondition) {
		if (!answer.equalsIgnoreCase("NA")) {

			int oathCount = 0;
			if(oathCondition.equalsIgnoreCase("Yes"))
			{
				oathCount=8;
			}
			else if(oathCondition.equalsIgnoreCase("No"))
			{
				oathCount=7;
			}
			
			for (int i = 1; i < oathCount; i++) {
					oath = new YesNo(driver, keys.getProperty("Oaths" + i)
							+ ".yesno");
					oath.setYesOrNo(answer);
					if(answer.equalsIgnoreCase("No"))
					{
						reasons = new AdditionalInfoFields(driver,
								"applicationData-" + keys.getProperty("Oaths" + i)
										+ ".explain");
						reasons.normalText(data.getProperty("Reasons"));
					}
					
				}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_10");
			 clickContinueInSQ();
		}
		return this;
	}

}
