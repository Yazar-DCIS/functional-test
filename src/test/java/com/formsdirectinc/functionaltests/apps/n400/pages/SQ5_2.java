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
 * Page model for SQ5_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ5_2 extends WizardPage {

	private YesNo tripsOutsideUS;
	private DateTag tripsStartDate, tripsEndDate;
	private AdditionalInfoFields countryVisited;

	public SQ5_2(WebDriver driver) {
		super(driver);

	}

	public SQ5_2 tripsTakenOutsideUS_InDetail(Properties copies,
			Properties data, int count, String notSureDatesOfTravel) {

		if ((count != -1) && (!notSureDatesOfTravel.equals("NA"))) {

			if (count > 0) {
				for (int i = 0; i < count; i++) {
					tripsTakenOutsideUS(copies, data, i, notSureDatesOfTravel);
					if (i < count - 1) {

						CommonInputClasses others = new CommonInputClasses(
								driver);
						others.addAnotherTrip();
					}
				}

			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ5_2");
			 clickContinueInSQ();
		}
		return this;

	}

	public SQ5_2 tripsTakenOutsideUS(Properties copies, Properties data,
			int count, String notSureDatesOfTravel) {

		tripsStartDate = new DateTag(driver, "travelHistory.travel[" + count
				+ "].dateLeftAndReturned.fromDate");
		tripsStartDate.selectDate(data.getProperty("fromDate"+count));

		tripsEndDate = new DateTag(driver, "travelHistory.travel[" + count
				+ "].dateLeftAndReturned.toDate");
		tripsEndDate.selectDate(data.getProperty("toDate"+count));

		tripsOutsideUS = new YesNo(driver, "travelHistory.travel[" + count
				+ "].notSureDatesOfTravel");

		if (notSureDatesOfTravel.equalsIgnoreCase("Yes")) {
			tripsOutsideUS.yes();
		}
		else if (notSureDatesOfTravel.equalsIgnoreCase("No")) {
			tripsOutsideUS.no();
		}

		countryVisited = new AdditionalInfoFields(driver,
				"applicationData-travelHistory.travel[" + count
						+ "].countriesVisitedDuringTrip");
		countryVisited.normalText(data.getProperty("tripCountry"+count));

		return this;
	}

}
