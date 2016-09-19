package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.formsdirectinc.functionaltests.tags.BaseTag;

/**
 * Name_FirstMiddleLast: Selenium page Model for Name_FirstMiddleLast tag
 * @author Orina
 * @Updated With Label copy Validation
 * Revision: $Rev$
 */

public class Name_FirstMiddleLast extends BaseTag {

	String firstNameFieldExpression = "%s-%s-first";
	WebElement firstNameField;

	String middleNameFieldExpression = "%s-%s-middle";
	WebElement middleNameField;
	
	String middleNameFieldPresentExpression = "%s-%s-middleNamePresent";
	String middleNameFieldPresentLabelExpression = "%s-%s-checkbox-label";
		
	String lastNameFieldExpression = "%s-%s-last";
	
	String questionTitleFieldExpression = "Name_Optional_MiddleName-%s-%s";
	
	WebElement lastNameField;

	String headerDivExpression = "%s-header";
	WebElement headerDiv;

	LabelReporter copyCheck=new LabelReporter(driver);
	
	WizardPage checkQuestions=new WizardPage(driver);
	
	
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

	
	
	public String checkQuestionTitleLabel() {
		
		WebElement questionTitle = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, beanName, property)));
		
		checkQuestions.questionTitle(questionTitle);
			
		return checkQuestions.questionTitle(questionTitle);
	}
	
	public String checkQuestionInstructionLabel() {
		
		WebElement questionInstruction = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, beanName, property)));
		
		checkQuestions.questionInstruction(questionInstruction);
		
		return checkQuestions.questionInstruction(questionInstruction);
	}
	
	public String checkLearnMoreLabel(String learnMoreID) {
		
		WebElement learnMore = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, beanName, property)));
		
		checkQuestions.learnMore(learnMore, learnMoreID);
		
		return checkQuestions.learnMore(learnMore, learnMoreID);
	}

	public String checkFirstNameLabel() {
		
		WebElement firstNameLabel = driver.findElement(By.className(String.format(
				firstNameFieldExpression, beanName, property)));
		
		String actualFirstNameLabel=firstNameLabel.getText();
		
		return actualFirstNameLabel;
	}
	
	public Name_FirstMiddleLast setMiddleNameField(String middleName) {
		middleNameField = driver.findElement(By.id(String.format(
				middleNameFieldExpression, beanName, property)));
		middleNameField.clear();
		middleNameField.sendKeys(middleName);

		return this;
	}
	
	public Name_FirstMiddleLast setNoMiddleNameField() {
		middleNameField = driver.findElement(By.id(String.format(
				middleNameFieldPresentExpression, beanName, property)));
		middleNameField.click();

		return this;
	}
	
	public String checkMiddleNameLabel() {
		WebElement middleNameLabel = driver.findElement(By.className(String.format(
				middleNameFieldExpression, beanName, property)));
	
		String actualMiddleNameLabel=middleNameLabel.getText();
			
		return actualMiddleNameLabel;
	}

	public String checkMiddleNamePresentLabel() {
		WebElement middleNameLabel = driver.findElement(By.className(String.format(
				middleNameFieldPresentLabelExpression,beanName, property)));
		String actualMiddleNameLabel=middleNameLabel.getText();
		System.out.println(actualMiddleNameLabel);
		return actualMiddleNameLabel;
	}
	
	public Name_FirstMiddleLast setLastNameField(String lastName) {
		lastNameField = driver.findElement(By.id(String.format(
				lastNameFieldExpression, beanName, property)));
		lastNameField.clear();
		lastNameField.sendKeys(lastName);

		return this;
	}

	public String checkLastNameLabel() {
		WebElement lastNameLabel = driver.findElement(By.className(String.format(
				lastNameFieldExpression, beanName, property)));
		String actualLastNameLabel=lastNameLabel.getText();
		return actualLastNameLabel;
	}
	
	
	public String getExplainThisText() {
		WebElement element = headerDiv.findElement(By.linkText("Explain This"));

		Actions builder = new Actions(driver); // Configure the Action
		Action mouseOver = builder.moveToElement(element).build(); // Get the
																	// action
		mouseOver.perform(); // Execute the Action

		return element.getText();
	}

	
}
