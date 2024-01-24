package automationscript;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;
import com.opencsv.CSVWriter;

public class ImageAltText {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Date d = new Date();
		
		System.out.println("Test Execution Date : "+d.toString());
		
		driver.get("https://www.xoxoday.com");
	}
	
	@Test
	public void altText()
	{
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		
		System.out.println("Total Available Images On This Page : "+imageList.size());
		
		int sno=1;
		
		try
		{
			FileWriter outputfile = new FileWriter("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\Test_Report\\Image_Alt_Text.csv");
			
			CSVWriter writer = new CSVWriter(outputfile);
			
			String[] header = {"S_No","Image Link","Image Size","Image Alt Text"};
			
			writer.writeNext(header);
			
			for(WebElement image:imageList)
			{
				String imageLink = image.getAttribute("src");
				
				String altText = image.getAttribute("alt");
				
				HttpURLConnection connection = (HttpURLConnection) new URL(imageLink).openConnection();
				
				int size = connection.getContentLength();
				
				String image_size = Integer.toString(size);
				
				String s_no = Integer.toString(sno);
				
				String[] data = {s_no,imageLink,image_size,altText};
				
				writer.writeNext(data);
				
				sno++;
			}
			
			writer.close();
			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void takeScreenshotOfFailedTestCase(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\screenshot\\Image_Alt_Text.png"));
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
