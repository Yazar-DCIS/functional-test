package com.formsdirectinc.functionaltests.tags;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

/**
 * PageCopiesAndContent: Base class for all copies
 * 
 * @author: <a href="mailto:orina.moorthy@dcis.net">Orina Moorthy</a>
 * @Notes The mis-match copy will get displayed in Reporter Log(index.html).
 *        Since the report is in html, it view is formated such that the Color
 *        of Error-Copy is in Red and Exact-Copy is in Green.
 */

public class UpdatesOfPageCopiesAndContent extends WizardPage {

	private By byPage = By.cssSelector("input[name='page']");
	private By byPageHeader = By.cssSelector("td[class='page-header']");

	public UpdatesOfPageCopiesAndContent(WebDriver driver) {
		super(driver);

	}

	/* Method to get the Page-ID */
	public String getPageID() {

		WebElement pageID = driver.findElement(byPage);
		return pageID.getAttribute("value");

	}

	/* Method to get the Page-ID */
	public String getPageTitle() {
		String pageTitle = driver.getCurrentUrl();
		Reporter.log("<h4>" + pageTitle + "</h4>");
		return pageTitle;
	}

	/* Method to get the PageHeader */
	public String verifyPageHeader(String expectedHeader) {

		String actualPageHeader = driver.findElement(byPageHeader).getText();
		writeAssertResults(actualPageHeader, expectedHeader, "Page-Header");
		return actualPageHeader;

	}

	public int getLengthOfCopies(String label) {
		List<WebElement> actuallabelTexts = null;

		if (label.contains("Question-title")
				|| label.contains("Question-instructions")
				|| label.contains("AnswerGroup-label")
				|| label.contains("AnswerField-label")) {
			actuallabelTexts = driver.findElements(By.cssSelector("div[class='"
					+ label + "']"));
		}
		if (label.contains("RadioInput") || label.contains("ToggleList")) {
			actuallabelTexts = driver.findElements(By
					.cssSelector("label[class='" + label + "-label']"));
		}
		if (label.contains("LearnMoreLink")) {
			actuallabelTexts = driver.findElements(By.cssSelector("a[class='"
					+ label + "']"));
		}
		Integer questionLength = actuallabelTexts.size();
		return questionLength;
	}

	/* Method to get the Page QuestionTitle */
	public UpdatesOfPageCopiesAndContent verifyCopies(String label,
			int expectedIndex, String expectedLabel) {

		List<WebElement> actuallabelTexts = null;

		if (label.contains("Question-title")
				|| label.contains("Question-instructions")
				|| label.contains("AnswerGroup-label")
				|| label.contains("AnswerField-label")) {
			actuallabelTexts = driver.findElements(By.cssSelector("div[class='"
					+ label + "']"));
		}
		if (label.contains("RadioInput") || label.contains("ToggleList")) {
			actuallabelTexts = driver.findElements(By
					.cssSelector("label[class='" + label + "-label']"));
		}
		if (label.contains("LearnMoreLink")) {
			actuallabelTexts = driver.findElements(By.cssSelector("a[class='"
					+ label + "']"));

		}
		String actualLabel = actuallabelTexts.get(expectedIndex - 1).getText();

		writeAssertResults(actualLabel, expectedLabel, label);

		return this;

	}

	public UpdatesOfPageCopiesAndContent verifyPageHeading(String type,
			String expectedLabelText) {

		// PageHeading-label
		// PageHeading-title

		WebElement pageLevelTexts = driver.findElement(By
				.cssSelector("div[class='PageHeading-" + type + "']"));

		String actualLabel = pageLevelTexts.getText();

		writeAssertResults(actualLabel, expectedLabelText, "PageHeading-"
				+ type + "");

		return this;
	}

	public String verifyLearnMore(int expectedIndex, String learnMoreID,
			String expectedLearnMore) {

		List<WebElement> actualLearnMore = driver.findElements(By
				.cssSelector("a[class='LearnMoreLink']"));
		actualLearnMore.get(expectedIndex - 1).click();

		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(
				actualLearnMore.get(expectedIndex - 1)).build();
		mouseOver.perform();

		WebElement explainThisCopy = driver.findElement(By
				.cssSelector(("div[id='" + learnMoreID + "']")));
		String actualLearnMoreText = explainThisCopy.getText();

		writeAssertResults(actualLearnMoreText, expectedLearnMore, "Learn More");

		return actualLearnMoreText;
	}

	/* Method to generate testng-report as html */
	public UpdatesOfPageCopiesAndContent writeAssertResults(String actual,
			String expected, String type) {

		/*
		 * The customized testng-html report for copies using "Assert" Page-ID
		 * in bold Error-Copy in RED Exact-Copy in GREEN results in index.html
		 * Reporter.log
		 */

		try {

			Assert.assertEquals(actual, expected);

			if (!type.contains("FAQ-SQ")) {
				Reporter.log("<h4>" + getPageID() + "</h4>");
			} else {
				Reporter.log("<h4>" + getPageTitle() + "</h4>");
			}

			Reporter.log("<b>" + " Expected "
					+ type
					+ " :  "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ expected
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Observed "
					+ type
					+ " : "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ actual
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Result  : "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ ""
					+ "PASS"
					+ "</font>"
					+ "<br>"
					+ "--------------------------------------------------------"
					+ "<br>");
		}

		catch (AssertionError e) {

			if (!type.contains("FAQ-SQ")) {
				Reporter.log("<h4>" + getPageID() + "</h4>");
			} else {
				Reporter.log("<h4>" + getPageTitle() + "</h4>");
			}

			/*
			 * Reporter.log("<font color=\"red\">"+e.getLocalizedMessage()+"</font>"
			 * + "<br>" +"----------------------------");
			 */

			Reporter.log("<b>" + " Expected "
					+ type
					+ " :  "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ expected
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Observed "
					+ type
					+ " : "
					+ "</b><br>"
					+ "<font color=\"red\">"
					+ actual
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Result  : "
					+ "</b><br>"
					+ "<font color=\"red\">"
					+ ""
					+ "FAIL"
					+ "</font>"
					+ "<br>"
					+ "--------------------------------------------------------"
					+ "<br>");

		}

		return this;
	}

}
