package com.formsdirectinc.functionaltests.apps.i90.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.tags.SelectElement;
/**
 * Page model for VerifyAddressPage1 Details
 * 
 * @author:Orina<br> Revision: $Rev$
 */
public class VerifyAddressPage1 extends WizardPage {

	public VerifyAddressPage1(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public VerifyAddressPage1 decideAddress(String addressIs) {
		
		String[] addressType=addressIs.split(",");
		
		if (!addressType[0].equalsIgnoreCase("na")) {
			SelectElement addressSelect = null;
			if (addressType[0].equalsIgnoreCase("suggested")
					|| addressType[0].equalsIgnoreCase("this")) {
				
				addressSelect = new SelectElement(driver,
						"//button[contains(text(),'Use " + addressType[0]+ " Address')]");
				if(addressType[1].equalsIgnoreCase("Physical"))
				{
					addressSelect.selectElementUsingXPath();
				}
				else if(addressType[1].equalsIgnoreCase("Mailing"))
				{
					addressSelect.selectInvisibleElementUsingXpath();
				}
				
			}
			else if (addressIs.equalsIgnoreCase("notsure")) {
				addressSelect = new SelectElement(driver,
						"//a[contains(text(),'Edit this address')]");
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
