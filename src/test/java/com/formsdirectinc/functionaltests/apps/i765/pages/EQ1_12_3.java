package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_12_3 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_12_3 extends WizardPage {

	public DateTag noticeDate;

	public EQ1_12_3(WebDriver driver) {
		super(driver);
	}

	public EQ1_12_3 receivedNoticeDateForI589(String date) throws Exception {
		if (!date.equalsIgnoreCase("NA")) {
			
			noticeDate = new DateTag(driver, "quiz.eadCardExpireDateOne");
			noticeDate.selectDateAsSingle(currentDate());
			// Copy

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

	public String currentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, +85);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());

		return Date;

	}
}
