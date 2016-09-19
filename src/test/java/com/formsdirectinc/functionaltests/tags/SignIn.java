package com.formsdirectinc.functionaltests.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.enums.Sites;

/**
 * Sign UP: Selenium page Model for Register And Payment Controls
 * 
 * @author Orina
 * @Date: 04/03/2016
 */
public class SignIn extends BaseTag {

	String signInExpressionCore = "//a[contains(text(),'Sign In')]";
	String signInEsExpressionCore = "//a[contains(text(),'Inicie sesión')]";
	
	String signInExpressionAIC =  "//span[contains(text(),'Sign in now!')]";
	String signInEsExpressionAIC =  "//span[contains(text(),'Iniciar sesión ahora!')]";
	
	String signInExpressionUSC =  "//span[contains(text(),'Sign in now!')]";
	String signInEsExpressionUSC =  "//span[contains(text(),'Iniciar sesión ahora!')]";
	
	String signInExpressionFR = "//span[contains(text(),'Sign In')]";
	
	String signInExpressionID = "//span[contains(text(),'Sign in now!')]";
	String signInEsExpressionID = "//span[contains(text(),'Sign in now!')]";
	
	String signInExpressionDUS="//button[contains(text(),'Sign In')]";
	String signInEsExpressionDUS="//button[contains(text(),'Sign In')]";
	
	String emailFieldExpressionCore = "loginEmail";
	String emailFieldExpressionFR = "loginEmail";
	String passwordFieldExpressionFR = "loginPassword";
	String passwordFieldExpressionCore = "loginPassword";
	String loginMessage="Login results of %s";
	String InvalidloginMessage="The user '%s' is invalid in '%s'";
	String ValidloginMessage="The user '%s' is valid in '%s'";
	
	String logInExpressionFR = "//span[contains(text(),'Sign in')]";
	String createFieldExpressionCore = "Createbutton";
	
	
	String logInExpressionAICDiscount="//a[contains(text(),'SIGN IN')]";
	String logInExpressionDUSDiscount="//a[contains(text(),'Sign In')]";
	String logInExpressionUSCDiscount="//span[contains(text(),'Sign In')]";
	String logInExpressionIDDiscount="//span[contains(text(),'SIGN IN')]";
	
	String logInEsExpressionAICDUSDiscount="//a[contains(text(),'Iniciar Sesión')]";
	String logInESExpressionIDUSCDiscount="//span[contains(text(),'Iniciar Sesión')]";
	
	

	WebElement valuefield;
	SelectElement clickOnElement;


	Sites site=Sites.valueOf(System.getProperty("site.name"));
	public SignIn(WebDriver driver, String property) {
		super(driver, property);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public SignIn(WebDriver driver) {
		super(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public SignIn selectSignIn() {
	
		if(site==Sites.FR)
		{
			clickOnElement=new SelectElement(driver, String.format(signInExpressionFR));
			clickOnElement.selectElementUsingXPath();
		}
		else 
		{
			clickOnElement=new SelectElement(driver, String.format(signInExpressionCore));
			if(site==Sites.DUS){
				clickOnElement.selectInvisibleElementUsingXpath();
			}
			else
			{
				clickOnElement.selectElementUsingXPath();
			}
		}
		return this;
	}
	
	//sigin link for core sites ES
	public SignIn selectSignInEs() {
		
		
			clickOnElement=new SelectElement(driver, String.format(signInEsExpressionCore));
			if(site==Sites.DUS){
				clickOnElement.selectInvisibleElementUsingXpath();
			}
			else
			{
				clickOnElement.selectElementUsingXPath();
			}
		
		return this;
	}

	public String setUserID(String userID) {
		
		if(site==Sites.FR)
		{
			valuefield = driver.findElement(By.id(String.format(emailFieldExpressionFR)));
		}
		else
		{
			valuefield = driver.findElement(By.id(String.format(emailFieldExpressionCore)));
		}
		
		valuefield.sendKeys(userID);

		return userID;
	}
	
	public String setUserPassword(String userPassword) {
		
		if(site==Sites.FR)
		{
			valuefield = driver.findElement(By.id(String.format(passwordFieldExpressionFR)));
		}
		else
		{
			valuefield = driver.findElement(By.id(String.format(passwordFieldExpressionCore)));
		}
		valuefield.sendKeys(userPassword);

		return userPassword;
	}
	
	public SignIn logIntoApplication(String userID) {
		
		if(site==Sites.AIC ||site==Sites.AICSTAGING )
		{
			valuefield = driver.findElement(By.xpath(String.format(signInExpressionAIC)));
		}
		else if(site==Sites.USC ||site==Sites.USCSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInExpressionUSC)));
		}
		
		else if(site==Sites.ID ||site==Sites.IDSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInExpressionID)));
		}
		else if(site==Sites.FR||site==Sites.FRSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(logInExpressionFR)));
		}
		else if(site==Sites.DUS||site==Sites.DUSSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInExpressionDUS)));
		}
		valuefield.click();

		if(driver.getCurrentUrl().contains("login"))
		{
			Reporter.log(String.format(InvalidloginMessage,userID,site));
		}
		else
		{
			Reporter.log(String.format(ValidloginMessage,userID,site));
		}
		
		CaptureScreen resultOfLogin=new CaptureScreen(driver);
		resultOfLogin.takeScreenShot("Login",String.format(loginMessage,userID));
		
		return this;
	}
	
	//Login button for Core sites ES
	public SignIn logIntoApplicationEs(String userID) {
		
		if(site==Sites.AIC ||site==Sites.AICSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInEsExpressionAIC)));
		}
		else if(site==Sites.USC ||site==Sites.USCSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInEsExpressionUSC)));
		}
		
		else if(site==Sites.ID ||site==Sites.IDSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInEsExpressionID)));
		}
		else if(site==Sites.FR ||site==Sites.FRSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(logInExpressionFR)));
		}
		else if(site==Sites.DUS ||site==Sites.DUSSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(signInEsExpressionDUS)));
		}
		valuefield.click();

		if(driver.getCurrentUrl().contains("login"))
		{
			Reporter.log(String.format(InvalidloginMessage,userID,site));
		}
		else
		{
			Reporter.log(String.format(ValidloginMessage,userID,site));
		}
		
		CaptureScreen resultOfLogin=new CaptureScreen(driver);
		resultOfLogin.takeScreenShot("Login",String.format(loginMessage,userID));
		
		return this;
	}
	
	public SignIn logIntoDiscount() {
		
		if(site==Sites.USC ||site==Sites.USCSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(logInExpressionUSCDiscount)));
		}
		else if(site==Sites.DUS ||site==Sites.DUSSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(logInExpressionDUSDiscount)));
		}
		
		else if(site==Sites.AIC ||site==Sites.AICSTAGING ||site==Sites.FR||site==Sites.FRSTAGING )
		
		{
		
		valuefield = driver.findElement(By.xpath(String.format(logInExpressionAICDiscount)));
		}
		
		else{
			valuefield = driver.findElement(By.xpath(String.format(logInExpressionIDDiscount)));
		}
		valuefield.click();
		return this;
		
	}
	
	public SignIn logIntoDiscountEs() {
		
		if(site==Sites.USC ||site==Sites.USCSTAGING||site==Sites.ID ||site==Sites.IDSTAGING)
		{
			valuefield = driver.findElement(By.xpath(String.format(logInESExpressionIDUSCDiscount)));
		}
		else
			
		{
		
		valuefield = driver.findElement(By.xpath(String.format(logInEsExpressionAICDUSDiscount)));
		}
		valuefield.click();
		return this;
		
	}
	
	
}
