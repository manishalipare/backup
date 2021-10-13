package com.vyomlabs.backup.generics;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebactionUtils {
	
    WebDriver driver;
    JavascriptExecutor js;
    Actions action;
    WebDriverWait wait;
    
	public WebactionUtils(WebDriver driver,long eto)
	{
		this.driver=driver;
		js=(JavascriptExecutor) driver;
		action=new Actions(driver);
		new WebDriverWait(driver, eto);
		
	}
	public void sendKeys(WebElement target,String KeysToType)
	{
		target.clear();
		target.sendKeys(KeysToType);
	}
	
	public void Click(WebElement target)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(target));
		target.click();
	}
	
	public void jsClick(WebElement target)
	{
		//wait.until(ExpectedConditions.elementToBeClickable(target));
		js.executeScript("arguments[0].click()",target);
	}
	
	public void ScrollDown(int yCoordinate)
	{
		js.executeScript("window.scrollBy(0," +yCoordinate+")");
	}
	public void Scrollup(int yCoordinate)
	{
		js.executeScript("window.scrollBy(0,-" +yCoordinate+")");
	}
	
	public void hoverMouseOnElement(WebElement target)
	{
		action.moveToElement(target).perform();
	}
	public void RightClickt(WebElement target)
	{
		action.contextClick(target).perform();
	}
	
	public void SelectByVissibleText(WebElement target,String vissibleText)
	{
		Select S1 = new Select(target);
		S1.selectByVisibleText(vissibleText);
	}
	public void SelectByValue(WebElement target, String Value)
	{
		Select S1 = new Select(target);
		S1.selectByValue(Value);
	}
	
	public void switchtoFrame(String idnameIndex)
	{
		   Utilities.SleepInsecsoncds(5);
	       int index= Integer.parseInt(idnameIndex);
	       try
	       {
	    	   driver.switchTo().frame(index);
	       }
	       catch(NumberFormatException e)
	       {
	    	   driver.switchTo().frame(idnameIndex);
	       }
	}
}

















