package com.vyomlabs.backup.scripts;

import org.testng.annotations.Test;

import com.vyomlabs.backup.pages.HomePage;
import com.vyomlabs.backup.pages.MyStorePage;
import com.vyomlabs.backup.pages.ProductDetailPage;
import com.vyomlabs.backup.pages.orderDetailedPage;

@Test()
public class TC002 extends BaseTest{	

	public void deleteProduct()
	{
		HomePage hp = new HomePage(driver, actionUtils);
		MyStorePage MSP = hp.clickOnTab("Dresses");
		ProductDetailPage PDP = MSP.ClickOnProduct("5");
		PDP.increaseQuantity(2);
		PDP.selectSize("L");
		PDP.selectColor("Black");
		PDP.addToKart();
		orderDetailedPage ODP = PDP.proceedToCheckout();
		ODP.deleteIcon("5");
		ODP.verifyProductAvailable("5");
		System.out.println("Done");
		
	}
}
