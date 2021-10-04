package com.vyomlabs.backup.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vyomlabs.backup.generics.WebactionUtils;

public class HomePage extends BasePage {

	
	public HomePage(WebDriver driver, WebactionUtils actionUtils)
	{
		super(driver, actionUtils);
	}
	
	@FindBy(xpath="//a[text()='Women']")
	private WebElement WomenTab;
	
	@FindBy(xpath=("((//a[text()='T-shirts'])[2]"))
	private WebElement TshirtTab;
	
	@FindBy(xpath="(//a[@title='Dresses'])[2]")
	private WebElement DressesTab;
	
	@FindBy(xpath="//a[@title='Log me out']")
	private WebElement SignOutButton;
	
	public MyStorePage clickOnTab(String tabName)
	{
		//Utilities.SleepInsecsoncds(4);
		tabName=tabName.toLowerCase();
		
		switch (tabName) {
		 case "women":  actionUtils.Click(WomenTab);
		                break;
		 case "dresses": actionUtils.jsClick(DressesTab);
		 				break;   
		 case "tshirt":  actionUtils.Click(TshirtTab);
		 				break;			
		    default:
			break;		
			
			
		}
		
		return new MyStorePage(driver,actionUtils);
		
	}
	
	public void Logout()
	{
		actionUtils.jsClick(SignOutButton);
	}
	
}
