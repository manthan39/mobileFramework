package org.courierdost.android;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.courierdost.TestUtils.AndroidBaseTest;
import org.courierdost.pageObjects.android.FormPage;
import org.courierdost.pageObjects.android.FormPage;


public class androidFirstTest extends AndroidBaseTest 
	
{
	FormPage fp;
	private Properties prop;

    @BeforeSuite
    public void setup() throws IOException {
    	prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
        fis.close();
    }
	
	
	@Test
	public void FillForm() throws IOException{
		
	fp = new FormPage(driver);
	fp.setNameField(prop.getProperty("gstNumber"));
	fp.setGender(prop.getProperty("gender"));
	fp.setCountrySelection(prop.getProperty("country"));
}

/*@BeforeMethod(alwaysRun=true)
public void preSetup()
{

	fp.setActivity();
			
}*/
}
