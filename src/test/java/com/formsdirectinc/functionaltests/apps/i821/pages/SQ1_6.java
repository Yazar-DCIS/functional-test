package com.formsdirectinc.functionaltests.apps.i821.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ1_6 extends WizardPage {

	public SQ1_6(WebDriver driver) {
		super(driver);
	}

	
	private DateTag firstEnterUS;
	private YesNo continuousResidingUS;
	private DateTag physicalPresentUS;
	private DateTag residentUS;

	public SQ1_6 presencein_US(String usstatus, Date physicalpresence,
			Date continuousresidence, Properties data) {

		if (!usstatus.equalsIgnoreCase("NA")) {
			DateFormat df = new SimpleDateFormat("MM-dd-yyyy");
			String date = df.format(physicalpresence);
			String date2 = df.format(continuousresidence);

			firstEnterUS = new DateTag(driver,
					"eligibilityDetails.firstEnterUS");

			firstEnterUS.selectDateAsSingle(date2);

			continuousResidingUS = new YesNo(driver,
					"eligibilityDetails.continuousResidingUS");
			if (usstatus.equalsIgnoreCase("Yes")) {
				continuousResidingUS.yes();

				physicalPresentUS = new DateTag(driver,
						"eligibilityDetails.physicalPresentUS");
				physicalPresentUS.selectDateAsSingle(date);

			} else if (usstatus.equalsIgnoreCase("No")) {
				continuousResidingUS.no();

				residentUS = new DateTag(driver,
						"eligibilityDetails.residentUS");
				residentUS.selectDateAsSingle(date2);

				physicalPresentUS = new DateTag(driver,
						"eligibilityDetails.physicalPresentUS");
				physicalPresentUS.selectDateAsSingle(date);

			}

			saveScreenShot("i821", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;

	}

	

}
