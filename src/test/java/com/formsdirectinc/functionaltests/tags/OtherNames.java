package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * OtherNames: Selenium page model for OtherNames tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class OtherNames extends BaseTag {

	protected String otherNameExpression = "%s.otherNames";
	protected WebElement otherNameField;

	protected String usedOtherNameExpression = "%s.usedOtherNames";
	protected WebElement usedOtherNameField;

	protected String inCareNameExpression = "%s.careofName";
	protected String mailCareNameExpression = "%s.mailCareName";
	protected WebElement inCareNameField;

	public OtherNames(WebDriver driver, String property) {
		super(driver, property);

	}

	public OtherNames setOtherName(String otherNames) {
		otherNameField = driver.findElement(By.id(String.format(
				otherNameExpression, property)));
		otherNameField.sendKeys(otherNames);
		return this;
	}

	public OtherNames setOtherNamesUsed(String usedOtherNames) {
		usedOtherNameField = driver.findElement(By.id(String.format(
				usedOtherNameExpression, property)));
		usedOtherNameField.sendKeys(usedOtherNames);
		return this;
	}

	public OtherNames setInCareOfName(String inCareOfName) {
		inCareNameField = driver.findElement(By.id(String.format(
				inCareNameExpression, property)));
		inCareNameField.sendKeys(inCareOfName);
		return this;
	}
	
	public OtherNames setMailCareOfName(String inCareOfName) {
		inCareNameField = driver.findElement(By.id(String.format(
				mailCareNameExpression, property)));
		inCareNameField.sendKeys(inCareOfName);
		return this;
	}
}
