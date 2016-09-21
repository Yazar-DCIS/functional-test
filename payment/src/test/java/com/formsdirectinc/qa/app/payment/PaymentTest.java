package com.formsdirectinc.qa.app.payment;

import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.formsdirectinc.qa.TestBase;
import com.formsdirectinc.qa.enums.Products;
import com.formsdirectinc.qa.enums.Sites;
import com.formsdirectinc.qa.pages.Login;
import com.formsdirectinc.qa.tags.SelectElement;
import com.formsdirectinc.qa.utils.CaptureScreen;
import com.formsdirectinc.qa.utils.PropertyResource;

/**
 * PaymentPage: Selenium Page Model for Payment Page
 * 
 * @author: <a href="mailto:orina.moorthy@dcis.net">Orina</a>
 * @Date: 6/29/15
 * @Updated:24.02.2016
 */
public class PaymentTest extends TestBase {

	
	public PaymentTest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentTest(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@Test
	@Parameters({ "sitename","siteurl", "product", "username", "password"})
	public void paymenttest(String sitename,String siteurl, String product, String username,
			String password) throws Exception {

		if(driver==null)
	 	{
	 		createStep(driver, this.getClass().getName());
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		PropertyResource propertyFile = new PropertyResource();
		Properties data = propertyFile.loadProperty("payment");
		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}

		String myproduct="%s";
		String testProduct = null;

		if (System.getProperty("product") == null) {
			
			testProduct =Products.valueOf(String.format(myproduct,product).
												toUpperCase()).getProductName();
			
		} else {
			
			testProduct =Products.valueOf( String.format(myproduct,System.getProperty("product")).
															toUpperCase()).getProductName();
			
		}

		if(!driver.getCurrentUrl().contains("payment.do"))
		{
			
			String paymentURL = "%s/" + data.getProperty("paymentURL")+ testProduct;
	
			if (siteURL() == null) {
				driver.get(String.format(paymentURL, siteurl));
			} else {
				driver.get(String.format(paymentURL, siteURL()));
			}
	
			Login signIn = new Login(getDriver());
			signIn.login(username, password,site);
			
		}
		Payment payForProduct = new Payment(driver);
		if (site.name().contains(Sites.FR.name())) {
			payForProduct.setFirstNameAsInCard(data
					.getProperty("CardFirstNameFR"));
		} else {

			payForProduct.setFirstNameAsInCard(data
					.getProperty("CardFirstName"));
			payForProduct.setLastNameAsInCard(data.getProperty("CardLastName"));
		}

		CaptureScreen myscreen = new CaptureScreen(driver);
		myscreen.takeScreenShot(product, "PaymentPage");

		if (site.name().contains(Sites.FR.name())) {
			payForProduct.selectCardType(data.getProperty("SelectCardType"));
		} else {
			payForProduct.setCardType(data.getProperty("CardType"));
		}
		payForProduct.setCardNumber(data.getProperty("CardNumber"));
		payForProduct.setCardMonth(data.getProperty("CardMonth"));
		payForProduct.setCardYear(data.getProperty("CardYear"));
		payForProduct.setCardPinNumber(data.getProperty("CardPIN"));

		payForProduct.setZipcode(data.getProperty("CardZipcode"));
		payForProduct.agreeCardTerms();

		if (site.name().contains(Sites.FR.name())
				|| site.name().contains(Sites.ID.name())
				|| site.name().contains(Sites.AIC.name())) {
			payForProduct.setCardState(data.getProperty("CardState"));
		}

		/* Select the submit payment---> */
		SelectElement selectPayment = new SelectElement(driver,
				data.getProperty("doPayment" + site));
		selectPayment.selectElementUsingXPath();

		/* Select the alert box---> */
		driver.switchTo().alert().accept();

		payForProduct.confirmPayment(product);
		setApplicationID(parseApplicationID());

		Logger logger = Logger.getLogger("ApplicationID");
		logger.info(getApplicationID());

	}

	@Override
	public void eqtest(String sitename, String siteurl, String product,
			String flowname) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void logintest(String sitename, String siteurl, String username,
			String password) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void sqtest(String sitename, String siteurl, String product,
			String username, String password, String flowname,
			String applicationID) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registrationtest(String sitename, String siteurl,
			String product, String emailID, String password, String flowname)
			throws Exception {
		// TODO Auto-generated method stub
		
	}


	
}
