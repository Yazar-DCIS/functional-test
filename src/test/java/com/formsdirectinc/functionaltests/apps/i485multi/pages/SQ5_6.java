package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_6 extends WizardPage {

	
	

	private YesNo haveDependents;
	private Name_FirstMiddleLast dependentName;
	private DateTag dependentDOB;
	private AdditionalInfoFields dependentRelation;
	private MultiRadioOptions dependencies;

	public SQ5_6(WebDriver driver) {
		super(driver);

	}

	public void haveOtherDependents(String haveDepend, Properties data) {

		haveDependents = new YesNo(driver,
				"principalFamilyMembers.haveOtherDependents");

		if (haveDepend.equalsIgnoreCase("Yes")) {
			haveDependents.yes();

			dependentName = new Name_FirstMiddleLast(driver, "applicationData",
					"principalFamilyMembers.otherDependentsDetails[0].name");
			dependentName.setFirstNameField(data.getProperty("FirstName1"));
			dependentName.setLastNameField(data.getProperty("LastName"));

			dependentDOB = new DateTag(driver,
					"principalFamilyMembers.otherDependentsDetails[0].dateOfBirth");
			dependentDOB.selectDateAsSingle(data.getProperty("DateOfBirth"));

			dependentRelation = new AdditionalInfoFields(driver,

			"applicationData-principalFamilyMembers.otherDependentsDetails[0].relation");
			dependentRelation.normalText(data.getProperty("childRelation"));

			dependencies = new MultiRadioOptions(
					driver,

					"applicationData-principalFamilyMembers.otherDependentsDetails[0].financialObligations");
			dependencies.selectOption(1);

		} else {
			haveDependents.no();
		}

	}

}
