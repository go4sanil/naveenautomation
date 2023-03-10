package com.naveenautomation.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.naveenautomation.Browsers.Browsers;
import com.naveenautomation.Listeners.WebdriverEvents;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {

    public static WebDriver driver;
    public static Capabilities capabalities;
    
    public Browsers DEFAULT_BROWSER = Browsers.GOOGLE_CHROME;
    
    public static WebdriverEvents events=new WebdriverEvents();
	public EventFiringWebDriver eventFiringWebDriver;

        	public void launchBrowser() {

    		switch (DEFAULT_BROWSER) {
    		case GOOGLE_CHROME:
    			WebDriverManager.chromedriver().setup();
    			driver = new ChromeDriver();
    			break;

    		case EDGE:
    			WebDriverManager.edgedriver().setup();
    			driver = new EdgeDriver();
    			break;

    		case FIREFOX:
    			WebDriverManager.firefoxdriver().setup();
    			driver = new FirefoxDriver();
    			break;
    			
    		case OPERA:
    			WebDriverManager.operadriver().setup();
    			driver = new OperaDriver();
    			break;	

    		default:
    			System.out.println("Not a valid browser");
    			break;
    		}
    	 
        
        eventFiringWebDriver=new EventFiringWebDriver(driver);
		eventFiringWebDriver.register(events);
		driver=eventFiringWebDriver;
		

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.manage().window().maximize();
        
      
 	
//		//Manage the page load timeout
//		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
 	
//		//Manage the script load timeout
//		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);

        // Launch a page
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/login");
 
    }

    public void quitBrowser() {

        driver.quit();
    }

}

