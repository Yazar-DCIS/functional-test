package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.formsdirectinc.functionaltests.tags.BaseTag;

/**
 * YesNo: YesNo tag based on new Updates
 * @author Orina Revision: $Rev$
 */
public class YesNo extends BaseTag {
	protected String noExpression = "applicationData-%s-no";
	protected String yesExpression = "applicationData-%s-yes";
	protected String label = "-label";
	String questionTitleFieldExpression = "YesNo_NoDefault-applicationData-%s";
	protected String explainExpression="applicationData-%s.explanation";
	protected WebElement noRadioButton;
	protected WebElement yesRadioButton;
	LabelReporter results = new LabelReporter(driver);

	public YesNo(WebDriver driver, String property) {
		super(driver, property);
	}

	public YesNo yes() {
		yesRadioButton = driver.findElement(By.id(String.format(yesExpression,
				property)));
		yesRadioButton.click();
		return this;
	}

	public YesNo no() {
		noRadioButton = driver.findElement(By.id(String.format(noExpression,
				property)));
		noRadioButton.click();
		return this;
	}
	public YesNo explain(String reason) {
		WebElement explainTextBox = driver.findElement(By.id(String.format(explainExpression,
				property)));
		explainTextBox.sendKeys(reason);
		return this;
	}
	// To check the Yes label
	public void checkYesLabel(String expected) {

		WebElement checkBoxLabel = driver.findElement(By
				.cssSelector("label[for='"+ String.format(yesExpression, property) + "']"));

		String actualYesLabel = checkBoxLabel.getText();

		results.writeAssertResults(actualYesLabel, expected, "Label-Yes");

	}

	// To check the No label
	public void checkNoLabel(String expected) {

		WebElement checkBoxLabel = driver.findElement(By
				.cssSelector("label[for='"+ String.format(noExpression, property) + "']"));

		String actualYesLabel = checkBoxLabel.getText();

		results.writeAssertResults(actualYesLabel, expected, "Label-No");

	}

	public YesNo setYesOrNo(String answer) {

		if (answer.equalsIgnoreCase("Yes")) {
			yes();
		} else if (answer.equalsIgnoreCase("No")) {
			no();
		}

		return this;
	}

	public boolean isYes() {
		return yesRadioButton.isSelected();
	}

	public boolean isNo() {
		return noRadioButton.isSelected();
	}
}
