package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * DropDown: Selenium page model for DropDown tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */
public class DropDown extends BaseTag {

	protected String ddmExpression = "%s";
	protected WebElement dropDown;
	protected String childrenCountExpression="%s.numberOfDependentChildren";
	protected String othersCountExpression="%s.numberOfOtherDependent";
	protected String sponsorsCountExpression="%s.numberOfSponsoredOthers";
	
	
	public DropDown(WebDriver driver, String property) {
		super(driver, property);

	}

	public DropDown selectValue(String value) {
		dropDown = driver.findElement(By.id(String.format(ddmExpression,
				property)));
		Select valueSelect = new Select(dropDown);
		valueSelect.selectByValue(value);

		return this;
	}

	public DropDown sendValue(String value) {
		dropDown = driver.findElement(By.id(String.format(ddmExpression,
				property)));
		dropDown.sendKeys(value);
		return this;
	}

	public DropDown setNumberOfChildren(String value) {
		dropDown = driver.findElement(By.id(String.format(childrenCountExpression,
				property)));
		Select valueSelect = new Select(dropDown);
		valueSelect.selectByValue(value);
		return this;
	}
	
	public DropDown setNumberOfOtherDependent(String value) {
		dropDown = driver.findElement(By.id(String.format(othersCountExpression,
				property)));
		Select valueSelect = new Select(dropDown);
		valueSelect.selectByValue(value);
		return this;
	}
	
	public DropDown setNumberOfSponsoredOthers(String value) {
		dropDown = driver.findElement(By.id(String.format(sponsorsCountExpression,
				property)));
		Select valueSelect = new Select(dropDown);
		valueSelect.selectByValue(value);
		return this;
	}
}
