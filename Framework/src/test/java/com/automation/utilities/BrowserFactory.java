package com.automation.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class BrowserFactory {
 
	public static WebDriver startApplication(WebDriver driver,String browserName,String appURL) {
		if(browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}else if(browserName.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver= new EdgeDriver();
		}else {
			System.out.println("Sorry, this browser is not supported");
		}
 		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(appURL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
	}
	
	public static void quitBrowser(WebDriver driver) {
		driver.quit();
	}
}
