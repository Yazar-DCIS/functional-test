package com.formsdirectinc.functionaltests.tags;

import java.util.List;

/*import org.apache.pdfbox.pdfparser.PDFParser;
 import org.apache.pdfbox.util.PDFTextStripper;*/
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.enums.Sites;

/**
 * PageCopiesAndContent: Base class for all copies
 * 
 * @author: <a href="mailto:orina.moorthy@dcis.net">Orina Moorthy</a>
 * @Notes The mis-match copy will get displayed in Reporter Log(index.html).
 *        Since the report is in html, it view is formated such that the Color
 *        of Error-Copy is in Red and Exact-Copy is in Green.
 */

public class PageCopiesAndContent extends WizardPage {

	protected String instructionalTextExpression = "p[class='pageInstructionalText']";
	protected String sectionHeaderExpression = "p[class='sectionHeader']";
	protected String labelTextExpression = "div[class='label']";
	protected String learnMoreLink = "Learn More";
	protected String explainThisLink = "Explain This";
	protected String explainThisContent = "%s";
	protected String explainHairColor = "%s.hairColor";
	protected String explainEyeColor = "%s.eyeColor";
	protected String learnMoreContent = "div[class='box-content']";
	protected String contactUS_Expression = "div[class='contact-us']";
	protected String tablePageHeaderExpression = "td[class='page-header']";
	protected String tableSectionHeaderExpression = "td[class='section-header']";
	protected String resourcesContent = "div[id='resources']";
	protected String faqContent = "div[class='popup-content']";
	protected String faqlinks = "div[class='modal-body']";
	protected String subLabels = "label[class='sub-label']";
	protected String spanSubLabels = "span[class='sub-label']";
	private WebElement intructionalText;
	private WebElement sectionHeaderText;
	private WebElement labelText;
	private WebElement learnMore;
	private WebElement explainThis;
	private WebElement contactUSText;
	private WebElement tableHeaderText;
	private WebElement resources;
	private WebElement faq;

	protected List<WebElement> explainThisLinks;
	protected List<WebElement> multiSectionHeaderText;

	private By byPage = By.cssSelector("input[name='page']");
	private WebElement pageID;

	private By bySection = By.tagName("div");
	private WebElement sectionID;

	public PageCopiesAndContent(WebDriver driver) {
		super(driver);

	}

	/* Method to get the Page-ID */
	public String getPageID() {

		pageID = driver.findElement(byPage);

		System.out.println("Page ID is:- " + pageID.getAttribute("value"));

		return pageID.getAttribute("value");
	}

	/* Method to get the Page-ID */
	public String getPageTitle() {

		String pageTitle = driver.getCurrentUrl();

		Reporter.log("<h4>" + pageTitle.toString() + "</h4>");
		System.out.println("Page Title is:- " + pageTitle.toString());

		return pageTitle.toString();
	}

	/* Method to get the Section-ID */
	public String getSectionID() {

		sectionID = driver.findElement(bySection);

		System.out.println("Page Section ID is:- "
				+ sectionID.getAttribute("value"));

		return sectionID.getAttribute("value");
	}

	/* Method to verify the Page-Labels */
	public PageCopiesAndContent verifyPageLabelText(String expectedLabelText,
			String property) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		WebElement actualElement = labelText.findElement(By.cssSelector(String
				.format(labelTextExpression)));

		String actualLabel = actualElement.getText();

		writeAssertResults(actualLabel, expectedLabelText, "PageLabel");

		return this;
	}

	/* Method to verify multiple labels in a Page */
	public PageCopiesAndContent verifyMultipleLabelText(
			String expectedLabelText, String property, int labelCount) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		List<WebElement> labelTexts = labelText.findElements(By
				.cssSelector(String.format(labelTextExpression)));

		String actualLabel = labelTexts.get(labelCount).getText();

		writeAssertResults(actualLabel, expectedLabelText, "PageLabel");

		return this;
	}

	/* Method to verify multiple sub-labels in a Page */
	public PageCopiesAndContent verifySubLabelsText(
			String expectedSubLabelText, String property, int subLabelCount) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		List<WebElement> subLabelText = labelText.findElements(By
				.cssSelector(String.format(subLabels)));

		String actualSubLabel = subLabelText.get(subLabelCount).getText();

		writeAssertResults(actualSubLabel, expectedSubLabelText, "PageSubLabel");

		return this;
	}

	/* Method to verify multiple sub-labels in a Page */
	public PageCopiesAndContent verifySubLabelsSpanText(
			String expectedSubLabelText, String property, int subLabelCount) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		List<WebElement> subLabelText = labelText.findElements(By
				.cssSelector(String.format(spanSubLabels)));
		String actualSubLabel = subLabelText.get(subLabelCount).getText();

		writeAssertResults(actualSubLabel, expectedSubLabelText, "PageSubLabel");

		return this;
	}

	/* Method to verify the Learn More content in the Page */
	public PageCopiesAndContent verifyLearnMoreText(String expectedLearnMore) {

		learnMore = driver
				.findElement(By.linkText(String.format(learnMoreLink)));
		learnMore.click();
		learnMore = driver.findElement(By.cssSelector(String
				.format(learnMoreContent)));
		String actualLearnMore = learnMore.getText();

		writeAssertResults(actualLearnMore, expectedLearnMore, "LearnMore");

		return this;

	}

	/* Method to verify the FAQ content in the Page */
	public PageCopiesAndContent verifyFAQText(String expectedFAQ,
			String expectedAnswer) {

		faq = driver.findElement(By.linkText(String.format(expectedFAQ)));
		faq.click();

		WebElement faqHeader = driver.findElement(By.tagName("h3"));
		String headerText = faqHeader.getText();

		List<WebElement> faqBody = driver.findElements(By
				.xpath("//div[contains(@class, 'box-content')]/p"));
		String actualText = faqBody.get(1).getText();
		System.out.println("-------------------->>>" + actualText);

		writeAssertResults(headerText, expectedFAQ, "FAQ-Question");

		writeAssertResults(actualText, expectedAnswer, "FAQ-Answer");

		return this;

	}

	/* Method to verify the Explain this content in the Page */
	public PageCopiesAndContent verifyExplainThisText(
			String expectedExplainThis, String property, String explainID) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		explainThis = labelText.findElement(By.linkText(String
				.format(explainThisLink)));
		explainThis.click();

		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(explainThis).build();
		mouseOver.perform();

		WebElement explainThisCopy = driver.findElement(By
				.cssSelector(("div[id='" + explainID + "']")));

		String actualExplainThis = explainThisCopy.getText();
		System.out.println("-------------->>>>" + explainThisCopy.getText());

		writeAssertResults(actualExplainThis, expectedExplainThis,
				"Explain This");

		return this;

	}

	/* Method to verify the Multiple Explain this in the Page */
	public PageCopiesAndContent verifyMultipleExplainText(
			String expectedExplainThis, int explainThisCount, String explainID) {

		explainThisLinks = labelText.findElements(By.linkText(String
				.format(explainThisLink)));
		explainThisLinks.get(explainThisCount).click();

		Actions builder = new Actions(driver);
		Action mouseOver = builder.moveToElement(
				explainThisLinks.get(explainThisCount)).build();
		mouseOver.perform();

		WebElement explainThisCopy = driver.findElement(By
				.cssSelector(("div[id='" + explainID + "']")));

		String actualExplainThis = explainThisCopy.getText();

		writeAssertResults(actualExplainThis, expectedExplainThis,
				"Explain This");

		return this;
	}

	/* Method to verify the section header content in the Page */
	public PageCopiesAndContent verifyPageSectionHeader(
			String expectedSectionHeader, String property) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		sectionHeaderText = labelText.findElement(By.cssSelector(String
				.format(sectionHeaderExpression)));

		String actualSectionHeader = sectionHeaderText.getText();

		writeAssertResults(actualSectionHeader, expectedSectionHeader,
				"Page SectionHeader");

		return this;

	}

	/* Method to verify the section header content in the Page */
	public PageCopiesAndContent verifyPageMultiSectionHeader(
			String expectedSectionHeader, String property, int sectionIndex) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		multiSectionHeaderText = labelText.findElements(By.cssSelector(String
				.format(sectionHeaderExpression)));

		String actualSectionHeader = multiSectionHeaderText.get(sectionIndex)
				.getText();

		writeAssertResults(actualSectionHeader, expectedSectionHeader,
				"Page SectionHeader");

		return this;

	}

	/* Method to verify the table header content in the Page */
	public PageCopiesAndContent verifyPageTableHeader(
			String expectedPageTableHeader) {

		tableHeaderText = driver.findElement(By.cssSelector(String
				.format(tablePageHeaderExpression)));

		String actualTableHeader = tableHeaderText.getText();

		writeAssertResults(actualTableHeader, expectedPageTableHeader,
				"Page TableHeader");

		return this;

	}

	/* Method to verify the instructional text in the Page */
	public PageCopiesAndContent verifyPageInstructionalText(
			String expectedInstructionText, String property) {

		labelText = driver.findElement(By.cssSelector("div[id='" + property
				+ "']"));

		intructionalText = labelText.findElement(By.cssSelector(String
				.format(instructionalTextExpression)));

		String actualPageInstruction = intructionalText.getText();

		writeAssertResults(actualPageInstruction, expectedInstructionText,
				"Page InstructionText");

		return this;
	}

	/* Method to verify the contact -us content in the Page */
	public PageCopiesAndContent verifyContactUsText(String expectedContact_US) {

		contactUSText = driver.findElement(By.cssSelector(String
				.format(contactUS_Expression)));
		String actualContact_US = contactUSText.getText();

		writeAssertResults(actualContact_US, expectedContact_US,
				"ContactUs Content");

		return this;
	}

	/* Method to verify the Resources content in the Page */
	public PageCopiesAndContent verifyResources_FAQContent(
			String expectedResources, String expectedFAQ,
			String expectedFAQAnswer) {

		Sites site = Sites.valueOf(System.getProperty("site.name"));

		resources = driver.findElement(By.cssSelector(String
				.format(resourcesContent)));
		String actualResources = resources.getText();

		writeAssertResults(actualResources, expectedResources,
				"Resources Content");

		String mainWindow = driver.getWindowHandle();

		WebElement resources_FAQ = driver.findElement(By.linkText(String
				.format(expectedFAQ)));
		resources_FAQ.click();

		for (String childWindow : driver.getWindowHandles()) {
			driver.switchTo().window(childWindow);
		}

		WebElement faqHeader = driver.findElement(By.tagName("h1"));
		String headerText = faqHeader.getText();
		System.out.println("-------------------->>>1" + headerText);

		WebElement faqBody = driver.findElement(By
				.xpath("//div[contains(@class, 'popup-content')]/p"));
		String actualText = faqBody.getText();

		System.out.println("-------------------->>>2" + actualText);

		writeAssertResults(headerText, expectedFAQ, "FAQ-SQ-Question");

		writeAssertResults(actualText, expectedFAQAnswer, "FAQ-SQ-Answer");

		WebElement close;
		if (site == Sites.FR) {
			close = driver.findElement(By.linkText("CLOSE"));
		} else {
			close = driver.findElement(By.linkText("Close"));
		}
		close.click();

		driver.switchTo().window(mainWindow);
		return this;

	}

	/* Method to verify the content of sorry Page */
	public PageCopiesAndContent verifySorryPageText(String expectedContent,
			String property) {

		WebElement sorryCopy = driver.findElement(By.cssSelector(("div[id='"
				+ property + "']")));
		String actualSorryCopy = sorryCopy.getText();

		writeAssertResults(actualSorryCopy, expectedContent,
				"Sorry Page Content");

		return this;

	}

	public String verifyQuestionTitle(int expectedIndex,
			String expectedQuestionTitle) {
		List<WebElement> actualQuestionTitle = driver.findElements(By
				.cssSelector("div[class='Question-title']"));
		String actualQuestionTitleText = actualQuestionTitle.get(
				expectedIndex - 1).getText();
		writeAssertResults(actualQuestionTitleText, expectedQuestionTitle,
				"Question-title");
		return actualQuestionTitleText;
	}

	public String verifyQuestionInstruction(int expectedIndex,
			String expectedQuestionInstruction) {
		List<WebElement> actualQuestionInstruction = driver.findElements(By
				.cssSelector("div[class='Question-instructions']"));
		String actualQuestionInstructionText = actualQuestionInstruction.get(
				expectedIndex - 1).getText();
		writeAssertResults(actualQuestionInstructionText,
				expectedQuestionInstruction, "Question-instructions");
		return actualQuestionInstructionText;
	}

	public String verifyAnswerFieldLabel(int expectedIndex,
			String expectedAnswerFieldText) {
		List<WebElement> actualAnswerField = driver.findElements(By
				.cssSelector("div[class='AnswerField-label']"));
		String actualAnswerFieldText = actualAnswerField.get(expectedIndex - 1)
				.getText();
		writeAssertResults(actualAnswerFieldText, expectedAnswerFieldText,
				"AnswerField-label");
		return actualAnswerFieldText;
	}

	public String verifyDefaultRadioLabel(int expectedIndex,
			String expectedDefaultRadioText) {
		List<WebElement> actualRadioLabelField = driver.findElements(By
				.cssSelector("label[class='ToggleInline-label']"));
		String actualDefaultRadioText = actualRadioLabelField.get(
				expectedIndex - 1).getText();
		writeAssertResults(actualDefaultRadioText, expectedDefaultRadioText,
				"ToggleInline-label");
		return actualDefaultRadioText;
	}

	public String verifyMultiLabel(int expectedIndex,
			String expectedMultiLabelText) {
		List<WebElement> actualMultiLabelField = driver.findElements(By
				.cssSelector("label[class='ToggleList-label']"));
		String actualMultiRadioText = actualMultiLabelField.get(
				expectedIndex - 1).getText();
		writeAssertResults(actualMultiRadioText, expectedMultiLabelText,
				"ToggleList-label");
		return actualMultiRadioText;
	}

	/* Method to generate testng-report as html */
	public PageCopiesAndContent writeAssertResults(String actual,
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
