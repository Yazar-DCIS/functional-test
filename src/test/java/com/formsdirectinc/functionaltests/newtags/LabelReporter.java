package com.formsdirectinc.functionaltests.newtags;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

public class LabelReporter extends WizardPage {

	private By byPage = By.cssSelector("input[name='page']");
	private By byPageHeader = By.cssSelector("td[class='page-header']");
	private By byEQPageHeader = By.cssSelector("div[class='EqSubHeader-label']");
	private By byQuestionTitle = By.cssSelector("div[class='Question-title']");
	private By byQuestionInstruction = By.cssSelector("div[class='Question-instructions']");
	private By byRadioNote = By.cssSelector("div[class='RadioInput-note']");
	private By byPageError=By.cssSelector("span[class='PageError-label']");
	private By byFieldError=By.cssSelector("p[class='AnswerField-error error']");

	public LabelReporter(WebDriver driver) {
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

	/* Method to get the EQ-PageHeader */
	public void verifyEQPageHeader(String expectedHeader) {

		String actualPageHeader = driver.findElement(byEQPageHeader).getText();
		writeAssertResults(actualPageHeader, expectedHeader, "Page-Header");
	}

	public void questionTitle(String expectedQuestionTitle) {

		WebElement questionTitleLabel = driver.findElement(byQuestionTitle);

		String actualquestionTitleLabel = questionTitleLabel.getText();

		writeAssertResults(actualquestionTitleLabel, expectedQuestionTitle,
				"QuestionTitle");

	}

	public void questionInstruction(String expectedQuestionInstruction) {

		WebElement questionInstructionLabel = driver
				.findElement(byQuestionInstruction);

		String actualquestionInstructionLabel = questionInstructionLabel
				.getText();

		writeAssertResults(actualquestionInstructionLabel,
				expectedQuestionInstruction, "QuestionInstruction");
	}

	public void radioNoteLabels(int noteNumber, String expectedNote) {

		List<WebElement> radioNoteLabel = driver.findElements(byRadioNote);
		String actualRadioNoteLabel = radioNoteLabel.get(noteNumber).getText();
		writeAssertResults(actualRadioNoteLabel, expectedNote,
				"RadioInput-Notes " + noteNumber);

	}

	public void checkEQLearnMoreWithTitle(int placeHolder, String learnMoreID,
			String expectedTitle, String expectedContent) {

		List<WebElement> learnMore = driver.findElements(By
				.cssSelector("a[class='LearnMoreLink']"));

		learnMore.get(placeHolder).click();

		WebElement learnMoreBox = driver.findElement(By.cssSelector("div[id='"
				+ learnMoreID + "']"));

		WebElement learnMoreContentTitle = learnMoreBox.findElement(By
				.cssSelector("div[class='InfoModal-title']"));
		String actualLearnMoreTitle = learnMoreContentTitle.getText();
		System.out.println(actualLearnMoreTitle);
		writeAssertResults(actualLearnMoreTitle, expectedTitle,
				"Learn More Title");

		WebElement learnMoreContent = learnMoreBox.findElement(By
				.cssSelector("div[class='InfoModal-content']"));
		String actualLearnMore = learnMoreContent.getText();
		System.out.println(actualLearnMore);
		writeAssertResults(actualLearnMore, expectedContent,
				"Learn More Content");

	}

	public void checkEQLearnMoreWithoutTitle(int placeHolder,
			String learnMoreID, String expectedContent) {

		List<WebElement> learnMore = driver.findElements(By
				.cssSelector("a[class='LearnMoreLink']"));

		learnMore.get(placeHolder).click();

		WebElement learnMoreBox = driver.findElement(By.cssSelector("div[id='"
				+ learnMoreID + "']"));

		WebElement learnMoreContent = learnMoreBox.findElement(By
				.cssSelector("div[class='InfoModal-content']"));
		String actualLearnMore = learnMoreContent.getText();
		System.out.println(actualLearnMore);
		writeAssertResults(actualLearnMore, expectedContent,
				"Learn More Content");

	}

	public String calculateDate(int year, int month) {
		DateFormat dateFormat = new SimpleDateFormat(" MMMM yyyy");
		Calendar dateLabel = Calendar.getInstance();
		dateLabel.add(Calendar.YEAR, -year);
		dateLabel.add(Calendar.MONTH, -month);
		return dateFormat.format(dateLabel.getTime());
	}

	public String verifyLearnMoreSQ(int expectedIndex, String learnMoreID,
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

	/* Method to get the PageError */
	public void verifyPageErrorMessage(String expectedError) {

		String actualPageError = driver.findElement(byPageError).getText();
		writeAssertResults(actualPageError, expectedError, "Page-Header-Error");
		
	}

	/* Method to get the PageFieldError */
	public void verifyFieldErrorMessage(String[] expectedError) {
		
		List<WebElement> errorFields=driver.findElements(byFieldError);
		int numberOfFields=errorFields.size(); 
		String actualFieldErrors[]=new String[numberOfFields];
		for(int i=0;i<numberOfFields;i++)
		{
			actualFieldErrors[i]=errorFields.get(i).getText();
			writeAssertResults(actualFieldErrors[i], expectedError[i], "Field-Error-"+i);
		}
	
	}
	
	/* Method to generate testng-report as html */
	public LabelReporter writeAssertResults(String actual, String expected,
			String type) {

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

			Reporter.log("<b>" + " Expected Label of "
					+ type
					+ " is :  "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ expected
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Actual Label of "
					+ type
					+ " is :  "
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

			Reporter.log("<b>" + " Expected Label of "
					+ type
					+ " is :  "
					+ "</b><br>"
					+ "<font color=\"green\">"
					+ expected
					+ "</font>"
					+ "<br>"
					+ "<b>"
					+ "Actual Label of "
					+ type
					+ " is :  "
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
