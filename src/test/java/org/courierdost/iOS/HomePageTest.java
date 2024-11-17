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

public class HomePageTest extends IOSBaseTest {
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	HomePage homePageObj;

	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
		fis.close();

		
	}

	@Test
	public void homePageVerification() {

		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		

		loginPageObj = new LoginPage(driver);

		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber(prop.getProperty("Mobile1"));
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin(prop.getProperty("PIN1"));
		loginPageObj.clickingOnLoginButton();
		
		homePageObj = new HomePage(driver);
		homePageObj.verifyHomePageElements();
		homePageObj.showAllactiveOrderList();

	}
}
