package com.proptiger1;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DesktopResponsive_Test {
	static TimeStamp t1= new TimeStamp();
	static String name="";
	static String name1="";
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String local= "http://192.168.0.216:5000";
	static String betahttp="http://beta.proptiger-ws.com";
	static String betassl="https://beta.proptiger-ws.com";
	static String BaseUrl=ssl;
	public static void Responsive(WebDriver driver, String name) throws InterruptedException 
	{	
			driver.get(BaseUrl+"/all-builders");
			t1.wait(driver,"//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']");
			Cookie cookie = new Cookie("TESTING_USER", "1");
		        driver.manage().addCookie(cookie);
			String AllBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']")).getText();
			if(!AllBuilderTitle.equalsIgnoreCase("Builders in India"))
			{
				Assert.fail("Builder page is not opening in  "+name);
				//driver.close();
			}
			System.out.println("2. All India builders page opening properly in desktop website in  "+name);
			driver.get(BaseUrl+"/bangalore/all-builders");
			t1.wait(driver, "//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']");
			String CityBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']")).getText();
			if(!CityBuilderTitle.equalsIgnoreCase("Builders in Bangalore"))
			{
				Assert.fail("City Builder page is not opening in  "+name);
				//driver.close();
			}
			System.out.println("3. All builders page of bangalore is opening properly in desktop website using  "+name);
			driver.get(BaseUrl+"/all-cities");
			Thread.sleep(4000L);
			String AllCityTitle= driver.getTitle();
			if(!AllCityTitle.equalsIgnoreCase("Cities in India - Best Buy/Sale Property Investment Towns in India :Proptiger.com"))
			{
				Assert.fail("All city page is not opening/ title is wrong on the page in  "+name);
				//driver.close();
			}
			System.out.println("4. All India cities page is opening properly in desktop website using  "+name);
			
			driver.get(BaseUrl+"/bangalore/all-localities");
			t1.wait(driver, "//a[@href='/bangalore-real-estate/hebbal-overview-50175']");
			String AllLocalityTitle= driver.getTitle();
			if(!AllLocalityTitle.equalsIgnoreCase("Bangalore Localities - List of top localities/Areas in Bangalore :Proptiger.com"))
			{
				Assert.fail("All locaities page is not opening in  "+name);
				//driver.close();
		     }
			System.out.println("5. All Localities page of bangalore is opening properly in desktop website using  "+name);
	}
	
	// Careers Page
	public static void Careers(WebDriver driver, String name)
	{
		driver.get(BaseUrl+"/careers");
		t1.wait(driver, "//div[@class='career_bnr']");
		boolean logo = t1.isElementPresent(driver,By.xpath("//span[@class='logo']//img[@src='/responsive/images/logo.png']"));
		String BannerText = driver.findElement(By.xpath("//div[@class='main_heading']")).getText();
		boolean AboutUs=t1.isElementPresent(driver, By.xpath("//a[@href='/aboutus']"));
		boolean Culture=t1.isElementPresent(driver, By.xpath("//a[@href='/culture']"));
		boolean careerTExt=t1.isElementPresent(driver, By.xpath("//a[@class='careers_icon active js-careers']"));
        boolean OpeningText= t1.isElementPresent(driver,By.xpath("//h2[@class='text-center']"));
        boolean careeremail= t1.isElementPresent(driver,By.linkText("careers@proptiger.com"));
        boolean IntersMail= t1.isElementPresent(driver,By.linkText("internship@proptiger.com"));
        boolean copyright= t1.isElementPresent(driver,By.xpath("//div[@class='propFooterCopyright']"));
        
        if (logo==false)
        {
        	Assert.fail("Logo is missing from the page");
        }
        if (!BannerText.equals("FOLLOW YOUR PASSION"))
        {
        	Assert.fail("Banner Text is missing or Incorrect");
        }
        if (AboutUs==false)
        {
        	Assert.fail("About Us link is not working or is missing from the page");
        }
        if (Culture==false)
        {
        	Assert.fail("Culture Link is not working or missing from the page");
        }
        if (careerTExt==false)
        {
        	Assert.fail("careerText is missing from the page");
        }
        if (OpeningText==false)
        {
        	Assert.fail("OpeningText label is missing from the page");
        }
        if (IntersMail==false)
        {
        	Assert.fail("Intership Mailto Link is missing from the page");
        }
        if (careeremail==false)
        {
        	Assert.fail("careere mailto link is missing from the page");
        }
        if (copyright==false)
        {
        	Assert.fail("copyright info is missing from the page");
        }
        else
     System.out.println("7.All objects are working fine on careers page in"+name);
   }
	// Verify Gallery page in desktop
	public static void Gallery(WebDriver driver, String name) throws InterruptedException
	{
		driver.get(BaseUrl+"/gallery/zonasha-estates-elegance-elevation-657209-584583");
		t1.wait(driver,"//div[@class='gallHeadInfo']//h1[@class='contSubheaderInfo']");
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
		boolean headerText= t1.isElementPresent(driver,By.xpath("//div[@class='gallHeadInfo']//h1[@class='contSubheaderInfo']"));
	 	boolean image= t1.isElementPresent(driver,(By.xpath("//img[@src='https://im.proptiger.com/1/657209/6/zonasha-estates-elegance-elevation-584583.jpeg']")));
	    boolean previousbutton= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy m-carousel-prev']"));
	    boolean NextButton= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy m-carousel-next']"));
	    if(headerText==false)
	    {
	    	Assert.fail("Header text is not appearing");
	    }
	   if (image==false)
	    {
	    	Assert.fail("Gallery image is not appearing on gallery page in  "+name);
	    }
	    if(previousbutton==false)
	    {
	    	Assert.fail("Back button on gallery page is not found in  "+name);
	    }
	    if(NextButton==false)
	    {
	    	Assert.fail("Next button on gallery page is not found in  "+name);
	    }
	    
	    else
	    {
	  	System.out.println("1. Desktop Gallery page is opening properly in  "+name);
	    }
	}

	public static void DesktopAmenityLead(WebDriver driver, String name) throws InterruptedException
	{       TimeStamp time= new TimeStamp();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);;
			driver.get(BaseUrl+"/delhi/zone-p-ii-51905/atms");
			Cookie cookie = new Cookie("TESTING_USER", "1");
		    driver.manage().addCookie(cookie);
			t1.wait(driver, "//div[@class='form-info']//input[@id='fullname']");
			int ran;
		    ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		   /* long mobile = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;*/
		   // String m= String.valueOf(mobile);
		    driver.findElement(By.xpath("//div[@class='form-info']//input[@id='fullname']")).sendKeys("AmenityLeadTest"+ran);
			driver.findElement(By.xpath("//div[@class='form-info']//input[@id='email']")).sendKeys("proptigerqa+"+ran+"@gmail.com");
			driver.findElement(By.xpath("//div[@class='form-info']//input[@id='mobile']")).sendKeys("1900000000");
			Select select = new Select(driver.findElement(By.xpath("//div[@class='formRow']//select[@class='form-control query-country']")));
		    select.selectByVisibleText("India");
			driver.findElement(By.xpath("//span[@class='btn btn-danger wd75percent']")).click();
			//driver.wait(3000L);
			t1.wait(driver, "//div[@class='title ta-center']");
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				driver.switchTo().window(window);
			WebElement element= driver.findElement(By.xpath("//section[@class='thanksFormWrapper']//div[@class='popup-back-btn']"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].scrollIntoView(true);", element);
			js.executeScript("arguments[0].click();", element);
			//Actions actionname = new Actions(driver);
	       // actionname.moveToElement(driver.findElement(By.xpath("//section[@class='thanksFormWrapper']//div[@class='popup-back-btn']")));
	        //actionname.build().perform();
			Thread.sleep(3000L);
			//driver.findElement(By.xpath("//section[@class='thanksFormWrapper']//div[@class='popup-back-btn']")).click();
			String ThankText= driver.findElement(By.cssSelector(".thanks-wrap.ta-center")).getAttribute("textContent");
			if(!ThankText.contains("Thanks for submitting"))
			{
				Assert.fail("Lead can not be submitted");
			}
			else
			{
			System.out.println("6. Lead submitted successfully from amenity page in desktop website");
			}
			//driver.quit();
		}
	}
	
	
	}
	
