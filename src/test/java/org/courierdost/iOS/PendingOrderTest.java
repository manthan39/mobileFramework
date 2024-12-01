package org.courierdost.iOS;

import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.PendingOrderPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PendingOrderTest extends IOSBaseTest{
	
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;
	PendingOrderPage pendingOrderObj;

	@BeforeTest
	public void setUpProperty() throws IOException {
		loadProperties();	
	}
	
	@Test(groups = {"Regression"},description = "Verfiy the pending order screen if pending order is available on HomePage")
	public void pendingOrderVerification() throws IOException, InterruptedException {
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		

		loginPageObj = new LoginPage(driver);
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(getPropertyOnKey("Mobile1"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(getPropertyOnKey("PIN1"));
		loginPageObj.clickingOnLoginButton();
		
		homePageObj = new HomePage(driver);
		if(homePageObj.isPendingOrderAvailable()) {
			homePageObj.pendingOrderClick().click();
			pendingOrderObj = new PendingOrderPage(driver);
			if(pendingOrderObj.numbersOfOrder()>0) {
				pendingOrderObj.clickOnFirstPendingOrderFromList();
				pendingOrderObj.validatePendingOrderScreenFields();
			}else {
				assertTrue(pendingOrderObj.noPendingOrderNow().isDisplayed());
			}
			
		}
	}
}
