package org.courierdost.android;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.utils.AndroidActions;
import org.courierdost.pageObjects.android.LoginPage;
import org.courierdost.pageObjects.android.SignUpPage;
import org.testng.annotations.Test;

public class LoginPageTest extends AndroidBaseTest  {
	LoginPage loginPageObj;

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
		loginPageObj = new LoginPage(driver);
		loginPageObj.clickloginLink();
		loginPageObj.enterMobileNumber("3114859375");
		loginPageObj.clickVerifyButton();
		loginPageObj.fillOTP("1234");
		loginPageObj.clickloginButton();
		loginPageObj.clickSingUpButton();
		loginPageObj.clicktncdetails();
		loginPageObj.clickOnPrivacyPolicy();
		loginPageObj.clicktncdetails();
		
	}
	
}
