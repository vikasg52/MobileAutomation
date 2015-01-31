package com.proptiger1;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cross_PlatForm {
	static TimeStamp t1= new TimeStamp();
	static String name="";
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String betahttp="http://beta.proptiger-ws.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String local= "http://192.168.0.216:5000";
	static String betassl="https://beta.proptiger-ws.com";
	static String BaseUrl=ssl;
    static void AllPages(WebDriver driver, String name) throws InterruptedException {
driver.manage().window().setSize(new Dimension(540,650));
		driver.manage().deleteAllCookies();		
		driver.get(BaseUrl);
		WebDriverWait wait1 = new WebDriverWait(driver,120);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='city-name-info bangalore-info']")));
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
	    boolean homepage= t1.isElementPresent(driver, By.xpath("//div[@class='home-top-textInfo']"));
		boolean CityStrip= t1.isElementPresent(driver, By.xpath("//div[@class='city-name-info bangalore-info']"));
		Cross_PlatForm.interstitial(driver, name);
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
			}
			try
			{
				driver.findElement(By.xpath("//div[@class='city-name-info bangalore-info']")).click();
				t1.wait(driver, "//select[@class='city-select-dd']//option[@selected='selected']");
				String CityHomeUrl= driver.getCurrentUrl();
				String ExpectedURL=BaseUrl+"/bangalore-real-estate-overview";
				String CitySelected= driver.findElement(By.xpath("//select[@class='city-select-dd']//option[@selected='selected']")).getText();
				if(!CityHomeUrl.equalsIgnoreCase(ExpectedURL))
				{
					Assert.fail("City Overview page url is wrong or not opening in"+name);			
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
			t1.wait(driver, "//div[@class='listing-title']");
			String ListingUrl=driver.getCurrentUrl();
			String ListingTitle= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!ListingUrl.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate") && !ListingTitle.equalsIgnoreCase("Bangalore"))
			{
				Assert.fail("\n Listing page is not opening,URL is incorrect or title is incorrect in"+name);
				driver.close();
			}
			// Verify menu drawer page on city listing page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			if(!name.equalsIgnoreCase("IE_Nokia_Lumia920"))
			{
				driver.findElement(By.xpath("//td[@class='ta-right padding5']//a[@class='no-ajaxy pull-right btn btn-default show-map-btn']")).click();
				String MapPage=driver.getCurrentUrl();				
				if(!MapPage.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate#mapStaticPopupBlock"))
				{
					Assert.fail("\n Map page is not opening in"+name);
					driver.close();
				}
				driver.navigate().back();
				Thread.sleep(3000L);
			}
			driver.findElement(By.xpath("//img[@src='https://im.proptiger.com/1/643769/6/samruddhi-group-wintergreen-elevation-555334.jpeg?width=400&height=300']")).click();
			t1.wait(driver, "//h1[@class='proj-name put-ellipsis']");
			String ProjectPage= driver.getCurrentUrl();
			String Projectheading= driver.findElement(By.xpath("//h1[@class='proj-name put-ellipsis']")).getText();
			if(!ProjectPage.equalsIgnoreCase(BaseUrl+"/bangalore/bellandur/samruddhi-group-winter-green-643769")
					&& !Projectheading.equalsIgnoreCase("Samruddhi Group Winter Green"))
			{
				Assert.fail("\n Project Page is not opening-URL is wrong, title is wrong or project name is wrong"+name);	
				driver.close();
			}
			driver.navigate().refresh();		
			// Verify menu drawer page on project page
			Cross_PlatForm.VerifyMenuDrawer(driver);	    
			driver.findElement(By.linkText("Explore this Locality")).click();
			t1.wait(driver, "//h1[@title='Locality Name']");
			String LocalityUrl= driver.getCurrentUrl();
			String Localityheading= driver.findElement(By.xpath("//h1[@title='Locality Name']")).getText();
			boolean LocalityImage= t1.isElementPresent(driver,  By.xpath("//img[@src='https://im.pt-img1.com/4/270/15/bellandur-bangalore-road-382762.jpeg?width=400&height=300']"));
			if(!LocalityUrl.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate/bellandur-overview-50270")
					&& !Localityheading.equalsIgnoreCase("Bellandur") && LocalityImage==false)
			{
				Assert.fail("\n Locality page is not opening, basis URL is incorrect/heading is incorrect/image is missing"+name);
				driver.close();  		
			}
			// Verify menu drawer page on Locality overview page
			Cross_PlatForm.VerifyMenuDrawer(driver);
		    driver.findElement(By.linkText("View all Projects")).click();
			t1.wait(driver, "//div[@class='listing-title']");
		    String LocalityListURL= driver.getCurrentUrl();
			String LocalityListheading= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!LocalityListURL.equalsIgnoreCase(BaseUrl+"/bangalore/property-sale-bellandur-50270") 
					&& !LocalityListheading.equalsIgnoreCase("Bellandur, Bangalore"))
			{
				Assert.fail("\n Locality listing page is not opening basis URL is wrong and heading is wrong"+name);
                driver.close();
			}

			// Verify menu drawer page on Locality listing page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			driver.navigate().back();
			t1.wait(driver, "//div[@class='btn btn-light-gray locality-change-btn']");
			driver.findElement(By.xpath("//div[@class='btn btn-light-gray locality-change-btn']")).click();
		    t1.wait(driver, "//div[@class='capitalize ta-center city-name']");
			String ChangeLocalityUrl=driver.getCurrentUrl();
			Boolean ChangeLocality= t1.isElementPresent(driver, By.xpath("//div[@class='capitalize ta-center city-name']"));
			String ChangeLocalityText= driver.findElement(By.xpath("//div[@class='capitalize ta-center city-name']")).getText();
			boolean serachbox= t1.isElementPresent(driver,By.xpath("//input[@placeholder='Search for locality']"));
			if(!ChangeLocalityUrl.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate/bellandur-overview-50270#localitySearchPopup") && serachbox==false && ChangeLocality==false && ChangeLocalityText!="Bangalore")
			{
				Assert.fail("\n Change locality page is not opening basis url is wrong, searchbox not found and heading is wrong in"+name);
				driver.close();
			}
			driver.findElement(By.xpath("//div[@class='pull-left back-btn']")).click();		
			t1.wait(driver, "//span[@class='logo pull-left']");
			boolean b= t1.isElementPresent(driver , By.xpath("//span[@class='logo pull-left']"));
			driver.findElement(By.xpath("//span[@class='logo pull-left']")).click();
			String s4= driver.getCurrentUrl();
			if(!s4.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate-overview") && b==false)
			{
				Assert.fail("\n logo click is not opening city home page in "+name);
				driver.close();
			}
			driver.get(BaseUrl+"/dlf-100002");
            t1.wait(driver, "//div[@class='listing-title']");
			String BuilderTitle= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!BuilderTitle.equalsIgnoreCase("DLF"))
			{
				Assert.fail("Builder listing page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to(BaseUrl+"/all-builders");
			t1.wait(driver, "//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']");
			boolean builders= t1.isElementPresent(driver,By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']"));
			if(builders==false)
			{
				Assert.fail("Heading is missing from builder page or is not loading");
			}
			String AllBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in India']")).getText();
			if(!AllBuilderTitle.equalsIgnoreCase("Builders in India"))
			{
				Assert.fail("Builder page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to(BaseUrl+"/bangalore/all-builders");
			t1.wait(driver,"//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']");
			String CityBuilderTitle= driver.findElement(By.xpath("//div[@class='col-xs-12 col-md-6 col-sm-6' and h1='Builders in Bangalore']")).getText();
			if(!CityBuilderTitle.equalsIgnoreCase("Builders in Bangalore"))
			{
				Assert.fail("City Builder page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to(BaseUrl+"/all-cities");
			String AllCityTitle= driver.getTitle();
			if(!AllCityTitle.equalsIgnoreCase("Cities in India - Best Buy/Sale Property Investment Towns in India"))
			{
				Assert.fail("All city page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to(BaseUrl+"/bangalore/all-localities");	 
			String AllLocalityTitle= driver.getTitle();
			if(!AllLocalityTitle.equalsIgnoreCase("Bangalore Localities - List of top localities/Areas in Bangalore"))
			{
				Assert.fail("All locaities page is not opening in"+name);
				driver.close();
			}	
          }
	}

	// Menu Drawer Verification
	public static void VerifyMenuDrawer(WebDriver driver) throws InterruptedException
	{
		t1.wait(driver, "//i[@class='icon-navicon']");
		boolean drawer= t1.isElementPresent(driver, By.xpath("//i[@class='icon-navicon']"));
		if(drawer==false)
		{
			Assert.fail("\nMenu Drawer is not present on city overview page");
			//driver.close();
		}
		t1.wait(driver,"//button[contains(@class,'topMenuBtn')]");
		driver.findElement(By.xpath("//button[contains(@class,'topMenuBtn')]")).click();
		boolean DrawerChangeCitydropwdown = t1.isElementPresent(driver , By.xpath("//select[@class='change-city']"));
		boolean cityHomeIcon= t1.isElementPresent(driver, By.xpath("//i[@class='cityLabel icon-apartment']"));
		String OtherSection= driver.findElement(By.xpath("//div[@class='sections others']//h4[@class='md']")).getText();
		if(DrawerChangeCitydropwdown==false && cityHomeIcon==false && !OtherSection.equalsIgnoreCase("Others"))
		{
			Assert.fail("\n Menau Drawer is not clickable or not opening basis home icon in menu drawer missing,label others and chnage city dropdown");
			driver.close();
		}
		driver.findElement(By.xpath("//button[contains(@class,'topMenuBtn')]")).click();			
	}

	// interstitial Verification
	public static void interstitial(WebDriver driver, String name) throws InterruptedException
	{
		boolean interstitial = t1.isElementPresent(driver, By.xpath("//div[@data-lazyclass='interstial-container']"));
		boolean appButton = t1.isElementPresent(driver, By.xpath("//div[@class='appbutton']"));
		boolean interstitialClose= t1.isElementPresent(driver, By.xpath("//div[@data-lazyclass='interstial-container']//div[@class='closeoption']"));
		boolean phoneimages= t1.isElementPresent(driver, By.xpath("//div[@data-lazyclass='mob-in-hand']"));
		boolean NoThanksText= t1.isElementPresent(driver, By.xpath("//a[@class='no-thanks']"));
		if(!name.equalsIgnoreCase("IE_Nokia_Lumia920"))
		{
			if(interstitial==false)
			{
				Assert.fail("Interstitial is not coming on home page");
			}
			if(appButton==false)
			{
				Assert.fail("All download button is not coming on interstitial");
			}
			if(interstitialClose==false)
			{
				Assert.fail("Close button is not found on interstitial");
			}
			if(phoneimages==false)
			{
				Assert.fail("Phone images are not found on interstitial");
			}
			if(NoThanksText==false)
			{
				Assert.fail("No Thanks Text is not found on interstitial");	
			}		
			if(name.contains("Android"))
			{
				boolean storeadd=t1.isElementPresent(driver,By.xpath("//a[@href='https://play.google.com/store/apps/details?id=com.proptiger']"));
				if(storeadd==false)
				{
					Assert.fail("Android App download link is incorrect or not opening");
				}
			}
			if(name.contains("iPhone"))
			{
				boolean storeadd=t1.isElementPresent(driver,By.xpath("//a[@href='https://itunes.apple.com/in/app/proptiger-real-estate-property/id935244607?ls=1&mt=8']"));
				if(storeadd==false)
				{
					Assert.fail("iOS App download link is incorrect or not opening");
				}
			}
		//driver.navigate().back();
		driver.findElement(By.xpath("//div[@data-lazyclass='interstial-container']//div[@class='closeoption']")).click();
		//driver.manage().deleteAllCookies();
		boolean interstitial1= t1.isElementPresent(driver, By.xpath("//div[@id='interstitalPopup' and @class='open']"));
		if(interstitial1==true)
		{
			Assert.fail("Interstitial close button is not working");
		}
	  }
	}
	


	public static void Check404Page(WebDriver driver) throws InterruptedException
	{
		driver.get(BaseUrl+"/noida/sector-118/supertech-romano-652425/atms");
		t1.wait(driver, "//*[@id='content']/div/table/tbody/tr/td/h2");
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
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
			t1.wait(driver, "//a[@class='no-ajaxy bigbtn projects-near-me']");
			String RedirectURl=driver.getCurrentUrl();
			if(!RedirectURl.equalsIgnoreCase(BaseUrl+"/"))
			{
				Assert.fail("\n Goto home page button is not redirecting to home page from 404 page");
				//driver.close();
			}
		}
		//driver.quit();


	public static void CheckAmenityPages(WebDriver driver) throws InterruptedException
	{
		driver.get(BaseUrl+"/mumbai/panvel-50006/atms");
		t1.wait(driver, "//h1[@class='locality-name']");
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
		String LocalityName= driver.findElement(By.xpath("//h1[@class='locality-name']")).getText();
		boolean CityDropDown= t1.isElementPresent(driver, By.xpath("//select[@class='city-select-dd']//option[@selected='true']"));
		String  SelectedCity=driver.findElement(By.xpath("//select[@class='city-select-dd']//option[@selected='true']")).getText();
		boolean AmenityButton=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-warning']//i[@class='imageIcon']"));
		boolean AmenityButtonIcon=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy btn btn-warning']//i[@class='imageIcon']"));
		String SelectedAmenity= driver.findElement(By.xpath("//a[@class='no-ajaxy btn btn-warning']")).getText();
		if(!LocalityName.equalsIgnoreCase("ATMs in panvel") && !SelectedAmenity.equalsIgnoreCase("Atms"))
		{
			Assert.fail("Amenity page is not opening for panvel-ATMS");
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
		if(!SelectedCity.equalsIgnoreCase("Mumbai"))
		{
			Assert.fail("Selected city in city dropdown is wrong");	
			driver.close();
		}
	}
}
