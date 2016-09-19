package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_9_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_9_2 extends WizardPage {

	private YesNo crime;
	private AdditionalInfoFields reasons;

	public SQ6_9_2(WebDriver driver) {
		super(driver);

	}

	public SQ6_9_2 crimeDetails(Properties copies, Properties keys,
			Properties data, String answer) {
		if (!answer.equalsIgnoreCase("NA")) {

			for (int i = 1; i < 11; i++) {
				crime = new YesNo(driver, keys.getProperty("sq692Crimes" + i)
						+ ".yesno");
				crime.setYesOrNo(answer);
				if (answer.equalsIgnoreCase("Yes")) {
				
					reasons = new AdditionalInfoFields(driver,
							"applicationData-"
									+ keys.getProperty("sq692Crimes" + i)
									+ ".explain");
					reasons.normalText(data.getProperty("Reasons"));
					if (i == 6) {
						crime = new YesNo(driver,
								"crimeDetails.youUsedWeaponInGroup.yesno");
						crime.setYesOrNo(answer);
						if (answer.equalsIgnoreCase("Yes")) {
							
							reasons = new AdditionalInfoFields(driver,

							"applicationData-crimeDetails.youUsedWeaponInGroup.explain");
							reasons.normalText(data.getProperty("Reasons"));
						}
						crime = new YesNo(driver,
								"crimeDetails.saidWeaponDetailsToGroupMember.yesno");
						crime.setYesOrNo(answer);
						if (answer.equalsIgnoreCase("Yes")) {
							reasons = new AdditionalInfoFields(driver,

							"applicationData-crimeDetails.saidWeaponDetailsToGroupMember.explain");
							reasons.normalText(data.getProperty("Reasons"));
						}
					}

					if (i == 7) {
						crime = new YesNo(driver,
								"crimeDetails.knowPersonGoingToUseWeapon.yesno");
						crime.setYesOrNo(answer);
						if (answer.equalsIgnoreCase("Yes")) {
							reasons = new AdditionalInfoFields(driver,
							"applicationData-crimeDetails.knowPersonGoingToUseWeapon.explain");
							reasons.normalText(data.getProperty("Reasons"));
						}
						crime = new YesNo(driver,"crimeDetails.knowPersonSellingWeapon.yesno");
						crime.setYesOrNo(answer);
						if (answer.equalsIgnoreCase("Yes")) {
						reasons = new AdditionalInfoFields(driver,

							"applicationData-crimeDetails.knowPersonSellingWeapon.explain");
							reasons.normalText(data.getProperty("Reasons"));
						}
					}

				}
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_9_2");
			 clickContinueInSQ();
		}

		return this;
	}

}
