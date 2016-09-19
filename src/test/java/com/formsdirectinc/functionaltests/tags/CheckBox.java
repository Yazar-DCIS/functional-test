package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * CheckBox_Tag: Selenium page model for CheckBox tag
 * 
 * @author:Orina
 */
public class CheckBox extends BaseTag {

	protected String checkExpression = "%s";
	protected String mulitCheckBoxExpression = "applicationData-%s.optionList[%d].value-";
	
	protected WebElement checkCheckBox;

	public CheckBox(WebDriver driver, String property) {
		super(driver, property);
		

	}

	public CheckBox check() {
		checkCheckBox = driver.findElement(By.id(String.format(checkExpression,
				property)));
		checkCheckBox.click();
		return this;
	}
	
	public CheckBox multipleCheckbox(int optionNumber) {
		checkCheckBox = driver.findElement(By.id(String.format(mulitCheckBoxExpression+optionNumber,
				property,optionNumber)));
		checkCheckBox.click();
		return this;
	}

	
}
