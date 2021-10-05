package com.vyomlabs.backup.scripts;
//added new cases TC004
import org.testng.Assert;

import com.vyomlabs.backup.pages.HomePage;
import com.vyomlabs.backup.pages.MyStorePage;
import com.vyomlabs.backup.pages.ProductDetailPage;
import com.vyomlabs.backup.pages.orderDetailedPage;

public class TC004 extends BaseTest{

	
	public void testYellowColor()
	{
		HomePage hp = new HomePage(driver, actionUtils);
		MyStorePage mp = hp.clickOnTab("dresses");
	    ProductDetailPage PDP=mp.ClickOnProduct("5");
		PDP.increaseQuantity(2);
		PDP.selectSize("M");  
		PDP.selectColor("Yellow");
		PDP.addToKart();
		orderDetailedPage ODP = PDP.proceedToCheckout();
		Assert.assertEquals(ODP.verifyProductAvailable("5"), true);
	}
}
