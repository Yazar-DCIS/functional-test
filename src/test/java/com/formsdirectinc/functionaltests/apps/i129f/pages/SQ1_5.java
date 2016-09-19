package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_5 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_5 extends WizardPage {

	private MultiRadioOptions selectOption;
	private YesNo hadNaturalizationCert;
	private AdditionalInfoFields certificateNumber, placeOfIssuance;
	private DateTag doi;

	public SQ1_5(WebDriver driver) {
		super(driver);
	}

	public SQ1_5 applicantUSCISNotfication(Properties data,
			String citizenShipThrough, String obtainedCertificateNumber) {
		selectOption = new MultiRadioOptions(driver,
				"applicationData-applicant.modeOfCitizenship");
		if (citizenShipThrough.equalsIgnoreCase("birth")) {
			selectOption.selectOption(1);
		}
		else if (citizenShipThrough.equalsIgnoreCase("naturalization")) {
			selectOption.selectOption(2);

			hadNaturalizationCert = new YesNo(driver, "applicant.hadNaturalizationCert");

			if (obtainedCertificateNumber.equalsIgnoreCase("Yes")) {
				hadNaturalizationCert.yes();

				certificateNumber = new AdditionalInfoFields(driver,
						"applicationData-applicant.naturalizationCertNum");
				certificateNumber.normalText(data.getProperty("ARN"));

				doi = new DateTag(driver, "applicant.naturalizationCertDate");
				doi.selectDateAsSingle(data.getProperty("DateIssued"));

				placeOfIssuance = new AdditionalInfoFields(driver,

				"applicationData-applicant.naturalizationCertPlace");
				placeOfIssuance.normalText(data.getProperty("Country"));

			}
			else if (obtainedCertificateNumber.equalsIgnoreCase("No")) {
				hadNaturalizationCert.no();
			}
		}
		else if (citizenShipThrough.equalsIgnoreCase("parents")) {
			selectOption.selectOption(3);

			hadNaturalizationCert = new YesNo(driver, "applicant.hadCitizenshipCert");

			if (obtainedCertificateNumber.equalsIgnoreCase("Yes")) {
				hadNaturalizationCert.yes();

				certificateNumber = new AdditionalInfoFields(driver,

				"applicationData-applicant.citizenshipCertNum");
				certificateNumber.normalText(data.getProperty("ARN"));

				doi = new DateTag(driver, "applicant.citizenshipCertDate");
				doi.selectDateAsSingle(data.getProperty("DateIssued"));

				placeOfIssuance = new AdditionalInfoFields(driver,

				"applicationData-applicant.citizenshipCertPlace");
				placeOfIssuance.normalText(data.getProperty("Country"));

			}
			else if (obtainedCertificateNumber.equalsIgnoreCase("No")) {
				hadNaturalizationCert.no();
			}
		}
		saveScreenShot("i129f", "SQ1_5"); clickContinueInSQ();
		return this;
	}

}
