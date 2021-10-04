package com.vyomlabs.backup.pages;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vyomlabs.backup.generics.WebactionUtils;

public class MyStorePage extends BasePage {

	public MyStorePage(WebDriver driver, WebactionUtils actionUtils)
	{
		super(driver, actionUtils);
	}
	
	@FindBy(xpath="//ul[contains(@class,'product_list')]//a[@class='product_img_link']")
	private List<WebElement> productList;
	
	@FindBy(xpath="//a[text()='Grid']")
	private WebElement gridView;
	
	@FindBy(xpath="//a[text()='List']")
	private WebElement listView;
	
	
	public ProductDetailPage ClickOnProduct(String productId)
	{
		productId = "id_product="+productId;
		for(WebElement product:productList)
		{
			
			if(product.getAttribute("href").contains(productId))
			{
				actionUtils.jsClick(product);
				break;
			}
		}
		return new ProductDetailPage(driver,actionUtils);
	}
	
	
}
