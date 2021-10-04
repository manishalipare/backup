
package com.vyomlabs.backup.scripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.vyomlabs.backup.generics.AutoConstants;
import com.vyomlabs.backup.generics.WebactionUtils;
import com.vyomlabs.backup.generics.takeScreenShot;
import com.vyomlabs.backup.pages.HomePage;
import com.vyomlabs.backup.pages.LoginPage;

public class BaseTest implements AutoConstants {
	
	public WebDriver driver;
	public WebactionUtils actionUtils;

	@Parameters({"browserName","appURL","ETO","ITO"})
	@BeforeClass
	public void LaunchBrowser(@Optional(DEFAULT_BROWSER) String browserName,
			                   @Optional(DEFAULT_APP_URL) String appURL,
			                   @Optional(ETO) String ETO,
			                   @Optional(ITO) String ITO)
	{
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_PATH);
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			driver = new ChromeDriver(options);
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			System.setProperty(GECK_KEY, GECKO_PATH);
			FirefoxOptions options = new FirefoxOptions();
			options.addPreference("dom.webnotifications.enabled", false);
			driver = new FirefoxDriver(options);
		}
		else 
		{
			throw new IllegalArgumentException("Enter valid browser");
		}
		
		long ito = Long.parseLong(ITO);
		long eto=Long.parseLong(ETO);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(ito, TimeUnit.SECONDS);
		driver.get(appURL);
		
		actionUtils = new WebactionUtils(driver, eto);
		
	}
	
	@BeforeMethod
	public void Login(@Optional(DEFAULT_USERNAME) String un ,
			           @Optional(DEFAULT_PASSWORD) String pwd)
	{
		actionUtils.ScrollDown(300);
		LoginPage lp = new LoginPage(driver, actionUtils);
		lp.Login(un, pwd);
	}
	
	@AfterMethod
	public void Logout(ITestResult result)
	{
	 
	    String testCaseN = result.getName();
	    int testcasestatus = result.getStatus();
	    if(testcasestatus==result.FAILURE)
	    {
	    	takeScreenShot.getPageScreenShot(driver, testCaseN);
	    }
		HomePage hp=new HomePage(driver, actionUtils);
		hp.Logout();
	}
	
	@AfterClass
	public void CloseApp()
	{
		driver.close();
	}
	
}
