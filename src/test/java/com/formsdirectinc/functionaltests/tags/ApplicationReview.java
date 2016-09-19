package com.formsdirectinc.functionaltests.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.enums.Sites;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;

/**
 * @author:Orina
 * <br> ApplicationReview Section
 */

public class ApplicationReview {

	private WebDriver driver;
	Sites site = Sites.valueOf(System.getProperty("site.name"));

	public ApplicationReview(WebDriver driver) {
		this.driver = driver;
		driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

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
	public ApplicationReview completeApplicationUsingNewCSS(String appname) throws ChecksumException, NotFoundException {

		CaptureScreen myscreen=new CaptureScreen(driver);
		
		SelectElement nextStep = new SelectElement(driver,
				"//button[contains(text(),'done reviewing, Go to Next Step')]");
		nextStep.selectElementUsingXPath();

		myscreen.takeScreenShot(appname, "FinishedPage");
		
		SelectElement finishApp = new SelectElement(driver,
				"//button[contains(text(),'Finished, Go to Next Step')]");
		
		finishApp.selectElementUsingXPath();

		if (appname == Products.I90.name()) {
			if (site != Sites.AIC) {
				completeApplicationWithILR();
			}
		}

		else if (appname == Products.N400.name()) {
			if (site == Sites.FR) {
				completeApplicationWithILR();
			}
		}
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		SelectElement openPDF = new SelectElement(driver,"a[href='openpdf.do']");
		openPDF.selectElementUsingCSS();

		DownloadProductPDFImages page = new DownloadProductPDFImages(driver);
		try {
				Thread.sleep(100000);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
			}
		
		
		String pdfFileName=page.getLatestFileName(appname);
		Reporter.log(pdfFileName+"<br>"+"Downloaded succesfully"+"<br>");
		
		SelectElement signOut = new SelectElement(driver, "Sign Out");
		signOut.selectElementUsingLinkText();
		
		myscreen.takeScreenShot(appname, "SignOutPage");
		return this;

	}
	
	
	public ApplicationReview completeApplicationUsingOldCSS(String product) {

		SelectElement nextStep = new SelectElement(driver, "show-light-box-s1");
		nextStep.selectElementUsingID();

		SelectElement finishApp = new SelectElement(driver,
				"a[href='previewapplication.do']");
		finishApp.selectElementUsingCSS();

		return this;

	}

	public ApplicationReview completeApplicationUsingPrint(String product) {

		// Application Review
		if (site == Sites.FR) {
			SelectElement review = new SelectElement(driver, "My applications");
			review.selectElementUsingLinkText();
		}
		if (site != Sites.FR) {
			SelectElement review = new SelectElement(driver,
					"Application Center");
			review.selectElementUsingLinkText();
		}

		String winHandleBefore = driver.getWindowHandle();
		
		SelectElement printApp = new SelectElement(driver,
				"//a[contains(text(),'Print')]");
		printApp.selectElementUsingXPath();

		SelectElement showprint = new SelectElement(driver,
				"a[href='showprint.jsp']");
		showprint.selectElementUsingCSS();

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		try {
			TimeUnit.SECONDS.sleep(30);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// takes the screen-shot of the the PDF Generated
		CaptureScreen page = new CaptureScreen(driver);
		page.takeScreenShot(product,product);

		driver.switchTo().window(winHandleBefore);
		
		
		SelectElement signOut = new SelectElement(driver, "Sign Out");
		signOut.selectElementUsingLinkText();

		return this;

	}

	public ApplicationReview completeApplicationWithILR() {

		// lawyer review
		SelectElement lawyerReview = new SelectElement(driver,

		"//button[contains(text(),'ready, send to lawyer now')]");
		lawyerReview.selectElementUsingXPath();

		SelectElement nextProcess = new SelectElement(driver,
				"//button[contains(text(),'Continue')]");
		nextProcess.selectElementUsingXPath();

		SelectElement confirmation = new SelectElement(driver, "confirmation");
		confirmation.selectElementUsingID();

		SelectElement readyToNext = new SelectElement(driver,

		"//button[contains(text(),'ready to continue')]");
		readyToNext.selectElementUsingXPath();

		SelectElement readyToFile = new SelectElement(driver,

		"//button[contains(text(),'File my application')]");
		readyToFile.selectElementUsingXPath();

		return this;

	}
	
	

	
}
