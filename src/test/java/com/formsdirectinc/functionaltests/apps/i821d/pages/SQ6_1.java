package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ6_1 extends WizardPage {
	private YesNo proceedings;
	private MultiRadioOptions status;
	private AdditionalInfoFields location, specifyStatus;
	private DateTag dateOfProcedings;

	public SQ6_1(WebDriver driver) {
		super(driver);
	}

	public SQ6_1 immigrationproceedings(String immigrationProcedings,
			String statusOfproceedings, Properties data) throws Exception {

		if (!immigrationProcedings.equalsIgnoreCase("Skip")) {

			proceedings = new YesNo(driver,
					"applicant.beenImmigrationProceedings");
			if (immigrationProcedings.equalsIgnoreCase("Yes")) {
					proceedings.yes();
			
			status = new MultiRadioOptions(driver,
							"applicationData-applicant.typeOfProceedings");
			if (statusOfproceedings.equalsIgnoreCase("Active")) {
					status.selectOption(1);
			}
			else if (statusOfproceedings.equalsIgnoreCase("AdministrativelyClosed")) {
				status.selectOption(2);
			}
			else if (statusOfproceedings.equalsIgnoreCase("Terminated")) {
				status.selectOption(3);
			}
			else if (statusOfproceedings.equalsIgnoreCase("FinalOrder")) {
				status.selectOption(4);
			}
			 	
			else if (statusOfproceedings.equalsIgnoreCase("Other")) {
				
				status.selectOption(5);

				specifyStatus = new AdditionalInfoFields(driver,

				"applicationData-applicant.proceedingsSpecify");
				specifyStatus.normalText(data.getProperty("State"));
			}

			location = new AdditionalInfoFields(driver,
					"applicationData-applicant.proceedingsLocation");
			location.normalText(data.getProperty("State"));

			dateOfProcedings = new DateTag(driver,
					"applicant.dateOfProceedings");
			dateOfProcedings.selectDate(data.getProperty("DOB"));
			}
			else if (immigrationProcedings.equalsIgnoreCase("No"))

			{
				proceedings.no();
			}

		}
		return this;
	}

}
