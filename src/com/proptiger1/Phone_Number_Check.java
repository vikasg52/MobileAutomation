package com.proptiger1;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Phone_Number_Check 
{
	TimeStamp t= new TimeStamp();
	String [] City =
		   {"Mumbai",
			"Noida",
			"Gurgaon",
			"Banglore",
			"Pune",
			"Chennai",
			"Ghaziabad",
			"Ahemdabad",
			"Kolkata",
			"Banglore-resale Project Page",
			 };

	String[] Number = 
		   {"+912261054545",
			"+911166765333",
			"+911166765111",
			"+918033512373",
			"+912067082636",
			"+914439942555",
	        "+919555606060",
	        "+917961343766",
	        "+913330566477",
	        "+918067417767",	        
	        };

	//public WebDriver driver = new FirefoBaseUrlDriver();
	public void GooglePages_SEM_Number(String x) throws InterruptedException
	{ 
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		String BaseUrl=prod;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS BaseUrl) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().window().setSize(new Dimension(280,650));
		//driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("2.Checking SEM Numbers for Google & Project pages after adding UTM parameters in cookie.");
		System.out.println("***************************************************************************************");
		//driver.manage().deleteAllCookies();
		String cookie= "utm_source=google&utm_medium=cpc&utm_campaign=Hot%20Projects%20Bangalore&utm_term={keyword}&utm_content={creative}&Network={ifContent:Content}{ifSearch:Search}&SiteTarget={placement}";
		String[] URLs={BaseUrl+"/google_page_4.php?projectId=501552&"+cookie,
				BaseUrl+"/google_page_13.php?projectId=501403&"+cookie,
		BaseUrl+"/google_page_14.php?projectId=662047&"+cookie,
		BaseUrl+"/bangalore/varthur/artha-crest-660735?"+cookie,
		BaseUrl+"/pune/hinjewadi/mittal-brothers-hillside-urban-666318?"+cookie,
		BaseUrl+"/chennai/navallur/adroit-urban-district-s-510882?"+cookie,
		BaseUrl+"/ghaziabad/pratap-vihar/prateek-group-grand-city-654996?"+cookie,
		BaseUrl+"/ahmedabad/near-vaishno-devi-circle-on-sg-highway/adani-elysium-647819?"+cookie,
		BaseUrl+"/kolkata/patuli/unimark-group-lakewood-estate-668039?"+cookie,
		BaseUrl+"/bangalore/itpl/prestige-shantiniketan-502704?"+cookie,
		};
		String Failed="";
		int i=0; 
		while(i!=URLs.length)
		{
			//driver.manage().deleteAllCookies();
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
		i++;
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
		   driver.quit();
		}
	}


	//**********************************************************************************************
	//**********************************************************************************************
	public String internal_Mailer(String y)
	{
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		String BaseUrl=prod;
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0_2 like Mac OS BaseUrl) AppleWebKit/537.51.1 "
				+ "(KHTML, like Gecko) CriOS/30.0.1599.12 Mobile/11A501 Safari/8536.25");
		WebDriver driver= new FirefoxDriver(profile);
		driver.manage().window().setSize(new Dimension(300,650));
		driver.manage().deleteAllCookies();
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
				"Ahemdabad"
			     };

		String[] Number = 
			   {"01166765300",
				"01130803623",
				"02261054546",
				"08067417772",
				"02030157200",
				"04439942777",
				"07961343767"
			   };
		
		String[] URLs=
			   {BaseUrl+"/google_page_4.php?projectId=661151&"+cookie,
				BaseUrl+"/google_page_13.php?projectId=662047&"+cookie,
				BaseUrl+"/google_page_14.php?projectId=501552&"+cookie,
				BaseUrl+"/google_page_15.php?projectId=664356&"+cookie,
				BaseUrl+"/pune/mohammadwadi/majestique-landmark-euriska-664237?"+cookie,
				BaseUrl+"/chennai/medavakkam/indiabulls-greens-501248?"+cookie,
				BaseUrl+"/ahmedabad/chandkheda/swati-procon-greens-667055?"+cookie,
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
		System.err.println("\n Internal Mailer Phone number test has failed"+Failed);
		}
		driver.quit();
		return y;	
		}



	//*********************************************************************************
	//*********************************************************************************
	// EBaseUrlternal Mailers
	@Test(priority=3)
	public String External_Mailer(String z)
	{	
		String beta="https://beta.proptiger-ws.com";
		String prod="https://www.proptiger.com";
		String BaseUrl=prod;
		FirefoxProfile profile = new FirefoxProfile();
	profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 7_0 like Mac OS X; en-us) "
			+ "AppleWebKit/537.51.1 (KHTML, like Gecko) Version/7.0 Mobile/11A465 Safari/9537.53");
	WebDriver driver2= new FirefoxDriver(profile);
	driver2.manage().window().setSize(new Dimension(300,650));
	driver2.manage().deleteAllCookies();
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
		"Ahemdabad"
	     };

       String[] Number = 
	   {"01166764004",
		"01166764111",
		"02261054547",
		"08067417773",
		"02067082924",
		"04439942666",
		"07961343767"
	   };

       String[] URLs=
	   {BaseUrl+"/google_page_4.php?projectId=513497&"+cookie,
		BaseUrl+"/google_page_13.php?projectId=662047&"+cookie,
		BaseUrl+"/google_page_14.php?projectId=501552&"+cookie,
		BaseUrl+"/google_page_15.php?projectId=664356&"+cookie,
		BaseUrl+"/pune/mohammadwadi/majestique-landmark-euriska-664237?"+cookie,
		BaseUrl+"/chennai/medavakkam/indiabulls-greens-501248?"+cookie,
		BaseUrl+"/ahmedabad/chandkheda/swati-procon-greens-667055?"+cookie,
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
	   Assert.fail("External Mailer Phone number tests Have Failed"+Failed);
		driver2.quit();
	}
		return Failed;
}
}