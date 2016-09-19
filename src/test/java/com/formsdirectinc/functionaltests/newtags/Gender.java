package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.tags.BaseTag;

/**
 * Gender_Tag: Selenium page model for Gender tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class Gender extends BaseTag {

	protected String maleExpression = "%s.male";
	protected String femaleExpression = "%s.female";
	String questionTitleFieldExpression = "Gender-%s";
	protected WebElement maleRadioButton;
	protected WebElement femaleRadioButton;
	WizardPage checkQuestions=new WizardPage(driver);
	
	public Gender(WebDriver driver, String property) {
		super(driver, property);

	}

	public String checkQuestionTitleLabel() {
		
		WebElement questionTitle = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.questionTitle(questionTitle);
		
		return checkQuestions.questionTitle(questionTitle);
	}
	
	public String checkQuestionInstructionLabel() {
		
		WebElement questionInstruction = driver.findElement(By.id(String.format(
				questionTitleFieldExpression,property)));
		
		checkQuestions.questionInstruction(questionInstruction);
		
		return checkQuestions.questionInstruction(questionInstruction);
	}
	
	public String checkLearnMoreLabel(String learnMoreID) {
		
		WebElement learnMore = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.learnMore(learnMore, learnMoreID);
		
		return checkQuestions.learnMore(learnMore, learnMoreID);
	}

	public Gender setGenderAsMale() {
		maleRadioButton = driver.findElement(By.id(String.format(
				maleExpression, property)));
		maleRadioButton.click();
		return this;
	}

	public String checkLabelMale() {
		WebElement maleRadioButtonLabel = driver.findElement(By.className(String.format(
				maleExpression, property)));
		String actualRadioButtonLabel=maleRadioButtonLabel.getAttribute("value");
		return actualRadioButtonLabel;
	}
	
	public Gender setGenderAsFemale() {
		femaleRadioButton = driver.findElement(By.id(String.format(
				femaleExpression, property)));
		femaleRadioButton.click();
		return this;
	}
	
	public String checkLabelFemale() {
		WebElement femaleRadioButtonLabel = driver.findElement(By.className(String.format(
				femaleExpression, property)));
		String actualRadioButtonLabel=femaleRadioButtonLabel.getAttribute("value");
		return actualRadioButtonLabel;
	}
}
