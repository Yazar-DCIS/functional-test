package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2 extends WizardPage {

	private YesNo haveUsedOtherNames;
	private PageCopiesAndContent copyValidation;

	// private Repeater<Name_FirstMiddleLast> otherNamesTag;

	public SQ1_2(WebDriver driver) {
		super(driver);

	}

	public SQ1_2 otherNamesInfo(Properties n600copies, String otherNames,
			Properties data, int count) {

		if (!otherNames.equalsIgnoreCase("NA") && count != -1) {

			

			try {
				copyValidation = new PageCopiesAndContent(driver);
				copyValidation
						.verifyPageLabelText(
								n600copies.getProperty("label.sq1.2.question1")
										+ " "
										+ data.getProperty("FirstName")
										+ " "
										+ n600copies
												.getProperty("label.sq1.2.question1.1"),
								"section-1.2.1");
				copyValidation.verifyExplainThisText(
						n600copies.getProperty("label.explainThis.sq1.2"),
						"section-1.2.1",
						n600copies.getProperty("elementID.explainThis.sq1.2"));
				copyValidation.getPageTitle();
			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}

			haveUsedOtherNames = new YesNo(driver,
					"applicant.hasUsedOtherNames");

			if (otherNames.equalsIgnoreCase("Yes")) {
				haveUsedOtherNames.yes();
				try {
					copyValidation
							.verifyPageInstructionalText(
									n600copies
											.getProperty("label.sq1.2.question2")
											+ " "
											+ data.getProperty("FirstName")
											+ " "
											+ n600copies
													.getProperty("label.sq1.2.question2.1"),
									"section-1.2.2");
				} catch (Exception e) {
					System.out.println(e.getStackTrace());
				}

				for (int i = 0; i < count; i++) {

					Name_FirstMiddleLast moreNames = new Name_FirstMiddleLast(
							driver, "applicationData",
							"applicant.usedOtherNamesHistory[" + i
									+ "].usedOtherNames");
					moreNames.setFirstNameField(data.getProperty("FirstName"));
					moreNames
							.setMiddleNameField(data.getProperty("MiddleName"));
					moreNames.setLastNameField(data.getProperty("LastName"));

					if (i < count - 1) {
						CommonInputClasses otherName = new CommonInputClasses(
								driver);
						otherName.addAnother();
					}

				}

			}

			if (otherNames.equalsIgnoreCase("No")) {
				haveUsedOtherNames.no();
			}

			saveScreenShot("n600", "SQ1_2"); clickContinueInSQ();
		}
		return this;
	}

	

}
