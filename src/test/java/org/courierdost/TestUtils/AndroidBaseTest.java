package org.courierdost.TestUtils;

import org.testng.annotations.BeforeClass;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import org.courierdost.pageObjects.android.FormPage;
import org.courierdost.utils.AppiumUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class AndroidBaseTest extends AppiumUtils {

	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public FormPage formPage;

	@BeforeClass(alwaysRun = true)
	public void ConfigureAppium() throws IOException {
		DesiredCapabilities flutterCapabilities = new DesiredCapabilities();
		flutterCapabilities.setCapability("appium:deviceName", "Pixel 8 Pro API 30");
		flutterCapabilities.setCapability("platformName", "Android");

		flutterCapabilities.setCapability("appium:automationName", "uiAutomator2");

		flutterCapabilities.setCapability("appium:app",
				System.getProperty("user.dir") + "//src//test//java//org//courierdost//resources//General-Store.apk");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), flutterCapabilities);

		// driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		formPage = new FormPage(driver);
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driver.quit();
	}

}
