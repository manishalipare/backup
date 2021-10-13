package com.vyomlabs.backup.generics;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
//import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class takeScreenShot {

	
	public static String getPageScreenShot(WebDriver driver, String testCaseName)
	{
	
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		LocalDateTime ltd = LocalDateTime.now();
		String date =ltd.toString().replace(':','-');
		TakesScreenshot ts = (TakesScreenshot) driver;
		driver.get("https://live.skillrary.com/testing-app/");
		File src = ts.getScreenshotAs(OutputType.FILE);
		String photopath="./errorshots/"+testCaseName+date+".png";
		File dest = new File(photopath);
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			return photopath;
	}
	
	public static String getElementScreenShot(WebElement target, String testCaseName)
	{
	
			LocalDateTime ltd = LocalDateTime.now();
			String date =ltd.toString().replace(':','-');
			
			
			File src = target.getScreenshotAs(OutputType.FILE);
			String PhotoPath="./errorshots/"+testCaseName+date+".png";
			File dest = new File(PhotoPath);
			
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
								e.printStackTrace();
			}
			return PhotoPath;
			
	}
}
