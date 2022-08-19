package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	//New comment1
    WebDriver driver;
    public LoginPage(WebDriver ldriver){
    	this.driver=ldriver;
    }
    //New comment2
    @FindBy(id="user-name") WebElement username;
    @FindBy(id="password") WebElement pass;
    @FindBy(id="login-button") WebElement loginButton;
    
    public void loginToCRM(String AppUsername, String AppPassword) {
    	
    	username.sendKeys(AppUsername);
    	pass.sendKeys(AppPassword);  	
    	loginButton.click();
    	
    	try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
