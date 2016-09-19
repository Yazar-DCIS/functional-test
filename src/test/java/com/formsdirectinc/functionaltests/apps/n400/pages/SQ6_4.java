package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_4 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_4 extends WizardPage {

	private YesNo otherAffiliations;
	private AdditionalInfoFields groupDetails;
	private DateTag groupBeginDate, groupEndDate;

	public SQ6_4(WebDriver driver) {
		super(driver);

	}

	public SQ6_4 otherAffiliationsDetails(Properties copies, Properties data,
			String answers, int count) {

		if (!answers.equalsIgnoreCase("NA") && count != -1) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					
					otherAffiliations(copies, i, data, answers);

					if ((i < count - 1) && (answers.equalsIgnoreCase("Yes"))) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherGroup();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_4");
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ6_4 otherAffiliations(Properties copies, int count,
			Properties data, String answers) {

		otherAffiliations = new YesNo(driver, "formSpecific.memberOfGroup");

		if (answers.equalsIgnoreCase("No")) {
			otherAffiliations.no();
		}

		if (answers.equalsIgnoreCase("Yes")) {

			otherAffiliations.yes();

			groupDetails = new AdditionalInfoFields(driver,
					"applicationData-formSpecific.nameOfGroup[" + count
							+ "].groupNameList");
			groupDetails.normalText(data.getProperty("groupName"));

			groupDetails = new AdditionalInfoFields(driver,
					"applicationData-formSpecific.nameOfGroup[" + count
							+ "].purposeOfGroup");
			groupDetails.normalText(data.getProperty("groupPurpose"));

			otherAffiliations = new YesNo(driver, "formSpecific.nameOfGroup["
					+ count + "].member");
			if (answers.equalsIgnoreCase("No")) {
				otherAffiliations.no();

				groupBeginDate = new DateTag(driver,
						"formSpecific.nameOfGroup[" + count
								+ "].dateRange.fromDate");
				groupBeginDate.selectDate(data.getProperty("fromDate0"));

				groupEndDate = new DateTag(driver, "formSpecific.nameOfGroup["
						+ count + "].dateRange.toDate");
				groupEndDate.selectDate(data.getProperty("toDate0"));
			}

			if (answers.equalsIgnoreCase("Yes")) {
				otherAffiliations.yes();
				groupBeginDate = new DateTag(driver,
						"formSpecific.nameOfGroup[" + count
								+ "].dateRange.fromDate");
				groupBeginDate.selectDate(data.getProperty("fromDate0"));
			}

		}

		return this;
	}

}
