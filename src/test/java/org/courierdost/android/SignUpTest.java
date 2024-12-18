package org.courierdost.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.SignUpPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest extends AndroidBaseTest  {
	SignUpPage LP;
	
	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
		loadProperties();
	}

	
	@Test
	public void loginAsVendor() throws InterruptedException, IOException {
		LP = new SignUpPage(driver);
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickNextButton();
		LP.clickGSTNumberFieldAndSendNumber(UniqueGSTNumber());
		LP.clickProceed();
		LP.fillCompanyDetails();
		LP.fillOTP(prop.getProperty("fillOTP"));
		LP.addfirstpin(prop.getProperty("addfirstpin"));
		LP.addReEnterpin(prop.getProperty("addReEnterpin"));
		LP.savePinAndContinue();
		LP.selectInternationalDomestic();
		LP.addAdditionalDetailsName(generateName());
		LP.addAdditionalDetailsWeblink(generateName());
		LP.addAdditionalDetailsPhone(generateMobileNumber());
		LP.saveAddCompanyLogo();
		LP.proceedAdditionalDetails();
		LP.inviteTeaWithPhone(generateMobileNumber());
		LP.clickSendInvite();		
		LP.searchforLocation(prop.getProperty("place"));
		LP.clickAddmoreDetails();
		LP.clickSaveAddressDetails();
	}
	
}
