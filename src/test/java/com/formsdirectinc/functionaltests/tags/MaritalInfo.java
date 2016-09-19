package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * MaritalInfo: Selenium page model for MaritalInformation
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class MaritalInfo extends BaseTag {

	protected String placeOfMarriageExpression = "%s.placeMarried";
	protected String maritalStatusExpression = "%s.status";
	
	WebElement maritalInfo;
	
	public MaritalInfo(WebDriver driver, String property) {
		super(driver, property);

	}

	public MaritalInfo setPlaceOfMarriage(String answer) {
		maritalInfo = driver.findElement(By.name(String.format(placeOfMarriageExpression, property)));
		maritalInfo.sendKeys(answer);
		return this;
	}

	public MaritalInfo setMarriageStatus(String answer) {
		maritalInfo = driver.findElement(By.id(String.format(maritalStatusExpression, property)));
		
		Select maritalSelect = new Select(maritalInfo);
		maritalSelect.selectByValue(answer);
		
		return this;
	}
	
	public MaritalInfo setMarriageStatusByName(String answer) {
		maritalInfo = driver.findElement(By.name(String.format(maritalStatusExpression, property)));
		
		Select maritalSelect = new Select(maritalInfo);
		maritalSelect.selectByValue(answer);
		
		return this;
	}
}
