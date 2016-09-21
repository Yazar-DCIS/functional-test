package com.formsdirectinc.qa.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.qa.utils.qastyles.ContentVerifierQA;

/**
 * MultiRadioOptions_Tag: Selenium page model for Multiple radio buttons tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class MultiRadioOptions extends BaseTag {

	protected String expression = "%s-";
	protected WebElement radioButton;

	public MultiRadioOptions(WebDriver driver, String property) {
		super(driver, property);

	}

	public MultiRadioOptions(WebDriver driver) {
		super(driver);

	}

	public MultiRadioOptions selectOption(int option) {
		radioButton = driver.findElement(By.id(String.format(expression
				+ option, property)));
		radioButton.click();
		return this;
	}

	public MultiRadioOptions selectOption(String property, int option) {
		radioButton = driver.findElement(By.id(String.format(expression
				+ option, property)));
		radioButton.click();
		return this;
	}

	// To check the Check-box labels
	public void checkOptionLabels(int option, String expected) {

		ContentVerifierQA results = new ContentVerifierQA(driver);

		WebElement checkBoxLabel = driver.findElement(By
				.cssSelector("label[for='"
						+ String.format(expression + option, property) + "']"));

		String actualOptionLabel = checkBoxLabel.getText();

		results.writeAssertResults(actualOptionLabel, expected,
				"Multi-Options-" + option);

	}

}
