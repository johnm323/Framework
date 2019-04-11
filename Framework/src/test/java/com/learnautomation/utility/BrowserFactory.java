package com.learnautomation.utility;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startapplication(WebDriver driver, String browsername, String AppURL){
		
		if(browsername.equals("Chrome")){
			System.setProperty("webdriver.chrome.driver","./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
						
		}
		
		if(browsername.equals("Firefox")){
			System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
			
			
		}
		
		if(browsername.equals("IE")){
			
		}
		
		else{
			System.out.println("We will not support this browser");
		}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(AppURL);
		return driver;
	}
	
	
	public static void closebrowser(WebDriver driver){
		driver.close();
		
	}

}
