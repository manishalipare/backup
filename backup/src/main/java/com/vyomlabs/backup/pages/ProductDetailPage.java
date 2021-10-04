package com.vyomlabs.backup.pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.vyomlabs.backup.generics.Utilities;
import com.vyomlabs.backup.generics.WebactionUtils;

public class ProductDetailPage extends BasePage{

	
	public ProductDetailPage(WebDriver driver, WebactionUtils actionUtils)
	{
		super(driver, actionUtils);
	}
	
	@FindBy(xpath="//i[@class='icon-minus']")
	private WebElement minusIcon;
	
	@FindBy(xpath="//i[@class='icon-plus']")
	private WebElement plusIcon;
	
	@FindBy(id="group_1")
	private WebElement selectSizeDropDown;
	
	@FindBy(xpath="//ul[@id='color_to_pick_list']//a")
	private List <WebElement> colorPicker;
	
	@FindBy(name="Submit")
	private WebElement addToKart;
	
	@FindBy(xpath="//span[@title='Close window']")
	private WebElement closeWindow;
	
	@FindBy(xpath="//span[@title='Continue shopping']")
	private WebElement continShoppingButton;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	private WebElement proceedToCheckOutButton;
	
	public void increaseQuantity(int num)
	{
		for(int i=1;i<=num;i++)
		{
			actionUtils.Click(plusIcon);
			Utilities.SleepInsecsoncds(3);
		}
	}
	
	public void decreaseQuantity(int num)
	{
		for(int i=num;i>=1;i--)
		{
			actionUtils.Click(plusIcon);
			Utilities.SleepInsecsoncds(3);
		}
	}
	
	public void selectSize(String size)
	{
		actionUtils.SelectByVissibleText(selectSizeDropDown, size);
	}
	
	public void selectColor(String userColor)
	{
		userColor=userColor.toUpperCase();
		for(WebElement color: colorPicker)
		{
			if(color.getAttribute("name").contains(userColor))
			{
				actionUtils.Click(color);
				break;
			}
		}
	}
	
	public void addToKart()
	{
		actionUtils.Click(addToKart);
	}
	
	public void continueShopping()
	{
		actionUtils.Click(continShoppingButton);
	}
	
	public orderDetailedPage proceedToCheckout()
	{
		actionUtils.Click(proceedToCheckOutButton);
		return new orderDetailedPage(driver,actionUtils);
	}
	
	public void closeProductDetailedPage()
	{
		actionUtils.Click(closeWindow);
	}
}








