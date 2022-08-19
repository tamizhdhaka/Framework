package com.automation.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ExcelDataProvider;
import com.aventstack.extentreports.model.SystemEnvInfo;

public class LoginTestCRM extends BaseClass {
	
	
	
	
    @Test
	public void loginApp() {
		
		
		logger=report.createTest("Login to SwagLabs");
    	
    	LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
    	
    	logger.info("Starting Application");
		
		loginPage.loginToCRM(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.pass("Login success");
		
	}
}
