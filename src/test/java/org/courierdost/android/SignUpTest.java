package org.courierdost.android;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.SignUpPage;
import org.testng.annotations.Test;

public class SignUpTest extends AndroidBaseTest  {
	SignUpPage LP;
	
	@Test
	public void loginAsVendor() throws InterruptedException {
		LP = new SignUpPage(driver);
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickProceed();
		LP.clickGSTNumberFieldAndSendNumber("36AABCU9355J1ZS");
		LP.clickProceed();
		LP.fillCompanyDetails();
		LP.fillOTP("1234");
		LP.addfirstpin("1234");
		LP.addReEnterpin("1234");
		LP.savePinAndContinue();
	}
	
}
