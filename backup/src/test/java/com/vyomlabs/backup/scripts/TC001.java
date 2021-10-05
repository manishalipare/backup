package com.vyomlabs.backup.scripts;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.vyomlabs.backup.pages.HomePage;
import com.vyomlabs.backup.pages.MyStorePage;
import com.vyomlabs.backup.pages.ProductDetailPage;
import com.vyomlabs.backup.pages.orderDetailedPage;

@Test()
public class TC001  extends BaseTest{	
	
	public void testLogin()
	{
		HomePage hp = new HomePage(driver, actionUtils);
		MyStorePage mp = hp.clickOnTab("dresses");
	    ProductDetailPage PDP=mp.ClickOnProduct("5");
		PDP.increaseQuantity(2);
		PDP.selectSize("M");  
		PDP.selectColor("Black");
		PDP.addToKart();
		orderDetailedPage ODP = PDP.proceedToCheckout();
		Assert.assertEquals(ODP.verifyProductAvailable("5"), true);
	}
}
