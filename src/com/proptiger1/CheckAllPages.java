package com.proptiger1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
public class CheckAllPages {
	
	@Test(priority=0)
	void Chrome_iPhone() throws InterruptedException 
	{
		String name="Chrome_iPhone";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		//driver.quit();
		Cross_PlatForm.Check404Page(driver);
		//driver.quit();
		Cross_PlatForm.CheckAmenityPages(driver);
		//driver.quit();
		System.out.println("All Pages are accessible on Chrome_iPhone");
		driver.quit();
	}
	
	@Test(priority=1)
	void Chrome_AndroidTablet() throws InterruptedException 
	{
		String name="Chrome_AndroidTablet";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.1.2; Nexus 7 Build/JZ054K) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on Chrome_AndroidTablet");
		driver.quit();
	}
	
	@Test(priority=2)
	void Chrome_AndroidMobile() throws InterruptedException 
	{
		String name="Chrome_AndroidMobile";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on Chrome_AndroidMobile");
		driver.quit();
	}
	@Test(priority=3)
	void FireFox_Android() throws InterruptedException 
	{
		String name="FireFox_Android";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Android; Tablet; rv:14.0) Gecko/14.0 Firefox/14.0");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on FireFox_Android");
		driver.quit();
	}
	@Test(priority=4)
	void Safari_iOS8() throws InterruptedException {
		String name="Safari_iOS8";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 "
				+ "(KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on iOS8");
		driver.quit();
	}
	@Test(priority=5)
	void Safari_iOS7() throws InterruptedException 
	{
		String name="Safari_iOS7";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) "
				+ "AppleWebKit/537.51.1(KHTML, like Gecko) Version/7.0 Mobile/11A4449d Safari/9537.53");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on iOS7");
		driver.quit();
	}
	@Test(priority=6)
	void IE_Nokia_Lumia920() throws InterruptedException 
	{
		String name="IE_Nokia_Lumia920";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0;"
				+ " Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920");
		WebDriver driver= new FirefoxDriver(profile);
		Cross_PlatForm.AllPages(driver,name);	
		Cross_PlatForm.Check404Page(driver);
		Cross_PlatForm.CheckAmenityPages(driver);
		System.out.println("All Pages are accessible on IE_Nokia_Lumia920");
		driver.quit();		
	}
	@AfterClass
	public static void teardown()  
	{
    
	}
}