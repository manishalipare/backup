package com.vyomlabs.backup.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vyomlabs.backup.pages.HomePage;
import com.vyomlabs.backup.pages.MyStorePage;
import com.vyomlabs.backup.pages.ProductDetailPage;
import com.vyomlabs.backup.pages.orderDetailedPage;

public class TC003 extends BaseTest{

	
@Test(description="verify failed test case for screenshot")
	public void testScreenshot()
		{
			HomePage hp = new HomePage(driver, actionUtils);
			MyStorePage mp = hp.clickOnTab("dresses");
		    ProductDetailPage PDP=mp.ClickOnProduct("5");
			PDP.increaseQuantity(2);
			PDP.selectSize("S");  //added size as small
			PDP.selectColor("Black");
			PDP.addToKart();
			orderDetailedPage ODP = PDP.proceedToCheckout();
			Assert.assertEquals(ODP.verifyProductAvailable("5"), false);
		}
	}

