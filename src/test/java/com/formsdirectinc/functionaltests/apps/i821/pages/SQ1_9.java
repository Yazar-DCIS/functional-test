package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_9 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_9 extends WizardPage {

	public SQ1_9(WebDriver driver) {
		super(driver);
	}

	
	private YesNo tripsOutsideUS;
	private DateTag dateLeftAndReturned;
	private AdditionalInfoFields reasonforthetrip;



	public SQ1_9 tripOutSide_US(String travelHistory, Properties data) {
		if (!travelHistory.equalsIgnoreCase("NA")) {

			tripsOutsideUS = new YesNo(driver, "travelHistory.tripsOutsideUS");

			if (travelHistory.equalsIgnoreCase("Yes")) {
				tripsOutsideUS.yes();
				addAnotherTrip(2, data);

			}
			else if (travelHistory.equalsIgnoreCase("No")) {
				tripsOutsideUS.no();
			}
			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

	public SQ1_9 addAnotherTrip(int count, Properties data) {

		for (int i = 0; i < count; i++) {

			dateLeftAndReturned = new DateTag(driver, "travelHistory.travel["
					+ i + "].dateLeftAndReturned.fromDate");
			dateLeftAndReturned
					.selectDateAsSingle(data.getProperty("fromDate"));

			dateLeftAndReturned = new DateTag(driver, "travelHistory.travel["
					+ i + "].dateLeftAndReturned.toDate");
			dateLeftAndReturned.selectDateAsSingle(data.getProperty("toDate"));

			
			reasonforthetrip = new AdditionalInfoFields(driver,
					"applicationData-travelHistory.travel[" + i
							+ "].countriesVisitedDuringTrip");
			reasonforthetrip.normalText(data.getProperty("ExpalinThis"));

			reasonforthetrip = new AdditionalInfoFields(driver,
					"applicationData-travelHistory.travel[" + i
							+ "].reasonForTrip");
			reasonforthetrip.normalText(data.getProperty("ExpalinThis"));

			if (i < count - 1) {
				CommonInputClasses others = new CommonInputClasses(driver);
				others.addAnother();
			}
		}
		return this;

	}
}
