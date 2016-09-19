package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.Country;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_6_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ3_6_1 extends WizardPage {

	private YesNo spouseEmployed, spouseStatus;
	private AdditionalInfoFields employerName;
	private Address employerAddr;
	private Country employeeCountry;

	public SQ3_6_1(WebDriver driver) {
		super(driver);

	}

	public SQ3_6_1 spouseEmploymentDetails(Properties copies, Properties data,
			String qualifyingStatus, String empStatus) {
		if (!qualifyingStatus.equalsIgnoreCase("NA")
				&& !empStatus.equalsIgnoreCase("NA")) {

			if (!(qualifyingStatus.equalsIgnoreCase("spouseMilitary"))) {

				spouseStatus = new YesNo(driver,
						"currentSpouse.currentMemberUSArmedForces");

				spouseStatus.setYesOrNo(empStatus);
			}

			spouseEmployed = new YesNo(driver,
					"currentSpouse.currentlyEmployed");

			if (empStatus.equalsIgnoreCase("Yes")) {
				spouseEmployed.yes();

				employerName = new AdditionalInfoFields(driver,

				"applicationData-currentSpouse.presentEmployer");
				employerName.normalText(data.getProperty("spouseFirstName"));

				employeeCountry = new Country(driver,
						"applicationData-currentSpouse.employerAddress.country");
				employeeCountry.setCountryDDM(data.getProperty("Country"));

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				employerAddr = new Address(driver,
						"applicationData-currentSpouse.employerAddress");
				employerAddr.setStreet(data.getProperty("StreetName"));
				employerAddr.setCity(data.getProperty("City"));
				employerAddr.setStateText(data.getProperty("State"));
				employerAddr.setZipcode(data.getProperty("Zipcode"));

			}

			else if (empStatus.equalsIgnoreCase("No")) {
				spouseEmployed.no();
			}
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ3_6_1");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
