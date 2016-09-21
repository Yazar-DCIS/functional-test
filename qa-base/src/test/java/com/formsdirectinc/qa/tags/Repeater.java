package com.formsdirectinc.qa.tags;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Repeater: Selenium page model for repeater tag
 * 
 * @author Orina Revision: $Rev$
 */
public class Repeater extends BaseTag {

	// Add another, ADD ANOTHER,DELETE, Delete
	private String addAnotherExpression = "//%s[contains(text(),'%s')]";
	private String deleteExpression = "//%s[contains(text(),'%s')]";

	private WebElement addAnotherField;
	protected List<WebElement> deleteField;

	public Repeater(WebDriver driver, String property) {
		super(driver, property);
	}

	public Repeater addAnother() {

		addAnotherField = driver.findElement(By.xpath(String.format(
				addAnotherExpression, property)));
		addAnotherField.click();

		return this;
	}

	public Repeater delete(int index) {

		deleteField = driver.findElements(By.xpath(String.format(
				deleteExpression, property)));
		deleteField.get(index).click();

		return this;
	}
}
