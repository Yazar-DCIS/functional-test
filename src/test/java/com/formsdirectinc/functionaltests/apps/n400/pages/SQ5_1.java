package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ5_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ5_1 extends WizardPage {

	private YesNo tripsOutsideUS, tripTravelled;

	public SQ5_1(WebDriver driver) {
		super(driver);

	}

	public SQ5_1 tripsTakenOutsideUS(Properties copies, String tripTaken,
			String tripMoreThanADay) {

		if (!tripTaken.equals("NA") && !tripMoreThanADay.equals("NA")) {

			tripsOutsideUS = new YesNo(driver, "travelHistory.tripsOutsideUS");
			if (tripTaken.equalsIgnoreCase("Yes")) {
				tripsOutsideUS.yes();

				tripTravelled = new YesNo(driver,
						"travelHistory.tripsOutsideUSHours");
				if (tripMoreThanADay.equalsIgnoreCase("Yes")) {
					tripTravelled.yes();
				}
				else if (tripMoreThanADay.equalsIgnoreCase("No")) {
					tripTravelled.no();
				}

			}
			else if (tripTaken.equalsIgnoreCase("No")) {
				tripsOutsideUS.no();
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ5_1");
			 clickContinueInSQ();
		}
		return this;
	}

}
