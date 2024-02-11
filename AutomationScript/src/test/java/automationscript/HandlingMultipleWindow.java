package automationscript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class HandlingMultipleWindow {
	WebDriver driver;
	
	@Test
	public void startBrowser()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://www.xoxoday.com");
		
	}
	
	@Test
	public void handleMultipleWindow()
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		String parenWindowHandle = driver.getWindowHandle();
		
		// click link to open new tab or window
		
		WebElement btn = driver.findElement(By.xpath("//a[@class='plum-cta-primary-dark secondary plum-btn-2 w-inline-block']"));
		
		btn.click(); //This will open a new window
		
		Set<String> windowHandleList = driver.getWindowHandles();
		
		List<String> handle = new ArrayList<String>(windowHandleList);
		
		
		
		String expected_title = "Activities, Tours, Attractions, Things To Do in Your City - Xoxoday";
		
		for(String s:handle)
		{
			String actual_Title = driver.switchTo().window(s).getTitle();
			
			if(actual_Title.contains(expected_title))
			{
				System.out.println("We are on the right");
			}
			
		}
	}
	
	
	
	@AfterTest
	public void closeBrowser()
	{
		driver.quit();
	}

}
