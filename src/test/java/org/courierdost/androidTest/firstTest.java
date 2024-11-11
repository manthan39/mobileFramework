package org.courierdost.androidTest;

import org.testng.annotations.Test;
import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.FormPage;

public class firstTest extends AndroidBaseTest

{
	@Test
	public void FillForm() {
		formPage.setNameField("manthan");
		formPage.setGender("Male");
		formPage.setCountrySelection("Brazil");
	}

	/*
	 * @BeforeMethod(alwaysRun=true) public void preSetup() {
	 * 
	 * formPage.setActivity();
	 * 
	 * }
	 */
}