package org.courierdost.android;

import java.io.IOException;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.SignUpPage;
import org.testng.annotations.Test;

public class SignUpTest extends AndroidBaseTest  {
	SignUpPage LP;
	
	@Test
	public void loginAsVendor() throws InterruptedException, IOException {
		LP = new SignUpPage(driver);
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickGSTNumberFieldAndSendNumber("36DKBCU9155J1ZL");
		LP.clickProceed();
		LP.fillCompanyDetails();
		LP.fillOTP("1234");
		LP.addfirstpin("1234");
		LP.addReEnterpin("1234");
		LP.savePinAndContinue();
		LP.selectInternationalDomestic();
		LP.addAdditionalDetailsName("Name");
		LP.addAdditionalDetailsWeblink("http://webdlink.com");
		LP.addAdditionalDetailsPhone("1234567890");
		LP.saveAddCompanyLogo();
		LP.proceedAdditionalDetails();
		LP.inviteTeaWithPhone("8736343837");
		LP.clickSendInvite();		LP.searchforLocation("Ahmedabad");
		LP.clickAddmoreDetails();
		LP.clickSaveAddressDetails();
	}
	
}
