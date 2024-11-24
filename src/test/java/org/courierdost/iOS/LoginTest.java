package org.courierdost.iOS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest extends IOSBaseTest{
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;
	
	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		loadProperties();
    }
	
	@Test
	public void loginAsVendor() throws IOException {
	
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		
		loginPageObj = new LoginPage(driver);
		
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(getPropertyOnKey("Mobile1"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(getPropertyOnKey("PIN1"));
		loginPageObj.clickingOnLoginButton();
		
		homePageObj = new HomePage(driver);
		homePageObj.verifyHomePageElements();
		
	}
}
