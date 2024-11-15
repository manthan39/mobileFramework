package org.courierdost.iOS;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class SignUpTest extends IOSBaseTest  {
	SignUpPage signUpObj;
	HomePage homePageObj;
	
	@Test	public void signUpAsVendor() throws InterruptedException {
		
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButton();
		signUpObj.clickNextButton();
		signUpObj.clickNextButton();
		signUpObj.clickProceed();
		
		signUpObj.clickGSTNumberFieldAndSendNumber(UniqueGSTNumber());		
		signUpObj.fillCompanyDetails();
		signUpObj.fillOTP(prop.getProperty("fillOTP"));
		signUpObj.addfirstpin(prop.getProperty("addfirstpin"));
		signUpObj.addReEnterpin(prop.getProperty("addReEnterpin"));
		signUpObj.selectInternationalDomestic();
		signUpObj.additionalDetailsPage(generateName(), generateName(), generateMobileNumber());
		
		signUpObj.enterPhoneNumberAndSendInvite(generateMobileNumber());
		signUpObj.searchAreaAndSaveAddress();
		
		homePageObj = new HomePage(driver);
		homePageObj.verifyHomePageElements();
		
	}
	
}
