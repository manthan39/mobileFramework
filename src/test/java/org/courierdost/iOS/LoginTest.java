package org.courierdost.iOS;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.Test;

public class LoginTest extends IOSBaseTest{
	SignUpPage signUpObj;
	LoginPage loginPageObj;
	
	@Test
	public void loginAsVendor() {
	
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButton();
		signUpObj.clickNextButton();
		signUpObj.clickNextButton();
		
		loginPageObj = new LoginPage(driver);
		
		loginPageObj.clickingOnAlredyRegisteredButton();
		loginPageObj.inputMobileNumber("3114859375");
		loginPageObj.clickingOnVerifyButton();
		loginPageObj.addPin("1234");
		loginPageObj.clickingOnLoginButton();
		
	}
}
