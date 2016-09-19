package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * CheckBox_Tag: Selenium page model for CheckBox tag
 * 
 * @author:Orina
 */
public class Buttons extends BaseTag {

	protected String buttonExpression = "//span[contains(text(),'%s')]";
	protected WebElement button;

	public Buttons(WebDriver driver,String property) {
		super(driver,property);
		
	}

	public Buttons selectButton() {
	
		button = driver.findElement(By.xpath(String.format(buttonExpression,property)));
		button.click();
		return this;
	}

}
