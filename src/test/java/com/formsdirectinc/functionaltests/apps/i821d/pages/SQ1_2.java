package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_2 extends WizardPage {

	private YesNo trips;

	public SQ1_2(WebDriver driver) {
		super(driver);
	}

	public SQ1_2 tripsOutsideUS(String travelHistory, int count, Properties data)
			throws Exception {

		if (!travelHistory.equalsIgnoreCase("Skip")) {

			trips = new YesNo(driver,
					"initialApplication.travelHistory.tripsOutsideUSsinceAug");

			if (travelHistory.equalsIgnoreCase("Yes")) {
				trips.yes();
			}

			else if (travelHistory.equalsIgnoreCase("No")) {

				trips.no();

				trips = new YesNo(driver,"initialApplication.travelHistory.tripsOutsideUS");
				if (travelHistory.equalsIgnoreCase("No")) {

					trips.no();
				}

				else if (travelHistory.equalsIgnoreCase("Yes")) {

					trips.yes();
					AddAnotherField reasonForTrip = new AddAnotherField(driver);
					reasonForTrip.addAnotherTrip(count, data,"initialApplication");
				}

			}

		}
		return this;
	}

}
