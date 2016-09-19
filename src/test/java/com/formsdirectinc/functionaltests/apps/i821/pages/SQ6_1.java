package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ6_1 extends WizardPage {

	public SQ6_1(WebDriver driver) {
		super(driver);
	}

	
	
	private MultiRadioOptions typeOfProceedings;
	private Address proceedingsLocation;
	private DateTag dateOfProceedings;

	public SQ6_1 immigration_Proceedings(String immigration, Properties data) {
		if (!immigration.equalsIgnoreCase("NA")) {
			
			
			YesNo beenImmigrationProceedings=new YesNo(driver, "applicant.beenImmigrationProceedings");
			beenImmigrationProceedings.setYesOrNo(immigration);
			
			if(immigration.equalsIgnoreCase("yes"))
			{
				typeOfProceedings = new MultiRadioOptions(driver,"applicationData-applicant.typeOfProceedings");
				typeOfProceedings.selectOption(1);

				proceedingsLocation = new Address(driver,"applicationData-applicant.proceedingsLocation");
				proceedingsLocation.setCity(data.getProperty("tripCity"));
				proceedingsLocation.setState(data.getProperty("tripState0"));

				dateOfProceedings = new DateTag(driver,"applicant.dateOfProceedings.fromDate");
				dateOfProceedings.selectDateAsSingle(data.getProperty("fromDate3"));

				dateOfProceedings = new DateTag(driver,	"applicant.dateOfProceedings.toDate");
				dateOfProceedings.selectDateAsSingle(data.getProperty("toDate3"));
			}
			
			CrimeDetails immigrationRelated=new CrimeDetails(driver);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.beenDeported", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.voluntaryDepart", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.failedDeportability", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.unlawfullReenter", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.orderReinstated", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.fraudMisRepresent", immigration);
			immigrationRelated.informationRelatedToCrime("i821", "applicant.accompanyingDeportedAlien", immigration);
			
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

}
