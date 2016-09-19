package com.formsdirectinc.functionaltests.tags;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.utils.PropertyResource;

/**
 * CrimeDetails : CrimeDetails 
 
 * @author Orina <br> Date: 3/14/16
 
 * Revision: $Rev$
 */
public class CrimeDetails extends BaseTag {


	protected String crimeInfo = "%s";
	protected String crime = "%s.yesno";
	protected String crimeExplaination = "applicationData-%s";
	protected String crimeExplain = "applicationData-%s.explain";
	protected String periodOfYears = "applicationData-%s.periodOfYears";
	protected String periodOfMonths = "applicationData-%s.periodOfMonths";
	protected String periodOfDays = "applicationData-%s.periodOfDays";
	
	
	public CrimeDetails(WebDriver driver) {
		super(driver);
	}
	
	public CrimeDetails(WebDriver driver,String property) {
		super(driver,property);
	}
	
	public CrimeDetails informationRelatedToCrime(String appname,String elementProperty,String anyCrimes) {

		PropertyResource propertyFile=new PropertyResource();
		Properties appName = propertyFile.loadProperty(appname);
		
		YesNo crimeDone = new YesNo(driver,String.format(crime, elementProperty));
		
		if(anyCrimes.equalsIgnoreCase("Yes"))
		{
			crimeDone.yes();
			
			SelectElement explainWhy=new SelectElement(driver, String.format(crimeExplain, elementProperty));
			explainWhy.sendValuesUsingElementID(appName.getProperty(elementProperty));
			
		}
		else if(anyCrimes.equalsIgnoreCase("No"))
		{
			crimeDone.no();
		}
	
		return this;
	}

	public CrimeDetails informationOnCrimeWithoutExplain(String elementProperty,String anyCrimes) {

		YesNo crimeDone = new YesNo(driver,String.format(crimeInfo, elementProperty));
		
		if(anyCrimes.equalsIgnoreCase("Yes"))
		{
			crimeDone.yes();
		}
		else if(anyCrimes.equalsIgnoreCase("No"))
		{
			crimeDone.no();
		}
	
		return this;
	}
	
	public CrimeDetails yearsSpentInPrison(String years)
	{
		SelectElement yearsSpentInPrison=new SelectElement(driver, String.format(periodOfYears, property));
		yearsSpentInPrison.sendValuesUsingElementID(years);
		
		return this;
	}
	
	public CrimeDetails monthsSpentInPrison(String months)
	{
		SelectElement monthsSpentInPrison=new SelectElement(driver, String.format(periodOfMonths, property));
		monthsSpentInPrison.sendValuesUsingElementID(months);
		return this;
	}
	
	public CrimeDetails daysSpentInPrison(String days)
	{
		SelectElement daysSpentInPrison=new SelectElement(driver, String.format(periodOfDays, property));
		daysSpentInPrison.sendValuesUsingElementID(days);
		return this;
	}
	
}
