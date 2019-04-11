package com.learnautomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	WebDriver driver;
	
	public LoginPage(WebDriver ldriver){
		this.driver =ldriver;
		
	}

	
	@FindBy(name="email") WebElement username;
	
	@FindBy(name="password") WebElement password;
	
	@FindBy(xpath="//div[@class='ui fluid large blue submit button']") WebElement loginbutton;
	
	
	public void logintocrm(String usernameapplication, String Passwordapplication) throws InterruptedException{
		
		Thread.sleep(2000);
		
		username.sendKeys(usernameapplication);
		password.sendKeys(Passwordapplication);
		loginbutton.click();
	}
	

	
	
}


