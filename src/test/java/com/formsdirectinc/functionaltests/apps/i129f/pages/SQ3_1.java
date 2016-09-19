package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_1 extends WizardPage {
	private YesNo relationship;
	private AdditionalInfoFields relationName;

	public SQ3_1(WebDriver driver) {
		super(driver);
	}

	public SQ3_1 relationShip(Properties data, String fianceRelatedToYou)
			throws Exception {
		
		relationship = new YesNo(driver,
				"applicant.relationshipToFiancee.relatedToFiance");
		if (fianceRelatedToYou.equalsIgnoreCase("Yes")) {
			relationship.yes();

			relationName = new AdditionalInfoFields(driver,
					"applicationData-applicant.relationshipToFiancee.relationship");
			relationName.normalText(data.getProperty("relation"));
		}
		else if (fianceRelatedToYou.equalsIgnoreCase("No")) {
			relationship.no();
		}
		saveScreenShot("i129f", "SQ3_1"); clickContinueInSQ();
		return this;
	}
}