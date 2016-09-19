package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ2_6 extends WizardPage {

	private YesNo presenceAtWedding;

	public SQ2_6(WebDriver driver) {
		super(driver);
	}

	public SQ2_6 physicallyPresentAtWedding(String weddingPresence) {
		
		
		if(weddingPresence.equalsIgnoreCase("yes")||weddingPresence.equalsIgnoreCase("no"))
		{
		presenceAtWedding=new YesNo(driver, "applicant.physicallyPresentAtWedding");
		
		presenceAtWedding.setYesOrNo(weddingPresence);
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		}
		return this;
	}

}
