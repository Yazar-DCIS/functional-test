package com.formsdirectinc.functionaltests.apps.i130i485.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Products;
import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.MemberShip;
import com.formsdirectinc.functionaltests.tags.WizardPage;
/**
 * Page model for SQ10_1 Details
 * @author:Orina<br> Revision: $Rev$
 */


public class SQ10_1 extends WizardPage {

	private CheckBox haveMembership;

	public SQ10_1(WebDriver driver) {
		super(driver);
	}

	public SQ10_1 relativeMembershipDetails(String haveMembershipInfo,int membershipCount) {

		String appname=Products.I130I485.name().toLowerCase();
		
		haveMembership = new CheckBox(driver,
				"applicationData-foreignRelative.haveMembership");
		if(haveMembershipInfo.equalsIgnoreCase("Yes"))
		{
			
			MemberShip membershipDetails=new MemberShip(driver);
			membershipDetails.setMembershipInformation("foreignRelative.membership", appname, membershipCount);
			
		}
		else if(haveMembershipInfo.equalsIgnoreCase("No"))
		{
			haveMembership.check();
		}
		saveScreenShot("i130i485", this.getClass().getSimpleName()); clickContinueInSQ();
		

		return this;
	}

}
