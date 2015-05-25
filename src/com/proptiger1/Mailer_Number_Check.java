package com.proptiger1;
import java.io.IOException;
import java.util.Scanner;

import org.testng.annotations.Test;

public class Mailer_Number_Check {
	static String name="";
	static String http="http://www.proptiger.com";
	static String ssl="https://www.proptiger.com";
	static String betahttp="http://beta.proptiger-ws.com";
	static String mobbeta="http://mob-beta.proptiger-ws.com";
	static String local= "http://192.168.0.216:5000";
	static String betassl="https://www.proptiger-ws.com";
	static String BaseUrl=betassl;
	@Test()
	public void numbertest() throws InterruptedException																																															
	{
		Phone_Number_Check Check_Number= new Phone_Number_Check();
		Sem_ListPage checkNumber= new Sem_ListPage();
	        //System.out.println("You have entered : " + BaseUrl);
        checkNumber.Sem_ListingPage(BaseUrl);
        Check_Number.GooglePages_SEM_Number(BaseUrl);
		System.out.println("\n");
		//driver.manage().deleteAllCookies();																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																																									
		Check_Number.internal_Mailer(BaseUrl);
		//driver.manage().deleteAllCookies();
		System.out.println("\n");
		Check_Number.External_Mailer(BaseUrl);
		}
	public void teardown()
	{
	
	}
}
