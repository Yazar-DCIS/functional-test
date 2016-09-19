package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_8_1 extends WizardPage {

	public DateTag arrivedUS;

	public EQ1_8_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_8_1 arrrivedUsOn(String arrivedUsOn) throws Exception {
		if (!arrivedUsOn.equalsIgnoreCase("NA")) {
			
			arrivedUS = new DateTag(driver, "quiz.visaArrivalDate");
			arrivedUS.selectDateAsSingle(currentDate());

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

	public String currentDate()

	{
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -25);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());

		return Date;

	}
}
