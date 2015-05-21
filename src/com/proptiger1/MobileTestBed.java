package com.proptiger1;
import java.io.IOException;

import org.apache.xpath.operations.String;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;

public class MobileTestBed {
	@BeforeTest
	public void start() throws InterruptedException 
	{
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		System.out.println("============ ALL PAGE ACCESSIBILITY TEST STARTED ==============");
	}
		
	@Test(priority=8)
	void Chrome_iPhone_AllPageTest() throws InterruptedException 
	{
		java.lang.String name="Chrome_iPhone";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		//driver.quit();
		Cross_PlatForm.Check404Page(driver);
		//driver.quit();
		Cross_PlatForm.CheckAmenityPages(driver);
		//driver.quit();
		System.out.println("9.All Pages are accessible on Chrome_iPhone");
		driver.quit();
	}
	
	@Test(priority=9)
	void Chrome_AndroidTablet_AllPageTest() throws InterruptedException 
	{
		java.lang.String name="Chrome_AndroidTablet";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.1.2; Nexus 7 Build/JZ054K) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("10.All Pages are accessible on Chrome_AndroidTablet");
		driver.quit();
	}
	
	@Test(priority=6)
	void Chrome_AndroidMobile__AllPageTest() throws InterruptedException 
	{
		java.lang.String name="Chrome_AndroidMobile";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.4.4; XT1030 Build/SU4.21) "
				+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/38.0.2125.102 Mobile Safari/537.36");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("7.All Pages are accessible on Chrome_AndroidMobile");
		driver.quit();
	}
	@Test(priority=5)
	void FireFox_Android_AllPageTest() throws InterruptedException 
	{
		java.lang.String name="FireFox_Android";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Android; Tablet; rv:14.0) Gecko/14.0 Firefox/14.0");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("6.All Pages are accessible on FireFox_Android");
		driver.quit();
	}
	@Test(priority=4)
	void Safari_iOS8__AllPageTest() throws InterruptedException {
		java.lang.String name="Safari_iOS8";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X) AppleWebKit/600.1.4"
				+ "(KHTML, like Gecko) Version/8.0 Mobile/12B440 Safari/600.1.4");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("5.All Pages are accessible on iOS8");
		driver.quit();
	}
	@Test(priority=7)
	void Safari_iOS7__AllPageTest() throws InterruptedException 
	{
		java.lang.String name="Safari_iOS7";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) "
				+ "AppleWebKit/537.51.1(KHTML, like Gecko) Version/7.0 Mobile/11A4449d Safari/9537.53");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("8.All Pages are accessible on iOS7");
		driver.quit();
	}
	@Test(priority=2)
	void IE_Nokia_Lumia920__AllPageTest() throws InterruptedException 
	{
		java.lang.String name="IE_Nokia_Lumia920";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0;"
				+ " Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);	
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("3.All Pages are accessible on IE_Nokia_Lumia920");
		driver.quit();		
	}
@Test(priority=1)
	void OperaMini_iPhone__AllPageTest() throws InterruptedException 
	{
		java.lang.String name="OperaMini_iPhone";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X)"
				+ "AppleWebKit/600.1.4 (KHTML, like Gecko) OPiOS/9.1.0.86723 Mobile/12B440 Safari/9537.53");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);	
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("2.All Pages are accessible on OperaMini_iPhone");																																																																																																																																																																																																																																																																																																																																																																																																																																																																
		driver.quit();		
	}
	@Test(priority=3)
	void OperaMini_Android__AllPageTest() throws InterruptedException 
	{
		java.lang.String name="OperaMini_Android";
		FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("general.useragent.override","Opera/9.80 (Android; Opera Mini/7.5.33361/31.1448; U; en)"
        		+ " Presto/2.8.119 Version/11.1010");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		Cross_PlatForm.AllPages(driver,name);	
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("4.All Pages are accessible on OperaMini_Android");
		driver.quit();		
	}
	
	@Test(priority=0)
	void UrlCheck() throws InterruptedException, IOException 
	{
		Cross_PlatForm.CheckUrls();
		System.out.println("1.All urls are working");		
	}
	
	@AfterClass
	public static void teardown()  
	{
		System.out.println("============= ALL PAGE ACCESSIBILITY TEST FINISHED ==============");
	}
}
