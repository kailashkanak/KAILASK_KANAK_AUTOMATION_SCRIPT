package automationscript;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
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

public class ImageSize {
	
	WebDriver driver;
	
	@BeforeTest
	public void startBrowser()
	{
		driver = new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.xoxoday.com");
		
		Date d = new Date();
		
		System.out.println("Test Execution date : "+d.toString());
	}
	
	@Test
	public void findBrokenLink() throws MalformedURLException, IOException
	{
		List<WebElement> imageList = driver.findElements(By.tagName("img"));
		
		System.out.println("Available images on this page are : "+imageList.size());
		
		try
		{
			FileWriter outputfile = new FileWriter("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\Test_Report\\image_size.csv");
			
			CSVWriter writer = new CSVWriter(outputfile);
			
			String[] header = {"S_No","Image Link","Image Size"};
			
			writer.writeNext(header);
			
			int sno=1;
			
			for(WebElement e:imageList)
			{
				String image_link = e.getAttribute("src");
				
				HttpURLConnection connection = (HttpURLConnection) new URL(image_link).openConnection();
				
				int size = connection.getContentLength();
				
				String img_size = Integer.toString(size);
				
				String s_no = Integer.toString(sno);
				
				String[] data = {s_no,image_link,img_size};
				
				writer.writeNext(data);				
				
			}
			
			writer.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\screenshot"));
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
