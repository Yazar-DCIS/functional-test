package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Gender_Tag: Selenium page model for Gender tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class Gender extends BaseTag {

	protected String maleExpression = "%s.male";
	protected String femaleExpression = "%s.female";

	protected WebElement maleRadioButton;
	protected WebElement femaleRadioButton;

	public Gender(WebDriver driver, String property) {
		super(driver, property);

	}

	public Gender setGenderAsMale() {
		maleRadioButton = driver.findElement(By.id(String.format(
				maleExpression, property)));
		maleRadioButton.click();
		return this;
	}

	public Gender setGenderAsFemale() {
		femaleRadioButton = driver.findElement(By.id(String.format(
				femaleExpression, property)));
		femaleRadioButton.click();
		return this;
	}

	public Gender setGender(String answer) {
		if(answer.equalsIgnoreCase("Female"))
		{
			setGenderAsFemale();
		}
		else if(answer.equalsIgnoreCase("Male"))
		{
			setGenderAsMale();
		}
		return this;
	}
	
}
