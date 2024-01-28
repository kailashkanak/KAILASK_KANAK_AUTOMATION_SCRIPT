package automationscript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.google.common.io.Files;

public class SoftAssertDemo {
	WebDriver driver;
	
	@BeforeTest
	public void startBrowser()
	{
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("http://www.xoxoday.com");
		
		Date d = new Date();
		
		System.out.println("Test Execution Date : "+d.toString());
	}
	
	@Test
	public void dropDownSelectItem()
	{
		String actual_title=driver.getTitle();
		
		String expected_title="Rewards, Incentives, Payouts, Perks, Loyalty & Engagements";
		
		SoftAssert softverify = new SoftAssert();
		
		softverify.assertEquals(actual_title, expected_title);
		
		softverify.assertAll();
		
	}
	
	@AfterMethod
	public void takeScreenShotofFailedTestCase(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\screenshot\\softAssert.png"));
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
