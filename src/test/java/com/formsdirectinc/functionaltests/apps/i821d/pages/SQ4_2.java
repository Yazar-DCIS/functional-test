package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ4_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ4_2 extends WizardPage {

	private YesNo haveDoneService;
	private AdditionalInfoFields militaryBranch, typeOfDischarge;
	private DateTag serviceDate, dischargeDate;
	private Sites site;

	public SQ4_2(WebDriver driver) {
		super(driver);

	}

	public SQ4_2 applicantNotServedMilitary(String militaryService,
			Properties data) throws Exception {
		site = Sites.valueOf(System.getProperty("site.name"));
		if (!militaryService.equalsIgnoreCase("Skip")) {
			if (militaryService.equalsIgnoreCase("Yes")) {
				haveDoneService = new YesNo(driver,
						"initialApplication.militaryDetails.coastGuardMember");
				haveDoneService.yes();

				if ((site == Sites.AIC) || (site == Sites.DUS)
						|| (site == Sites.USC)) {
					militaryBranch = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.militaryDetails.militaryBranch");
					militaryBranch.normalText(data.getProperty("State"));
				}
				else if ((site == Sites.FR) || (site == Sites.ID)
						|| (site == Sites.AIC)) {
					militaryBranch = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.militaryDetails.militaryBranch");
					militaryBranch.selectDDM("Army");
				}

				serviceDate = new DateTag(driver,
						"initialApplication.militaryDetails.serviceDate.fromDate");
				serviceDate.selectDate(data.getProperty("DOB"));

				dischargeDate = new DateTag(driver,
						"initialApplication.militaryDetails.serviceDate.toDate");
				dischargeDate.selectDate(data.getProperty("DOB"));

				if ((site == Sites.AIC) || (site == Sites.DUS)
						|| (site == Sites.USC)) {
					typeOfDischarge = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.militaryDetails.dischargeType");
					typeOfDischarge.normalText(data.getProperty("State"));
				}
				else if ((site == Sites.FR) || (site == Sites.ID)
						|| (site == Sites.AIC)) {
					typeOfDischarge = new AdditionalInfoFields(driver,

					"applicationData-initialApplication.militaryDetails.dischargeType");
					typeOfDischarge.selectDDM("Honorable");
				}

			}

			else if (militaryService.equalsIgnoreCase("No")) {
				haveDoneService = new YesNo(driver,
						"initialApplication.militaryDetails.coastGuardMember");
				haveDoneService.no();
			}

		}
		return this;

	}

}
