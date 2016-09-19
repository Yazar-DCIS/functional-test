package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.CrimeDetails;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ6_6 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ6_6 extends WizardPage {

	private YesNo criminalCharges;

	public SQ6_6(WebDriver driver) {
		super(driver);

	}

	public SQ6_6 criminalCharges(Properties copies, Properties data,
			String answers) {
		if (!answers.equalsIgnoreCase("NA")) {

			CrimeDetails crimes=new CrimeDetails(driver);
			crimes.informationOnCrimeWithoutExplain("crimeDetails.crimeNotArrested",answers);
			crimes.informationOnCrimeWithoutExplain("crimeDetails.beenArrested",answers);
			crimes.informationOnCrimeWithoutExplain("crimeDetails.chargedForCrime",answers);
			crimes.informationOnCrimeWithoutExplain("crimeDetails.convictedForCrime",answers);
			crimes.informationOnCrimeWithoutExplain("crimeDetails.beenSentenced",answers);
			
			criminalCharges = new YesNo(driver,	"crimeDetails.suspendedSentence");
			criminalCharges.setYesOrNo(answers);
			if (answers.equalsIgnoreCase("Yes")) {
				crimes.informationOnCrimeWithoutExplain("crimeDetails.completedProbationOrParole",answers);
			}

			criminalCharges = new YesNo(driver,	"crimeDetails.beenInJailOrPrison");
			criminalCharges.setYesOrNo(answers);
			if (answers.equalsIgnoreCase("Yes")) {
							
				CrimeDetails crimeDuration=new CrimeDetails(driver,"crimeDetails.howLongInPrison");
				crimeDuration.yearsSpentInPrison(data.getProperty("years"));
				crimeDuration.monthsSpentInPrison(data.getProperty("months"));
				crimeDuration.daysSpentInPrison(data.getProperty("days"));
			}

			
			crimes.informationOnCrimeWithoutExplain("crimeDetails.arrestOrConvictionVacated",answers);
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ6_6");			
			 clickContinueInSQ();
		}
		return this;
	}

}
