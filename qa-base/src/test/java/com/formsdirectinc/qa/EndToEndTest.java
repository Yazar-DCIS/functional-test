package com.formsdirectinc.qa;

import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;

/**
 * @author Orina
 * @MainClass Decides which Class(ie -Decides on Product) has to be executed
 *            with their respective Eligibility/Registration/Payment/Simple
 *            Questions
 */
public class EndToEndTest extends TestBase{

	
	public static final String CLASS_NAME = "com.formsdirectinc.qa.app.%s.%s";
	public static final String TESTNG_LOG = "Executing the test for %s for the product %s and flow name as %s in the site %s";

	@Test
	@Parameters({ "sitename","siteurl","product","flowname","username","password","applicationID" })
	public void start(String sitename,String siteurl,String product, String flowname,
			String username,String password,String applicationID) throws Exception {

		System.out.println(this.getClass().getSimpleName());
		String productName = Products.valueOf(product.toUpperCase()).name()
				.toLowerCase();
		
		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}
		TestBase step = null;
		
		String[] stepNames;
		String stepsToExceute = System.getProperty("test");
		String defaultSteps = "EligibilityQuestionsTest,RegistrationTest,PaymentTest,SimpleQuestionsTest";

		if (stepsToExceute == null) {
			stepNames = defaultSteps.split(",");
		} else {
			stepNames = stepsToExceute.split(",");
		}

		for (String stepToRun : stepNames) {

			if ((stepToRun.equals("RegistrationTest")|| stepToRun.equals("PaymentTest") 
														|| stepToRun.equals("LoginTest"))) {
				step=createStep(driver, String.format(CLASS_NAME,
						stepToRun.toLowerCase().replace("test", ""), stepToRun));
				step.setNextStep(step);
				
				if(stepToRun.equals("LoginTest"))
				{
					step.executeLoginTest(sitename, siteurl,username, password);
				}else if(stepToRun.equals("RegistrationTest"))
				{
					step.executeRegistrationTest(sitename, siteurl, productName, username, password,flowname);
				}
				else if(stepToRun.equals("PaymentTest")){
					step.executePaymentTest(sitename, siteurl, productName, username, password);
				}
			}

			else{
				step=createStep(driver,String.format(CLASS_NAME, productName, stepToRun));
				step.setNextStep(step);
				
				if(stepToRun.equals("EligibilityQuestionsTest")){
					step.executeEQTest(sitename, siteurl, productName, flowname);
				}
				else if(stepToRun.equals("SimpleQuestionsTest"))
				{
					step.executeSQTest(sitename, siteurl, productName, username, password, flowname, applicationID);
				}
				
				
			}

			Reporter.log("<br><b>"+ String.format(TESTNG_LOG, stepToRun, productName,
							flowname, site) + "<br><b>");

			

		}
		driver.quit();
	}

	@Override
	public void eqtest(String sitename, String siteurl, String product,
			String flowname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logintest(String sitename, String siteurl, String username,
			String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

	@Override
	public void sqtest(String sitename, String siteurl, String product,
			String username, String password, String flowname,
			String applicationID) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrationtest(String sitename, String siteurl,
			String product, String emailID, String password, String flowname)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paymenttest(String sitename, String siteurl, String product,
			String emailID, String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

	

}
