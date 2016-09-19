package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Name_FirstMiddleLast: Selenium page Model for Name_FirstMiddleLast tag
 
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/19/15 7:31 PM
 * Revision: $Rev$
 */
public class Name_FirstMiddleLast extends BaseTag {

	String firstNameFieldExpression = "%s-%s-first";
	WebElement firstNameField;

	String middleNameFieldExpression = "%s-%s-middle";
	String middleNamePresentFieldExpression = "%s-%s-middleNamePresent";
	
	WebElement middleNameField;

	String lastNameFieldExpression = "%s-%s-last";
	WebElement lastNameField;
	
	String maidenNameFieldExpression = "%s-%s.maidenName";
	WebElement maidenNameField;
	
	String fatherNameFieldExpression = "%s-%s.fatherFirstName";
	WebElement fatherNameField;
	
	String motherNameFieldExpression = "%s-%s.motherFirstName";
	WebElement motherNameField;

	String otherNameFieldExpression = "%s-%s.otherNames";
	WebElement otherNameField;
	
	String headerDivExpression = "%s-header";
	WebElement headerDiv;

	String firstNameLabelExpression = "../../div[@class='label']";
	WebElement firstNameLabel;

	String middleNameLabelExpression = "../../div[@class='label']";
	WebElement middleNameLabel;

	String lastNameLabelExpression = "../../div[@class='label']";
	WebElement lastNameLabel;

	public Name_FirstMiddleLast(WebDriver driver, String beanName,
			String property) {
		super(driver, beanName, property);

	}

	public Name_FirstMiddleLast setFirstNameField(String firstName) {
		firstNameField = driver.findElement(By.id(String.format(
				firstNameFieldExpression, beanName, property)));
		firstNameField.clear();
		firstNameField.sendKeys(firstName);

		return this;
	}

	public Name_FirstMiddleLast setMiddleNameField(String middleName) {
		middleNameField = driver.findElement(By.id(String.format(
				middleNameFieldExpression, beanName, property)));
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		return this;
	}
	
	public Name_FirstMiddleLast setNoMiddleName() {
		middleNameField = driver.findElement(By.id(String.format(
				middleNamePresentFieldExpression, beanName, property)));
		middleNameField.click();
		return this;
	}

	public Name_FirstMiddleLast setLastNameField(String lastName) {
		lastNameField = driver.findElement(By.id(String.format(
				lastNameFieldExpression, beanName, property)));
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		return this;
	}

	public Name_FirstMiddleLast setMaidenNameField(String maidenName) {
		maidenNameField = driver.findElement(By.id(String.format(
				maidenNameFieldExpression, beanName, property)));
		maidenNameField.clear();
		maidenNameField.sendKeys(maidenName);

		return this;
	}
	
	public Name_FirstMiddleLast setOtherNameField(String otherName) {
		otherNameField = driver.findElement(By.id(String.format(
				otherNameFieldExpression, beanName, property)));
		otherNameField.clear();
		otherNameField.sendKeys(otherName);

		return this;
	}
	
	public Name_FirstMiddleLast setFatherNameField(String fatherName) {
		fatherNameField = driver.findElement(By.id(String.format(
				fatherNameFieldExpression, beanName, property)));
		fatherNameField.clear();
		fatherNameField.sendKeys(fatherName);

		return this;
	}
	
	public Name_FirstMiddleLast setMotherNameField(String motherName) {
		motherNameField = driver.findElement(By.id(String.format(
				motherNameFieldExpression, beanName, property)));
		motherNameField.clear();
		motherNameField.sendKeys(motherName);

		return this;
	}
	
	public String getExplainThisText() {
		WebElement element = headerDiv.findElement(By.linkText("Explain This"));

		Actions builder = new Actions(driver); // Configure the Action
		Action mouseOver = builder.moveToElement(element).build(); // Get the
																	// action
		mouseOver.perform(); // Execute the Action

		return element.getText();
	}
	public Name_FirstMiddleLast setApplicantNameDetails(String firstName,String lastName,
			String haveMiddleName,String middleName) {
		
		setFirstNameField(firstName);
		setLastNameField(lastName);
		if(haveMiddleName.equalsIgnoreCase("yes"))
		{
			setMiddleNameField(middleName);
		}
		else if(haveMiddleName.equalsIgnoreCase("no"))
		{
			setNoMiddleName();
		}
		return this;
	}
	public String getFirstNameLabel() {
		firstNameLabel = firstNameField.findElement(By
				.xpath(firstNameLabelExpression));
		return firstNameLabel.getText();
	}

	public String getMiddleNameLabel() {
		middleNameLabel = middleNameField.findElement(By
				.xpath(middleNameLabelExpression));
		return middleNameLabel.getText();
	}

	public String getLastNameLabel() {
		lastNameLabel = lastNameField.findElement(By
				.xpath(lastNameLabelExpression));
		return lastNameLabel.getText();
	}
}
