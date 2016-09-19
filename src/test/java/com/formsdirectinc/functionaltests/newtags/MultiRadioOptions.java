package com.formsdirectinc.functionaltests.newtags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.tags.BaseTag;

/**
 * MultiRadioOptions_Tag: Selenium page model for Multiple radio buttons tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class MultiRadioOptions extends BaseTag {

	protected String expression = "%s-";
	protected WebElement radioButton;

	String questionTitleFieldExpression = "RB_Req1-%s";
	WizardPage checkQuestions=new WizardPage(driver);
	
	public MultiRadioOptions(WebDriver driver, String property) {
		super(driver, property);

	}
	
	public String checkQuestionTitleLabel() {
		
		WebElement questionTitle = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		checkQuestions.questionTitle(questionTitle);
		return checkQuestions.questionTitle(questionTitle);
	}

	public String checkLearnMoreLabel(String learnMoreID) {
		
		WebElement learnMore = driver.findElement(By.id(String.format(
				questionTitleFieldExpression, property)));
		
		checkQuestions.learnMore(learnMore, learnMoreID);
		
		return checkQuestions.learnMore(learnMore, learnMoreID);
	}
	public String checkOptionLabels(int option) {
		WebElement optionLabel = driver.findElement(By.className(String.format(expression + option +"-radio-label", property)));
		String actualOptionLabel=optionLabel.getText();
		optionLabel.getAttribute("value");
		System.out.println("ATTRIBUTE----"+String.valueOf(option));
		System.out.println("TEXT----"+optionLabel.getText());
		return actualOptionLabel;
	}
	
	public MultiRadioOptions selectOption(int option) {
		radioButton = driver.findElement(By.id(String.format(expression
				+ option, property)));
		radioButton.click();
		return this;
	}

}
