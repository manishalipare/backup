package com.vyomlabs.backup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.vyomlabs.backup.generics.WebactionUtils;

public class BasePage {
    
	public WebDriver driver;
	public WebactionUtils actionUtils;
	public BasePage(WebDriver driver,WebactionUtils actionUtils)
	{
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		this.actionUtils=actionUtils;
	}
}
