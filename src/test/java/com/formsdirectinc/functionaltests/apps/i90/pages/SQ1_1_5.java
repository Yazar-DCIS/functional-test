package com.formsdirectinc.functionaltests.apps.i90.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;


import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.newtags.PhysicalTraits;
import com.formsdirectinc.functionaltests.newtags.WizardPage;
import com.formsdirectinc.functionaltests.newtags.YesNo;

/**
 * Physical Traits
 * @author Orina
 *
 */
public class SQ1_1_5 extends WizardPage {

	private MultiRadioOptions race, hairColor, eyeColor;
	private YesNo hispanicLatino;
	private PhysicalTraits setHeight,setWeight;
	
	public SQ1_1_5(WebDriver driver) {
		super(driver);
	}

	public SQ1_1_5 physicalTraits(Properties data, String weightOption,String raceType,int hairColorType,
			int eyeColorType,String hispanicOrLatino) {

		
		setHeight = new PhysicalTraits(driver, "applicationData","applicant.height");
		setHeight.selectHeightinFeet_i90(data.getProperty("applicant.height.feet"));
		setHeight.selectHeightinInches_i90(data.getProperty("applicant.height.inches"));
		
		setWeight=new PhysicalTraits(driver,"applicationData","applicant.weight");
		if(weightOption.equalsIgnoreCase("english"))
		{			
			setWeight.setWeightinPounds(data.getProperty("applicant.weight.pounds"));
		}
		else if(weightOption.equalsIgnoreCase("metric"))
		{
			setWeight.setWeightinKilograms(data.getProperty("applicant.weight.kilograms"));
		}

	
		String raceValues=raceType;
		for(String raceTypeSelect:raceValues.split(",")) {
			race = new MultiRadioOptions(driver,"applicationData-applicant-raceList["+raceTypeSelect+"]-race");
			race.selectOption(Integer.parseInt(raceTypeSelect));
		}
		
		
		hairColor = new MultiRadioOptions(driver,
				"applicationData-applicant.hairColor");
		hairColor.selectOption(hairColorType);

		eyeColor = new MultiRadioOptions(driver,
				"applicationData-applicant.eyeColor");
		eyeColor.selectOption(eyeColorType);

		hispanicLatino = new YesNo(driver, "applicant.hispanicorLatino");
		if(hispanicOrLatino.equalsIgnoreCase("yes"))
		{
			hispanicLatino.yes();
		}
		else if(hispanicOrLatino.equalsIgnoreCase("no"))
		{

			hispanicLatino.no();
		}
		saveScreenShot("i90", this.getClass().getSimpleName()); gotoNextPage("div","Next");

		return this;
	}
}
