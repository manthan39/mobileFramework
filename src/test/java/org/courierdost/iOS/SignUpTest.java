package org.courierdost.iOS;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.Test;

public class SignUpTest extends IOSBaseTest  {
	SignUpPage LP;
	
	@Test
	public void loginAsVendor() throws InterruptedException {
		LP = new SignUpPage(driver);
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickProceed();
		LP.clickGSTNumberFieldAndSendNumber("36AABCU8422J1ZQ");
		LP.clickProceed();
		LP.fillCompanyDetails();
		LP.fillOTP("1234");
		LP.addfirstpin("1234");
		LP.addReEnterpin("1234");
		LP.savePinAndContinue();
		LP.selectInternationalDomestic();
		LP.clickProceed();
	}
	
}
