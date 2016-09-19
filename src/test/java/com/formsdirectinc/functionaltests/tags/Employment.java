package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * Employment: Employment Details
 
 * @author Orina <br> Date: 3/10/16
 
 * Revision: $Rev$
 */
public class Employment extends BaseTag {

	private DateTag employmentDates;
	private Address employerAddress;
	private Employment employerInformation;
	private YesNo currentOccupation;
	
	protected String employerNameExpression = "%s.employerName";
	protected String employerOccupationExpression = "%s.occupation";
	protected String selfEmployerExpression = "%s.selfemployedAs";
	protected String retiredEmployerExpression = "%s.retiredFrom";
	protected String officeOfUSCISAppliedExpression="%s.USCISOfficeApplied";
	protected String resultOfApplicationExpression="%s.resultOfApplication";

	protected WebElement employerInfo;
	
	public Employment(WebDriver driver) {
		super(driver);
	}

	public Employment(WebDriver driver,String property) {
		super(driver,property);
	}
	
	public Employment setEmployerName(String employeeName) {
		employerInfo = driver.findElement(By.id(String.format(
				employerNameExpression, property)));
		employerInfo.sendKeys(employeeName);
		return this;
	}

	public Employment setEmployerOccupation(String employeeOccupation) {
		employerInfo = driver.findElement(By.id(String.format(
				employerOccupationExpression, property)));
		employerInfo.sendKeys(employeeOccupation);
		return this;
	}
	
	public Employment setSelfEmployerInfo(String selfEmployerInfo) {
		employerInfo = driver.findElement(By.id(String.format(
				selfEmployerExpression, property)));
		employerInfo.sendKeys(selfEmployerInfo);
		return this;
	}
	
	public Employment setRetiredEmployerInfo(String retiredEmployerInfo) {
		employerInfo = driver.findElement(By.id(String.format(
				retiredEmployerExpression, property)));
		employerInfo.sendKeys(retiredEmployerInfo);
		return this;
	}
	
	public Employment setUSCISOfficeAppliedInfo(String office) {
		employerInfo = driver.findElement(By.id(String.format(
				officeOfUSCISAppliedExpression, property)));
		employerInfo.sendKeys(office);
		return this;
	}
	
	public Employment setResultsOfApplicationInfo(String results) {
		employerInfo = driver.findElement(By.id(String.format(
				resultOfApplicationExpression, property)));
		employerInfo.sendKeys(results);
		return this;
	}
	public Employment employmentInformation(String elementProperty,String appname,
											String isThisCurrentOccupation,
											String occupationCountry) {
		
		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		employerInformation =new Employment(driver, "applicationData-"+ elementProperty);
		employerInformation.setEmployerName(data.getProperty(elementProperty+".employerName"));
		employerInformation.setEmployerOccupation(data.getProperty(elementProperty+".occupation"));
		
		employerAddress = new Address(driver, "applicationData-"+elementProperty+".employerAddress");
		
		if(occupationCountry.equalsIgnoreCase("USA"))
		{
			employerAddress.setCountryField(data.getProperty(elementProperty+".employerAddress.countryUSA"));
			employerAddress.setApartmentTypeAndNumber(data.getProperty(elementProperty+".employerAddress.aptName"), 
					data.getProperty(elementProperty+".employerAddress.aptNum"));
			employerAddress.setState(data.getProperty(elementProperty+".employerAddress.state"));
		}
		else if(!occupationCountry.equalsIgnoreCase("USA"))
		{
			employerAddress.setCountryField(data.getProperty(elementProperty+".employerAddress.country"));
		}
		employerAddress.setStreet(data.getProperty(elementProperty+".employerAddress.street"));
		employerAddress.setCity(data.getProperty(elementProperty+".employerAddress.city"));
		employerAddress.setZipcode(data.getProperty(elementProperty+".employerAddress.zipcode"));
		
		currentOccupation=new YesNo(driver, elementProperty+".presentJob");
			if(isThisCurrentOccupation.equalsIgnoreCase("yes"))
			{
				currentOccupation.yes();
				
				employmentDates =new DateTag(driver, elementProperty+".dateRange");
				employmentDates.setStartDay(data.getProperty(elementProperty+".dateRange.fromDate"));
				employmentDates.setStartMonth(data.getProperty(elementProperty+".dateRange.fromMonth"));
				employmentDates.setStartYear(data.getProperty(elementProperty+".dateRange.fromYear"));
			}
			else if(isThisCurrentOccupation.equalsIgnoreCase("no"))
			{
				currentOccupation.no();
				
				employmentDates =new DateTag(driver, elementProperty+".dateRange");
				employmentDates.setStartDay(data.getProperty(elementProperty+".dateRange.fromDate"));
				employmentDates.setStartMonth(data.getProperty(elementProperty+".dateRange.fromMonth"));
				employmentDates.setStartYear(data.getProperty(elementProperty+".dateRange.fromYear"));
				
				employmentDates.setEndDay(data.getProperty(elementProperty+".dateRange.toDate"));
				employmentDates.setEndMonth(data.getProperty(elementProperty+".dateRange.toMonth"));
				employmentDates.setEndYear(data.getProperty(elementProperty+".dateRange.toYear"));
			}
	
		
		return this;
	}

	

	public Employment employmentAuthorizationInformation(String elementProperty,String appname,
			int workAuthorizationCount) {

		PropertyResource propertyFile=new PropertyResource();
		Properties data = propertyFile.loadProperty(appname);

		for(int i=0;i<workAuthorizationCount;i++)
		{

			employerInformation =new Employment(driver, "applicationData-"+ elementProperty+"["+i+"]");
			employerInformation.setUSCISOfficeAppliedInfo(data.getProperty(elementProperty+"["+i+"].USCISOfficeApplied"));
			employerInformation.setResultsOfApplicationInfo(data.getProperty(elementProperty+"["+i+"].resultOfApplication"));

			employmentDates = new DateTag(driver, elementProperty+"["+i+"].dateApplied");
			employmentDates.selectDate(data.getProperty(elementProperty+"["+i+"].dateApplied"));

			if (i < workAuthorizationCount - 1) {
				CommonInputClasses addAnotherWorkAuthorization=new CommonInputClasses(driver);
				addAnotherWorkAuthorization.addAnother();
			}

		}
		return this;
	}
	
}
