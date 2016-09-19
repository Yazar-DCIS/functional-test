package com.formsdirectinc.functionaltests.apps.i821d.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ3_2 extends WizardPage {
	private YesNo haveI94;
	private DateTag stayExpiry;
	private AdditionalInfoFields i94_1;
	private SelectElement i94_2;

	public SQ3_2(WebDriver driver) {
		super(driver);

	}

	public SQ3_2 applicantDontHaveI94(String arrival_departure, Properties data)
			throws Exception {

		if (!arrival_departure.equalsIgnoreCase("skip")) {

			if (arrival_departure.equalsIgnoreCase("Yes")) {
				haveI94 = new YesNo(driver, "initialApplication.havingI94Num");
				haveI94.yes();

				i94_1 = new AdditionalInfoFields(driver,
						"applicationData-initialApplication.i94Number");
				i94_1.isStatusOther(data.getProperty("i94_1"));

				i94_2 = new SelectElement(driver,
						"initialApplication.i94Number.adn2");
				i94_2.sendValuesUsingElementName(data.getProperty("i94_2"));

				stayExpiry = new DateTag(driver,
						"initialApplication.dateAuthourized");
				stayExpiry.selectDateAsSingle(data.getProperty("DateEntered"));
			}
			else if (arrival_departure.equalsIgnoreCase("No")) {
				haveI94 = new YesNo(driver, "initialApplication.havingI94Num");
				haveI94.no();
			}

		}

		return this;
	}

}
