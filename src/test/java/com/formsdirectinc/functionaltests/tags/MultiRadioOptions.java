package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

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

	public MultiRadioOptions selectOption(int option) {
		radioButton = driver.findElement(By.id(String.format(expression
				+ option, property)));
		radioButton.click();
		return this;
	}

}
