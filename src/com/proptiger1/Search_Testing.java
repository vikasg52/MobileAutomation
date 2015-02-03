package com.proptiger1;
import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
public class Search_Testing 
{
    TimeStamp t= new TimeStamp();	
	@BeforeTest
	public void start()
	{
		System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.Jdk14Logger");
		System.out.println("============== SEARCH TEST STARTED ===============");
	}	
	@Test(priority=8)
	void SearchChrome_iPhone() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");		
		/*String Xport= System.getProperty("Importal.xvfb.id",":1");
		final File firefoxPath= new File (System.getProperty("Importal.deploy.firefox.path","/usr/bin/firefox"));
		FirefoxBinary fb= new FirefoxBinary(firefoxPath); 
		fb.setEnvironmentProperty("DISPLAY", Xport);
		String name="Chrome_Iphone";
		WebDriver driver = new FirefoxDriver(fb, profile);*/
		WebDriver driver= new FirefoxDriver(profile);
		String name="Chrome_Iphone";
	        Search.search(driver, name);
		System.out.println("9.Search working fine in Chrome-iPhone");
		driver.quit();
	}
	
	@Test(priority=4)
	void SearchChrome_AndroidTablet() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.1.2; Nexus 7 Build/JZ054K) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.166 Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);
		String name="Chrome_AndroidTablet";
		Search.search(driver, name);
		System.out.println("5.Search working fine in Chrome-Android-Tablet");
		driver.quit();
	}
	
	@Test(priority=2)
	void SearchChrome_AndroidMobile() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);
		String name="Chrome_AndroidMobile";
	        Search.search(driver, name);	
		System.out.println("3.Search working fine in Chrome-AndroidMobile");
		driver.quit();
	}
	@Test(priority=0)
	void SearchFireFox_Android() throws InterruptedException 
	{
		TimeStamp t= new TimeStamp();;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Android; Tablet; rv:14.0) Gecko/14.0 Firefox/14.0");
		WebDriver driver= new FirefoxDriver(profile);		
		String name= "FireFox-Android";
		//driver.manage().deleteAllCookies();
	        Search.search(driver, name);	
		System.out.println("1.Search working fine in FireFox-Android");
		driver.quit();
	}
	@Test(priority=1)
	void SearchSafari_iOS8() throws InterruptedException {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 8_0 like Mac OS X) AppleWebKit/600.1.3 "
				+ "(KHTML, like Gecko) Version/8.0 Mobile/12A4345d Safari/600.1.4");
		WebDriver driver= new FirefoxDriver(profile);
		
		String name="iOS8-Safari";
		//driver.manage().deleteAllCookies();
	        Search.search(driver, name);	
		System.out.println("2.Search working fine in iOS8-Safari");
		driver.quit();
	}
	@Test(priority=5)
	void SearchSafari_iOS7() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) "
				+ "AppleWebKit/537.51.1(KHTML, like Gecko) Version/7.0 Mobile/11A4449d Safari/9537.53");
		WebDriver driver= new FirefoxDriver(profile);
				
		String name= "iOS-Safari";
		//driver.manage().deleteAllCookies();
	        Search.search(driver, name);	
		System.out.println("6.Search working fine in iOS7-Safari");
		driver.quit();
	}
	@Test(priority=6)
	void SearchIE_Nokia_Lumia920() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (compatible; MSIE 10.0; Windows Phone 8.0;"
				+ " Trident/6.0; IEMobile/10.0; ARM; Touch; NOKIA; Lumia 920");
		WebDriver driver= new FirefoxDriver(profile);
				
		String name="IE_Nokia_Lumia920";
	        Search.search(driver, name);	
		System.out.println("7.Search working fine in IE_Nokia_Lumia920 ");
		driver.quit();		
	}
	@Test(priority=7)
	void SearchOperaMini_iPhone() throws InterruptedException 
	{
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_2 like Mac OS X) "
				+ "AppleWebKit/600.1.4 (KHTML, like Gecko) OPiOS/9.1.0.86723 Mobile/12B440 Safari/9537.53");
		WebDriver driver= new FirefoxDriver(profile);
		String name="OperaMini_iPhone";
			
		Search.search(driver, name);
		System.out.println("8.Search working fine in OperaMini_iPhone");
		driver.quit();		
	}
	@Test(priority=3)
	void SearchOperaMini_Android() throws InterruptedException 
	{
		String name="OperaMini_Android";
		 FirefoxProfile profile = new FirefoxProfile();
                   profile.setPreference("general.useragent.override","Opera/9.80 (Android; Opera Mini/7.5.33361/31.1448; U; en)"
        		+ " Presto/2.8.119 Version/11.1010");
		WebDriver driver= new FirefoxDriver(profile);		
		Search.search(driver, name);
		System.out.println("4.Search working fine in OperaMini_Android");
		driver.quit();		
	}
	@AfterClass
	public static void teardown()  
	 {
		System.out.println("============== SEARCH TEST FINISHED ===============\n");
     }
}
