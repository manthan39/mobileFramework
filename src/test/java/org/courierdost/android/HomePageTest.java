package org.courierdost.android;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.utils.AndroidActions;
import org.courierdost.pageObjects.android.HomePage;
import org.courierdost.pageObjects.android.LoginPage;
import org.testng.annotations.Test;

public class HomePageTest extends AndroidBaseTest  {
	HomePage homePageObj;
	LoginPage loginPageObj;
	
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
