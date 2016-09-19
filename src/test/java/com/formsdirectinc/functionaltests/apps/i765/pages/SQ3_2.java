package com.formsdirectinc.functionaltests.apps.i765.pages;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.formsdirectinc.functionaltests.tags.AdditionalInfoFields;
import com.formsdirectinc.functionaltests.tags.MultiRadioOptions;
import com.formsdirectinc.functionaltests.tags.WizardPage;
import com.formsdirectinc.functionaltests.tags.YesNo;
/**
 * Page model for SQ3_2 Details
 * @author:Orina<br> Revision: $Rev$
 */
public class SQ3_2 extends WizardPage {

	private AdditionalInfoFields eligiblityStatus, STEMDetails,
			receiptCodeSelect, receiptCode, categoryNone, categoryNoneReason;
	private MultiRadioOptions employmentType, employerImmigrationStatus,
			practicalTraining;
	private YesNo parloedAsRefugee;

	public SQ3_2(WebDriver driver) {
		super(driver);
	}

	public SQ3_2 eligiblityStatus(Properties data, String category,
			String reason1, String reason2) throws Exception {
		if (!category.equalsIgnoreCase("NA")) {

			eligiblityStatus = new AdditionalInfoFields(driver,

			"applicationData-formSpecific.newFilingCategory-filingCategoryOne");

			if (category.equalsIgnoreCase("F-1Student")) {

				eligiblityStatus.selectDDM(data.getProperty("I765_F-1Student"));
				eligibilityStatusExplanation(data);

				employmentType = new MultiRadioOptions(driver,

				"applicationData-formSpecific.newFilingCategory.indicateKindOfEmployment");
				if (reason1.equalsIgnoreCase("PracticalTraning")) {
					employmentType.selectOption(1);
					// reason2
					practicalTraining = new MultiRadioOptions(driver,

					"applicationData-formSpecific.newFilingCategory.optionalTraining");
					if (reason2.equalsIgnoreCase("PreCompletion")) {
						practicalTraining.selectOption(1);
					}
					else if (reason2.equalsIgnoreCase("PostCompletion")) {
						practicalTraining.selectOption(2);
					}
					else if (reason2.equalsIgnoreCase("STEM")) {
						practicalTraining.selectOption(3);

						STEMDetails = new AdditionalInfoFields(driver,

						"applicationData-formSpecific.newFilingCategory.degree");
						STEMDetails.normalText(data.getProperty("I765_Degree"));

						STEMDetails = new AdditionalInfoFields(driver,

						"applicationData-formSpecific.newFilingCategory.employerNameVerify");
						STEMDetails.normalText(data
								.getProperty("I765_EmployerName"));

						STEMDetails = new AdditionalInfoFields(driver,

						"applicationData-formSpecific.newFilingCategory.employerCompanyVerify");
						STEMDetails.normalText(data
								.getProperty("I765_EmployerCompany"));
					}
				}
				else if (reason1.equalsIgnoreCase("EmpUnderSponsorShip")) {
					employmentType.selectOption(2);
				}
				else if (reason1.equalsIgnoreCase("EmpUnderEconomicHarship")) {
					employmentType.selectOption(3);
				}
			}
			else if (category.equalsIgnoreCase("M-1Student")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_M-1Student"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("J1orJ2")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_J1orJ2"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("AdjustmentOfStatus")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_AdjustmentOfStatus"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("ProcessOfFillingAOS")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_ProcessOfFillingAOS"));
			}
			if (category.equalsIgnoreCase("K1orK2")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_K1orK2"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("K3orK4")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_K3orK4"));
			}
			else if (category.equalsIgnoreCase("H4SpouseOfH1BVisaHolder")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_H4SpouseOfH1BVisaHolder"));
				// reason2
				employmentType = new MultiRadioOptions(driver,

				"applicationData-formSpecific.newFilingCategory.indicateSpouseDetails");
				if (reason1.equalsIgnoreCase("SpouseApprovedI140")
						|| reason1.equalsIgnoreCase("SpouseGrantedH1B")) {
					if (reason1.equalsIgnoreCase("SpouseApprovedI140")) {
						employmentType.selectOption(1);
					}
					else if (reason1.equalsIgnoreCase("SpouseGrantedH1B")) {
						employmentType.selectOption(2);
					}
					receiptCodeSelect = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.newFilingCategory.indicateReceiptType");
					receiptCodeSelect.selectDDM(data
							.getProperty("I765_ReceiptName"));

					receiptCode = new AdditionalInfoFields(driver,

					"applicationData-formSpecific.newFilingCategory.indicateReceiptNumber");
					receiptCode
							.normalText(data.getProperty("I765_ReceiptCode"));
				}
				else if (reason1.equalsIgnoreCase("None")) {
					employmentType.selectOption(3);
				}

			}
			else if (category.equalsIgnoreCase("V1/V2/V3Nonimmigrant")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_V1/V2/V3"));
			}
			else if (category.equalsIgnoreCase("U1Nonimmigrant")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_U1"));
			}
			else if (category.equalsIgnoreCase("U2/U3/U4/U5Nonimmigrant")) {
				eligiblityStatus
						.selectDDM(data.getProperty("I765_U2/U3/U4/U5"));
			}
			else if (category.equalsIgnoreCase("T1Nonimmigrant")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_T1"));
			}
			else if (category.equalsIgnoreCase("T2/T3/T4Nonimmigrant")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_T2/T3/T4"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("N8/N9Nonimmigrant")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_N8/N9"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("Refugee")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_Refugee"));
				eligibilityStatusExplanation(data);
				parloedAsRefugee = new YesNo(driver,
						"formSpecific.newFilingCategory.eligibilityStatusInfo");
				parloedAsRefugee.yes();
			}
			else if (category.equalsIgnoreCase("Asylee")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_Asylee"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("Asylum")) {
				eligiblityStatus.selectDDM(data.getProperty("I765_Asylum"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("AsylumUnderABCSettlement")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_AsylumUnderABCSettlement"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("B1Personal/Domestic")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_B1Personal/Domestic"));
				eligibilityStatusExplanation(data);
				employerImmigrationStatus = new MultiRadioOptions(
						driver,

						"applicationData-formSpecific.newFilingCategory.indicateEmployerImmigrationStatus");
				employerImmigrationStatus.selectOption(1);
			}
			else if (category.equalsIgnoreCase("B1NonImmigrantByForeignAirline")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_B1NonImmigrantByForeignAirline"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("CitizenOfMicronesia")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_CitizenOfMicronesia"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("LIFELegalization")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_LIFELegalization"));
			}
			else if (category.equalsIgnoreCase("NACARA")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_NACARARelief"));
			}
			else if (category.equalsIgnoreCase("FamilyUnityBenefits")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_FamilyUnityBenefits"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("LIFEFamilyUnity")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_LIFEFamilyUnity"));
			}
			else if (category.equalsIgnoreCase("ParoledInPublicInterest")) {
				eligiblityStatus.selectDDM(data
						.getProperty("I765_ParoledInPublicInterest"));
				eligibilityStatusExplanation(data);
			}
			else if (category.equalsIgnoreCase("None")) {
				eligiblityStatus.selectDDM(data.getProperty("None"));
				categoryNone = new AdditionalInfoFields(driver,"formSpecific.newFilingCategory.filingCategoryTwo");
				if (reason1.equalsIgnoreCase("SpouseOfL1Holder")) {
					categoryNone.selectDDM(data.getProperty("I765_L1Holder"));
					eligibilityStatusExplanation(data);
				}
				else if (reason1.equalsIgnoreCase("SpouseOfE1/E2/E3Holder")) {
					categoryNone.selectDDM(data
							.getProperty("I765_E1/E2/E3Holder"));
					eligibilityStatusExplanation(data);
				}
				else if (reason1.equalsIgnoreCase("SpouseOrMinorChildOfA1/A2Holder")) {
					categoryNone
							.selectDDM(data.getProperty("I765_A1/A2Holder"));
				}
				else if (reason1
						.equalsIgnoreCase("SpouseOrMinorChildOfG1/G2/G3NonImmigrant")) {
					categoryNone.selectDDM(data
							.getProperty("I765_G1/G2/G3NonImmigrant"));
				}
				else if (reason1
						.equalsIgnoreCase("SpouseOrMinorChildOfNATONonImmigrant")) {
					categoryNone.selectDDM(data.getProperty("I765_NATO"));
				}
				else if (reason1
						.equalsIgnoreCase("SpouseOrChildOfTECRO-E1NonImmigrant")) {
					categoryNone.selectDDM(data.getProperty("I765_TECRO"));
					eligibilityStatusExplanation(data);
				}
				else if (reason1.equalsIgnoreCase("None")) {
					categoryNone.selectDDM(data.getProperty("I765_None"));

					categoryNoneReason = new AdditionalInfoFields(driver,

					"formSpecific.newFilingCategory.filingCategoryThree");
					if (reason2.equalsIgnoreCase("Removal")) {
						categoryNoneReason.selectDDM(data
								.getProperty("I765_Removal"));
						eligibilityStatusExplanation(data);
					}
					else if (reason2.equalsIgnoreCase("Suspension")) {
						categoryNoneReason.selectDDM(data
								.getProperty("I765_Suspension"));
						eligibilityStatusExplanation(data);
					}
					else if (reason2.equalsIgnoreCase("GrantedDACA")) {
						categoryNoneReason.selectDDM(data
								.getProperty("I765_GrantedDACA"));
						eligibilityStatusExplanation(data);
					}
					else if (reason2.equalsIgnoreCase("ExtendedDeparture")) {
						categoryNoneReason.selectDDM(data
								.getProperty("I765_Departure"));
					}
					else if (reason2.equalsIgnoreCase("PendingFinalOrder")) {
						categoryNoneReason.selectDDM(data
								.getProperty("I765_PendingFinalOrder"));
						eligibilityStatusExplanation(data);
					}
				}
			}

			saveScreenShot("i765", this.getClass().getSimpleName()); clickContinueInSQ();
		}

		return this;
	}

	public void eligibilityStatusExplanation(Properties data) {
		eligiblityStatus = new AdditionalInfoFields(driver,
				"applicationData-formSpecific.newFilingCategory.eligibilityStatusExplanation");
		eligiblityStatus.normalText(data.getProperty("USCIS_Office"));
	}

}
