package org.courierdost.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public abstract class AppiumUtils {

	public AppiumDriverLocalService service;

	
	public Double getFormattedAmount(String amount)
	{
		Double price = Double.parseDouble(amount.substring(1));
		return price;
		
	}
	
	public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {
//System.getProperty("user.dir")+"//src//test//java//org//rahulshettyacademy//testData//eCommerce.json"
		// conver json file content to json string
		String jsonContent = FileUtils.readFileToString(new File(jsonFilePath),StandardCharsets.UTF_8);

		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});

		return data;

	}
	
	public AppiumDriverLocalService startAppiumServer(String ipAddress,int port)
	{
		 HashMap<String, String> environment = new HashMap();
		 System.out.println(System.getenv("PATH"));
		 environment.put("PATH", "/usr/local/Cellar/node/20.8.0/bin:" + System.getenv("PATH"));

		
	 service = new AppiumServiceBuilder().withAppiumJS(new File("/usr/local/Cellar/node/20.8.0/lib/node_modules/appium/build/lib/main.js"))	
		
			 .withEnvironment(environment)
			 
			 .withIPAddress(ipAddress).usingPort(port).build();
			service.start();
			return service;
			
	}
	
	
	public void waitForElementToAppear(WebElement ele, AppiumDriver driver,int timeInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
	    wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void waitForElementToBeClickable(WebElement ele, AppiumDriver driver,int timeInSeconds)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeInSeconds));
	    wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	 public void waitUntilElementIsClicked(WebElement element, int timeoutInSeconds,AppiumDriver driver) {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	        try {
	            wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	        } catch (Exception e) {
	            System.out.println("Element was not clickable within the specified time: " + e.getMessage());
	        }
	    }
	
	
	public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException
	{
		File source = driver.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"//reports"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;
		//1. capture and place in folder //2. extent report pick file and attach to report
		
	}
	
	public String generateMobileNumber() {
		
		String mobileNumber;
		
		Random random = new Random();
		
		int firstDigit = random.nextInt(9) + 1;
		long remainingDigits = (long) (random.nextDouble() * 1_000_000_000);
		mobileNumber = firstDigit + String.format("%09d", remainingDigits);
		return mobileNumber;
	}
	
	public String UniqueGSTNumber() {
		
		Random random = new Random();
        int fourDigitNumber = random.nextInt(9000) + 1000;
		
		return "36AABCU"+fourDigitNumber+"J1ZQ";
	}
	
	public StringBuilder generateName() {
		Random random = new Random();
        StringBuilder name = new StringBuilder();

        // Generate 5 random alphabetic characters
        for (int i = 0; i < 10; i++) {
            // Randomly choose between uppercase (A-Z) and lowercase (a-z)
            char randomChar = (char) (random.nextBoolean() 
                ? random.nextInt(26) + 'A'  // Uppercase
                : random.nextInt(26) + 'a'  // Lowercase
            );
            name.append(randomChar);
        }
        return name;
	}
	
}
