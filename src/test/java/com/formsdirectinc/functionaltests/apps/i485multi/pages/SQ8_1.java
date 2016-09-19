package com.formsdirectinc.functionaltests.apps.i485multi.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.DateTag;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ8_1 Details
 * @author:Orina<br> Revision: $Rev$
 */



public class SQ8_1 extends WizardPage {

	private YesNo travelDocument;

	public SQ8_1(WebDriver driver) {
		super(driver);

	}

	public void travelDocumentIssuedBefore(Properties data,String answer) {
		travelDocument = new YesNo(driver, "principalFormSpecific.travelDocument.hasDocumentIssued");
		if(answer.equalsIgnoreCase("yes"))
		{
			travelDocument.yes();
			DateTag dateIssued=new DateTag(driver, "principalFormSpecific.travelDocument.issuedDate");
			dateIssued.selectDate(data.getProperty("DOB"));
			
			SelectElement disposition=new SelectElement(driver, "principalFormSpecific.travelDocument.disposition");
			disposition.sendValuesUsingElementName("lost");
			
		}
		else if(answer.equalsIgnoreCase("no"))
		{
			travelDocument.no();
		}
		

	}

}
