package Caching;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Test;

public class CachingTest {
	String beta="https://beta.proptiger-ws.com";
	String prod="https://www.proptiger.com";
	String BaseUrl=beta;
	@Test(priority=0)
	public void PageCaching() throws IOException, InterruptedException {
		FileInputStream newFile1 = new FileInputStream("./Input/MainTest.xls"); 
		HSSFWorkbook workbook = new HSSFWorkbook(newFile1);
		HSSFSheet sheet = workbook.getSheetAt(0);
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("general.useragent.override", "Mozilla/5.0 (iPhone; CPU iPhone OS 8_1_3 like Mac OS X) AppleWebKit/600.1.4"
				+ "(KHTML, like Gecko) CriOS/40.0.2214.73 Mobile/12B466 Safari/600.14");
		WebDriver driver= new FirefoxDriver(profile);
        driver.manage().window().setSize(new Dimension(280,650));
		driver.manage().deleteAllCookies();
		try{
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			String mainurl=sheet.getRow(i).getCell((short) 1).getStringCellValue();
			if(mainurl.contains("?"))
			{
			 String URLs= BaseUrl+"?"+mainurl;
			 driver.get(URLs);
			 Thread.sleep(4000L);
			 System.out.println(i+URLs+"      : Cached");
			}
			else
			{
			 String URLs= BaseUrl+"/"+mainurl;
			 driver.get(URLs);
			 Thread.sleep(4000L);
			 System.out.println(i+ "."+URLs+"      : Cached");
			}
		}
		}catch(Exception e){System.out.println(e.getMessage());}
	}
}
	

