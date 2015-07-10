package com.proptiger1;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes.Name;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Cross_PlatForm {
	public static TimeStamp t1= new TimeStamp();
	static String name="";
	static int count=0;
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String ssl1="https://www.proptiger.com/";
	static String betahttp="http://beta.proptiger-ws.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String local="http://192.168.0.216:5000";
	static String betassl="https://beta.proptiger-ws.com";
	static String betassl1="https://beta.proptiger-ws.com/";
	static String qassl="https://beta.proptiger-ws.com";
	static String qassl1="https://beta.proptiger-ws.com/";
	static String BaseUrl=ssl;
	static String BaseUrl1=ssl1;
	static URL url;
    static void AllPages(WebDriver driver, String name) throws InterruptedException {
		driver.manage().window().setSize(new Dimension(350,700));
		driver.get(BaseUrl);
		driver.manage().deleteAllCookies();	
		WebDriverWait wait1 = new WebDriverWait(driver,120);
		wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='city-selector']")));
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
	    boolean SelectCity= t1.isElementPresent(driver, By.xpath("//div[@class='city-selector']"));
		boolean SearchBTN= t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy srch-btn']"));
		if(SelectCity==false && SearchBTN==false)
		{
            Assert.fail("\n Global home Page could not be opened in"+name);
			driver.close();
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='city-selector']")).click();
			Thread.sleep(3000L);
			int cityCount= driver.findElements(By.xpath("//li[@class='js-city-list']")).size();
			if(cityCount!=14)
			{
				Assert.fail("\n Count of diplayed cities on home page is wrong!!");
			}
			try
			{
				driver.manage().deleteAllCookies();
				t1.wait(driver, "//li[@data-city-name='Bangalore']");
				driver.findElement(By.xpath("//li[@class='js-city-list' and text()='Bangalore']")).click();
				driver.findElement(By.xpath("//input[@type='search']")).click();
				t1.wait(driver, "//div[@data-redirect-url='/bangalore/property-sale-kr-puram-50167']");
				driver.findElement(By.xpath("//div[contains(text(),'KR')]")).click();
				Thread.sleep(4000L);
				String title= driver.findElement(By.xpath("//h1[contains(text(),'Property for Sale')]")).getText();
				if(!title.equalsIgnoreCase("Property for sale in KR Puram"))
				{
					System.out.println("Locality listing page pf KR puram is not opening");
				}
				driver.findElement(By.xpath("//button[@class='topMenuBtn seoclick header-drawer js-toggle-menu']")).click();
				t1.wait(driver,"//a[@href='/projects-in-bangalore']");
				driver.findElement(By.xpath("//ul[@class='drawer-list']//a[contains(text(),'See all')]")).click();
				Thread.sleep(3000L);
				String CityHomeUrl= driver.getCurrentUrl();
				String ExpectedURL=BaseUrl+"/projects-in-bangalore";
				if(!CityHomeUrl.equalsIgnoreCase(ExpectedURL))
				{
					Assert.fail("City Overview page url is wrong or not opening in"+name);			
				}
				
			// Verify menu drawer page on city page
			Cross_PlatForm.VerifyMenuDrawer(driver);
			//driver.findElement(By.partialLinkText("All projects in")).click();
			Cookie cookie1 = new Cookie("TESTING_USER", "1");
		    driver.manage().addCookie(cookie1);
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
			Thread.sleep(2000L);
			if(!name.equalsIgnoreCase("IE_Nokia_Lumia920"))
			{
				driver.findElement(By.xpath("//td[@class='ta-right map-btn-wrapper']//a[@class='no-ajaxy pull-right btn btn-default show-map-btn']")).click();
				String MapPage=driver.getCurrentUrl();				
				if(!MapPage.equalsIgnoreCase(BaseUrl+"/projects-in-bangalore#mapStaticPopupBlock"))
				{
					Assert.fail("\n Map page is not opening in"+name);
					driver.close();
				}
				driver.navigate().back();
				Thread.sleep(3000L);
			}
			 boolean Alt= t1.isElementPresent(driver, By.xpath("//img[@alt='skylark ithaca Elevation']")); 
			 while(Alt!=true)
			 {
			 Actions actions = new Actions(driver);
			 actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			 Alt= t1.isElementPresent(driver, By.xpath("//img[@alt='skylark ithaca Elevation']")); 
			 }
			driver.findElement(By.xpath("//img[@alt='skylark ithaca Elevation']")).click();
			t1.wait(driver, "//div[@class='proj-name']");
			String ProjectPage= driver.getCurrentUrl();
			String ProjName= driver.findElement(By.xpath("//div[@class='proj-name']")).getText();
			String LocName= driver.findElement(By.xpath("//div[@class='loc-name']")).getText();
			if(!ProjectPage.equalsIgnoreCase(BaseUrl+"/bangalore/kr-puram/skylark-ithaca-642535")
					&& !ProjName.equalsIgnoreCase("Skylark ithaca"))
			{
				Assert.fail("\n Project Page is not opening/URL is wrong or project name/locality name is missing"+name);	
			}
			boolean prjImg= t1.isElementPresent(driver,By.xpath("//div[@class='img-banner']"));
			if(prjImg==false)Assert.fail("Image not found on project page:"+prjImg);
			boolean socialShareLinks=t1.isElementPresent(driver, By.xpath("//a[@class='no-ajaxy whiteStrokeBtn js-share-button active']"));
			boolean socialshareIcon=t1.isElementPresent(driver, By.xpath("//i[@class='icon-share-o']"));
			boolean phoneIcon= t1.isElementPresent(driver,By.xpath("//i[@class='icon-phone']"));
			boolean serachIcon=t1.isElementPresent(driver, By.xpath("//i[2class='icon-search']"));
			String Overview= driver.findElement(By.xpath("//section[@class='section-proj-overview js-section-proj-overview']//h3[@class='section-title']")).getText();
			String SubTitle= driver.findElement(By.xpath("//section[@class='section-proj-overview js-section-proj-overview']//span[@class='subtitle']")).getText();
			boolean RupeeIcon= t1.isElementPresent(driver,By.xpath("//i[@class='icon-rupee-o']"));
			String PriceRange= driver.findElement(By.xpath("//section[@class='section-proj-overview js-section-proj-overview']//div[@class='price-txt']")).getText();
			boolean bedicon= t1.isElementPresent(driver, By.xpath("//i[@class='icon-bed-o']"));
			String bhkoption= driver.findElement(By.xpath("//div[@class='type-txt']")).getText();
			boolean flooricon= t1.isElementPresent(driver, By.xpath("//i[@class='icon-floor-o']"));
			String sizetext= driver.findElement(By.xpath("//div[@class='size-txt']")).getText();
			String FloorPlan= driver.findElement(By.xpath("//span[@class='linktxt']")).getText();
			boolean possession= t1.isElementPresent(driver,By.xpath("//i[@class='icon-key-o']"));
			String possessionDate= driver.findElement(By.xpath("//div[@class='possn-txt']")).getText();
			boolean MoreLink= t1.isElementPresent(driver, By.xpath("//div[@class='proj-desc js-more-less-parent js-short-overview-link']//a[@class='more-link js-more-less no-ajaxy']"));
			while(MoreLink!=true)
			{
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			MoreLink= t1.isElementPresent(driver, By.xpath("//div[@class='proj-desc js-more-less-parent js-short-overview-link']//a[@class='more-link js-more-less no-ajaxy']"));
			}
			driver.navigate().refresh();
			if(MoreLink==false)Assert.fail("More link is not visible in description");
			else
			driver.findElement(By.xpath("//a[@data-read-more-type='overview']")).click();
			boolean LessLink= t1.isElementPresent(driver,By.xpath("//a[@class='more-link js-more-less no-ajaxy']"));
			while(LessLink!=true)
			{
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			LessLink= t1.isElementPresent(driver, By.xpath("//div[@class='proj-desc js-more-less-parent js-long-overview-link']//a[@class='more-link js-more-less no-ajaxy']"));
			}
			if(LessLink==false)
			{
				System.out.println("Clicking on more link text is not expanding or more link is not coming");
			}
			driver.findElement(By.xpath("//div[@class='proj-desc js-more-less-parent js-long-overview-link']//a[@class='more-link js-more-less no-ajaxy']")).click();
		    boolean more2= t1.isElementPresent(driver, By.xpath("//div[@class='proj-desc js-more-less-parent js-short-overview-link']//a[@class='more-link js-more-less no-ajaxy']"));
			if(more2==false)
			{
				System.out.println("Clicking on less link text is not shrinking or less link is not working");
			}
			boolean livability=t1.isElementPresent(driver,By.xpath("//i[@class='icon-livability-o']"));
			boolean arrowup=t1.isElementPresent(driver,By.xpath("//i[@class='icon-arrow-up']"));
			boolean livabilityscore=t1.isElementPresent(driver,By.xpath("//div[@class='col-xs-6 ta-center']//span[@class='count']"));
			if(livabilityscore==false)
			{
		    livabilityscore=t1.isElementPresent(driver,By.xpath("//div[@class='col-xs-12 ta-center']//span[@class='count']"));
			String LivabilityScore=driver.findElement(By.xpath("//div[@class='col-xs-12 ta-center']//span[@class='count']")).getText();
			}
			else{
				livabilityscore=t1.isElementPresent(driver,By.xpath("//div[@class='col-xs-6 ta-center']//span[@class='count']"));
				String LivabilityScore=driver.findElement(By.xpath("//div[@class='col-xs-6 ta-center']//span[@class='count']")).getText();				}
			boolean facts= t1.isElementPresent(driver,By.xpath("//div[@class='facts-wrap']"));
			String Heading= driver.findElement(By.xpath("//span[@class='txt-area']")).getText();
	    	/*boolean builderprpt=t1.isElementPresent(driver,By.xpath("//div[@class='option js-builder-properties']"));
			String builderprttext=driver.findElement(By.xpath("//div[@class='option js-builder-properties']")).getText();
			boolean resalerprpt=t1.isElementPresent(driver,By.xpath("//div[@class='option resale js-resale-properties active']"));
			String resaleprpttext=driver.findElement(By.xpath("//div[@class='option resale js-resale-properties active']")).getText();
			String newcount= driver.findElement(By.xpath("//div[@class='option js-builder-properties']//span[@class='count']")).getText();
		    String countresale= driver.findElement(By.xpath("//div[@class='option resale js-resale-properties active']//span[@class='count']")).getText();
		    String c1=countresale.replace("(","");
			String c2=c1.replace(")","");
		    int rcount= Integer.parseInt(c2);
			if(rcount!=6)
			{
				Assert.fail("Count of resale listings on new project page is incorrect");
			}*/
		    boolean floorplanimage1=t1.isElementPresent(driver,By.xpath("//img[@src='https://im.proptiger.com/2/5064479/12/skylark-ithaca-floor-plan-1bhk-1t-605-sq-ft-475951.jpeg?width=350&height=200']"));
			boolean uparrow= t1.isElementPresent(driver,By.xpath("//i[@class='icon-chevron-up js-icon-chevron-up show']"));
			boolean locality_Button= t1.isElementPresent(driver,By.name("Explore Locality"));
			driver.navigate().refresh();
	        Cross_PlatForm.VerifyMenuDrawer(driver);	
			t1.wait(driver, "//a[@id='headerLogo']");
			boolean b= t1.isElementPresent(driver , By.xpath("//a[@id='headerLogo']"));
			while(b!=true)
			{
				Actions actions = new Actions(driver);
			    actions.keyDown(Keys.CONTROL).sendKeys(Keys.UP).perform();
			   b = t1.isElementPresent(driver , By.xpath("//a[@id='headerLogo']"));
			}
			driver.findElement(By.xpath("//a[@id='headerLogo']")).click();
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
			/*boolean pagination= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='//all-builders']"));
			boolean pagination2= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='//all-builders?page=2']"));
			while(pagination!=true){
				Actions actions = new Actions(driver);
				actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
				pagination= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='//all-builders']"));	
			}
			if(pagination==false && pagination2==false)
			{
				Assert.fail("Pagination is missing on all builders page");
			}*/
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
			if(!AllCityTitle.equalsIgnoreCase("Cities in India - Best Buy/Sale Property Investment Towns in India :PropTiger.com"))
			{
				Assert.fail("All city page is not opening in"+name);
				driver.close();
			}
			driver.navigate().to(BaseUrl+"/bangalore/all-localities");	 
			String AllLocalityTitle= driver.getTitle();
			if(!AllLocalityTitle.equalsIgnoreCase("Bangalore Localities - List of top localities/Areas in Bangalore :PropTiger.com"))
			{
				Assert.fail("All locaities page is not opening in"+name);
				driver.close();
			}	
		driver.navigate().to(BaseUrl+"/gurgaon/all-suburbs");	 
		String AllSuburbs= driver.getTitle();
		if(!AllSuburbs.equalsIgnoreCase("Best Residential Areas in Gurgaon | All Suburbs of Gurgaon :PropTiger.com"))
		{
			Assert.fail("All suburb page is not opening in"+name);
			driver.close();
		}	
		String suburb_heading=driver.findElement(By.xpath("//h1[@style='margin:0 0 10px -5px;']")).getText();
		if(!suburb_heading.equalsIgnoreCase("Best Residential Areas in Gurgaon"))
				{
			Assert.fail("suburb page heading is missing/ page is not opening");
				}
		boolean pagination= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='/gurgaon/all-suburbs']"));
		boolean pagination2= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='/gurgaon/all-suburbs?page=2']"));
		while(pagination!=true)
		{
			Actions actions = new Actions(driver);
			actions.keyDown(Keys.CONTROL).sendKeys(Keys.END).perform();
			pagination= t1.isElementPresent(driver,By.xpath("//ul[@class='custom-pagi pull-right']//a[@href='//all-builders']"));	
		}
	
		if(pagination==false && pagination2==false)
		{
			Assert.fail("Pagination is missing on all suburb page in bottom");
		}}catch(Exception e){System.out.println(e.getLocalizedMessage());}
		}}
			// Menu Drawer Verification
	public static void VerifyMenuDrawer(WebDriver driver) throws InterruptedException
	{
		t1.wait(driver, "//i[@class='icon icon-mapmarker']");
		boolean localityicon= t1.isElementPresent(driver, By.xpath("//i[@class='icon icon-mapmarker']"));
		if(localityicon==false)
		{
			Assert.fail("\nMenu Drawer is not present on city overview page");
			//driver.close();
		}
		t1.wait(driver,"//button[contains(@class,'topMenuBtn')]");
		driver.findElement(By.xpath("//button[contains(@class,'topMenuBtn')]")).click();
		boolean citydropdown= t1.isElementPresent(driver, By.xpath("//div[@class='city-selector-box js-city-selector-box']"));
		boolean cityHomeIcon= t1.isElementPresent(driver, By.xpath("//i[@class='icon icon-mapmarker']"));
		boolean facebook= t1.isElementPresent(driver, By.xpath("//div[@class='menu-drawer-wrap js-menu-drawer-wrap']//i[@class='icon-facebook']"));
		boolean googleplus= t1.isElementPresent(driver, By.xpath("//div[@class='menu-drawer-wrap js-menu-drawer-wrap']//i[@class='icon-google-plus']"));
		boolean linkedin= t1.isElementPresent(driver, By.xpath("//div[@class='menu-drawer-wrap js-menu-drawer-wrap']//i[@class='icon-linkedin']"));
		boolean youtube= t1.isElementPresent(driver, By.xpath("//div[@class='menu-drawer-wrap js-menu-drawer-wrap']//i[@class='icon-youtube']"));
		boolean twitter= t1.isElementPresent(driver, By.xpath("//div[@class='menu-drawer-wrap js-menu-drawer-wrap']//i[@class='icon-twitter']"));
		if(citydropdown==false && cityHomeIcon==false)
		{
			Assert.fail("\n Menau Drawer is not clickable or not opening basis home icon in menu drawer is missing");
			driver.close();
		}
		if(facebook==false )
		{
			Assert.fail("facebook link is missing in the menu drawer");
		}
		if(googleplus==false )
		{
			Assert.fail("Google Plus link is missing in the menu drawer");
		}
		if(linkedin==false )
		{
			Assert.fail("LinkedIn link is missing in the menu drawer");
		}
		if(youtube==false )
		{
			Assert.fail("Youtube link is missing in the menu drawer");
		}
		if(twitter==false )
		{
			Assert.fail("Twitter Link is missing in the menu drawer");
		}
		driver.findElement(By.xpath("//label[@id='drawer-overlay']")).click();			
	}

	
public static void locality(WebDriver driver) throws InterruptedException{
    t1.wait(driver, "//div[@class='ta-center marginT20']//a[@class='btn btn-blu explore-this-locality']");
			driver.findElement(By.xpath("//div[@class='ta-center marginT20']//a[@class='btn btn-blu explore-this-locality']")).click();
			t1.wait(driver, "//h1[@class='metah1' and text()='Property in Adugodi']");
			String LocalityUrl= driver.getCurrentUrl();
			String Localityheading= driver.findElement(By.xpath("//div[@class='capitalize put-ellipsis']")).getText();
			//boolean LocalityImage= t1.isElementPresent(driver,By.xpath("//img[@data-src='https://im.proptiger.com/1/504226/6/mythreyi-group-naimisha-elevation-472821.jpeg?width=400&height=300']"));
			if(!LocalityUrl.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate/adugodi-overview-52720")
					&& !Localityheading.equalsIgnoreCase("Adugodi"))
			{
				Assert.fail("\n Locality page is not opening, basis URL is incorrect/heading is incorrect/image is missing"+name);
				driver.close();  		
			}
			driver.findElement(By.xpath("//table[@class='tab-list']//td[@id='pricetrend-tab-link']")).click();
			t1.wait(driver,  "//canvas[@id='appartment-price-trend']");
			//Price Trends
			boolean PriceTrendLabel=t1.isElementPresent(driver,By.xpath("//div[@class='title tcw' and text()=' Price Trends']"));
			boolean PTApartmentActiveTab=t1.isElementPresent(driver,By.xpath("//a[@id='apt-chart-tab']"));
			boolean PTActive= t1.isElementPresent(driver,By.xpath("//section[@class='white-bg-pad10 marginTB10 locality-price-trend-card open']//a[@class='no-ajaxy graph-tab active']"));
			boolean PTVillaTab=t1.isElementPresent(driver,By.xpath("//a[@id='villa-chart-tab']"));
			boolean PTPlotTab=t1.isElementPresent(driver,By.xpath("//a[@id='plot-chart-tab']"));
			
			boolean PTCardclose=t1.isElementPresent(driver, By.xpath("//div[@class='title tcw' and text()=' Price Trends']//i[@class='toggle-icon']"));
			boolean Graph= t1.isElementPresent(driver, By.xpath("//canvas[@id='appartment-price-trend']"));
			//Price compare part
			boolean PriceComparelabel=t1.isElementPresent(driver,By.xpath("//div[@class='title tcw' and text()=' Price Comparison']"));
			boolean PCActiveTab=t1.isElementPresent(driver,By.xpath("//section[@class='white-bg-pad10 marginTB10 price-comparison-card open']//a[@class='no-ajaxy graph-tab active']"));
			boolean ApartmentTab=t1.isElementPresent(driver,By.xpath("//a[@id='apt-chart=tab-comparison']"));
			boolean VillaTab=t1.isElementPresent(driver,By.xpath("//a[@id='villa-chart=tab-comparison']"));
			boolean PlotTab=t1.isElementPresent(driver,By.xpath("//a[@id='plot-chart=tab-comparison']"));
			boolean PCCardClose= t1.isElementPresent(driver,By.xpath("//div[@class='title tcw' and text()=' Price Comparison']//i[@class='toggle-icon']"));
			
			driver.findElement(By.xpath("//table[@class='tab-list']//td[@id='neighbourhood-tab-link']")).click();
			boolean School= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-Sch']"));
			boolean Hospital= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-hospital']"));
			boolean Petrol= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-petrol-station']"));
			boolean Bank= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-bank']"));
			boolean Restaurant= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-restaurant']"));
			boolean AppDownload= t1.isElementPresent(driver,By.xpath("//span//i[@class='icon-Apple and text()='DOWNLOAD OUR iPhone APP']"));
			boolean DownloadLink=t1.isElementPresent(driver,By.xpath("https://itunes.apple.com/in/app/proptiger-real-estate-property/id935244607?ls="
					+ "1&mt=8&referrer=utm_source=(direct)&utm_medium=(none)&utm_content=LOCALITY-OVERVIEW&utm_campaign=mobilesite"));
		    driver.findElement(By.xpath("//table[@class='tab-list']//td[@id='reviews-tab-link']")).click();
			Boolean rating= t1.isElementPresent(driver,By.xpath("//div[@class='user-rating mini-title']"));
			driver.findElement(By.xpath("//table[@class='tab-list']//td[@id='overview-tab-link']")).click();
			//t1.wait(driver,"//img[@src='https://im.proptiger.com/4/270/15/bellandur-bangalore-road-382762.jpeg?width=400&height=300']");
			//boolean image= t1.isElementPresent(driver,By.xpath("//img[@src='https://im.proptiger.com/4/270/15/bellandur-bangalore-road-382762.jpeg?width=400&height=300']"));
			// Verify menu drawer page on Locality overview page
			Cross_PlatForm.VerifyMenuDrawer(driver);
		    driver.findElement(By.linkText("View all Projects")).click();
			t1.wait(driver, "//div[@class='listing-title']");
		    String LocalityListURL= driver.getCurrentUrl();
			String LocalityListheading= driver.findElement(By.xpath("//div[@class='listing-title']")).getText();
			if(!LocalityListURL.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate/adugodi-overview-52720") 
					&& !LocalityListheading.equalsIgnoreCase("Adugodi, Bangalore"))
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
			boolean ChangeLocality= t1.isElementPresent(driver, By.xpath("//div[@class='capitalize ta-center city-name']"));
			String ChangeLocalityText= driver.findElement(By.xpath("//div[@class='capitalize ta-center city-name']")).getText();
			boolean serachbox= t1.isElementPresent(driver,By.xpath("//input[@placeholder='Search for locality']"));
			if(!ChangeLocalityUrl.equalsIgnoreCase(BaseUrl+"/bangalore-real-estate/adugodi-overview-52720#localitySearchPopup") && serachbox==false && ChangeLocality==false && ChangeLocalityText!="Bangalore")
			{
				Assert.fail("\n Change locality page is not opening basis url is wrong, searchbox not found and heading is wrong in"+name);
				driver.close();
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
			t1.wait(driver,"//a[@class='no-ajaxy btn btn-d-yellow']");
            WebElement e= driver.findElement(By.xpath("//a[@class='no-ajaxy btn btn-d-yellow']"));
            Actions s = new Actions(driver);
            s.doubleClick(e);
            s.perform();
			//driver.navigate().refresh();
			t1.wait(driver, "//h3[contains(text(),'Explore more')]");
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
		t1.wait(driver, "//section[@class='top-area max1170']//h1[@class='locality-name']");
		Cookie cookie = new Cookie("TESTING_USER", "1");
	    driver.manage().addCookie(cookie);
		String LocalityName= driver.findElement(By.xpath("//section[@class='top-area max1170']//h1[@class='locality-name']")).getText();
		boolean CityDropDown= t1.isElementPresent(driver, By.xpath("//select[@class='city-select-dd js-city-change-dropdown']//option[@selected='true']"));
		String  SelectedCity=driver.findElement(By.xpath("//select[@class='city-select-dd js-city-change-dropdown']//option[@selected='true']")).getText();
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
   public static void CheckUrls() throws IOException
   {
	   FileInputStream newFile1 = new FileInputStream("./Input/Main.xls"); 
		 HSSFWorkbook workbook = new HSSFWorkbook(newFile1);
		 HSSFSheet sheet = workbook.getSheetAt(0);
		 System.out.println(" PROCESSING Urls..........");
       System.out.println("*************************************************************************************");
      for(int i=1;i<=sheet.getLastRowNum();i++)
     	{
     	 String URLs= BaseUrl1+sheet.getRow(i).getCell((short) 1).getStringCellValue();
		try {
		    URL url = new URL(URLs);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4"
				+ "(KHTML, like Gecko) CriOS/40.0.2214.73 Mobile/12B466 Safari/600.14");
		    con.setRequestProperty("Connection", "close");
		    con.connect();
		    if (con.getResponseCode()==200) 
		    {
		       System.out.println(i+":"+URLs+"  "+con.getResponseCode()+"  Ok");
		    }
		    if(con.getResponseCode()!=200)
		    {
		    	System.err.println(i+":"+URLs+"  "+con.getResponseCode()+" Not Ok");
		    }
		    
		  } catch (MalformedURLException e1) {
		    e1.printStackTrace();
		  } catch (  UnknownHostException unknownHostException) {
		    System.err.println("This Url is not correct: " + unknownHostException);
		  }catch (  NullPointerException ex) {
		    System.err.println("This Url is not correct: " + ex);
		  }
     	}	
      
   for(int i=1;i<=sheet.getLastRowNum();i++)
   { 
	        String URLs= BaseUrl1+"/"+sheet.getRow(i).getCell((short) 1).getStringCellValue();
		    url = new URL(URLs);
		    HttpURLConnection con = (HttpURLConnection) url.openConnection();
		    con.setRequestProperty("User-Agent", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4"
				+ "(KHTML, like Gecko) CriOS/40.0.2214.73 Mobile/12B466 Safari/600.14");
		    con.setRequestProperty("Connection", "close");
		    con.connect();
		   if(con.getResponseCode()!=200)
		    {
		    	count=count+1;
		    }
		}
   //System.err.println("1.Some URLS are not OK. Please check report for status:500/404"+count);
   if(count>=1)
   {
	   Assert.fail("Some URLS are failing.");
   }
   }
}
   
   
