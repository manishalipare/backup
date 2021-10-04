package com.vyomlabs.backup.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vyomlabs.backup.generics.WebactionUtils;

public class orderDetailedPage extends BasePage{

	public orderDetailedPage(WebDriver driver, WebactionUtils actionUtils)
	{
		super(driver, actionUtils);
	}
	
	@FindBy(xpath="//tbody/tr//td[@class='cart_product']/a")
	private List <WebElement> productList;
	
	@FindBy(xpath="//i[@class='icon-trash']")
	private WebElement DeleteIcon;
	
	public boolean verifyProductAvailable(String productId)
	{
		productId="id_product="+productId;
		
		for(WebElement product : productList )
		{
			if (product.getAttribute("href").contains(productId))
					{
				       return true;
					}
		}
		
		return false;
	}
	
	public void deleteIcon(String productId)
	{
		productId="id_product="+productId;
		for(WebElement product : productList)
		{
			if(product.getAttribute("href").contains(productId))
			{
				actionUtils.jsClick(DeleteIcon);
			}
			
		}
	}
	
}
