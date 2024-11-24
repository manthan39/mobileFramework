package org.courierdost.pageObjects.android;

import java.time.Duration;
import java.util.Arrays;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Origin;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class PendingOrderPage extends AndroidActions{
	public AndroidDriver driver;
	
	public PendingOrderPage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;
		
	}

	public WebElement pendingOrderButton() {
		return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Pending orders')]"));
	}
	
	public WebElement orderId() {
		return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Order Id')][1]"));
	}
	public WebElement orderFromToValidation() {
		String regexPattern = "\\d{6}\\n[A-Za-z]+\\n\\d{6}\\n[A-Za-z]+\\n₹ \\d+\\.\\d";
		 String dynamicXPath = String.format(
		            "//android.widget.ImageView[matches(@content-desc, '%s')]",
		            regexPattern
		        );
		 WebElement element = driver.findElement(AppiumBy.xpath(dynamicXPath));
         return element;
	}
	 public boolean isPackageDetailsVisible() {
	        String[] labels = {
	            "Weight per unit",  // Weight per unit
	            "Quantity",         // Quantity
	            "Package Value",    // Package Value
	            "Delivery Type",    // Delivery Type
	            "Pickup Date",      // Pickup Date
	            "Pickup Time",      // Pickup Time
	            "Sender Details",
	            "Order Id",
	            "Pickup Address",
	            "Phone",
	            "Adhaar Id Number",
	            "Receiver Details",
	            "Delivery Address",
	            "Name",
	            "Phone"
	        };

	        for (String label : labels) {
	            boolean isVisible = false; // Track visibility of each label
	            for (int attempt = 0; attempt < 2; attempt++) { // Allow one swipe attempt
	                try {
	                    // Locate element using XPath with contains()
	                    String xpath = "//*[contains(@text, '" + label + "') or contains(@content-desc, '" + label + "')]";
	                    WebElement element = driver.findElement(AppiumBy.xpath(xpath));

	                    if (element.isDisplayed()) {
	                        isVisible = true; // Set visible if found and displayed
	                        break; // Exit retry loop
	                    }
	                } catch (NoSuchElementException e) {
	                    System.out.println("Label not found: " + label + " on attempt " + (attempt + 1));
	                }

	                // Perform swipe if element is not found or not visible
	                if (attempt == 0) {
	                    System.out.println("Performing swipe for label: " + label);
	                    driver.perform(Arrays.asList(createSwipeAction()));
	                }
	            }

	            if (!isVisible) {
	                System.out.println("Label still not visible after swipe: " + label);
	                return false; // Return false if any label is not visible after retries
	            }
	        }
	        return true;
	    }
	
	public void clickPendingOrderButton() throws InterruptedException {
		
		WebElement home =driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Home')]"));

		waitForElementToAppear(home, driver, 2000);
		Thread.sleep(300);
	    // Perform the swipe
	    driver.perform(Arrays.asList(createSwipeAction()));
        pendingOrderButton().click();
                   
    
	}
	public void isOrderDetailDisplayed() {
		orderFromToValidation().isDisplayed();
	}
	public void clickOrderID() {
		orderId().click();
		
	}
}
