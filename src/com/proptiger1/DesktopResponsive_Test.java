package com.proptiger1;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class DesktopResponsive_Test {
	static TimeStamp t1= new TimeStamp();
	static String name="";
	static String name1="";
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String local= "http://192.168.0.216:5000";
	static String betahttp="http://beta.proptiger-ws.com";
	static String betassl="https://beta.proptiger-ws.com";
	static String BaseUrl=betahttp;
	public static void Responsive(WebDriver driver, String name) throws InterruptedException {	
			driver.navigate().to(BaseUrl+"/all-builders");
			Thread.sleep(4000L);
			Cookie cookie = new Cookie("TESTING_USER", "1");
		    driver.manage().addCookie(cookie);
			String AllBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']")).getText();
			if(!AllBuilderTitle.equalsIgnoreCase("Builders in India"))
			{
				Assert.fail("Builder page is not opening in  "+name);
				//driver.close();
			}
			System.out.println("2. All India builders page opening properly in desktop website in  "+name);
			driver.navigate().to(BaseUrl+"/bangalore/all-builders");
			String CityBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']")).getText();
			if(!CityBuilderTitle.equalsIgnoreCase("Builders in Bangalore"))
			{
				Assert.fail("City Builder page is not opening in  "+name);
				//driver.close();
			}
			System.out.println("3. All builders page of bangalore is opening properly in desktop website using  "+name);
			driver.navigate().to(BaseUrl+"/all-cities");
			String AllCityTitle= driver.getTitle();
			if(!AllCityTitle.equalsIgnoreCase("Cities in India - Best Buy/Sale Property Investment Towns in India"))
			{
				Assert.fail("All city page is not opening in  "+name);
				//driver.close();
			}
			System.out.println("4. All India cities page is opening properly in desktop website using  "+name);
			
			driver.navigate().to(BaseUrl+"/bangalore/all-localities");	 
			String AllLocalityTitle= driver.getTitle();
			if(!AllLocalityTitle.equalsIgnoreCase("Bangalore Localities - List of top localities/Areas in Bangalore"))
			{
				Assert.fail("All locaities page is not opening in  "+name);
				//driver.close();
		     }
			System.out.println("5. All Localities page of bangalore is opening properly in desktop website using  "+name);
          }
	
	// Verify Amenity pages
	public static void CheckAmenityPages(WebDriver driver, String name) throws InterruptedException
	{
		driver.get(BaseUrl+"/bangalore/whitefield-50161/atms");
		Thread.sleep(5000L);
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
	    Thread.sleep(5000L);
		String LocalityName= driver.findElement(By.xpath("//h1[@class='locality-name']")).getText();
		boolean CityDropDown= t1.isElementPresent(driver, By.xpath("//select[@class='city-select-dd']//option[@selected='true']"));
		String  SelectedCity=driver.findElement(By.xpath("//select[@class='city-select-dd']//option[@selected='true']")).getText();
		boolean AmenityButton=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-warning']//i[@class='imageIcon']"));
		boolean ATMiCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-rupee']"));
		boolean SchooliCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-Sch']"));
		boolean BankiCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-bank']"));
		boolean RestroiCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-restaurant']"));
		boolean PetroiCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-petrol-station']"));
		boolean HospitaliCon=t1.isElementPresent(driver,By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-hospital']"));
		String defaultActiceAmenity=driver.findElement(By.xpath("//a[@class='no-ajaxy btn btn-default active']")).getText();
		driver.findElement(By.xpath("//div[@class='btn-group hidden-xs']//i[@class='icon-bank']")).click();
		String ChangebankButton=driver.getCurrentUrl();
		if(!LocalityName.equalsIgnoreCase("ATMs in Whitefield"))
		{
			Assert.fail("Amenity page is not opening for whitefield-ATMS  "+name);
			driver.close();
		}
		if(!defaultActiceAmenity.equalsIgnoreCase("Atms"))
		{
			Assert.fail("Default selected amenity is not ATM  "+name);
		}
		if(ATMiCon==false)
		{
		Assert.fail("Atms icon is not available on amenity page  "+name);	
		}
		if(SchooliCon==false)
		{
			Assert.fail("Schools icon is not available on amenity page  "+name);	
		}
		if(BankiCon==false)
		{	
			Assert.fail("Banks icon is not available on amenity page  "+name);	
		}
		if(RestroiCon==false)
		{
			Assert.fail("Restaurants icon is not available on amenity page  "+name);	
		}
		if(HospitaliCon==false)
		{
			Assert.fail("Hospitals icon is not available on amenity page  "+name);	
		}
		if(PetroiCon==false)
		{
			Assert.fail("Petrol pums icon is not available on amenity page  "+name);	
		}
		if(CityDropDown==false)
		{
			Assert.fail("City dropdown is missing from the amenity page  "+name);		
			driver.close();
		}
		if(CityDropDown==false && AmenityButton==false)
		{
			Assert.fail("CityDrop down and amenity dropdown is missing from the amenity page  "+name);	
			driver.close();
		}
		if(!SelectedCity.equalsIgnoreCase("Bangalore"))
		{
			Assert.fail("Selected city in city dropdown is wrong  "+name);	
			driver.close();
		}
		if (!ChangebankButton.equalsIgnoreCase(BaseUrl+"/bangalore/whitefield-50161/banks"))
		{
			Assert.fail("Clicking on bank button is not opening bank amenity page   "+name);
		}
		else
		{
		System.out.println("6. Amenity page is opening properly in  "+name);
	     }
		}
		
	// Verify Gallery page in desktop
	public static void Gallery(WebDriver driver, String name) throws InterruptedException
	{
		driver.get(BaseUrl+"/gallery/samruddhi-group-wintergreen-layout-plan-643769-357091");
		Thread.sleep(5000L);
		boolean headerText= t1.isElementPresent(driver,By.xpath("//div[@class='row contHeaderInfo']//h1[@class='contSubheaderInfo']"));
	 	boolean image= t1.isElementPresent(driver,(By.xpath("//img[@src='http://im.pt-img2.com/1/143769/4/samruddhi-group-wintergreen-layout-plan-357091.jpeg']")));
	    boolean previousbutton= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy m-carousel-prev']"));
	    boolean NextButton= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy m-carousel-next']"));
	    if(headerText==false)
	    {
	    	Assert.fail("Header text is not appearing");
	    }
	    if(image==false)
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
			driver.get("http://www.proptiger.com/delhi/zone-p-ii-51905/atms");
			Thread.sleep(4000L);
			int ran;
		    ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		    long mobile = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
		    String m= String.valueOf(mobile);
		    driver.findElement(By.xpath("//div[@class='form-info']//input[@id='fullname']")).sendKeys("AmenityLeadTest");
			driver.findElement(By.xpath("//div[@class='form-info']//input[@id='email']")).sendKeys("proptigerqa"+ran+"@gmail.com");
			driver.findElement(By.xpath("//div[@class='form-info']//input[@id='mobile']")).sendKeys(m);
			Select select = new Select(driver.findElement(By.xpath("//div[@class='formRow']//select[@class='form-control query-country']")));
		    select.selectByVisibleText("India");
			driver.findElement(By.xpath("//span[@class='btn btn-danger wd75percent']")).click();
			Thread.sleep(5000L);
			Set<String> windows = driver.getWindowHandles();
			for (String window : windows) {
				driver.switchTo().window(window);
			driver.findElement(By.xpath("//div[@class='title ta-center']")).click();
			System.out.println("7. Lead submitted successfully from amenity page in desktop website");
			//driver.quit();
		}
	}
	
	//GP13
	public static void GP(WebDriver driver,String userName, String name) throws InterruptedException
	{     
		TimeStamp t1= new TimeStamp();
		boolean tooltip= t1.isElementPresent(driver,By.xpath("//div[@class='tooltip']"));
		boolean guaraantee= t1.isElementPresent(driver, By.xpath("//i[@class='icon-guarantee']"));
		boolean bigimage= t1.isElementPresent(driver,By.xpath("//section[@class='proj-info-bg projectImgSection']"));
	    if(tooltip==false)
	    {
	    	Assert.fail("Tooltip is missing from the gp page 13");
	    }
	    if(guaraantee==false)
	    {
	    	Assert.fail("guarantee seal is missing from the gp page 13");
	    }
	    if(bigimage==false)
	    {
	    	Assert.fail("Gallery Image is missing from the gp page 13");
	    }
		int ran;
	    ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
	    long mobile = (long) Math.floor(Math.random() * 9000000000L) + 1000000000L;
	    String m= String.valueOf(mobile);
	    Set<String> windows = driver.getWindowHandles();
		for (String window : windows) {
			driver.switchTo().window(window);	
			driver.findElement(By.xpath("//div[@class='form-info']//input[@id='fullname']")).clear();
		driver.findElement(By.xpath("//div[@class='form-info']//input[@id='fullname']")).sendKeys(userName);
		driver.findElement(By.xpath("//div[@class='form-info']//input[@id='email']")).clear();
		driver.findElement(By.xpath("//div[@class='form-info']//input[@id='email']")).sendKeys("proptigerqa"+ran+"@gmail.com");
		driver.findElement(By.xpath("//div[@class='form-info']//input[@id='mobile']")).clear();
		driver.findElement(By.xpath("//div[@class='form-info']//input[@id='mobile']")).sendKeys(m);
		Select select = new Select(driver.findElement(By.xpath("//div[@class='formRow desktop-wd-1third']//select[@class='form-control query-country']")));
	    select.selectByVisibleText("India");
		driver.findElement(By.xpath("//span[@class='btn btn-danger wd75percent']")).click();
		//System.out.println("7. Lead submitted successfully from GP13 in desktop website using"+name);
	Thread.sleep(6000L);
	Set<String> windowss = driver.getWindowHandles();
	for (String windo : windowss) {
		driver.switchTo().window(windo);
	driver.findElement(By.xpath("//div[@class='ta-center' and text()='Thank You']")).click();
	}	
	}}
	// GP13
	public static void gp13 (WebDriver driver,String name) throws InterruptedException
	{       	
		driver.manage().deleteAllCookies();
		String userName="GP13LeadTest";
		String URL= BaseUrl+"/google_page_13.php?projectId=648393";
		driver.get(URL);
		GP(driver, userName,name);
	    System.out.println("7.Lead submitted successfully from GP13 using"+name);
	}
	//GP14
	public static void gp14 (WebDriver driver,String name) throws InterruptedException
	{       
		driver.manage().deleteAllCookies();
		String URL= BaseUrl+"/google_page_14.php?projectId=648393";
		String userName="GP14LeadTest";
		driver.get(URL);
	    GP(driver,userName,name);
	    System.out.println("8.Lead submitted successfully from GP14 using"+name);
	}
	//GP15
	public static void gp15 (WebDriver driver, String name) throws InterruptedException
		{       	
		driver.manage().deleteAllCookies();
		String URL= BaseUrl+"/google_page_15.php?projectId=648393";	
		String userName="GP15LeadTest";
		driver.get(URL);
		GP(driver,userName, name);
	    System.out.println("9.Lead submitted successfully from GP15 using"+name);
	   	}
	}
	