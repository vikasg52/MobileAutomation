package com.proptiger1;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Cross_PlatForm {
	static TimeStamp t1= new TimeStamp();
	public static void AllPages(WebDriver driver, String name) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(300,630));
		driver.manage().deleteAllCookies();		
		driver.get("http://www.proptiger.com");
		Thread.sleep(4000L);
		boolean homepage= t1.isElementPresent(driver, By.xpath("//div[@class='home-top-textInfo']"));
		boolean CityStrip= t1.isElementPresent(driver, By.xpath("//div[@class='city-name-info bangalore-info']"));
		if(homepage==false && CityStrip==false)
		{
			Assert.fail("\n Global home Page could not be opened in"+name);
			driver.close();
		}
		else
		{
			int cityCount= driver.findElements(By.xpath("//a[@class='city-list']")).size();
			if(cityCount!=10)
			{
				Assert.fail("\n Count of diplayed cities on home page is wrong!!");
				driver.close();
			}
			try
			{
				driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
				driver.navigate().refresh();
				Thread.sleep(4000L);
				driver.findElement(By.xpath("//div[@class='city-name-info bangalore-info']")).click();
				Thread.sleep(15000L);
				String CityHomeUrl= driver.getCurrentUrl();
				String ExpectedURL="http://www.proptiger.com/bangalore-real-estate-overview";
				String CitySelected= driver.findElement(By.xpath("//div[@class='city-select-wrap pull-left']//option[@selected='selected']")).getText();
				if(!CityHomeUrl.equalsIgnoreCase(ExpectedURL))
				{
					Assert.fail("\n City Overview page url is wrong or not opening in"+name);			
				}
				if(!CitySelected.equalsIgnoreCase("Bangalore"))
				{
					Assert.fail("\n Selected City in the dropdown on overview page is wrong in"+name);	
					//driver.close();
				}}catch(NoSuchElementException e)
				{System.out.println("\n City Overview page is not opened in"+name);}
			// Verify menu drawer page on city page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			driver.findElement(By.partialLinkText("All projects in")).click();
			Thread.sleep(9000L);
			String ListingUrl=driver.getCurrentUrl();
			String ListingTitle= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!ListingUrl.equalsIgnoreCase("http://www.proptiger.com/bangalore-real-estate") && !ListingTitle.equalsIgnoreCase("Bangalore"))
			{
				Assert.fail("\n Listing page is not opening,URL is incorrect or title is incorrect in"+name);
				driver.close();
			}
			// Verify menu drawer page on city listing page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			Thread.sleep(8000L);
			//boolean mapButton= t1.isElementPresent(driver, By.xpath("//td[@class='ta-right padding5']//a[@class='no-ajaxy pull-right btn btn-default show-map-btn']"));
			if(!name.equalsIgnoreCase("IE_Nokia_Lumia920"))
				{
					driver.findElement(By.xpath("//td[@class='ta-right padding5']//a[@class='no-ajaxy pull-right btn btn-default show-map-btn']")).click();
					Thread.sleep(4000L);
					String MapPage=driver.getCurrentUrl();				
					if(!MapPage.equalsIgnoreCase("http://www.proptiger.com/bangalore-real-estate#mapStaticPopupBlock"))
					{
						Assert.fail("\n Map page is not opening in"+name);
						driver.close();
					}
					driver.navigate().back();
				}
			Thread.sleep(4000L);
			driver.findElement(By.xpath("//img[@src='http://im.proptiger.com/1/643769/6/samruddhi-group-wintergreen-elevation-555334.jpeg?width=400&height=300']")).click();
			Thread.sleep(14000L);
			String ProjectPage= driver.getCurrentUrl();
			String Projectheading= driver.findElement(By.xpath("//h1[@title='Project Name']")).getText();
			if(!ProjectPage.equalsIgnoreCase("http://www.proptiger.com/bangalore/bellandur/samruddhi-group-winter-green-643769")
					&& !Projectheading.equalsIgnoreCase("Samruddhi Group Winter Green"))
			{
				Assert.fail("\n Project Page is not opening-URL is wrong, title is wrong or project name is wrong"+name);	
				driver.close();
			}
			driver.navigate().refresh();		
			// Verify menu drawer page on project page
			Cross_PlatForm.VerifyMenuDrawer(driver);	    
			driver.findElement(By.linkText("Explore this Locality")).click();
			Thread.sleep(11000L);
			String LocalityUrl= driver.getCurrentUrl();
			Thread.sleep(6000L);
			String Localityheading= driver.findElement(By.xpath("//h1[@title='Locality Name']")).getText();
			boolean LocalityImage= t1.isElementPresent(driver,  By.xpath("//img[@src='http://im.pt-img1.com/4/270/15/bellandur-bangalore-road-382762.jpeg?width=400&height=300']"));
			if(!LocalityUrl.equalsIgnoreCase("http://www.proptiger.com/bangalore-real-estate/bellandur-overview-50270")
					&& !Localityheading.equalsIgnoreCase("Bellandur") && LocalityImage==false)
			{
				Assert.fail("\n Locality page is not opening, basis URL is incorrect/heading is incorrect/image is missing"+name);
				driver.close();  		
			}
			// Verify menu drawer page on Locality overview page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			driver.findElement(By.linkText("View all Projects")).click();
			Thread.sleep(11000L);
			String LocalityListURL= driver.getCurrentUrl();
			String LocalityListheading= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!LocalityListURL.equalsIgnoreCase("http://www.proptiger.com/bangalore/property-sale-bellandur-50270") 
					&& !LocalityListheading.equalsIgnoreCase("Bellandur, Bangalore"))
			{
				Assert.fail("\n Locality listing page is not opening basis URL is wrong and heading is wrong"+name);

				driver.close();
			}

			// Verify menu drawer page on Locality listing page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			// come back on locality listing
			driver.navigate().back();
			Thread.sleep(7000L);
			driver.findElement(By.xpath("//div[@class='btn btn-light-gray locality-change-btn']")).click();
			Thread.sleep(3000L);
			String ChangeLocalityUrl=driver.getCurrentUrl();
			Boolean ChangeLocality= t1.isElementPresent(driver, By.xpath("//div[@class='capitalize ta-center city-name']"));
			String ChangeLocalityText= driver.findElement(By.xpath("//div[@class='capitalize ta-center city-name']")).getText();
			boolean serachbox= t1.isElementPresent(driver,By.xpath("//input[@placeholder='Search for locality']"));
			if(!ChangeLocalityUrl.equalsIgnoreCase("http://www.proptiger.com/bangalore-real-estate/bellandur-overview-50270#localitySearchPopup")
					&& serachbox==false && ChangeLocality==false && ChangeLocalityText!="Bangalore")
			{
				Assert.fail("\n Change locality page is not opening basis url is wrong, searchbox not found and heading is wrong in"+name);
				driver.close();
			}
			driver.findElement(By.xpath("//div[@class='pull-left back-btn']")).click();		
			Thread.sleep(9000L);
			boolean b= t1.isElementPresent(driver , By.xpath("//span[@class='logo pull-left']"));
			Thread.sleep(4000L);
			driver.findElement(By.xpath("//span[@class='logo pull-left']")).click();
			String s= driver.getCurrentUrl();
			if(!s.equalsIgnoreCase("http://www.proptiger.com/bangalore-real-estate-overview") && b==false)
			{
				Assert.fail("\n logo click is not opening city home page in "+name);
				driver.close();
			}
			driver.get("www.proptiger.com/dlf-100002");
			String BuilderTitle= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!BuilderTitle.equalsIgnoreCase("DLF"))
			{
				Assert.fail("Builder listing page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to("www.proptiger.com/all-builders");
			Thread.sleep(4000L);
			String AllBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']")).getText();
			if(!AllBuilderTitle.equalsIgnoreCase("Builders in India"))
			{
				Assert.fail("Builder page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to("www.proptiger.com/bangalore/all-builders");
			String CityBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']")).getText();
			if(!CityBuilderTitle.equalsIgnoreCase("Builders in Bangalore"))
			{
				Assert.fail("City Builder page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to("www.proptiger.com/all-cities");
			String AllCityTitle= driver.getTitle();
			if(!AllCityTitle.equalsIgnoreCase("Cities in India - Best Buy/Sale Property Investment Towns in India"))
			{
				Assert.fail("All city page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to("www.proptiger.com/bangalore/all-localities");	 
			String AllLocalityTitle= driver.getTitle();
			if(!AllLocalityTitle.equalsIgnoreCase("Bangalore Localities - List of top localities/Areas in Bangalore"))
			{
				Assert.fail("All locaities page is not opening in"+name);
				driver.close();
			}	
		}
	}

	// Menu Drawer Verification
	public static void VerifyMenuDrawer(WebDriver driver)
	{
		boolean drawer= t1.isElementPresent(driver, By.xpath("//i[@class='icon-navicon']"));
		if(drawer==false)
		{
			Assert.fail("\nMenu Drawer is not present on city overview page");
			driver.close();
		}
		driver.findElement(By.xpath("//div[@id='header-drawer-button']")).click();
		boolean DrawerChangeCitydropwdown = t1.isElementPresent(driver , By.xpath("//select[@class='change-city']"));
		boolean cityHomeIcon= t1.isElementPresent(driver, By.xpath("//i[@class='cityLabel icon-apartment']"));
		String OtherSection= driver.findElement(By.xpath("//div[@class='sections others']//h4[@class='md']")).getText();
		if(DrawerChangeCitydropwdown==false && cityHomeIcon==false && !OtherSection.equalsIgnoreCase("Others"))
		{
			Assert.fail("\n Menau Drawer is not clickable or not opening basis home icon in menu drawer missing,label others and chnage city dropdown");
			driver.close();
		}
		driver.findElement(By.xpath("//div[@id='header-drawer-button']")).click();			
	}

	
	public static void Check404Page(WebDriver driver) throws InterruptedException
	{
		driver.get("http://www.proptiger.com/noida/sector-118/supertech-romano-652425/atms");
		Thread.sleep(4000L);
		try
		{
			String ErrorText= driver.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr/td/h2")).getText();
			String WarningMsg=driver.findElement(By.xpath("//*[@id='content']/div/table/tbody/tr/td/p[1]")).getText();
			String ExpectedWarning="You've hit a wrong path. You may have followed an outdated link or entered an incorrect url.";
			boolean GoHomeButton= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-d-yellow']"));
			if(!ErrorText.equalsIgnoreCase("Error 404"))
			{
				Assert.fail("\n Error text is not coming on 404 page");
			}
			if(!WarningMsg.equalsIgnoreCase(ExpectedWarning))
			{
				Assert.fail("Warning message is missing on the 404 page");
				
			}
			if(GoHomeButton==false)
			{
				Assert.fail("Goto Home page button is missing on the 404 page");
				//driver.close();
			}
			driver.findElement(By.xpath("//a[@class='no-ajaxy btn btn-d-yellow']")).click();
			Thread.sleep(4000L);
			String RedirectURl=driver.getCurrentUrl();
			if(!RedirectURl.equalsIgnoreCase("http://www.proptiger.com/"))
			{
				Assert.fail("\n Goto home page button is not redirecting to home page from 404 page");
				//driver.close();
			}
		}catch(NoSuchElementException e)
		{
			System.err.println("not found");
		}
		//driver.quit();
	}


	public static void CheckAmenityPages(WebDriver driver) throws InterruptedException
	{
		driver.get("http://www.proptiger.com/bangalore/whitefield-50161/atms");
		Thread.sleep(4000L);
			String LocalityName= driver.findElement(By.xpath("//h1[@class='locality-name']")).getText();
			boolean CityDropDown= t1.isElementPresent(driver, By.xpath("//select[@class='city-select-dd']//option[@selected='true']"));
			String  SelectedCity=driver.findElement(By.xpath("//select[@class='city-select-dd']//option[@selected='true']")).getText();
			boolean AmenityButton=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-warning']//i[@class='imageIcon']"));
			boolean AmenityButtonIcon=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-warning']//i[@class='imageIcon']"));
			String SelectedAmenity= driver.findElement(By.xpath("//a[@class='no-ajaxy btn btn-warning']")).getText();
		    if(!LocalityName.equalsIgnoreCase("ATMs in Whitefield") && !SelectedAmenity.equalsIgnoreCase("Atms"))
		    {
		    	Assert.fail("Amenity page is not opening for whitefield-ATMS");
		    	driver.close();
		    }
		    if(CityDropDown==false && AmenityButtonIcon==false && AmenityButton==false)
	    	{
		    	Assert.fail("CityDrop down and amenity dropdown is missing from the amenity page");		
		    	driver.close();
	    	}
		    if(CityDropDown==false && AmenityButton==false)
	    	{
		    	Assert.fail("CityDrop down and amenity dropdown is missing from the amenity page");	
		    	driver.close();
	    	}
		    if(!SelectedCity.equalsIgnoreCase("Bangalore"))
	    	{
		    	Assert.fail("Selected city in city dropdown is wrong");	
	            driver.close();
	    	}
			//driver.quit();
	}
}
