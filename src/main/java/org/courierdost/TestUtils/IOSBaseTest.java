package org.courierdost.TestUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;

import org.courierdost.utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class IOSBaseTest extends AppiumUtils {

	public IOSDriver driver;
	public AppiumDriverLocalService service;
	public Properties prop;

    @BeforeSuite(alwaysRun = true)
	public void setUpProperty() throws IOException {
    	prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//org//courierdost//testData//testdata.properties");
		prop.load(fis);
        fis.close();
    }

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException {

		// service = startAppiumServer(ipAddress,Integer.parseInt(port));

		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iPhone 16 Pro");
		options.setApp(System.getProperty("user.dir") + "//src//main//java//org//courierdost//resources//Runner.app");

		/// Users/bhagatsinhk/Documents/bgtkher002/AppiumFramework/src/test/java/org/courierdost/resources
		options.setPlatformVersion("18.1");
		// Appium- Webdriver Agent -> IOS Apps.
		options.setWdaLaunchTimeout(Duration.ofSeconds(20));
		options.setCapability("autoAcceptAlerts", true);
		options.setCapability("permissions", "{\"com.itdcd.vendor\": {\"photos\": \"yes\"}}");


		driver = new IOSDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
