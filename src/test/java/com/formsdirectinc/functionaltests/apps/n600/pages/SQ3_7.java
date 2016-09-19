package com.formsdirectinc.functionaltests.apps.n600.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_7 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_7 extends WizardPage {

	protected YesNo absentFromUS;
	protected Address placeVisited;
	protected DateTag absenceDateFrom, absenceDateTo;

	
	public SQ3_7(WebDriver driver) {
		super(driver);

	}

	public SQ3_7 otherTravelDetails(Properties data, String traveledOut,
			int count) {

		if (!traveledOut.equalsIgnoreCase("NA") && count != -1) {
			if (count > 0) {
				for (int i = 0; i < count; i++) {
					travelDetails(data, traveledOut, i);
					if ((i < count - 1)
							&& (traveledOut.equalsIgnoreCase("Yes"))) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherTrip();
					}
				}
			}
			saveScreenShot("n600", "SQ3_7"); clickContinueInSQ();
		}

		return this;

	}

	public SQ3_7 travelDetails(Properties data, String traveledOut, int count) {

		absentFromUS = new YesNo(driver,
				"applicant.additionalInfo.absentFirstArrived");

		if (traveledOut.equalsIgnoreCase("Yes")) {
			absentFromUS.yes();

			absenceDateFrom = new DateTag(
					driver,

					"applicant.additionalInfo.absentFromUSSinceFirstArrivedHistory["
							+ count
							+ "].absentFromUSSinceFirstArrived.dateLeftAndReturned.fromDate");
			absenceDateFrom.selectDate(data.getProperty("fromDate" + count));

			absenceDateTo = new DateTag(
					driver,

					"applicant.additionalInfo.absentFromUSSinceFirstArrivedHistory["
							+ count
							+ "].absentFromUSSinceFirstArrived.dateLeftAndReturned.toDate");
			absenceDateTo.selectDate(data.getProperty("toDate" + count));

			placeVisited = new Address(
					driver,

					"applicationData-applicant.additionalInfo.absentFromUSSinceFirstArrivedHistory["
							+ count
							+ "].absentFromUSSinceFirstArrived.placeOfEntry");
			placeVisited.setCity(data.getProperty("tripCity"));
			placeVisited.setState(data.getProperty("tripState"));

		}

		if (traveledOut.equalsIgnoreCase("No")) {
			absentFromUS.no();
		}

		return this;
	}

}
