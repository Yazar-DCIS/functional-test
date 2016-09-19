package com.formsdirectinc.functionaltests.tags;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * HeightOptions_Tag: Selenium page model for Height tag
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class PhysicalTraits extends BaseTag {

	protected String heightInFeetExpression = "%s-%s.feet";
	protected WebElement heightInFeet;
	protected String heightInInchesExpression = "%s-%s.inches";
	protected WebElement heightInInches;

	protected String heightInFeetExpression_i90 = "%s.feet";
	protected WebElement heightInFeet_i90;
	protected String heightInInchesExpression_i90 = "%s.inches";
	protected WebElement heightInInches_i90;
	protected String weightInPoundsExpression = "%s.pounds";
	protected WebElement weightInPounds;

	protected String heightInCentimeterExpression = "%s-%s.centimeters";
	protected WebElement heightInCentimeter;
	protected String heightOptionExpression = "%s";
	protected List<WebElement> heightOptionButton;

	public PhysicalTraits(WebDriver driver, String beanName, String property) {
		super(driver, beanName, property);

	}

	public PhysicalTraits(WebDriver driver) {
		super(driver);

	}
	
	public PhysicalTraits selectHeightinFeet(String feet) {
		heightInFeet = driver.findElement(By.id(String.format(
				heightInFeetExpression, beanName, property)));
		heightInFeet.sendKeys(feet);
		return this;
	}
	
	public PhysicalTraits selectHeightinFeetN400(String feet) {
		heightInFeet = driver.findElement(By.id(String.format(
				heightInFeetExpression, beanName, property)));
		heightInFeet.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		heightInFeet.clear();
		heightInFeet.sendKeys(feet);
		return this;
	}
	
	public PhysicalTraits selectHeightinInches(String inch) {
		heightInInches = driver.findElement(By.id(String.format(
				heightInInchesExpression, beanName, property)));
		heightInInches.sendKeys(inch);
		return this;
	}

	public PhysicalTraits selectHeightinFeet_i90(String feet) {
		heightInFeet_i90 = driver.findElement(By.id(String.format(
				heightInFeetExpression_i90, property)));
		heightInFeet_i90.sendKeys(feet);
		return this;
	}

	public PhysicalTraits selectHeightinInches_i90(String inch) {
		heightInInches_i90 = driver.findElement(By.id(String.format(
				heightInInchesExpression_i90, property)));
		heightInInches_i90.sendKeys(inch);
		return this;
	}

	public PhysicalTraits setHeightinFeet(String feet) {
		heightInFeet = driver.findElement(By.id(String.format(
				heightInFeetExpression, beanName, property)));
		heightInFeet.clear();
		heightInFeet.sendKeys(feet);
		return this;
	}

	public PhysicalTraits setWeightinPounds(String pounds) {
		weightInPounds = driver.findElement(By.id(String.format(
				weightInPoundsExpression, property)));
		weightInPounds.clear();
		weightInPounds.sendKeys(pounds);
		return this;
	}

	public PhysicalTraits setHeightinInches(String inch) {
		heightInInches = driver.findElement(By.id(String.format(
				heightInInchesExpression, beanName, property)));
		heightInInches.clear();
		heightInInches.sendKeys(inch);
		return this;
	}

	public PhysicalTraits setHeightinCentimetre(String cms) {
		heightInCentimeter = driver.findElement(By.id(String.format(
				heightInCentimeterExpression, beanName, property)));
		heightInCentimeter.clear();
		heightInCentimeter.sendKeys(cms);
		return this;
	}

	public PhysicalTraits heightEnglish() {
		heightOptionButton = driver.findElements(By.name(String.format(
				heightOptionExpression, property)));
		heightOptionButton.get(0).click();
		return this;
	}

	public PhysicalTraits heightMetric() {
		heightOptionButton = driver.findElements(By.name(String.format(
				heightOptionExpression, property)));
		heightOptionButton.get(1).click();
		return this;
	}
	
	public PhysicalTraits setRaceOptions(String elementID,String raceType)
	{
		String raceValues=raceType;
		for(String raceTypeSelect:raceValues.split(",")) {
			MultiRadioOptions race = new MultiRadioOptions(driver,"applicationData-"+elementID+".raceList["+raceTypeSelect+"].race");
			race.selectOption(Integer.parseInt(raceTypeSelect));
		}
		return this;
	}
}
