package com.formsdirectinc.functionaltests.apps.n400.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.CaptureScreen;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ2_1_1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ2_1_1_1 extends WizardPage {

	private YesNo haveEverReEnListed;
	private Address reEnListAddress, firstEnListAddress, enListAddress;
	private AdditionalInfoFields serviceNumber;

	public SQ2_1_1_1(WebDriver driver) {
		super(driver);

	}

	public SQ2_1_1_1 enlistmentInfo(Properties n400copies, Properties data,
			String reenlistedForMilitary, int serviceCount) {

		if (reenlistedForMilitary.equalsIgnoreCase("Yes")
				|| reenlistedForMilitary.equalsIgnoreCase("No")) {

			if (serviceCount > 1) {
				haveEverReEnListed = new YesNo(driver,
						"presenceInUs.haveEverReEnListed");

				if (reenlistedForMilitary.equalsIgnoreCase("Yes")) {
					haveEverReEnListed.yes();
					firstEnListAddress = new Address(driver,
							"applicationData-presenceInUs.whereFirstEnlist");
					firstEnListAddress.setVisaCity(data
							.getProperty("firstEnlistCity"));
					firstEnListAddress.setState(data
							.getProperty("firstEnlistState"));

					reEnListAddress = new Address(driver,
							"applicationData-presenceInUs.whereReEnlist");
					reEnListAddress.setVisaCity(data
							.getProperty("reEnlistCity"));
					reEnListAddress.setState(data.getProperty("reEnlistState"));

				}
				else if (reenlistedForMilitary.equalsIgnoreCase("No")) {
					haveEverReEnListed.no();
					enListAddress = new Address(driver,
							"applicationData-presenceInUs.whereEnlist");
					enListAddress.setVisaCity(data.getProperty("enlistCity"));
					enListAddress.setState(data.getProperty("enlistState"));
				}
			}

			if (serviceCount == 1) {
				enListAddress = new Address(driver,
						"applicationData-presenceInUs.whereEnlist");
				enListAddress.setVisaCity(data.getProperty("enlistCity"));
				enListAddress.setState(data.getProperty("enlistState"));
			}

			serviceNumber = new AdditionalInfoFields(driver,
					"applicationData-presenceInUs.militaryServiceNumber");
			serviceNumber.normalText(data.getProperty("MilitaryServiceNumber"));
			
			CaptureScreen myscreen=new CaptureScreen(driver);
			myscreen.takeScreenShot("n400", "SQ2_1_1_1");
			
			 clickContinueInSQ();
		}
		return this;
	}

}
