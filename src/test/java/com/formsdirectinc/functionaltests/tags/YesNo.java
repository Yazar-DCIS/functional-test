package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * YesNo: Selenium page model for YesNo tag
 * Author: <a href="mailto:hari@dcis.net">Hari Selvarajan</a> Date: 6/21/15 4:18 PM
 * Revision: $Rev$
 */
public class YesNo extends BaseTag {
	protected String noExpression = "%s.no";
	protected String yesExpression = "%s.yes";
	protected String expainExpression = "%s.explain";

	protected WebElement noRadioButton;
	protected WebElement yesRadioButton;
	protected WebElement explainTextArea;

	public YesNo(WebDriver driver, String property) {
		super(driver, property);
		noRadioButton = driver.findElement(By.id(String.format(noExpression,
				property)));
		yesRadioButton = driver.findElement(By.id(String.format(yesExpression,
				property)));

	}

	public YesNo yes() {
		yesRadioButton.click();
		return this;
	}

	public YesNo no() {
		noRadioButton.click();
		return this;
	}

	
	public YesNo setYesOrNo(String answer) {
		
		if(answer.equalsIgnoreCase("Yes"))
		{
			yes();
		}
		else if(answer.equalsIgnoreCase("No"))
		{
			no();
		}
		
		return this;
	}
	
	
	public YesNo setExplaination(String explainWhy) {
		explainTextArea=driver.findElement(By.id(String.format(expainExpression,
				property)));
		explainTextArea.sendKeys(explainWhy);
		return this;
	}
	
	
	public String questionText() {
		WebElement div = driver.findElement(By.xpath("//input[@name='"
				+ property + "']/../../div[@class='label']"));
		return div.getText();
	}

	public boolean isYes() {
		return yesRadioButton.isSelected();
	}

	public boolean isNo() {
		return noRadioButton.isSelected();
	}
}
