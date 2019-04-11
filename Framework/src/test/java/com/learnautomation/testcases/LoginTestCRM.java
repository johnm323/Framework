package com.learnautomation.testcases;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.learnautomation.pages.BassClass;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.utility.BrowserFactory;
import com.learnautomation.utility.Helper;


public class LoginTestCRM extends BassClass {
	
	
	@Test
	public void loginApp() throws InterruptedException{
		
		logger = report.createTest("Login to CRM");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		
		logger.info("Start Application");
		
		loginPage.logintocrm(excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));
		
		logger.info("Login success");
		
	}
	

	
	
}
