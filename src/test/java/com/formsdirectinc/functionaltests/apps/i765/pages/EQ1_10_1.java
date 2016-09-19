package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for EQ1_10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ1_10_1 extends WizardPage {

	public DateTag noticeDate;

	public EQ1_10_1(WebDriver driver) {
		super(driver);
	}

	public EQ1_10_1 receivedNoticeDateForI589(String datearrivedUsOn)
			throws Exception {
		if (!datearrivedUsOn.equalsIgnoreCase("NA")) {
			
			noticeDate = new DateTag(driver, "quiz.asylumReceiptDate");
			noticeDate.selectDateAsSingle(currentDate());

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

	public String currentDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DAY_OF_YEAR, -155);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String date = fmt.format(calendar.getTime());

		return date;
	}

}
