package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * DisabilitiesInfo: Selenium page model for DisabilitiesInfo
 * 
 * @author:Orina 
 *        <br> Date: 3/14/16
 */

public class DisabilitiesInfo extends BaseTag {

	protected String sightDisabilityExpression = "%s.sightDisability";
	protected String hearingImpairedExpression="%s.hearingImpaired";
	protected String otherDisabilityExpression="%s.otherDisability";
	
	protected String sightDisabilityExpression1 = "%s.sightImpairedAccomodationDetail";
	protected String hearingImpairedExpression1="%s.hearingImpairedAccommodationDetail";
	protected String otherDisabilityExpression1="%s.otherDisabilityAccomodationDetail";
	
	WebElement disablityInfo;
	
	public DisabilitiesInfo(WebDriver driver, String property) {
		super(driver, property);

	}

	public DisabilitiesInfo setSightDisability(String sightDisability) {
		disablityInfo = driver.findElement(By.id(String.format(sightDisabilityExpression, property)));
		disablityInfo.sendKeys(sightDisability);
		return this;
	}

	public DisabilitiesInfo setHearingImpaired(String hearingImpaired) {
		disablityInfo = driver.findElement(By.id(String.format(hearingImpairedExpression, property)));
		disablityInfo.sendKeys(hearingImpaired);
		return this;
	}

	public DisabilitiesInfo setOtherDisability(String otherDisability) {
		disablityInfo = driver.findElement(By.id(String.format(otherDisabilityExpression, property)));
		disablityInfo.sendKeys(otherDisability);
		return this;
	}
	
	public DisabilitiesInfo setSightDisabilityAccomodation(String sightDisability) {
		disablityInfo = driver.findElement(By.id(String.format(sightDisabilityExpression1, property)));
		disablityInfo.sendKeys(sightDisability);
		return this;
	}

	public DisabilitiesInfo setHearingImpairedAccomodation(String hearingImpaired) {
		disablityInfo = driver.findElement(By.id(String.format(hearingImpairedExpression1, property)));
		disablityInfo.sendKeys(hearingImpaired);
		return this;
	}

	public DisabilitiesInfo setOtherDisabilityAccomodation(String otherDisability) {
		disablityInfo = driver.findElement(By.id(String.format(otherDisabilityExpression1, property)));
		disablityInfo.sendKeys(otherDisability);
		return this;
	}
	
}
