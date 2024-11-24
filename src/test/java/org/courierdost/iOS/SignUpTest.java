package org.courierdost.iOS;

import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.LoginPage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.openqa.selenium.Keys;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SignUpTest extends IOSBaseTest  {
	SignUpPage signUpObj;
	HomePage homePageObj;
	LoginPage loginPageObj;
	
	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
    	loadProperties();
    }
	
	@Test(priority = 1)
	public void signUpAsVendor() throws InterruptedException, IOException {
		
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		signUpObj.clickProceed();
		
		signUpObj.clickGSTNumberFieldAndSendNumber(UniqueGSTNumber());		
		signUpObj.clickOnVerifyOtp();
		signUpObj.fillOTP(getPropertyOnKey("fillOTP"));
		signUpObj.addfirstpin(getPropertyOnKey("addfirstpin"));
		signUpObj.addReEnterpin(getPropertyOnKey("addReEnterpin"));
		signUpObj.selectInternationalDomestic();
		signUpObj.additionalDetailsPage(generateName(), generateName(), generateMobileNumber());
		
		signUpObj.enterPhoneNumberAndSendInvite(generateMobileNumber());
		signUpObj.searchAreaAndSaveAddress();
		
		homePageObj = new HomePage(driver);
		homePageObj.domesticTab().isDisplayed();
		homePageObj.internationalTab().click();
		
	}
	
	@Test(priority = 2)
	public void errorCasesForSignUpFlow() throws InterruptedException, IOException {
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
		signUpObj.clickProceed();
		
		signUpObj.validateErrormessagesForGST();
		
		loginPageObj = new LoginPage(driver);
		loginPageObj.clickingOnAlredyRegisteredButton();
		
		loginPageObj.SignUpButton().click();
		
		signUpObj.clickGSTNumberFieldAndSendNumber(UniqueGSTNumber());	
		signUpObj.clickOnVerifyOtp();
		
		signUpObj.verifyOTPNumber().click();
		assertTrue(signUpObj.enterValidOTPError().isDisplayed());
		
		signUpObj.fillOTP(getPropertyOnKey("fillOTP"));
		
		signUpObj.savePINandContinue().click();
		
		assertTrue(signUpObj.emptyPinError().isDisplayed());
		assertTrue(signUpObj.emptyConfirmPinError().isDisplayed());
		signUpObj.addfirstpin(getPropertyOnKey("addfirstpin"));
		assertTrue(signUpObj.pinShouldBeMatchError().isDisplayed());
		signUpObj.addReEnterpin(getPropertyOnKey("addReEnterpin"));
		
		signUpObj.selectInternationalDomestic();
		
		signUpObj.additionaDetailsError();
		signUpObj.additionalDetailsPage(generateName(), generateName(), generateMobileNumber());
		
		waitForElementToBeClickable(signUpObj.inputPhoneNumber(), driver,90);
		
		//Need to check this
		
		signUpObj.inviteYourFriendScreenError();
		
		signUpObj.addressDetailsError();
		
		homePageObj = new HomePage(driver);
		homePageObj.domesticTab().isDisplayed();
		homePageObj.internationalTab().click();
		
	}
}
