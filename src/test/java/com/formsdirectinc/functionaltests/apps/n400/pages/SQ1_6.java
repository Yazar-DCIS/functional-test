package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.EMailAddress;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ1_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_6 extends WizardPage {

	private YesNo notification;

	public SQ1_6(WebDriver driver) {
		super(driver);

	}

	public SQ1_6 contactInformation(Properties n400copies, Properties data,
			String notify) {

		

		try {
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			copyValidation.verifyPageTableHeader(n400copies
					.getProperty("SQ-1.6.pageheader"));
			for (int i = 0; i <= 5; i++) {
				copyValidation.verifyMultipleLabelText(
						n400copies.getProperty("SQ-1.6.pagetext." + i),
						"section-1.6.1", i);
			}
			copyValidation.verifyResources_FAQContent(
					n400copies.getProperty("SQ-1.6.resources.1") + " "
							+ n400copies.getProperty("SQ-1.6.resources.2")
							+ " " + n400copies.getProperty("faq.1.6.question"),
					n400copies.getProperty("faq.1.6.question"),
					n400copies.getProperty("faq.1.6.answer"));
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}

		PhoneNumber contactNumber = new PhoneNumber(driver,"applicationData-applicant.contactMethods");
		contactNumber.setDayTimeNumber("994","5552671");
		contactNumber.setEveningTimeNumber("994", "7774893");
		
		PhoneNumber workNumber = new PhoneNumber(driver,"applicationData-applicant.workPhoneNo");
		workNumber.setPhoneCode("994");
		workNumber.setPhoneNumber("6663782");
		
		PhoneNumber cellNumber = new PhoneNumber(driver,"applicationData-applicant.cellPhoneNo");
		cellNumber.setPhoneCode("248");
		cellNumber.setPhoneNumber("8885104");
		
		
		// e-mail address
		EMailAddress email = new EMailAddress(driver,
				"applicationData-applicant.contactMethods");
		//email.setEMail(data.getProperty("Mail"));
		email.setEMail("john.doe@yahoo.com");

		notification = new YesNo(driver, "applicant.acceptedForProcessing");
		notification.setYesOrNo(notify);
		
		CaptureScreen myscreen=new CaptureScreen(driver);
		myscreen.takeScreenShot("n400", "SQ1_6");
		
		 clickContinueInSQ();
		return this;
	}

}
