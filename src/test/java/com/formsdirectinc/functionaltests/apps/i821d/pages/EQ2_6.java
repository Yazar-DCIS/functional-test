package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.CheckBox;
import com.formsdirectinc.functionaltests.tags.WizardPage;

/**
 * Page model for EQ2_6 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class EQ2_6 extends WizardPage {

	private CheckBox chooseAllThatApply;

	public EQ2_6(WebDriver driver) {
		super(driver);
	}

	public EQ2_6 chooseAllThatApply(String chooseallthatapply) throws Exception {
		if (!chooseallthatapply.equalsIgnoreCase("skip")) {
			if (chooseallthatapply.equalsIgnoreCase("parent")) {
				chooseAllThatApply = new CheckBox(driver,
						"applicationData-quiz.chooseAllThatApply.optionList[1].value-1");
				chooseAllThatApply.check();
			} else if (chooseallthatapply.equalsIgnoreCase("first_entered")) {
				chooseAllThatApply = new CheckBox(driver,
						"applicationData-quiz.chooseAllThatApply.optionList[2].value-2");
				chooseAllThatApply.check();
			} else if (chooseallthatapply.equalsIgnoreCase("both")) {
				chooseAllThatApply = new CheckBox(driver,
						"applicationData-quiz.chooseAllThatApply.optionList[1].value-1");
				chooseAllThatApply.check();
				chooseAllThatApply = new CheckBox(driver,
						"applicationData-quiz.chooseAllThatApply.optionList[2].value-2");
				chooseAllThatApply.check();
			}
			saveScreenShot("i821d", this.getClass().getSimpleName()); clickContinueInEQ();
		}
		return this;
	}

}
