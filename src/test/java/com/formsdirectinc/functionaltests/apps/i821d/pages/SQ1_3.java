package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AddAnotherField;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_3 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_3 extends WizardPage {

	private YesNo tripsOutsideUS;

	public SQ1_3(WebDriver driver) {
		super(driver);
	}

	public SQ1_3 tripOutside(String tripsoutsideUS, int count, Properties data)
			throws Exception {
		if (!tripsoutsideUS.equalsIgnoreCase("Skip")) {
			String date = data.getProperty("fromDateDaca");

			tripsOutsideUS = new YesNo(driver,
					"renewalApplication.travelHistory.tripsOutsideUS");

			if (tripsoutsideUS.equalsIgnoreCase("Yes")) {
				tripsOutsideUS.yes();

				AddAnotherField reasonForTrip = new AddAnotherField(driver);
				reasonForTrip.addAnotherTrip(count, data, "renewalApplication");

				if (date.equalsIgnoreCase("8-15-2012")) {
					YesNo tripsOnOrAfterAug = new YesNo(driver,
							"renewalApplication.travelHistory.tripsOnOrAfterAug");
					tripsOnOrAfterAug.setYesOrNo(tripsoutsideUS);
					
				}

			}
			if (tripsoutsideUS.equalsIgnoreCase("No")) {
				tripsOutsideUS.no();
			}

		}
		return this;
	}

}
