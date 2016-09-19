package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.PageCopiesAndContent;
import com.formsdirectinc.functionaltests.tags.ReadDataFromExcelSheet;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.utils.PropertyResource;
/**
 * Page model for SQ1_5_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_5_6 extends WizardPage {

	public SQ1_5_6(WebDriver driver) {
		super(driver);

	}

	public SQ1_5_6 applicantInEligible(String visitThisPage, int flowNo) throws Exception {

		ReadDataFromExcelSheet readFromExcelSheet = PageFactory.initElements(
				driver, ReadDataFromExcelSheet.class);
		String n400Sheet = "N400";
		readFromExcelSheet.initializeWorkbook(n400Sheet);

		PropertyResource propertyFile=new PropertyResource();
		Properties n400data = propertyFile.loadProperty("name");

		Properties n400Copies = propertyFile.loadProperty("n400");

		if (visitThisPage.equalsIgnoreCase("Yes")) {

			
			PageCopiesAndContent copyValidation = new PageCopiesAndContent(
					driver);
			try {

				copyValidation.verifyPageTableHeader(n400Copies
						.getProperty("SQ-1.5.6.pageheader"));
				copyValidation
						.verifySorryPageText(
								n400Copies.getProperty("SQ-1.5.6.pagetext.1")
										+ n400Copies
												.getProperty("SQ-1.5.6.pagetext.2")
										+ n400Copies
												.getProperty("SQ-1.5.6.pagetext.3")
										+ n400Copies
												.getProperty("SQ-1.5.6.pagetext.5"),
								"section-1.5.6.1");

			} catch (Exception e) {
				System.out.println(e.getStackTrace());
			}
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ1_5_6");
			
			 clickContinueInSQ();

			int prevFlow = flowNo - 1;
			// Current Address
			SQ1_5_3 sq1_5_3 = PageFactory.initElements(driver, SQ1_5_3.class);
			sq1_5_3.applicantResidenceDetails(n400Copies,
					n400data,
					readFromExcelSheet.getCellStringContent(prevFlow, 28),
					readFromExcelSheet.getCellStringContent(prevFlow, 29),
					readFromExcelSheet.getCellStringContent(prevFlow, 30));

			// Current Address
			SQ1_5_4 sq1_5_4 = PageFactory.initElements(driver, SQ1_5_4.class);
			sq1_5_4.applicantResidenceDetails(n400Copies,
					n400data,
					readFromExcelSheet.getCellStringContent(prevFlow, 31),
					readFromExcelSheet.getCellStringContent(prevFlow, 32),
					readFromExcelSheet.getCellStringContent(prevFlow, 33));

		}

		return this;
	}

}
