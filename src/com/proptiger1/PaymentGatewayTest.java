package com.proptiger1;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaymentGatewayTest {
	static TimeStamp t1= new TimeStamp();
	static String pgurl="www.citruspay.com";
	static String BaseUrl="http://www.proptiger.com";
	public static void Pg_Test(WebDriver driver) throws InterruptedException
	{
		/*FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override","Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 "
				+ "(KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19");
		WebDriver driver= new FirefoxDriver(profile);	*/
		driver.manage().window().setSize(new Dimension(300,650));
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		try
		{
		driver.get(BaseUrl);
		Thread.sleep(5000L);
	    }catch(NoSuchElementException e)
	    {System.out.println("\n Global home page is not opening-either site is down or net is not working");}
		driver.findElement(By.xpath("//div[@class='city-name-info bangalore-info']")).click();
		Thread.sleep(13000L);
		driver.findElement(By.xpath("//span[@class='see-all-wrap']")).click();
		Thread.sleep(11000L);
		driver.findElement(By.xpath("//li[@data-url='/bangalore/bellandur/samruddhi-group-winter-green-643769']")).click();
		Thread.sleep(12000L);
		driver.findElement(By.xpath("//section[@class='project-config']//section[@id='config-banner-propties']")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//div[@data-selecttext='20,000 coupon selected for 2BHK+2T (1200 sq ft) in Bellandur, Bangalore']")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow pull-right continue-button']")).click();
		String s7=driver.getCurrentUrl();
		int ran;
	    ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		System.out.println("=============================================\n");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='full-name']")).sendKeys("PropTiger-QA");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='email']")).sendKeys("Proptigerqa+"+ran+"@gmail.com");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='mobile-no checkout-mobile-no']")).sendKeys("1900000000");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='id-nmbr']")).sendKeys("b8909k9284f");
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow payment-button']")).click();
		Thread.sleep(9000L);
		//driver.navigate().refresh();
		boolean error = t1.isElementPresent(driver,By.xpath("//div[@class='errorMessage']"));
		String PGURL=driver.getCurrentUrl();
		boolean x=PGURL.contains(pgurl);
		String FailedTest="";
		if( error==true)
		{ 
			String error1= driver.findElement(By.xpath("//div[@id='content']//div[@class='errorMessage']")).getText();
			FailedTest=FailedTest+"\n*Payment Gateway page is down:Error Message:-\n"+error1;
		}
		if(x==false)
		{
			FailedTest=FailedTest+"\n*PG URL is wrong: " +PGURL+"\n";	
		}
		List<WebElement> cancelButton = driver.findElements(By.xpath("//a[@id='btn-guestPaymentCancel-temp9']"));
		if(cancelButton.size()==0 )
		{
			FailedTest=FailedTest+"\n*Payment gateway page is down\n";
			driver.quit();
		}
		else
		{
			driver.findElement(By.xpath("//a[@id='btn-guestPaymentCancel-temp9']")).click();
			driver.findElement(By.xpath("//button[@id='jqi_state0_buttonYes']")).click();
			//driver.findElement(By.xpath("//div[@class='jqi_state']//button[@id='jqi_state1_buttonCancelTransaction']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			Thread.sleep(3000L);
			String RedirectUrl=driver.getCurrentUrl();		
			boolean y=RedirectUrl.contains(BaseUrl);
			boolean z=t1.isElementPresent(driver,  By.xpath("//a[@class='btn btn-d-yellow no-ajaxy']"));
			if(y==false)
			{
				FailedTest=FailedTest+"\n*RedirectUrl is wrong frompayment status page: " +RedirectUrl;
				driver.quit();
			}
			if(z==false)
			{
				FailedTest=FailedTest+"\n*Final Payment status page has not rendered";
				driver.quit();
			}
			if(FailedTest=="")
			{
				System.out.println("Payment gateway is up and running");
			}
			else
			{
				Assert.fail("Payment gateway is down-Reason"+FailedTest);
			}
		 driver.quit();
		}
	}
}

