package org.courierdost.pageObjects.android;

import org.courierdost.utils.AndroidActions;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class HomePage extends AndroidActions{
	public AndroidDriver driver;
	
	public HomePage(AndroidDriver driver) {
		super(driver);
		this.driver =driver;
	}

    public WebElement domesticTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Domestic')]"));
    }

    public WebElement internationalTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'International')]"));
    }

    public WebElement showAllButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Show all']"));
    }

    public WebElement activeOrdersSection() {
        return driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='Active orders']"));
    }

    public WebElement pendingOrdersSection() {
        return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Pending orders ')]"));
    }
    
    public WebElement pastOrdersSection() {
        return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Past orders ')]"));
    }

    public WebElement homeTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Home\nTab 1 of 4']"));
    }

    private WebElement settingsTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Settings\nTab 4 of 4']"));
    }
    public WebElement noPickUpRequestHeader() {
		return driver.findElement(AppiumBy.accessibilityId("No pickup requests available"));
	}
    private WebElement statisticsTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Statistics\nTab 2 of 4']"));
    }
    
    private WebElement supportTab() {
        return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[@content-desc='Supports\nTab 3 of 4']"));
    }

	public WebElement firstNewOrderOnHomePage() {
		return driver.findElement(AppiumBy.xpath("//android.view.View[contains(@content-desc, 'Order ID') and @index='0']"));

	}
	
	public WebElement pendingOrderClick() {
		return driver.findElement(AppiumBy.xpath("//android.widget.ImageView[contains(@content-desc, 'Pending orders')]"));

	}
	
	//==============Web elements completed========================//
    
    public void clickOnStatisticsTab() {
    	statisticsTab().click();
    }
	
    public void clickOnSupportTab() {
    	supportTab().click();
    }
    
    public void clickOnSettingTab() {
    	settingsTab().click();
    }
    
    public void clickOnHomeTab() {
    	homeTab().click();
    }
    
    public void clickOnShowAllBtn() {
    	showAllButton().click();
    }
    
    public void clickOnPendingOrdersSection() {
    	pendingOrdersSection().click();
    }
    
    public void clickOnPastOrdersSection() {
    	pastOrdersSection().click();
    }
    
    public void clickOnInternationalTab() {
    	internationalTab().click();
    }
    
    public void clickOnDomesticTab() {
    	domesticTab().click();
    }
      
	public void clickOnNewOrder() {
		waitForElementToBeClickable(firstNewOrderOnHomePage(), driver, 10);
		firstNewOrderOnHomePage().click();
	}
	
	public boolean isNewOrderAvailavle() throws InterruptedException {
		Thread.sleep(5000);
		return firstNewOrderOnHomePage().isDisplayed();
	}

}
