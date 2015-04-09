package com.proptiger1;

import java.util.concurrent.TimeUnit;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

import com.proptiger1.TimeStamp;
public class Phone_Number_Check 
{
	TimeStamp t= new TimeStamp();
	public String x="";
	String [] City =
		   {"Mumbai",
			"Noida",
			"Gurgaon",
			"Mumbai",
			"Banglore",
			"Pune",
			"Chennai",
			"Ghaziabad",
			"Banglore-resale Google page 4",
			"Banglore-resale Project Page",
			 };

	String[] Number = 
		   {"+918080921094",
			"+919278721212",
			"+919278719191",
			"+918080921094",
			"+919590522774",
			"+917304245566",
			"+918144109869",
	        "+919555606060",
	        "+918067417767",	        
	        "+918067417767",
	        };

	//public WebDriver driver = new FirefoxDriver();
	@Test(priority=1)
	public void GooglePages_SEM_Number(String x) throws InterruptedException
	{ 
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		x=beta;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().window().setSize(new Dimension(280,650));
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("2.Checking SEM Numbers for Google & Project pages after adding UTM parameters in cookie.");
		System.out.println("***************************************************************************************");
		//driver.manage().deleteAllCookies();
		String cookie= "utm_source=google&utm_medium=cpc&utm_campaign=Hot%20Projects%20Bangalore&utm_term={keyword}&utm_content={creative}&Network={ifContent:Content}{ifSearch:Search}&SiteTarget={placement}";
		String[] URLs={x+"/google_page_13.php?projectId=501552&"+cookie,
				x+"/google_page_13.php?projectId=501403&"+cookie,
		x+"/google_page_13.php?projectId=662047&"+cookie,
		x+"/google_page_14.php?projectId=501552&"+cookie,
		x+"/google_page_15.php?projectId=664356&"+cookie,
		x+"/pune/mohammadwadi/majestique-landmark-euriska-664237?"+cookie,
		x+"/chennai/medavakkam/indiabulls-greens-501248?"+cookie,
		x+"/ghaziabad/crossing-republik/akvs-india-infra-surya-heights-647495?"+cookie,
		x+"/google_page_4.php?projectId=502704&"+cookie,
		x+"/bangalore/itpl/prestige-shantiniketan-502704?"+cookie,
		};
		String Failed=""; 
		for(int i = 0;i<URLs.length;i++)
		{
			driver.manage().deleteAllCookies();
			driver.get(URLs[i]);
			t.wait(driver,"//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']");
			String s=driver.findElement(By.xpath("//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']")).getAttribute("href");
			String Sem=s.replace("tel:", "");
			// String City=sheet.getRow(i).getCell((short)1).getStringCellValue();
			if(!Sem.equalsIgnoreCase(Number[i]))
			{
				Failed=Failed+"*for :-> "+City[i]+"== Expected Number:"+Number[i]+"|| Actual Number:"+Sem+"\n";
				//System.out.println(Failed);
			}
			else
			{ 
				System.out.println("SEM Number test has passed for:->"+City[i]+":    "+Sem);
			}
		}
		if(Failed=="")
		{
			System.out.println("***********************************************************************************");
			System.out.println("ALL SEM number tests has passed after saving CPC Cookie on GP pages and project pages.. ");
			System.out.println("***********************************************************************************");
			driver.quit();
		}
		if(Failed!="")
		{
		   System.err.println("SEM number test has failed"+Failed);
		   Assert.fail("Test Failed for SEM number on google pages");
		   driver.quit();
		}
	}


	//**********************************************************************************************
	//**********************************************************************************************
	@Test(priority=2)
	public String internal_Mailer(String y)
	{
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		y=beta;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS X) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().window().setSize(new Dimension(300,650));
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//driver.manage().deleteAllCookies();
		System.out.println("3.Checking Mailer Internal Numbers for GP & Project pages wit UTM parameters in cookie.");
		System.out.println("***************************************************************************************");
		String cookie= "utm_source=internal&utm_medium=mailerInternal&utm_campaign=Hot%20Projects%20Bangalore&utm_term={keyword}&utm_content={creative}&Network="
				+ "{ifContent:Content}{ifSearch:Search}&SiteTarget={placement}";
		String [] City =
				{"Noida",
				"Gurgaon",
				"Mumbai",
				"Banglore",
				"Pune",
				"Chennai",
			     };

		String[] Number = 
			   {"+919250404698",
				"+919278722226",
				"+918080930810",
				"+919019295625",
				"+917304408611",
				"+917667075488",
			   };
		
		String[] URLs=
			   {y+"/google_page_4.php?projectId=661151&"+cookie,
				y+"/google_page_13.php?projectId=662047&"+cookie,
				y+"/google_page_14.php?projectId=501552&"+cookie,
				y+"/google_page_15.php?projectId=664356&"+cookie,
				y+"/pune/mohammadwadi/majestique-landmark-euriska-664237?"+cookie,
				y+"/chennai/medavakkam/indiabulls-greens-501248?"+cookie,
				};
		String Failed=""; 
		for(int i = 0;i<URLs.length;i++)
		{
			driver.get(URLs[i]);	
			t.wait(driver,"//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']");
			String s=driver.findElement(By.xpath("//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']")).getAttribute("href");
			String Sem=s.replace("tel:", "");
			// String City=sheet.getRow(i).getCell((short)1).getStringCellValue();
			if(!Sem.equalsIgnoreCase(Number[i]))
			{
				Failed=Failed+"for:-> "+City[i]+"== Expected Number:"+Number[i]+"|| Actual Number:"+Sem+"\n";
				//System.out.println(Failed);
			}
			else
			{ 
				System.out.println("Internal Mailer Number test has PASSED for : "+City[i]+": "+Sem);
			}
		}
		if(Failed=="")
		{
			System.out.println("**********************************************************************************");
			System.out.println("Internal Mailer Phone number test has passed");
			System.out.println("**********************************************************************************");
			driver.quit();
		}
		else
		{
		System.err.println("Internal Mailer Phone number test has failed"+Failed);
		Assert.fail("Test Failed for Internal Mailer Phone number on google pages");
		}
		driver.quit();
		return y;	
		}



	//*********************************************************************************
	//*********************************************************************************
	// External Mailers
	@Test(priority=3)
	public String External_Mailer(String z)
	{	
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		z= beta;
		FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) "
			+ "AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");
	WebDriver driver2= new FirefoxDriver(profile);
	driver2.manage().window().setSize(new Dimension(300,650));
	//driver.manage().deleteAllCookies();
	driver2.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	System.out.println("4.Checking Mailer External Numbers for Google & Project pages with UTM parameters in cookie.");
	System.out.println("******************************************************************************************");
	String cookie= "utm_source=mailerExternal&utm_medium=mailerExternal&utm_campaign=Hot%20"
				+ "Projects%20Bangalore&utm_term={keyword}&utm_content={creative}&Network=%22{ifContent:Content}{ifSearch:Search}"
				+ "&SiteTarget={placement}";

		String [] City =
			   {"Noida",
				"Gurgaon",	
				"Mumbai",
				"Banglore",
				"Pune",
				"Chennai",
		        };

		String[] Number =
			   {"+919278722211",
				"+919278722223",
				"+918080930820",
				"+919019407477",                          
				"+917304408622",
				"+917667703680",
				"+918067417767",	        
			    "+918067417767",
			   };

		String[] URLs={z+"/google_page_4.php?projectId=661151&"+cookie,
				z+"/google_page_13.php?projectId=662047&"+cookie,
				z+"/google_page_14.php?projectId=501552&"+cookie,
				z+"/google_page_15.php?projectId=664356&"+cookie,
				z+"/pune/mohammadwadi/majestique-landmark-euriska-664237?"+cookie,
				z+"/chennai/medavakkam/indiabulls-greens-501248?"+cookie,
				};
		String Failed=""; 
		for(int i = 0;i<URLs.length;i++)
		{
			driver2.get(URLs[i]);
			t.wait(driver2,"//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']");
			String s=driver2.findElement(By.xpath("//a[@class='no-ajaxy pull-left btn btn-success wd48percent main-page-call-btn']")).getAttribute("href");
			String Sem=s.replace("tel:", "");
			// String City=sheet.getRow(i).getCell((short)1).getStringCellValue();
			if(!Sem.equalsIgnoreCase(Number[i]))
			{
				Failed=Failed+" *For :-> "+City[i]+"== Expected Number:"+Number[i]+"|| Actual Number:"+Sem+"\n";
				//System.out.println(Failed);
			}
			else
			{ 
				System.out.println("External mailer number test has passed for:->"+City[i]+":   "+Sem);
			}
		}		
		if(Failed=="")
		{
			System.out.println("*************************************************************************************");
			System.out.println("All External Mailer Phone number tests have passed with UTM Cookie");
			System.out.println("*************************************************************************************");
			driver2.quit();
          }
		else
		{
			System.err.println("External Mailer Phone number tests Have Failed"+Failed);
		driver2.quit();
		Assert.fail("\n External phone check failed..");
	}
		return Failed;
}
	public void teardown()
	{
		
	}
}

