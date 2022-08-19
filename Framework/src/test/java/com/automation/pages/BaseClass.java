package com.automation.pages;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigDataProvider;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class BaseClass {
  public WebDriver driver;
  public ExcelDataProvider excel;
  public ConfigDataProvider config;
  public Helper helper;
  public ExtentReports report;
  public ExtentTest logger;
  
    @BeforeSuite
    public void setUpSuite() {
    	 excel=new ExcelDataProvider();
    	 config=new ConfigDataProvider();
    	 helper=new Helper();
    	 
    	 ExtentSparkReporter spark=new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/Spark_"+Helper.getCurrentDateTime()+".html"));
    	 report=new ExtentReports();
    	 report.attachReporter(spark);
    }
    
	@BeforeClass
	public void setUp() {
		driver=BrowserFactory.startApplication(driver, config.getBrowser(), config.getStagingUrl());
	}
	
	@AfterClass
	public void tearDown() {
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterMethod
	public void tearDownMenthod(ITestResult result) {
		if(result.getStatus()==ITestResult.FAILURE) {
		helper.captureScreenshot(driver);
		logger.fail("Login Failed", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			
		helper.captureScreenshot(driver);
		logger.pass("Login Successful", MediaEntityBuilder.createScreenCaptureFromPath(helper.captureScreenshot(driver)).build());	
		}
		
		report.flush();
	}
}
