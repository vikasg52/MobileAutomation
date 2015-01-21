package com.proptiger1;
import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.By;
public class TimeStamp<WebElement> {
	public static void main(String[] args) 
	{
		HtmlUnitDriver driver= new HtmlUnitDriver();
		timestamp();	  
	}
	public void wait(WebDriver driver, String element)
	{
		WebDriverWait wait1 = new WebDriverWait(driver,35);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
	}
	public static String timestamp()
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyy : hh-mm-ss");
		String DateTime = format.format(new Date());
		System.out.println(DateTime);
		return DateTime;
	}

		public boolean isElementPresent( WebDriver driver1, By by1)
		{
		try
		{
		driver1.findElement(by1);
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
		}
						
	}
	
