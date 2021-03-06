package com.proptiger1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DesktopTestBed {
	@BeforeTest
	public void start()
	{
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		System.out.println("============== DESKTOP RESPONSIVE PAGE TEST STARTED ===============");
	}
	@Test(priority=5)
	void ResponsivePage_FireFox_Linux() throws InterruptedException 
	{
		java.lang.String name="FireFox_Linux";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (X11; Ubuntu; Linux x86_64; rv:33.0) "
				+ "Gecko/20100101 Firefox/33.0");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("==============================================================================");
		DesktopResponsive_Test.Gallery(driver,name);
		
		DesktopResponsive_Test.Responsive(driver, name);
		//DesktopResponsive_Test.CheckAmenityPages(driver,name);
		DesktopResponsive_Test.DesktopAmenityLead(driver, name);
		DesktopResponsive_Test.Careers(driver, name);
		
		System.out.println("=============================================================================");
    	driver.quit();
	}
	@Test(priority=4)
	void ResponsivePage_Chrome_Linux() throws InterruptedException 
	{
		java.lang.String name="Chrome_Linux";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (X11; Linux x86_64) "
				+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/39.0.2171.65 Safari/537.36");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		System.out.println("==============================================================================");
		DesktopResponsive_Test.Gallery(driver,name);
		
		DesktopResponsive_Test.Responsive(driver, name);
		//DesktopResponsive_Test.CheckAmenityPages(driver,name);
		DesktopResponsive_Test.DesktopAmenityLead(driver, name);
		DesktopResponsive_Test.Careers(driver, name);
		System.out.println("==============================================================================");
  	    driver.quit();
	}
	@Test(priority=2)
	void ResponsivePage_FireFox_Windows() throws InterruptedException 
	{
		java.lang.String name="FireFox_Windows";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 ;Windows NT 6.3; WOW64;"
				+ " rv:34.0; Gecko/20100101 Firefox/34.0");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		DesktopResponsive_Test.Gallery(driver,name);
		//DesktopResponsive_Test.Careers(driver, name);
		DesktopResponsive_Test.Responsive(driver, name);
		//DesktopResponsive_Test.CheckAmenityPages(driver,name);
		DesktopResponsive_Test.DesktopAmenityLead(driver, name);
		DesktopResponsive_Test.Careers(driver, name);
		System.out.println("==============================================================================");
		driver.quit();
	}
	@Test(priority=3)
	void ResponsivePage_Chrome_Windows() throws InterruptedException 
	{
		java.lang.String name="Chrome_Windows";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 ;Windows NT 6.3; WOW64; AppleWebKit/537.36 ;"
				+ "KHTML, like Gecko; Chrome/39.0.2171.95 Safari/537.36");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().deleteAllCookies();	
		driver.manage().window().maximize();
		System.out.println("==============================================================================");
		DesktopResponsive_Test.Gallery(driver,name);
		//DesktopResponsive_Test.Careers(driver, name);
		DesktopResponsive_Test.Responsive(driver, name);
		//DesktopResponsive_Test.CheckAmenityPages(driver,name);
		DesktopResponsive_Test.DesktopAmenityLead(driver, name);
		DesktopResponsive_Test.Careers(driver, name);
		System.out.println("==============================================================================");
		driver.quit();
	}
	@Test(priority=1)
void ResponsivePage_Chrome_Mac() throws InterruptedException 
{
	java.lang.String name="Chrome_Mac";
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("general.useragent.override","Mozilla/5.0 ;Macintosh; Intel Mac OS X 10_10_1; "
			+ "AppleWebKit/537.36 ;KHTML, like Gecko; Chrome/39.0.2171.95 Safari/537.36");
	WebDriver driver= new FirefoxDriver(profile);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	System.out.println("==================================================================================");
	DesktopResponsive_Test.Gallery(driver,name);
	//DesktopResponsive_Test.Careers(driver, name);
	DesktopResponsive_Test.Responsive(driver, name);
	//DesktopResponsive_Test.CheckAmenityPages(driver,name);
	DesktopResponsive_Test.DesktopAmenityLead(driver, name);
	DesktopResponsive_Test.Careers(driver, name);
	System.out.println("==================================================================================");
	driver.quit();
}
	@Test(priority=0)
void ResponsivePage_Safari_Mac() throws InterruptedException 
{
	java.lang.String name="Safari_Mac";
	FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("general.useragent.override","Mozilla/5.0 ;Macintosh; Intel Mac OS X 10_10_1; "
			+ "AppleWebKit/600.2.5 ;KHTML, like Gecko; Version/8.0.2 Safari/600.2.5");
	WebDriver driver= new FirefoxDriver(profile);
	driver.manage().deleteAllCookies();
	driver.manage().window().maximize();
	System.out.println("==================================================================================");
	DesktopResponsive_Test.Gallery(driver,name);
	//DesktopResponsive_Test.Careers(driver, name);
	DesktopResponsive_Test.Responsive(driver, name);
	//DesktopResponsive_Test.CheckAmenityPages(driver,name);
	DesktopResponsive_Test.DesktopAmenityLead(driver, name);
	DesktopResponsive_Test.Careers(driver, name);	
	System.out.println("==================================================================================");
	driver.quit();
}
	@AfterClass
	public static void teardown()  
	{
		System.out.println("============== DESKTOP RESPONSIVE TEST FINISHED ===============");
    }
}
