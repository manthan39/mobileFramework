package org.courierdost.iOS;

import java.io.IOException;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.ActiveOrderPage;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ActiveOrderPageTest extends IOSBaseTest {
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;
	ActiveOrderPage activeOrderObj;

	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		loadProperties();
	}

	@Test(groups = {"Regression"},description = "Verfiy the active order page if active order is present")
	public void activeOrderVerification() throws InterruptedException, IOException {

		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		

		loginPageObj = new LoginPage(driver);
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(getPropertyOnKey("Mobile"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(getPropertyOnKey("PIN"));
		loginPageObj.clickingOnLoginButton();
		
		homePageObj = new HomePage(driver);
		if(homePageObj.noActiveOrderScreenAvailable()==0) {
			homePageObj.clickOnActiveOrder();
			
			activeOrderObj = new ActiveOrderPage(driver);
			activeOrderObj.validateActiveOrderScreenFields();
			activeOrderObj.assignDeliveryPartner();
			
			homePageObj.domesticTab().isDisplayed();
		}else {
			System.out.println("Active order is not available at this moment");
		}
		
	}
}
