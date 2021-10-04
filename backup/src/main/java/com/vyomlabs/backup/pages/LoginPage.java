package com.vyomlabs.backup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vyomlabs.backup.generics.WebactionUtils;

public class LoginPage extends BasePage {

	
	public LoginPage(WebDriver driver,WebactionUtils actionUtils)
	{
		super(driver,actionUtils);
	}
	
	//Writting webElements 
	
	@FindBy(id="email")
	private WebElement email;
	
	@FindBy(id="passwd")
	private WebElement password;
	
	@FindBy(id="SubmitLogin")
	private WebElement submitButton;
	
	@FindBy(xpath="//a[text()='Forgot your password?']")
	private WebElement forgotPassworkLink;
	


//Login Page Action methods

   public HomePage Login(String un,String pwd)
   {
	   actionUtils.sendKeys(email, un);
	   actionUtils.sendKeys(password, pwd);
	   actionUtils.jsClick(submitButton);
	   return new HomePage(driver,actionUtils);
   }
   public boolean VerifyLoginPageTitle()
   {
	   return driver.getTitle().equals("Login - My Store");
   }
   
}