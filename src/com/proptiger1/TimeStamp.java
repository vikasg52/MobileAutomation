package com.proptiger1;
import java.awt.List;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.htmlunit.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.openqa.selenium.By;
public class TimeStamp<WebElement> {
	public static void main(String[] args) 
	{
		HtmlUnitDriver driver= new HtmlUnitDriver();
		timestamp();	  
	}
	public static String timestamp()
	{
		DateFormat format = new SimpleDateFormat("dd-MM-yyy : hh-mm-ss");
		String DateTime = format.format(new Date());
		System.out.println(DateTime);
		return DateTime;
	}

	/*public boolean isElementPresent(By by) {
		HtmlUnitDriver driver= new HtmlUnitDriver();
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e)
		{
			return false;
		}
	}
		*/
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
	
