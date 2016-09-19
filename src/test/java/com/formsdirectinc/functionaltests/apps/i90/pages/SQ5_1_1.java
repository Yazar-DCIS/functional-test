package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;




import com.formsdirectinc.functionaltests.tags.Address;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.Name_FirstMiddleLast;
import com.formsdirectinc.functionaltests.tags.PhoneNumber;
import com.formsdirectinc.functionaltests.tags.SelectElement;
import com.formsdirectinc.functionaltests.newtags.WizardPage;

/**
 * I-90:Interpreter Info
 * 
 * @author Orina 
 */

public class SQ5_1_1 extends WizardPage {

	public SQ5_1_1(WebDriver driver) {
		super(driver);
	}

	public SQ5_1_1 interpreterInfo(Properties data,String haveIntrepretor,String workingWithOrgForInterpretation ) {

			MultiRadioOptions haveLanguageIntrepretor = new MultiRadioOptions(driver,
					"applicationData-applicant.certification.readAndUnderstandEnglish");

			if (haveIntrepretor.equalsIgnoreCase("no")) {
				haveLanguageIntrepretor.selectOption(1);
			}

			else if (haveIntrepretor.equalsIgnoreCase("yes")) {
				haveLanguageIntrepretor.selectOption(2);
				
				SelectElement languageUsed=new SelectElement(driver, "applicationData-applicant.certification.languageOfinterpreter");
				languageUsed.sendValuesUsingElementID(data.getProperty("applicant.certification.languageOfinterpreter"));
				
				MultiRadioOptions helpViaOrganisations=new MultiRadioOptions(driver, 
						"applicationData-applicant.certification.workingWithOrgForInterpretation");
					if(workingWithOrgForInterpretation.equalsIgnoreCase("yes")){
						
						helpViaOrganisations.selectOption(1);
						
						SelectElement nameOfOrganisation=new SelectElement(driver, 
								"applicationData-applicant.certification.businessNameOfinterpreter");
						nameOfOrganisation.sendValuesUsingElementID(data.getProperty(
								"applicant.certification.businessNameOfinterpreter"));
					}
					else if(workingWithOrgForInterpretation.equalsIgnoreCase("no"))
					{
						helpViaOrganisations.selectOption(2);
					}
					
					Name_FirstMiddleLast interpreterName=new Name_FirstMiddleLast(driver, "applicationData",
							"applicant.certification.nameOfinterpreter");
					interpreterName.setFirstNameField(data.getProperty("applicant.certification.nameOfInterpreter.first"));
					interpreterName.setLastNameField(data.getProperty("applicant.certification.nameOfInterpreter.last"));
					
					Address interpreterAddress=new Address(driver, 
														"applicationData-applicant.certification.mailingAddressOfInterpreter");
					interpreterAddress.setStreet(data.getProperty("applicant.certification.mailingAddressOfInterpreter.street"));
					interpreterAddress.setCity(data.getProperty("applicant.certification.mailingAddressOfInterpreter.city"));
					interpreterAddress.setState(data.getProperty("applicant.certification.mailingAddressOfInterpreter.state"));
					interpreterAddress.setZipcode(data.getProperty("applicant.certification.mailingAddressOfInterpreter.zipcode"));
					
					PhoneNumber interpreterNumber=new PhoneNumber(driver, 
														"applicationData-applicant.certification.phoneOfInterpreter");
					interpreterNumber.setPhoneCode(data.getProperty("applicant.certification.phoneOfInterpreter.phone1"));
					interpreterNumber.setPhoneNumber(data.getProperty("applicant.certification.phoneOfInterpreter.phone2"));
			}
			saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");
			return this;
	}
}
