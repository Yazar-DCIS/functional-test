package com.formsdirectinc.functionaltests.newtags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;

/**
 * @author:Orina <br>
 *               ApplicationReview Section
 */

public class ApplicationReview {

	private WebDriver driver;
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public ApplicationReview(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	public ApplicationReview selectStartApplication() {

		SelectElement startApp = new SelectElement(driver,
				"//a[contains(text(),'Start Application')]");
		startApp.selectElementUsingXPath();

		return this;

	}

	public ApplicationReview selectStartHereLink() {

		SelectElement startSQ = new SelectElement(driver, "Start Here");
		startSQ.selectElementUsingLinkText();

		return this;

	}

	public ApplicationReview selectContinueApplication() {

		SelectElement startApp = new SelectElement(driver,
				"//a[contains(text(),'Continue')]");
		startApp.selectElementUsingXPath();
	
		return this;

	}

	public ApplicationReview gotoPage(String product, String page) {
		
		String pageURL = null;
		if(page.contains("SQ"))
		{
			pageURL=site.getBaseURL()+product+"/controller.do?goto="+page+"&vstatus=true";
		}
		else if(page.contains("review"))
		{
			pageURL=site.getBaseURL()+product+"/reviewyouranswers.do";
		}
		else
		{
			pageURL=site.getBaseURL()+"application-center/applicationcenter.do";
		}
		
		driver.get(pageURL);
		
		return this;

	}
	
	public ApplicationReview completeApplicationUsingNewCSS(String appname)
			throws ChecksumException, NotFoundException {

		CaptureScreen myscreen = new CaptureScreen(driver);

		SelectElement nextStep = new SelectElement(driver,"//div[contains(text(),'Done Reviewing')]");
		nextStep.selectElementUsingXPath();

		myscreen.takeScreenShot(appname, "FinishedPage");

		SelectElement finishApp = new SelectElement(driver,"//div[contains(text(),'Finished,')]");

		finishApp.selectElementUsingXPath();

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if((site!=Sites.AIC)&&appname.equalsIgnoreCase("i90"))
		{
			completeApplicationWithILR();
		}
		if((site==Sites.FR)&&appname.equalsIgnoreCase("n400"))
		{
			completeApplicationWithILR();
		}
		
		SelectElement openPDF = new SelectElement(driver,"//div[contains(text(),'Print Filing Packet')]");
		openPDF.selectElementUsingXPath();

	
		try {
			Thread.sleep(60000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		SelectElement signOut = new SelectElement(driver, "Sign Out");
		signOut.selectElementUsingLinkText();

		myscreen.takeScreenShot(appname, "SignOutPage");
		return this;

	}

	
	
	public ApplicationReview completeApplicationWithILR() {

		// lawyer review
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//n-400
		SelectElement lawyerReview = new SelectElement(driver,"//div[contains(text(),'Ready, Send to')]");
		lawyerReview.selectElementUsingXPath();

		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		SelectElement nextProcess = new SelectElement(driver,"//div[contains(text(),'Continue')]");
		nextProcess.selectElementUsingXPath();

		SelectElement confirmation = new SelectElement(driver, "confirmation");
		confirmation.selectElementUsingID();

		SelectElement readyToNext = new SelectElement(driver,"//div[contains(text(),'Continue')]");
		readyToNext.selectElementUsingXPath();

		//I'm ready to move forward
		readyToNext.selectElementUsingXPath();
		return this;

	}

}
