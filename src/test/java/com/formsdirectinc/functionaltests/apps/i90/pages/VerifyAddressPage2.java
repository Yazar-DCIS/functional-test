package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.enums.Sites;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.tags.SelectElement;
/**
 * Page model for VerifyAddressPage2 Details
 * 
 * @author:Orina<br> Revision: $Rev$
 */
public class VerifyAddressPage2 extends WizardPage {

	public VerifyAddressPage2(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public VerifyAddressPage2 sureAboutMyMailingAddress(String sureAboutAddress) {
	
		String[] addressType=sureAboutAddress.split(",");
		
		if (!addressType[0].equalsIgnoreCase("na")) {
		
			if (addressType[0].equalsIgnoreCase("yes")) {
				
				if(site==Sites.FR||site==Sites.DUS)
				{
					addressType[1]="Phisical";
				}
				else
				{
					addressType[1]="Physical";
				}
				
				SelectElement addressSelect = new SelectElement(driver,
						"//input[@name='formSpecific.sureAboutMy"+addressType[1]+"Address']");
				addressSelect.selectElementUsingXPath();
							
				gotoNextPage("div","Next");
				 
			} else if (addressType[0].equalsIgnoreCase("no")) {
				SelectElement addressSelect = new SelectElement(driver,
						"//a[contains(text(),'Go fix this address')]");
				if(addressType[1].equalsIgnoreCase("Physical"))
				{
					addressSelect.selectElementUsingXPath();
				}
				else if(addressType[1].equalsIgnoreCase("Mailing"))
				{
					addressSelect.selectInvisibleElementUsingXpath();
				}
			}

		}
		return this;

	}
}
