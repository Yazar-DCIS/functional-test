package com.formsdirectinc.functionaltests.apps.i131.pages;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_6 extends WizardPage {
	private DateTag dateOfDep;

	public SQ1_6(WebDriver driver) {
		super(driver);
	}

	public SQ1_6 dateOfDeparture(Properties data,
			String dateOfDepMoreThan30DaysFrmCurrentDate) {
		if (!dateOfDepMoreThan30DaysFrmCurrentDate.equalsIgnoreCase("NA")) {
			
			if (dateOfDepMoreThan30DaysFrmCurrentDate
					.equalsIgnoreCase("MoreThan30Days")) {
				dateOfDep = new DateTag(driver, "applicant.departingDate");
				dateOfDep
						.selectDateAsSingle(DateGreaterThan30DaysFromTodayDate());
			}

			else if (dateOfDepMoreThan30DaysFrmCurrentDate
					.equalsIgnoreCase("LessThan30Days")) {
				dateOfDep = new DateTag(driver, "applicant.departingDate");
				dateOfDep.selectDateAsSingle(DateLessThan30daysFromTodayDate());
			}
			saveScreenShot("i131", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

	public String DateGreaterThan30DaysFromTodayDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, +20);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());
		System.out.println(Date);
		return Date;

	}

	public String DateLessThan30daysFromTodayDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, +50);
		DateFormat fmt = new SimpleDateFormat("MM-d-yyyy");
		String Date = fmt.format(calendar.getTime());
		System.out.println(Date);
		return Date;

	}
}
