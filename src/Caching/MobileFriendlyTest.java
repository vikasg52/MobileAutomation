package Caching;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MobileFriendlyTest {

    public void MobileFriendly() throws IOException
    {

        String beta="https://beta.proptiger-ws.com/";
        String production = "https://www.proptiger.com/";
        String BaseUrl=production;
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();

        FileInputStream file = new FileInputStream(new File("./Input/ALLURL.xls"));
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet Sheet = workbook.getSheet("Sheet1");
        for (int i=15;i<=Sheet.getLastRowNum();i++)
        {

            Row CurrentRow=Sheet.getRow(i);
            Cell URLcell =CurrentRow.getCell(0);

            String UrlString="";
            String FriendlyYes="";
            String FriendlyNo="";

            UrlString=URLcell.getStringCellValue();

            if ( (URLcell==null) || (URLcell.getCellType()==Cell.CELL_TYPE_BLANK))
            {

                UrlString="";
                FriendlyYes="Nothing because links is blank";

            }

            else 
            {
                driver.get("https://www.google.com/webmasters/tools/mobile-friendly");

                driver.findElement(By.name("url")).clear();
                driver.findElement(By.name("url")).sendKeys(BaseUrl+UrlString);

                driver.findElement(By.xpath("//div[@id='page-speed-insights']/div/form/div/div/div[@role='button']")).click();

                new WebDriverWait(driver, 500).until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='pagespeed-results']"))));

                try
                {
                    FriendlyYes =(driver.findElement(By.xpath("//div/div/div/span[2][text()[contains(.,'This page is mobile-friendly')]]")).getText());

                    System.out.println(i+". "+BaseUrl+UrlString + "  ==>  "  + FriendlyYes);


                    CurrentRow.createCell(1).setCellValue(FriendlyYes);    
                }

                catch (NoSuchElementException e){
                    try
                    {
                        FriendlyNo =(driver.findElement(By.xpath("//div/div/div[text()[contains(.,'Not mobile-friendly')]]")).getText());

                        System.err.println(i+". "+BaseUrl+UrlString + "  ==>  "  + FriendlyNo);
                        CurrentRow.createCell(1).setCellValue(FriendlyNo);

                        List<WebElement> allLinks = driver.findElements(By.xpath("//div[@class='goog-control rule-result failed'][*]"));

                        Iterator<WebElement> itr = allLinks.iterator();
                        while(itr.hasNext()) {
                            String reason= (itr.next().getText());
                            System.out.println("* "+reason);

                            CurrentRow.createCell(2).setCellValue(reason);
                        }

                    }
                    catch(NoSuchElementException err) 

                    {
                        try{
                            String errorMessage =(driver.findElement(By.xpath("//div/span[text()[contains(.,'Failed to fetch the requested URL')]]")).getText());

                            System.err.println(i+". "+BaseUrl+UrlString + "  ==>  "  + errorMessage);
                            CurrentRow.createCell(1).setCellValue(errorMessage);
                        }


                        catch(NoSuchElementException errr)  {

                            try {
                                String errorMessage =(driver.findElement(By.xpath("//div/div/span[text()[contains(.,'There was a problem with the request. Please try again later.')]]")).getText());

                                System.err.println(i+". "+BaseUrl+UrlString + "  ==>  "  + errorMessage);
                                CurrentRow.createCell(1).setCellValue(errorMessage);
                            }
                            catch(NoSuchElementException error)
                            {
                                String errorMessage =(driver.findElement(By.xpath("//div/div/span[text()[contains(.,'The requested URL is disallowed by robots.txt.')]]")).getText());

                                System.err.println(i+". "+BaseUrl+UrlString + "  ==>  "  + errorMessage);
                                CurrentRow.createCell(1).setCellValue(errorMessage);

                            }


                        }

                    }
                }
            }



            if ((i%10)==0)
            {

                FileOutputStream fos = new FileOutputStream(new File("ALLURL.xls"));
                workbook.write(fos);
                fos.close();
                System.out.println("------Finished ---------- : "+i+"-----------------------");


                FileOutputStream fos1 = new FileOutputStream(new File("ALLURL.xls"));
                workbook.write(fos1);
                fos.close();
            }    

        }

    }}