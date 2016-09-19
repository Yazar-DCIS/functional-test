package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_3_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class EQ1_3_2 extends WizardPage {

	public DateTag cardExpires;

	public EQ1_3_2(WebDriver driver) {
		super(driver);
	}

	public EQ1_3_2 reasonForI765Application(String cardExpiresOn)
			throws Exception {
		if (!cardExpiresOn.equalsIgnoreCase("NA")) {
			
			cardExpires = new DateTag(driver, "quiz.eadCardExpireDate");
			cardExpires.selectDateAsSingle(currentDate());

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

	public String currentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, +25);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());

		return Date;

	}

}
