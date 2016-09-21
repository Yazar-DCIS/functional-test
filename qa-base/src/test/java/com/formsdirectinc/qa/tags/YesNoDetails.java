package com.formsdirectinc.qa.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.qa.utils.PropertyResource;

/**
 * yesnoElementDetails : yesnoElementDetails
 * 
 * @author Orina <br>
 *         Date: 3/14/16
 * 
 *         Revision: $Rev$
 */
public class YesNoDetails extends BaseTag {

	protected String information = "%s";
	protected String yesnoElement = "%s.yesno";
	protected String yesnoElementExplaination = "applicationData-%s";
	protected String yesnoElementExplain = "applicationData-%s.explain";
	protected String periodOfYears = "%s.periodOfYears";
	protected String periodOfMonths = "%s.periodOfMonths";
	protected String periodOfDays = "%s.periodOfDays";

	// Supporting Evidence
	protected String yesnoElementWithValue = "%s.yesno.value";
	protected String yesnoElementValue = "%s.value";

	public YesNoDetails(WebDriver driver) {
		super(driver);
	}

	public YesNoDetails(WebDriver driver, String property) {
		super(driver, property);
	}

	public YesNoDetails informationRelatedWithExplainationFor_Yes(
			String appname, String elementProperty, String answer) {

		PropertyResource propertyFile = new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(yesnoElement, elementProperty));

		answerYesOrNo.setYesOrNo(answer);
		if (answer.equalsIgnoreCase("Yes")) {
			SelectElement explainWhy = new SelectElement(driver, String.format(
					yesnoElementExplain, elementProperty));
			explainWhy.sendValuesUsingElementID(appName
					.getProperty(elementProperty));

		}

		return this;
	}

	public YesNoDetails informationRelatedWithExplainationValue_Yes(
			String appname, String elementProperty, String answer) {

		PropertyResource propertyFile = new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(yesnoElementWithValue, elementProperty));

		answerYesOrNo.setYesOrNo(answer);
		if (answer.equalsIgnoreCase("Yes")) {
			SelectElement explainWhy = new SelectElement(driver, String.format(
					yesnoElementExplain, elementProperty));
			explainWhy.sendValuesUsingElementID(appName
					.getProperty(elementProperty));
		}

		return this;
	}

	public YesNoDetails informationRelatedWithExplainationFor_No(
			String appname, String elementProperty, String answer) {

		PropertyResource propertyFile = new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(yesnoElement, elementProperty));

		answerYesOrNo.setYesOrNo(answer);
		if (answer.equalsIgnoreCase("No")) {
			SelectElement explainWhy = new SelectElement(driver, String.format(
					yesnoElementExplain, elementProperty));
			explainWhy.sendValuesUsingElementID(appName
					.getProperty(elementProperty));
		}

		return this;
	}

	public YesNoDetails informationRelatedWithExplainationValue_No(
			String appname, String elementProperty, String answer) {

		PropertyResource propertyFile = new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(yesnoElementWithValue, elementProperty));

		answerYesOrNo.setYesOrNo(answer);
		if (answer.equalsIgnoreCase("No")) {
			SelectElement explainWhy = new SelectElement(driver, String.format(
					yesnoElementExplain, elementProperty));
			explainWhy.sendValuesUsingElementID(appName
					.getProperty(elementProperty));
		}

		return this;
	}

	public YesNoDetails informationRelatedWithoutExplaination(
			String elementProperty, String answer) {

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(information, elementProperty));

		answerYesOrNo.setYesOrNo(answer);

		return this;
	}

	public YesNoDetails informationRelatedWithoutExplainationValue(
			String elementProperty, String answer) {

		com.formsdirectinc.qa.tags.qastyles.YesNo answerYesOrNo = new com.formsdirectinc.qa.tags.qastyles.YesNo(
				driver, String.format(yesnoElementValue, elementProperty));

		answerYesOrNo.setYesOrNo(answer);

		return this;
	}

	public YesNoDetails yearsSpentInPrison(String years) {
		SelectElement yearsSpentInPrison = new SelectElement(driver,
				String.format(periodOfYears, property));
		yearsSpentInPrison.sendValuesUsingElementName(years);

		return this;
	}

	public YesNoDetails monthsSpentInPrison(String months) {
		SelectElement monthsSpentInPrison = new SelectElement(driver,
				String.format(periodOfMonths, property));
		monthsSpentInPrison.sendValuesUsingElementName(months);
		return this;
	}

	public YesNoDetails daysSpentInPrison(String days) {
		SelectElement daysSpentInPrison = new SelectElement(driver,
				String.format(periodOfDays, property));
		daysSpentInPrison.sendValuesUsingElementName(days);
		return this;
	}

}
