package com.proptiger1;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PaymentGatewayTest {
	private static final Exception Exception = null;
	static TimeStamp t1= new TimeStamp();
	static String name="";
	static String betapg="sandbox.citruspay.com";
	static String pg="www.citruspay.com";
	static String http="http://www.proptiger.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String ssl="https://www.proptiger.com";
	static String local= "http://192.168.0.216:5000";
	static String betahttp="http://beta.proptiger-ws.com";
	static String betassl="https://qa.proptiger-ws.com";
	static String BaseUrl=betassl;
	static String pgurl=pg;
	public static void Pg_Test(WebDriver driver) throws InterruptedException
	{   
		driver.manage().window().setSize(new Dimension(500,650));
		driver.manage().deleteAllCookies();	
		try
		{
			driver.get(BaseUrl);
			t1.wait(driver, "//div[@class='city-name-info bangalore-info']");
			Cookie cookie = new Cookie("TESTING_USER", "1");
			driver.manage().addCookie(cookie);
		}catch(NoSuchElementException e1)
		{
			Assert.fail("\n Global home page is not opening-either site is down or net is not working");
		}
		driver.findElement(By.xpath("//div[@class='city-name-info bangalore-info']")).click();
		t1.wait(driver, "//span[@class='see-all-wrap']");
		driver.findElement(By.xpath("//span[@class='see-all-wrap']")).click();
		t1.wait(driver, "//select[@class='citydd offer-city']");
		ValidateOfferLanding(driver);
		Select select2 = new Select(driver.findElement(By.xpath("//select[@class='citydd offer-city']")));
		select2.selectByIndex(2);
		Thread.sleep(4000L);
		driver.navigate().refresh();
		driver.findElement(By.xpath("//li[@data-url='/bangalore/electronics-city/patel-townsville-501369']")).click();
		t1.wait(driver, "//section[@class='project-config']//section[@id='config-banner-propties']");
		Cookie cookie = new Cookie("TESTING_USER", "1");
		driver.manage().addCookie(cookie);
		driver.findElement(By.xpath("//section[@class='project-config']//section[@id='config-banner-propties']")).click();
		t1.wait(driver,"//div[@data-selecttext='40,000 coupon selected for 3.5BHK+3T (3377 sq ft) in Electronics City, Bangalore']");
		driver.findElement(By.xpath("//div[@data-selecttext='40,000 coupon selected for 3.5BHK+3T (3377 sq ft) in Electronics City, Bangalore']")).click();
		t1.wait(driver,"//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow pull-right continue-button']");
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow pull-right continue-button']")).click();
		String s7=driver.getCurrentUrl();
		int ran;
		ran = 100 + (int)(Math.random() * ((10000 - 100) + 1));
		System.out.println("===========================================================");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='full-name']")).sendKeys("PropTiger-QA");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='email']")).sendKeys("Proptigerqa+"+ran+"@gmail.com");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='mobile-no checkout-mobile-no']")).sendKeys("1900000000");
		driver.findElement(By.xpath("//form[@class='dtl-form']//input[@class='id-nmbr']")).sendKeys("b8909k9284f");
		driver.findElement(By.xpath("//div[@class='btn-area']//a[@class='no-ajaxy btn btn-d-yellow payment-button']")).click();
		t1.wait(driver, "//a[@id='btn-guestPaymentCancel-temp9']");
		//driver.navigate().refresh();
		boolean error = t1.isElementPresent(driver,By.xpath("//div[@class='errorMessage']"));
		String PGURL=driver.getCurrentUrl();
		boolean x=PGURL.contains(pgurl);
		String FailedTest="";
		if( error==true)
		{ 
			String error1= driver.findElement(By.xpath("//div[@id='content']//div[@class='errorMessage']")).getText();
			Assert.fail("\n*Payment Gateway page is down:Error Message:-\n"+error1);
		}
		if(x==false)
		{
			Assert.fail("\n*PG URL is wrong: " +PGURL+"\n");	
		}
		try{
			List<WebElement> cancelButton = driver.findElements(By.xpath("//a[@id='btn-guestPaymentCancel-temp9']"));
			if(cancelButton.size()==0 )
			{
				Assert.fail("\n*Payment gateway page is down\n");
				//driver.quit();
			}
			else
			{
				driver.findElement(By.xpath("//a[@id='btn-guestPaymentCancel-temp9']")).click();
				driver.findElement(By.xpath("//button[@id='jqi_state0_buttonYes']")).click();
				//driver.findElement(By.xpath("//div[@class='jqi_state']//button[@id='jqi_state1_buttonCancelTransaction']")).click();
				/*Alert alert = driver.switchTo().alert();
			alert.accept();*/
				t1.wait(driver, "//a[@class='btn btn-d-yellow no-ajaxy']");
				String RedirectUrl=driver.getCurrentUrl();		
				boolean y=RedirectUrl.contains(BaseUrl);
				boolean TransactionFail= t1.isElementPresent(driver,By.xpath("//section[@class='sorry-status']//div[@class='p-msg']"));
				boolean z=t1.isElementPresent(driver,  By.xpath("//a[@class='btn btn-d-yellow no-ajaxy']"));
				if(y==false)
				{
					Assert.fail("\n*RedirectUrl is wrong from payment status page: " +RedirectUrl);

				}
				if(TransactionFail==false)
				{
					Assert.fail("\n* Transaction unsuccessfull message is not displayed or is wrong.");
				}
				if(z==false)
				{
					Assert.fail("\n*TRY AGAIN* button is not coming on the final page if payment is not successfull.");
					//driver.quit();
				}}}catch(Exception e1)
				{ 
			      Assert.fail("*. Payment gateway is not working");
			    }
			System.out.println("Payment gateway is up and running");
			}


	// Validate offer landing
	public static void ValidateOfferLanding(WebDriver driver) throws InterruptedException
	{
		int Pune = 0, Bang = 0,India;
		driver.navigate().refresh();
		t1.wait(driver, "//select[@class='citydd offer-city']");
		boolean OfferCity= t1.isElementPresent(driver,By.xpath("//select[@class='citydd offer-city']"));
		boolean projectCount=t1.isElementPresent(driver, By.xpath("//span[@class='pro-count']"));
		String selectedCity= driver.findElement(By.xpath("//select[@class='citydd offer-city']//option[@selected='selected']")).getText();
		String s= driver.findElement(By.xpath("//span[@class='pro-count']")).getText();	
		String OfferUrl= driver.getCurrentUrl();
		if(!OfferUrl.equalsIgnoreCase(BaseUrl+"/mega-property-sale"))
		{
			Assert.fail("Offer landing page is not opening");
		}
		if(OfferCity==false)
		{
			Assert.fail("Offer city drop down is not available on offer landing page");	
		}
		if(!selectedCity.equalsIgnoreCase("Bangalore"))
		{
			Assert.fail("Selecetd city on offer landing page is incorrect");
		}
		if(projectCount==false)
		{
			Assert.fail("Project count is missing on offer landing page");
		}
		boolean FooterTextBang= t1.isElementPresent(driver,By.xpath("//a[@class='v-all all-project-link']"));
		String FooterText1=	driver.findElement(By.xpath("//a[@class='v-all all-project-link']")).getText();
		if(FooterTextBang==false && !FooterText1.equalsIgnoreCase("VIEW ALL PROJECTS IN BANGALORE"))
		{
			Assert.fail("Text in the footer on offer landing page is incorrect or missing");	
		}
		// Pune selection
		Select select = new Select(driver.findElement(By.xpath("//select[@class='citydd offer-city']")));
		select.selectByIndex(1);
		//Thread.sleep(3000L);
		driver.navigate().refresh();		
		t1.wait(driver, "//span[@class='pro-count']");
		String PuneUrl=driver.getCurrentUrl();
		String s2= driver.findElement(By.xpath("//span[@class='pro-count']")).getText();
		String s3=s2.replace(" Projects in India","");
		String CountProjectPune=s3.replaceAll("\\+s","");
		Select select11= new Select(driver.findElement(By.xpath("//select[@class='citydd offer-city']")));
		String selectedCity1= select11.getFirstSelectedOption().getText();
		if(!PuneUrl.equalsIgnoreCase(BaseUrl+"/mega-property-sale/filters?cityLabel=pune") && !selectedCity1.equalsIgnoreCase("pune"))
		{
			Assert.fail("Changing Offer city from dropdown is not changing the URL correctly");
		}
		// All India selection
		Select select1 = new Select(driver.findElement(By.xpath("//select[@class='citydd offer-city']")));
		select1.selectByIndex(0);
		Thread.sleep(3000L);
		driver.navigate().refresh();
		t1.wait(driver, "//select[@class='citydd offer-city']");
		String ChangeUrlIndia=driver.getCurrentUrl();
		Select select2 = new Select(driver.findElement(By.xpath("//select[@class='citydd offer-city']")));
		String selectedCity2= select2.getFirstSelectedOption().getText();
		if(!ChangeUrlIndia.equalsIgnoreCase(BaseUrl+"/mega-property-sale/filters?cityLabel=india") && !selectedCity2.equalsIgnoreCase("All India"))
		{
			Assert.fail("Changing Offer city from dropdown is not changing the URL correctly");
		}
		String s4= driver.findElement(By.xpath("//span[@class='pro-count']")).getText();
		String s5=s4.replace(" Projects in India","");
		String CountProjectIndia=s5.replaceAll("\\+s","");
		if (s.contains("Projects"))
		{
			String s1=s.replace(" Projects in Bangalore","");
			String CountProjectBang= s1.replaceAll("\\+s","");
			Bang= Integer.parseInt(CountProjectBang);
		}
		else
		{
			String s1=s.replace(" Project in Bangalore","");
			String CountProjectBang= s1.replaceAll("\\+s","");
			Bang= Integer.parseInt(CountProjectBang);
		}
		if (s2.contains("Projects"))
		{
			s3=s2.replace(" Projects in Pune","");
			CountProjectPune= s3.replaceAll("\\+s","");
			Pune= Integer.parseInt(CountProjectPune);
		}
		else
		{
			String s1=s.replace(" Project in Pune","");
			CountProjectPune= s1.replaceAll("\\+s","");
			Pune= Integer.parseInt(CountProjectPune);
		}

		India= Integer.parseInt(CountProjectIndia);

		if(India!=Bang+Pune)
		{
			Assert.fail("Count of offer project in India is not equal to sum of banglore and pune");
		}
	}
}


