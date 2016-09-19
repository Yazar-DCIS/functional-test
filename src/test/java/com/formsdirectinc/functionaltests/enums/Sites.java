package com.formsdirectinc.functionaltests.enums;

/**
 * Sites: Enum listing the sites we test
 * 
 * @author Orina
 * @version added FileRight
 */
public enum Sites {

	// AIC,ID, DUS,FR, USC(LIVE-URL)
	AIC("https://www.us-immigration.com/","cart/category/immigration-forms.html"), 
	ID("https://www.immigrationdirect.com/", "uscis-forms/uscis-forms.jsp"), 
	FR("https://www.fileright.com/", "products.jsp"), 
	USC("https://www.uscitizenship.info/","us-immigration-forms.jsp?lang=en"), 
	DUS("https://www.usimmigration.us/", "immigration-forms/"),

	//AIC,ID, DUS,FR, USC(STAGING - URL )
	AICSTAGING("https://stage.us-immigration.com/","cart/category/immigration-forms.html"), 
	IDSTAGING("https://stage.immigrationdirect.com/","uscis-forms/uscis-forms.jsp"),
	FRSTAGING("https://stage.fileright.com/", "products.jsp"), 
	USCSTAGING("https://stage.uscitizenship.info/","us-immigration-forms.jsp?lang=en"), 
	DUSSTAGING("https://stage.usimmigration.us/", "immigration-forms/");
			
			
	private String baseUrl;
	private String productUrl;

	Sites(String baseUrl, String productUrl) {
		this.baseUrl = baseUrl;
		this.productUrl = productUrl;
	}

	public String getBaseURL() {
		return this.baseUrl;
	}

	public String getProductURL() {

		return this.baseUrl + this.productUrl;
	}
}
