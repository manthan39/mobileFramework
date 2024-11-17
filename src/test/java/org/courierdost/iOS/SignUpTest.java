package org.courierdost.iOS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.IOSBaseTest;
import org.courierdost.pageObjects.ios.HomePage;
import org.courierdost.pageObjects.ios.SignUpPage;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.annotation.JsonAppend.Prop;

public class SignUpTest extends IOSBaseTest  {
	SignUpPage signUpObj;
	HomePage homePageObj;
	
	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException {
    	prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
        fis.close();
    }
	
	@Test	public void signUpAsVendor() throws InterruptedException {
		
		signUpObj = new SignUpPage(driver);
		signUpObj.clickNextButtonForOnboardingScreen();
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
		homePageObj.domesticTab().isDisplayed();
		homePageObj.internationalTab().click();
		
		
	}
	
}
