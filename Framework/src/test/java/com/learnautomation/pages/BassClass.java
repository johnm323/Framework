package com.learnautomation.pages;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.ConfigDataProvider;
import com.learnautomation.utility.ExcelDataProvider;
import com.learnautomation.utility.Helper;

public class BassClass {
	
	public WebDriver driver;
	public ExcelDataProvider excel;
	public ConfigDataProvider config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setupSuite(){
		
		Reporter.log("Setting up reports and test is getting started",true);
		
		
		 excel = new ExcelDataProvider();
		 config = new ConfigDataProvider();
		 
		 
ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/freecrm"+Helper.getCurrentDateTime()+".html"));
report = new ExtentReports();
report.attachReporter(extent);


Reporter.log("Setting Done and test can be started",true);
		 
		 
	}
	
	
	@BeforeClass
	public void setup(){
		
		Reporter.log("Trying to start browser and getting application ready",true);
		
		BrowserFactory.startapplication(driver, config.getBrowser(), config.getStagingURL());
		driver.getTitle();
		
		Reporter.log("Browser and application is up and running",true);
	}
	
	@AfterClass
	public void teardown(){
		
		Reporter.log("Test is about to end",true);
		
		BrowserFactory.closebrowser(driver);
	}
		
	
	@AfterMethod
	public void teardownmethod(ITestResult result) throws IOException{
		
		if(result.getStatus()==ITestResult.FAILURE){
			logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
			
		}else if(result.getStatus()==ITestResult.SUCCESS){
			logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());
	
		}else if(result.getStatus()==ITestResult.SKIP){
			logger.skip("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.capturescreenshot(driver)).build());

		}
		
		
		
		report.flush();
		Reporter.log("Test Completed",true);
	}

}
