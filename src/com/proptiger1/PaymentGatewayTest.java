package com.proptiger1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class PaymentGatewayTest {
	static TimeStamp t1= new TimeStamp();
	@Test
	public static void Pg_Test(WebDriver driver) throws InterruptedException
	{
		driver.manage().window().setSize(new Dimension(300,650));
		driver.manage().deleteAllCookies();	
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("************* PG Test started *****************************************************");
		driver.get("http://www.proptiger.com");
		Thread.sleep(5000L);
		String s2= driver.getCurrentUrl();
		System.out.println("1.Global Home page is opening :" +s2);
		driver.findElement(By.xpath("//div[@class='city-name-info bangalore-info']")).click();
		Thread.sleep(9000L);
		String s1=driver.getCurrentUrl();
		System.out.println("2.City home page is opening: " +s1);
		driver.findElement(By.xpath("//span[@class='see-all-wrap']")).click();
		Thread.sleep(7000L);
		driver.findElement(By.xpath("//li[@data-url='/bangalore/bellandur/samruddhi-group-winter-green-643769']")).click();
		String s4=driver.getCurrentUrl();
		System.out.println("3.Offer Landing Page is opening: " +s4);
		Thread.sleep(9000L);
		driver.findElement(By.xpath("//section[@class='project-config']//section[@id='config-banner-propties']")).click();
		Thread.sleep(5000L);
		driver.findElement(By.xpath("//div[@data-selecttext='20,000 coupon selected for 2BHK+2T (1200 sq ft) in Bellandur, Bangalore']")).click();
		Thread.sleep(5000L);
		String s6= driver.getCurrentUrl();
		System.out.println("4.Property selection checkout page is opening: " +s6);
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow pull-right continue-button']")).click();
		String s7=driver.getCurrentUrl();
		System.out.println("5.Payment details checout page is opening: " +s7);
		System.out.println("**************************************************************************************************\n");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='full-name']")).sendKeys("Testing");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='email']")).sendKeys("propmail46@gmail.com");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='mobile-no checkout-mobile-no']")).sendKeys("1100000000");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='id-nmbr']")).sendKeys("bnppk9284f");
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow payment-button']")).click();
		Thread.sleep(9000L);
		driver.navigate().refresh();
		boolean error = t1.isElementPresent(driver,By.xpath("//div[@class='errorMessage']"));
		String PGURL=driver.getCurrentUrl();
		boolean x=PGURL.contains("https://www.citruspay.com");
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
		}
		else
		{
			driver.findElement(By.xpath("//a[@id='btn-guestPaymentCancel-temp9']")).click();
			driver.findElement(By.xpath("//button[@id='jqi_state0_buttonYes']")).click();
			driver.findElement(By.xpath("//div[@class='jqi_state']//button[@id='jqi_state1_buttonCancelTransaction']")).click();
			Alert alert = driver.switchTo().alert();
			alert.accept();
			String RedirectUrl=driver.getCurrentUrl();		
			boolean y=RedirectUrl.contains("www.proptiger.");
			if(y==false)
			{
				FailedTest=FailedTest+"\n*RedirectUrl is wrong: " +RedirectUrl;
			}
			String Status="";
			if(FailedTest=="")
			{
				Status="PASS";
				System.out.println("Payment gateway is up and running-"+Status);

			}
			else
			{
				Status="FAILED";
				System.out.println("Payment gateway is down-"+Status);
				System.out.println("Reason:" +FailedTest);
			}
			System.out.println("\n**************************************************************************************************");
			driver.quit();
		}
	}
}

