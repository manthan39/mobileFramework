package org.courierdost.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.LoginPage;
import org.courierdost.pageObjects.android.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginPageTest extends AndroidBaseTest  {
	LoginPage loginPageObj;
	SignUpPage LP;


	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
		fis.close();

		
	}

	
	@Test
	public void loginpageAsVendor() throws InterruptedException {
		LP = new SignUpPage(driver);
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickNextButton();
	/*	loginPageObj = new LoginPage(driver);
		loginPageObj.clickloginLink();
		loginPageObj.enterMobileNumber(prop.getProperty("Mobile1"));
		loginPageObj.clickVerifyButton();
		loginPageObj.fillOTP(prop.getProperty("PIN1"));
		loginPageObj.clickloginButton();
		loginPageObj.clickSingUpButton();
		loginPageObj.clicktncdetails();
		loginPageObj.clickOnPrivacyPolicy();
		loginPageObj.clicktncdetails();
		*/
	}
	
}
