package Caching;

import java.io.IOException;

import org.testng.annotations.Test;

public class Caching {
	CachingTest test = new CachingTest();
	MobileFriendlyTest test1= new MobileFriendlyTest();
	
  @Test(priority=0)
  public void Caching() throws IOException, InterruptedException
  {
	test.PageCaching();  
   }
  @Test(priority=1)
  public void MobileFriend() throws IOException, InterruptedException 
  {
	test1.MobileFriendly();  
   }
}
