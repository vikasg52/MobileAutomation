package com.proptiger1;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
public class Search {
	static String ssl="https://www.proptiger.com";
	static String betassl="https:/beta.proptiger-ws.com";
	static String BaseUrl=ssl;
	static TimeStamp t= new TimeStamp();
	 @SuppressWarnings("deprecation")
	public static void search(WebDriver driver, String name) throws InterruptedException
	 {
		 driver.manage().window().setSize(new Dimension(520,730));
		 driver.manage().deleteAllCookies();		
		 driver.get(BaseUrl);
		 if(name!="IE_Nokia_Lumia920")
		 {
		 t.wait(driver,"//div[@data-lazyclass='interstial-container']//div[@class='closeoption']");
		 driver.findElement(By.xpath("//div[@data-lazyclass='interstial-container']//div[@class='closeoption']")).click();
		 }
		 t.wait(driver,"//div[@class='bangalore-dec-info city-image']");
		 //driver.findElement(By.linkText("Bangalore")).click();
		driver.findElement(By.xpath("//div[contains(@class,'bangalore-dec')]")).click();
		t.wait(driver,"//input[contains(@class,'search-input wd85percent')]");
		boolean search_box= t.isElementPresent(driver , By.xpath("//input[contains(@class,'search-input wd85percent')]"));
		boolean search_button= t.isElementPresent(driver , By.xpath("//button[@class='srch-btn wd14percent']"));
		String Default_Text= driver.findElement(By.xpath("//input[contains(@class,'search-input wd85percent')]")).getAttribute("placeholder");
        boolean Search_icon = t.isElementPresent(driver, By.xpath("//i[@class='icon-search']"));
		if(search_box==false)
        {
        	Assert.fail("*.Search text box is missing on the city home page when accessed via "+name);
        }
        if(search_button==false)
        {
        	Assert.fail("*.Search button is missing on the city home page when accessed via "+name);	
        }
        if(Search_icon==false)
        {
        	Assert.fail("*.Search icon is missing on the city home page when accessed via "+name);	
        }
        if(!Default_Text.equalsIgnoreCase("Search for a project, builder or locality"))
        {
        	Assert.fail("*. Default text in the serach text box is not present or incorrect when accessed via "+name);	
        }
        t.wait(driver,"//input[@class='fake-search-box search-input wd85percent']");
        boolean x= driver.findElement(By.xpath("//input[@class='fake-search-box search-input wd85percent']")).isDisplayed();
        if (x==true)
        {
        WebElement s=driver.findElement(By.xpath("//input[@class='fake-search-box search-input wd85percent']"));
        s.submit();
        }
        driver.getCurrentUrl();
        boolean search_pagebox= t.isElementPresent(driver, By.xpath("//input[@class='search-input wd65percent']"));
        if(!driver.getCurrentUrl().contains(BaseUrl+"/bangalore-real-estate-overview") && search_pagebox == false)
        {
        	Assert.fail("*. After tapping on search text box search page is not opening when accessed via "+name);
        }
        //=============================
        // search page object verification
        //=============================
        search_pagebox= t.isElementPresent(driver, By.xpath("//input[@class='search-input wd65percent']"));
        boolean Search_pageicon = t.isElementPresent(driver, By.xpath("//i[@class='icon-search']"));
        boolean blue_text = t.isElementPresent(driver,By.xpath("//div[@class='ta-center blue']"));
        boolean grey_text =t.isElementPresent(driver,By.xpath("//div[@class='ta-center grey]"));
        if(search_pagebox==false && Search_pageicon==false)
        {
        	Assert.fail("*.Search box and search icon is missing on search page when accessed in "+name);
        }
        if(blue_text==false && grey_text==false)
        {
        	Assert.fail("*.Blue text and grey color text is missing from the search page");
        }
        t.wait(driver, "//a[@class='no-ajaxy srch-cancel wd20percent']");
        WebElement e= driver.findElement(By.xpath("//a[@class='no-ajaxy srch-cancel wd20percent']"));
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();",e);
        //driver.findElement(By.xpath("//a[@class='no-ajaxy srch-cancel wd20percent']")).click();
        WebDriverWait wait3 = new WebDriverWait(driver,120);
		wait3.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class='fake-search-box search-input wd85percent']")));
		if(!driver.getCurrentUrl().equalsIgnoreCase("https://www.proptiger.com/bangalore-real-estate-overview"))
        {
        	Assert.fail("*.After clicking cancel link on search page home page is not opening in "+name);
        }
        //=============================================
        //Search result verification
        //=============================================
        driver.findElement(By.xpath("//input[@class='fake-search-box search-input wd85percent']")).click();
        WebDriverWait wait4 = new WebDriverWait(driver,120);
		wait4.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='srch-xplore']//input[@placeholder='Search in bangalore']")));
	    driver.findElement(By.xpath("//div[@class='srch-xplore']//input[@placeholder='Search in bangalore']")).sendKeys("dl");
        boolean searchResult= t.isElementPresent(driver, By.xpath("//div[@class='search-results']"));
        boolean searchCancel=t.isElementPresent(driver,By.xpath("//span[@class='search-cancel']"));
        boolean FirstResulticon= t.isElementPresent(driver, By.xpath("//div[@data-opt-idx='0']//i[@class='icon-apartment pull-left paddingR5']"));
        String FirstResult=driver.findElement(By.xpath("//div[@class='put-ellipsis' and text()='DLF - Bella Greens - Bangalore']")).getText();
        int Resultcount = driver.findElements(By.xpath("//div[@class='ac-opt']")).size();
        if(searchResult==false && searchCancel==false)
        {
        	Assert.fail("search Results are not appearing/cancel button is missing after entering text 'dl' in text box on "+name);
        }
        if(Resultcount!=4)
        {
        	Assert.fail("Result Count is incorrect tested on -"+name);
        }
        if(FirstResulticon==false)
        {
        	Assert.fail("Wrong search result is displayed, After entering 'dl', First result icon not coming as 'Apartment' on"+name);
        }
        if(!FirstResult.equalsIgnoreCase("DLF - Bella Greens - Bangalore"))
        {
        	Assert.fail("First Result is displayed incorrectly: on"+name);
        }
        
        // Click on search result verification
        driver.findElement(By.xpath("//div[@class='put-ellipsis' and text()='DLF - Bella Greens - Bangalore']")).click();
        Thread.sleep(3000L);
        if(!driver.getCurrentUrl().equalsIgnoreCase(BaseUrl+"/bangalore/begur/dlf-bella-greens-513482"))
        {
        	Assert.fail("Clicking on first search result the next page is not opening/ url of next page is wrong-tested on"+name);
        }
	 }

}
