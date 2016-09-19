package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * ClassOfAdmission: Selenium page model for ClassOfAdmission
 * 
 * @author:Orina <br> Date: 3/14/16
 */

public class ClassOfAdmission extends BaseTag {

	protected String mannerExpression = "%s.manner";
	protected String currentStatusExpression="%s.currentStatus";
	protected String validIndefinitelyExpression="%s.validIndefinitely";
	WebElement classOfAdmissionInfo;
	
	public ClassOfAdmission(WebDriver driver, String property) {
		super(driver, property);

	}

	public ClassOfAdmission setClassOfAdmissionManner(String answer) {
		classOfAdmissionInfo = driver.findElement(By.name(String.format(mannerExpression, property)));
		classOfAdmissionInfo.sendKeys(answer);
		return this;
	}

	public ClassOfAdmission setClassOfAdmissionCurrentStatus(String answer) {
		classOfAdmissionInfo = driver.findElement(By.name(String.format(currentStatusExpression, property)));
		classOfAdmissionInfo.sendKeys(answer);
		return this;
	}

	public ClassOfAdmission setClassOfAdmissionValidity() {
		classOfAdmissionInfo = driver.findElement(By.name(String.format(validIndefinitelyExpression, property)));
		classOfAdmissionInfo.click();
		return this;
	}
	
}
