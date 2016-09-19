package com.formsdirectinc.functionaltests.tags;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Date: Selenium page model for Date Tag
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/22/15 1:28 PM
 * @author Orina
 * Revision: $Rev$
 */
public class DateTag extends BaseTag {

	protected String monthExpression = "%s.month";
	protected String dayExpression = "%s.day";
	protected String yearExpression = "%s.year";

	protected String fromExpression = "%s.fromDate";
	protected String toExpression = "%s.toDate";

	protected String month = ".month";
	protected String day = ".day";
	protected String year = ".year";

	WebElement fromDDMField;
	WebElement toDDMField;

	WebElement monthDDM;
	WebElement dayDDM;
	WebElement yearDDM;

	private SimpleDateFormat monthFormat = new SimpleDateFormat("MMM");
	private SimpleDateFormat dayFormat = new SimpleDateFormat("dd");
	private SimpleDateFormat dayFormatSingle = new SimpleDateFormat("d");
	private SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy");
	private SimpleDateFormat mmddyyyyFormat = new SimpleDateFormat("MM-dd-yyyy");
	private SimpleDateFormat mmdyyyyFormat = new SimpleDateFormat("MM-d-yyyy");

	public DateTag(WebDriver driver, String propertyValue) {
		super(driver, propertyValue);

	}

	public DateTag selectMonth(String threeLetterMonth) {
		monthDDM = driver.findElement(By.name(String.format(monthExpression,
				property)));
		Select monthSelect = new Select(monthDDM);
		monthSelect.selectByValue(threeLetterMonth);
		return this;
	}

	public DateTag selectDay(String day) {
		dayDDM = driver.findElement(By.name(String.format(dayExpression,
				property)));
		Select daySelect = new Select(dayDDM);
		daySelect.selectByValue(day);
		return this;
	}

	public DateTag selectYear(String fourDigitYear) {
		yearDDM = driver.findElement(By.name(String.format(yearExpression,
				property)));
		/*
		 * Select yearSelect = new Select(yearDDM);
		 * yearSelect.selectByValue(fourDigitYear);
		 */
		yearDDM.sendKeys(fourDigitYear);

		return this;
	}

	// for date holding double value call this method
	public DateTag selectDate(String mmddyyyyDate) {
		java.util.Date date;

		try {
			date = mmddyyyyFormat.parse(mmddyyyyDate);
		} catch (java.text.ParseException pe) {
			throw new RuntimeException(pe);
		}

		selectMonth(monthFormat.format(date));
		selectDay(dayFormat.format(date));
		selectYear(yearFormat.format(date));

		return this;
	}

	// for date holding single value call this method
	public DateTag selectDateAsSingle(String mmdyyyyDate) {
		java.util.Date date;

		try {
			date = mmdyyyyFormat.parse(mmdyyyyDate);
		} catch (java.text.ParseException pe) {
			throw new RuntimeException(pe);
		}

		selectMonth(monthFormat.format(date));
		selectDay(dayFormatSingle.format(date));
		selectYear(yearFormat.format(date));

		return this;
	}

	public DateTag setStartDay(String fromDate) {
		fromDDMField = driver.findElement(By.name(String.format(fromExpression
				+ day, property)));
		Select daySelect = new Select(fromDDMField);
		daySelect.selectByValue(fromDate);
		return this;
	}

	public DateTag setEndDay(String toDate) {
		toDDMField = driver.findElement(By.name(String.format(toExpression
				+ day, property)));
		Select daySelect = new Select(toDDMField);
		daySelect.selectByValue(toDate);
		return this;
	}

	public DateTag setStartMonth(String fromMonth) {
		fromDDMField = driver.findElement(By.name(String.format(fromExpression
				+ month, property)));
		Select monthSelect = new Select(fromDDMField);
		monthSelect.selectByValue(fromMonth);
		return this;
	}

	public DateTag setEndMonth(String toMonth) {
		toDDMField = driver.findElement(By.name(String.format(toExpression
				+ month, property)));
		Select monthSelect = new Select(toDDMField);
		monthSelect.selectByValue(toMonth);
		return this;
	}

	public DateTag setStartYear(String fromYear) {
		fromDDMField = driver.findElement(By.name(String.format(fromExpression
				+ year, property)));
		Select yearSelect = new Select(fromDDMField);
		yearSelect.selectByValue(fromYear);
		return this;
	}

	public DateTag setEndYear(String toYear) {
		toDDMField = driver.findElement(By.name(String.format(toExpression
				+ year, property)));
		Select yearSelect = new Select(toDDMField);
		yearSelect.selectByValue(toYear);
		return this;
	}
	
	public void calculateDate(String date,int monthCalculation,int dayCalculation,int yearCalculation)
	{
		DateFormat year = new SimpleDateFormat("YYYY");
		DateFormat day = new SimpleDateFormat("d");
		DateFormat month = new SimpleDateFormat("MMM");
		Calendar dateLabel = Calendar.getInstance();
		
		if(date.equalsIgnoreCase("future"))
		{
			dateLabel.add(Calendar.YEAR, +yearCalculation);
			dateLabel.add(Calendar.MONTH, +monthCalculation);
			dateLabel.add(Calendar.DATE, +dayCalculation);
			
			System.out.println("Month:::::"+month.format(dateLabel.getTime()));
			System.out.println("Day::::::"+day.format(dateLabel.getTime()));
			System.out.println("Year::::::"+year.format(dateLabel.getTime()));
			
			selectYear(year.format(dateLabel.getTime()));
			selectMonth(month.format(dateLabel.getTime()));
			selectDay(day.format(dateLabel.getTime()));
		}
		else if(date.equalsIgnoreCase("past"))
		{
			dateLabel.add(Calendar.YEAR, -yearCalculation);
			dateLabel.add(Calendar.MONTH, -monthCalculation);
			dateLabel.add(Calendar.DATE, -dayCalculation);
			
			System.out.println("Month:::::"+month.format(dateLabel.getTime()));
			System.out.println("Day::::::"+day.format(dateLabel.getTime()));
			System.out.println("Year::::::"+year.format(dateLabel.getTime()));
			
			selectYear(year.format(dateLabel.getTime()));
			selectMonth(month.format(dateLabel.getTime()));
			selectDay(day.format(dateLabel.getTime()));
		}
		
	}
}
