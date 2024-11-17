package org.courierdost.iOS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

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
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
		fis.close();		
	}

	@Test
	public void activeOrderVerification() {

		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		

		loginPageObj = new LoginPage(driver);
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(prop.getProperty("Mobile1"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(prop.getProperty("PIN1"));
		loginPageObj.clickingOnLoginButton();
		
		homePageObj = new HomePage(driver);
		homePageObj.clickOnActiveOrder();
		
		activeOrderObj = new ActiveOrderPage(driver);
		activeOrderObj.validateActiveOrderScreenFields();
		activeOrderObj.assignDeliveryPartner();
		
		homePageObj.domesticTab().isDisplayed();
		

	}
}
