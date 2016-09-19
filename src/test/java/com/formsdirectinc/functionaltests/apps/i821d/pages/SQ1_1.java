package com.formsdirectinc.functionaltests.apps.i821d.pages;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;

/**
 * Page model for SQ1_1 Details
 * @author:Orina<br> Revision: $Rev$
 */

public class SQ1_1 extends WizardPage {
	private YesNo presenceInUS;
	private MultiRadioOptions initialApplication;

	public SQ1_1(WebDriver driver) {
		super(driver);
	}

	public SQ1_1 presenceInUS(String reasonfor_request,
			String usPresence_options) throws Exception {

		if (!reasonfor_request.equalsIgnoreCase("Skip")) {
			if ((reasonfor_request.equalsIgnoreCase("First_Time_DACA"))
					|| (reasonfor_request
							.equalsIgnoreCase("ExpiredOver_1yearago"))) {

				if (usPresence_options.equalsIgnoreCase("Yes")) {
					presenceInUS = new YesNo(driver,
							"initialApplication.usPresence");
					presenceInUS.yes();

					if (usPresence_options.equalsIgnoreCase("Yes")) {
						presenceInUS = new YesNo(driver,
								"applicant.usContinousPresence");
						presenceInUS.yes();

						if (usPresence_options.equalsIgnoreCase("Yes")) {
							presenceInUS = new YesNo(driver,
									"initialApplication.returnToUs");
							presenceInUS.yes();

							initialApplication = new MultiRadioOptions(driver,

							"applicationData-initialApplication.bestApplies");
							initialApplication.selectOption(1);
						}

						else if (usPresence_options.equalsIgnoreCase("No")) {
							presenceInUS = new YesNo(driver,
									"initialApplication.returnToUs");
							presenceInUS.no();
						}
					} else if (usPresence_options.equalsIgnoreCase("No")) {
						presenceInUS = new YesNo(driver,
								"applicant.usContinousPresence");
						presenceInUS.no();
					}

				}

				else if (usPresence_options.equalsIgnoreCase("No")) {
					presenceInUS = new YesNo(driver,
							"initialApplication.usPresence");
					presenceInUS.no();
				}
			}

			if (reasonfor_request.equalsIgnoreCase("Recently_Expired")) {

				presenceInUS = new YesNo(driver,"applicant.usContinousPresence");
				presenceInUS.setYesOrNo(usPresence_options);

			}

		}
		return this;
	}

}
