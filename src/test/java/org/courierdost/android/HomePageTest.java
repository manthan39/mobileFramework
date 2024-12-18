package org.courierdost.android;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.HomePage;
import org.courierdost.pageObjects.android.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends AndroidBaseTest  {
	HomePage homePageObj;
	LoginPage loginPageObj;
	
	@BeforeTest(alwaysRun = true)
	public void setUpProperty() throws IOException, InterruptedException {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream(
//				System.getProperty("user.dir") + "//src//main//java//org//courierdost//testData//testdata.properties");
//		prop.load(fis);
//		fis.close();
		loadProperties();
		LoginPage lpt = new LoginPage(driver);
		lpt.logmein(prop.getProperty("Mobile1"),prop.getProperty("pin"));
		
	}

	
	@Test
	public void homepageAsVendor() throws InterruptedException {
		loginPageObj = new LoginPage(driver);
		loginPageObj.clickloginLink();
		loginPageObj.enterMobileNumber("3114859375");
		loginPageObj.clickVerifyButton();
		loginPageObj.fillOTP("1234");
		loginPageObj.clickloginButton();
	
		homePageObj = new HomePage(driver);
		
		homePageObj.clickOnInternationalTab();
		homePageObj.clickOnDomesticTab();
		homePageObj.clickOnStatisticsTab();
		homePageObj.clickOnSupportTab();
		homePageObj.clickOnSettingTab();
		homePageObj.clickOnHomeTab();
		homePageObj.clickOnShowAllBtn();
		driver.navigate().back();
		homePageObj.clickOnPendingOrdersSection();
		driver.navigate().back();
		homePageObj.clickOnPastOrdersSection();
	}
	
}
