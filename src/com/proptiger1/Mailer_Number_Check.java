package com.proptiger1;
import java.io.IOException;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Mailer_Number_Check {
	static String name="";
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String betahttp="https://beta.proptiger-ws.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String qa= "http://qa.proptger-ws.com";
	static String betassl="https://www.proptiger-ws.com";
	static String BaseUrl=betahttp;
	@Test()
	public void numbertest() throws InterruptedException																																															
	{
		Phone_Number_Check Check_Number= new Phone_Number_Check();
		Sem_ListPage<?> checkNumber= new Sem_ListPage<Object>();
		//WebDriver driver = new FirefoxDriver();
	    System.out.println("You have entered : " + BaseUrl);
        checkNumber.Sem_ListingPage(BaseUrl);
        Check_Number.GooglePages_SEM_Number(BaseUrl);
		System.out.println("\n");
		Check_Number.internal_Mailer(BaseUrl);
		System.out.println("\n");
		Check_Number.External_Mailer(BaseUrl);
		System.out.println("\n");
		}
	public void teardown()
	{
	
	}
}
