package org.courierdost.iOS;

import java.io.IOException;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends IOSBaseTest {
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;

	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		loadProperties();
	}

	@Test(groups = {"Regression"},description = "Verfiy the home page elements after login with valid credentials")
	public void homePageVerification() throws IOException, InterruptedException {

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
		homePageObj.showAllactiveOrderList();

	}
}
