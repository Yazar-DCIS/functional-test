package com.formsdirectinc.functionaltests.tags;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @author Orina<br>
 *         For fields that have different element values
 */
public class AdditionalInfoFields extends BaseTag {

	protected String passportNumberExpression = "%s.passportNumber";
	protected String documentNameExpression = "%s.documentName";
	protected String travelDocNumberExpression = "%s.travelNumber";
	protected String visaNumberExpression = "%s.visaNumber";
	protected String mannerExpression = "%s.manner";
	protected String currentStatusExpression = "%s.currentStatus";
	protected String officeAppliedExpression = "%s.officeApplied";
	protected String finalDecisionExpression = "%s.finalDecision";
	protected String generalTextExpression = "%s";
	protected String otherStatusExplaination = "%s";

	protected String cityLivedAdjStatusFieldExpression="%s.cityLivedAdjustmentOfStatus";
	protected String uscisOfficeFieldExpression="%s.uscisOffice";
	protected String cityLivedImmigrantFieldExpression="%s.cityLivedAsImmigrant";
	protected String consulateVisaFieldExpression="%s.consulateVisaIssued";
	
	
	protected String naturalizationNumberExpression = "%s.number";
	protected String naturalizationDateExpression = "%s.dateIssued";
	protected String naturalizationPlaceExpression = "%s.placeIssued";
	protected WebElement naturalizationInformation;

	protected WebElement passportNumberField;
	protected WebElement travelNumberField;
	protected WebElement documentNameField;
	protected WebElement visaNumberField;

	protected WebElement maritalStatusField;
	protected WebElement otherStatusExplain;
	protected WebElement generalTextField;

	protected WebElement immigrationInformation;
	
	public AdditionalInfoFields(WebDriver driver, String property) {
		super(driver, property);

	}

	
	public AdditionalInfoFields isStatusOther(String explain) {
		otherStatusExplain = driver.findElement(By.id(String.format(
				otherStatusExplaination, property)));
		otherStatusExplain.clear();
		otherStatusExplain.sendKeys(explain);
		return this;
	}

	public AdditionalInfoFields passportNumber(String passportNum) {
		passportNumberField = driver.findElement(By.id(String.format(
				passportNumberExpression, property)));
		passportNumberField.clear();
		passportNumberField.sendKeys(passportNum);
		return this;
	}

	public AdditionalInfoFields travelDocNumber(String travelNumber) {
		travelNumberField = driver.findElement(By.id(String.format(
				travelDocNumberExpression, property)));
		travelNumberField.clear();
		travelNumberField.sendKeys(travelNumber);
		return this;
	}

	public AdditionalInfoFields setVisaNumber(String visaNumber) {
		visaNumberField = driver.findElement(By.id(String.format(
				visaNumberExpression, property)));
		visaNumberField.clear();
		visaNumberField.sendKeys(visaNumber);
		return this;
	}

	public AdditionalInfoFields documentName(String docName) {
		documentNameField = driver.findElement(By.id(String.format(
				documentNameExpression, property)));
		documentNameField.clear();
		documentNameField.sendKeys(docName);
		return this;
	}

	public AdditionalInfoFields normalText(String docName) {
		generalTextField = driver.findElement(By.id(String.format(
				generalTextExpression, property)));
		generalTextField.sendKeys(docName);
		return this;
	}

	public AdditionalInfoFields setOfficeApplied(String office) {
		generalTextField = driver.findElement(By.id(String.format(
				officeAppliedExpression, property)));
		generalTextField.clear();
		generalTextField.sendKeys(office);
		return this;
	}

	public AdditionalInfoFields setFinalDecision(String finalDecision) {
		generalTextField = driver.findElement(By.id(String.format(
				finalDecisionExpression, property)));
		generalTextField.clear();
		generalTextField.sendKeys(finalDecision);
		return this;
	}

	public AdditionalInfoFields setLastEntryManner(String manner) {
		generalTextField = driver.findElement(By.id(String.format(
				mannerExpression, property)));
		Select generalTextDDM = new Select(generalTextField);
		generalTextDDM.selectByValue(manner);
		return this;
	}

	public AdditionalInfoFields setCurrentStatus(String currentStatus) {
		generalTextField = driver.findElement(By.id(String.format(
				currentStatusExpression, property)));
		generalTextField.clear();
		generalTextField.sendKeys(currentStatus);
		return this;
	}

	public AdditionalInfoFields textDDM(String docName) {
		generalTextField = driver.findElement(By.id(String.format(
				generalTextExpression, property)));
		generalTextField.sendKeys(docName);
		return this;
	}

	public AdditionalInfoFields selectDDM(String docName) {
		generalTextField = driver.findElement(By.id(String.format(
				generalTextExpression, property)));
		Select generalTextDDM = new Select(generalTextField);
		generalTextDDM.selectByValue(docName);
		return this;
	}

	public AdditionalInfoFields selectDDM_Number(Integer docName) {
		generalTextField = driver.findElement(By.id(String.format(
				generalTextExpression, property)));
		Select generalTextDDM = new Select(generalTextField);
		generalTextDDM.selectByIndex(docName);
		return this;
	}

	public AdditionalInfoFields setNumber(String number) {
		naturalizationInformation = driver.findElement(By.name(String.format(
				naturalizationNumberExpression, property)));
		naturalizationInformation.sendKeys(number);
		return this;
	}

	public AdditionalInfoFields setIssuedDate(String date) {
		naturalizationInformation = driver.findElement(By.name(String.format(
				naturalizationDateExpression, property)));
		naturalizationInformation.sendKeys(date);
		return this;
	}

	public AdditionalInfoFields setIssuedPlace(String place) {
		naturalizationInformation = driver.findElement(By.name(String.format(
				naturalizationPlaceExpression, property)));
		naturalizationInformation.sendKeys(place);
		return this;
	}

	
	public AdditionalInfoFields setCityLivedAdjustmentOfStatus(String place) {
		immigrationInformation = driver.findElement(By.id(String.format(
				cityLivedAdjStatusFieldExpression, property)));
		immigrationInformation.sendKeys(place);
		return this;
	}
	
	public AdditionalInfoFields setConsulateVisaIssued(String place) {
		immigrationInformation = driver.findElement(By.id(String.format(
				consulateVisaFieldExpression, property)));
		immigrationInformation.sendKeys(place);
		return this;
	}
	
	public AdditionalInfoFields setCityLivedAsImmigrant(String place) {
		immigrationInformation = driver.findElement(By.id(String.format(
				cityLivedImmigrantFieldExpression, property)));
		immigrationInformation.sendKeys(place);
		return this;
	}
	
	public AdditionalInfoFields setUSCISOffice(String place) {
		immigrationInformation = driver.findElement(By.id(String.format(
				uscisOfficeFieldExpression, property)));
		immigrationInformation.sendKeys(place);
		return this;
	}
}