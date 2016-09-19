package com.formsdirectinc.functionaltests.apps.n565.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_2 extends WizardPage {

	private AdditionalInfoFields documentUscis, nameOnDocument;
	private DateTag dateOfDocument;
	private YesNo otherName;
	private Name_FirstMiddleLast addNames;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 DocsIssuanceDetails(String othername, int count,
			Properties data) {
		if (!othername.equalsIgnoreCase("NA")) {
			documentUscis = new AdditionalInfoFields(driver,
					"applicationData-formSpecific.uscisOfficeObtainedDocument");
			documentUscis.normalText(data.getProperty("Document"));

			dateOfDocument = new DateTag(driver,
					"formSpecific.dateWhenObtainedDocument");
			dateOfDocument.selectDate(data.getProperty("DOE"));

			nameOnDocument = new AdditionalInfoFields(driver,

			"applicationData-formSpecific.nameOnLastCertificate");
			nameOnDocument.normalText(data.getProperty("Document"));

			otherName = new YesNo(driver, "applicant.haveUsedOtherNames");

			if (othername.equalsIgnoreCase("Yes")) {
				otherName.yes();
				int[] othernames = { count };
				for (int i = 0; i < othernames.length; i++) {
					
					
					addNames = new Name_FirstMiddleLast(driver,"applicationData",
					"applicant.appOtherNames[" + i+ "].otherNames");
					addNames.setFirstNameField(data.getProperty("FirstName"));
					addNames.setLastNameField(data.getProperty("LastName"));
					
					if (i < othernames.length - 1) {
						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnother();
					}
				}
			}

			else if (othername.equalsIgnoreCase("No")) {
				otherName.no();
			}
			saveScreenShot("n565", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
