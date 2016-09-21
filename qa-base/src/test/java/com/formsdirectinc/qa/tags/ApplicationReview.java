package com.formsdirectinc.qa.tags;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.utils.CaptureScreen;
import com.google.zxing.ChecksumException;
import com.google.zxing.NotFoundException;

/**
 * @author:Orina <br>
 *               ApplicationReview Section
 */

public class ApplicationReview {

	private WebDriver driver;
	
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
		if (page.contains("SQ")) {
			pageURL = siteURL() + product + "/controller.do?goto=" + page
					+ "&vstatus=true";
		} else if (page.contains("review")) {
			pageURL = siteURL() + product + "/reviewyouranswers.do";
		} else {
			pageURL = siteURL() + "application-center/applicationcenter.do";
		}

		driver.get(pageURL);

		return this;

	}

	private String siteURL() {
		// TODO Auto-generated method stub
		return System.getProperty("site.url");
	}

	public ApplicationReview completeApplicationUsingNewCSS(String appname,Sites site)
			throws ChecksumException, NotFoundException {

		CaptureScreen myscreen = new CaptureScreen(driver);

		SelectElement nextStep = new SelectElement(driver,
				"//button[contains(text(),'done reviewing, Go to Next Step')]");
		nextStep.selectElementUsingXPath();

		myscreen.takeScreenShot(appname, "FinishedPage");

		SelectElement finishApp = new SelectElement(driver,
				"//button[contains(text(),'Finished, Go to Next Step')]");

		finishApp.selectElementUsingXPath();

		if (appname.equalsIgnoreCase(Products.I90.name())) {

			completeApplicationWithILR();

		}

		else if (appname.equalsIgnoreCase(Products.N400.name())) {
			if (site == Sites.FR) {
				completeApplicationWithILR();
			}
		}

		/*try {
			Thread.sleep(5000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		SelectElement openPDF = new SelectElement(driver,
				"a[href='openpdf.do']");
		openPDF.selectElementUsingCSS();

		try {
			Thread.sleep(60000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/

		SelectElement signOut = new SelectElement(driver, "Sign Out");
		signOut.selectElementUsingLinkText();

		myscreen.takeScreenShot(appname, "SignOutPage");
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
