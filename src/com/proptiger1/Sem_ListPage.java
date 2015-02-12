package com.proptiger1;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.proptiger1.TimeStamp;

public class Sem_ListPage {
	 TimeStamp t= new TimeStamp();
	 @Test(priority=0)
	public void Sem_ListingPage(String BaseUrl) throws InterruptedException
	{
		BaseUrl="https://www.proptiger.com";
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		//driver.manage().deleteAllCookies();
		driver.manage().window().setSize(new Dimension(280,650));		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("=======================================================================================");
		System.out.println("1.Checking SEM Numbers on listing page of different cities with UTM parameters        ");
		System.out.println("=======================================================================================");
		String [] City =
			{"Mumbai",
				"Noida",
				"Gurgaon",
				"Banglore",
				"Pune",
				"Chennai",
				"Ghaziabad",
			};
		String[] Number = 
			{"+918080921094",
				"+919278721212",
				"+919278719191",
				"+919590522774",
				"+917304245566",
				"+918144109869",
			    "+919555606060"};
		String Cookie= "?utm_source=google&utm_adgroup=PropTiger%20Branding&utm_medium=cpc&utm_term=proptiger&utm_content=52210766295&utm_campaign=PropTiger%20Branding&Network=Search";
		String [] URLs={
				BaseUrl+"/mumbai-real-estate"+Cookie,
				BaseUrl+"/noida-real-estate"+Cookie,
				BaseUrl+"/gurgaon-real-estate"+Cookie,
				BaseUrl+"/bangalore-real-estate"+Cookie,
				BaseUrl+"/pune-real-estate"+Cookie,
				BaseUrl+"/chennai-real-estate"+Cookie,
				//BaseUrl+"/bangalore/itpl/prestige-shantiniketan-502704"+Cookie,
				BaseUrl+"/ghaziabad-real-estate"+Cookie};
		String Failed=""; 
		for(int i = 0;i<URLs.length;i++)
		{
			driver.get(URLs[i]);
			t.wait(driver, "//a[@class='no-ajaxy project-call']");
			String ss=driver.findElement(By.xpath("//a[@class='no-ajaxy project-call']")).getAttribute("href");
			String Sem=ss.replace("tel:", "");
			if(!Sem.equalsIgnoreCase(Number[i]))
			{
				Failed=Failed+"== Expected Number for " +City[i] + " is:"+Number[i]+":: Actual Number:"+Sem+"\n";
			}
			else
			{ 
				System.out.println("SEM number test has passed on listing page for: "+City[i]+": "+Sem);
				
			}
		}
		driver.quit();
		if(Failed!="")
		{
		System.err.println("\n=======================================================================================");
		Assert.fail("\nSEM Phone number test has failed on listing page for:-\n");
		System.err.println("======================================================================================\n"+Failed);
		driver.quit();
		}
	}
}

