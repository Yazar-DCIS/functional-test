package com.formsdirectinc.qa;

import java.lang.reflect.Constructor;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.formsdirectinc.qa.driverprofile.FirefoxDriverProfile;
import com.formsdirectinc.qa.tags.SelectElement;
import com.formsdirectinc.qa.utils.CaptureScreen;

/**
 * @author Orina
 * @Step Rules for the methods that are used
 */

public abstract class TestBase {

	protected WebDriver driver;
	protected WebDriverWait wait;
	protected List<WebElement> applicationLink;
	protected String applicationID;
	private String productName;
	public TestBase nextStep;

	public TestBase(){
		
	}
	
	public TestBase(WebDriver driver){
		this.driver=driver;
	}
	
	
	public WebDriver getDriver() {
		return driver;
	}

	@BeforeTest
	@Parameters({"product" })
	public void startTest(String product) throws Exception {
		setTime();
		FirefoxDriverProfile profile = new FirefoxDriverProfile();
		driver =  new FirefoxDriver(profile.firefoxProfile(product));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@AfterTest
	@Parameters({"product","flowname"})
	public void endTest(String product,String flowname) {
		setTime();
		CaptureScreen snapShot = new CaptureScreen(driver);
		snapShot.takeScreenShot(product, flowname);
		driver.quit();
	}
	
	
	protected String parseApplicationID() {
		SelectElement element = new SelectElement(driver, "application-id");
		return element.getElementText("div", "class");
	}

	protected void clickOnStartApplicationLink(String productName,
			String applicationID) {

		applicationLink = driver.findElements(By.linkText("Start Application"));
		// applicationLink=driver.findElements(By.linkText("Continue"));

		String elementHref, applicationIDOnPage, productNameOnPage = null;

		for (WebElement hrefValue : applicationLink) {
			// Lists all the application that are in the Start Stage.
			elementHref = hrefValue.getAttribute("href");

			applicationIDOnPage = elementHref.substring(
					elementHref.indexOf("&applicationId") + 1,
					elementHref.indexOf("&stageId"));

			productNameOnPage = elementHref.substring(
					elementHref.indexOf("/") + 1,
					elementHref.indexOf("/stagemanager.do?"));

			System.out.println(applicationIDOnPage + ":" + productNameOnPage);

			if (applicationIDOnPage.contains(applicationID)
					|| productNameOnPage.contains(productName)) {
				// Clicks on the given application -ID Start Application Link
				hrefValue.click();
				break;
			}

		}

	}

	public void setTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date));
		Logger logger = Logger.getLogger("Script Time : ");
		logger.info(dateFormat.format(date));
	}
	
	public String siteURL() {
		return System.getProperty("site.url");
	}

	public String getApplicationID() {
		return applicationID;
	}

	public void setApplicationID(String applicationID) {
		this.applicationID = applicationID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	
	public TestBase createStep(WebDriver driver,String classNames)throws Exception {
		Class<?> stepClass = Class.forName(String.format(classNames));
		Constructor<?> stepContructor=stepClass.getConstructor(WebDriver.class);
		return (TestBase)stepContructor.newInstance(driver);

	}
	
	public void setNextStep(TestBase nextStep) {
		this.nextStep = nextStep;
	}

	public void executeEQTest(String sitename,String siteurl,String product, String flowname)
					throws Exception
	{
		if (nextStep != null) {
			nextStep.eqtest(sitename, siteurl, product, flowname);
		}
	}
	
	public void executeLoginTest(String sitename,String siteurl,String username, String password)
			throws Exception
	{
		if (nextStep != null) {
			nextStep.logintest(sitename, siteurl, username, password);
		}
	}
	
	public void executeRegistrationTest(String sitename,String siteurl,String product, 
								String username,String password,String flowname)throws Exception
	{
		if (nextStep != null) {
			nextStep.registrationtest(sitename, siteurl, product, username,password,flowname);
		}
	}

	public void executePaymentTest(String sitename,String siteurl,String product, 
			String username,String password)throws Exception
	{
		if (nextStep != null) {
			nextStep.paymenttest(sitename, siteurl, product, username,password);
		}
	}
	
	
	public void executeSQTest(String sitename,String siteurl, String product, String username,
			String password, String flowname, String applicationID)
					throws Exception
	{
		if (nextStep != null) {
			nextStep.sqtest(sitename, siteurl, product, username, password, flowname, applicationID);
		}
	}
	
		
	public abstract void eqtest(String sitename,String siteurl, String product, 
									String flowname)throws Exception;
	
	public abstract void logintest(String sitename,String siteurl, String username, 
			String password)throws Exception;
	
	public abstract void registrationtest(String sitename,String siteurl, String product,
											String emailID,String password,String flowname)throws Exception;
	
	public abstract void paymenttest(String sitename,String siteurl, String product,
			String emailID,String password)throws Exception;
	
	public abstract void sqtest(String sitename,String siteurl, String product, String username,
			String password, String flowname, String applicationID) throws Exception;
	
	
}