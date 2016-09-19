package com.formsdirectinc.functionaltests.apps.i129f.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.OtherExplain;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {
	private YesNo personalMeeting, metThruMarriageBroker;
	private OtherExplain meetings;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 personalMeeting(Properties data,
			String metFianceInPersonInLast2Years,
			String metFianceThruMarriageBroker) throws Exception {
		
		personalMeeting = new YesNo(driver,
				"applicant.relationshipToFiancee.metInPerson");
		if (metFianceInPersonInLast2Years.equalsIgnoreCase("Yes")) {

			personalMeeting.yes();

			meetings = new OtherExplain(driver, "applicationData",
					"applicant.relationshipToFiancee");
			meetings.setMeetingDescription(data.getProperty("Reason"));
		}
		else if (metFianceInPersonInLast2Years.equalsIgnoreCase("No")) {
			personalMeeting.no();

			meetings = new OtherExplain(driver, "applicationData",
					"applicant.relationshipToFiancee");
			meetings.setMannerRelation(data.getProperty("Reason"));
		}

		metThruMarriageBroker = new YesNo(driver,
				"applicant.relationshipToFiancee.metThroughMarriageBroker");
		if (metFianceThruMarriageBroker.equalsIgnoreCase("Yes")) {
			metThruMarriageBroker.yes();

			meetings = new OtherExplain(driver, "applicationData",
					"applicant.relationshipToFiancee");
			meetings.setBrokerAddress(data.getProperty("StreetName"));
		}
		else if (metFianceThruMarriageBroker.equalsIgnoreCase("No")) {
			metThruMarriageBroker.no();
		}

		saveScreenShot("i129f", "SQ3_2"); clickContinueInSQ();
		return this;
	}
}