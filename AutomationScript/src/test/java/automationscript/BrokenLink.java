package automationscript;

import java.io.File;
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

public class BrokenLink {
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
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Available links on this page are : "+allLinks.size());
		
		for(WebElement e:allLinks)
		{
			String individual_link = e.getAttribute("href");
			
			HttpURLConnection connection = (HttpURLConnection) new URL(individual_link).openConnection();
			
			connection.connect();
			
			int resCode = connection.getResponseCode();
			
			if(resCode>400)
			{
				System.out.println(individual_link + " ::::>>>  is a broken link");
			}
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
