package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CommonInputClasses;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ1_5_5 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5_5 extends WizardPage {

	private Country applicantCountry;
	private CommonInputClasses applicantAddress;
	private DateTag dateHistory;

	public SQ1_5_5(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_5 applicantResidenceHistoryInfo(Properties copies,
			Properties data, int count, String country)
			throws InterruptedException {

		if (count > 0) {
			for (int i = 0; i < count; i++) {
				applicantResidenceHistory(copies, data, i, country);
				if (i < count - 1) {

					CommonInputClasses others = new CommonInputClasses(driver);
					others.addAnotherAddress();
				}
			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_5");
			
			 clickContinueInSQ();
		}

		return this;

	}

	public SQ1_5_5 applicantResidenceHistory(Properties n400copies,
			Properties data, int count, String country)
			throws InterruptedException {

		
		PageCopiesAndContent copyValidation = new PageCopiesAndContent(driver);
		try {

			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.5.5.pageheader"));
			copyValidation.verifyPageInstructionalText(
					n400copies.getProperty("SQ-1.5.5.instructionaltext.1"),
					"example");

			copyValidation.verifyPageSectionHeader(
					n400copies.getProperty("SQ-1.5.5.sectionHeader"),
					"section-1.5.5.1");

		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		applicantCountry = new Country(driver,
				"applicationData-personalDetails." + "residentialHistory["
						+ count + "].address");

		System.out.println("---------------->Country" + country);

		if (country.equalsIgnoreCase("notUS")) {
			applicantCountry.setCountry(data.getProperty("Country"));
			Thread.sleep(5000);
			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantOtherAddressDetails(
					"applicationData-personalDetails." + "residentialHistory["
							+ count + "].address", data);

		}

		else if (country.equalsIgnoreCase("inUS")) {
			applicantCountry.setCountry(data.getProperty("DACA_Country"));
			Thread.sleep(5000);
			applicantAddress = new CommonInputClasses(driver);
			applicantAddress.applicantAddressDetails(
					"applicationData-personalDetails." + "residentialHistory["
							+ count + "].address", data);
		}

		else
		{
			applicantCountry.setCountry(data.getProperty("EmplCountry"));
			Thread.sleep(5000);
			Address testAddress=new Address(driver, "applicationData-personalDetails." + "residentialHistory["+ count + "].address");
			testAddress.setStreet("200 E MAIN ST");
			testAddress.setCity("PHOENIX");
			testAddress.setState("AZ");
			testAddress.setZipcode("85123");
		}
		
		dateHistory = new DateTag(driver, "personalDetails.residentialHistory["
				+ count + "]." + "dateRange.fromDate");
		//dateHistory.selectDate(data.getProperty("fromDate"));
		dateHistory.selectDate("03-16-2009");

		dateHistory = new DateTag(driver, "personalDetails.residentialHistory["
				+ count + "]." + "dateRange.toDate");
		//dateHistory.selectDate(data.getProperty("toDate"));
		dateHistory.selectDate("04-14-2015");
		return this;
	}

}
