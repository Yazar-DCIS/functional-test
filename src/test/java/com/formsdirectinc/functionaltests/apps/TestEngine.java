package com.formsdirectinc.functionaltests.apps;

import java.lang.reflect.Constructor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.utils.FirefoxDriverProfile;

/**
 * @author Orina
 * @MainClass Decides which Class(ie -Decides on Product) has to be executed
 *            with their respective Eligibility/Registration/Payment/Simple
 *            Questions
 */
public class TestEngine {


	public static final String CLASS_NAME_FR = "com.formsdirectinc.functionaltests.apps.%s.%s.%s";
	public static final String CLASS_NAME = "com.formsdirectinc.functionaltests.apps.%s.%s";
	public static final String PACKAGE_NAME = "com.formsdirectinc.functionaltests.apps";
	public static final String TESTNG_LOG="Executing the test for %s for the product %s and flow name as %s in the site %s";
		
	@Test
	@Parameters({ "product", "flowname" })
	public void start(String product, String flowname) throws Exception {

		System.out.println(this.getClass().getSimpleName());
		FirefoxDriverProfile profile=new FirefoxDriverProfile();
		
		WebDriver driver = new FirefoxDriver(profile.firefoxProfile(product));
		
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		String productName = Products.valueOf(product.toUpperCase()).name()
				.toLowerCase();

		Sites site = Sites.valueOf(System.getProperty("site.name"));
		Step step = null;
		String[] stepNames;
		String stepsToExceute=System.getProperty("test");
		String defaultSteps="EligiblityQuestions,Registration,Payment,SimpleQuestions";

		if(stepsToExceute==null)
		{
			stepNames = defaultSteps.split(",");
		}
		else
		{
			stepNames = stepsToExceute.split(",");
		}

		for (String stepToRun : stepNames) {

			if(stepToRun.contains(PACKAGE_NAME))
			{
				step= createStep(driver, stepToRun);
			}
			
			else if((stepToRun.equals("Registration")||stepToRun.equals("Payment")
					||stepToRun.equals("Login")||stepToRun.equals("DVD")))
			{
				step= createStep(driver, String.format(CLASS_NAME, stepToRun.toLowerCase(),stepToRun));
			}
			
			else if(stepToRun.equals("Discountpayment"))
					{
				         	step= createStep(driver, String.format(CLASS_NAME, stepToRun.toLowerCase(),stepToRun));
						
					}

			else
			{
				step= createStep(driver, String.format(CLASS_NAME, productName,stepToRun));
			}

			Reporter.log("<br><b>"+String.format(TESTNG_LOG,stepToRun,productName,flowname,site)+"<br><b>");

			step.setNextStep(step);
			step.executeNextStep(productName, flowname);
			
		}
		driver.quit();
	}

	private Step createStep(WebDriver driver, String classNames)
			throws Exception {
		Class<?> stepClass = Class.forName(String.format(classNames));
		Constructor<?> constructor = stepClass.getConstructor(WebDriver.class);
		return (Step) constructor.newInstance(driver);
	}



}
