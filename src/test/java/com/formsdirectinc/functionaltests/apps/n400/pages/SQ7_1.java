package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ7_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ7_1 extends WizardPage {

	private YesNo armedForceServices, memberOfArmedForces;

	public SQ7_1(WebDriver driver) {
		super(driver);

	}

	public SQ7_1 priorService(Properties copies, Properties keys,
			Properties data, String answer) {
		if (!answer.equalsIgnoreCase("NA")) {

			CrimeDetails services=new CrimeDetails(driver);
		
			armedForceServices = new YesNo(driver,"militaryDetails.armedForceServices.yesno");
			armedForceServices.setYesOrNo(answer);

			memberOfArmedForces = new YesNo(driver,	"militaryDetails.memberOfArmedForces.yesno");
			memberOfArmedForces.setYesOrNo(answer);
			if (answer.equalsIgnoreCase("Yes")) {
			
				services.informationRelatedToCrime("n400", "militaryDetails.deployVessel", answer);
				services.informationRelatedToCrime("n400", "militaryDetails.stationedOverseas", answer);
				
			}
			services.informationRelatedToCrime("n400", "militaryDetails.courtMartialed", answer);
			services.informationRelatedToCrime("n400", "militaryDetails.disCharged", answer);
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ7_1");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
