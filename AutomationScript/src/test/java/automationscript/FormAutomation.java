package automationscript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.google.common.io.Files;

public class FormAutomation {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.xoxoday.com/plum/demo");
	}
	
	@Test
	public void formFill()
	{
		String actual_title = driver.getTitle();
		
		String expected_title = "Get A Demo";
		
		Assert.assertEquals(actual_title, expected_title);
		
		driver.findElement(By.id("firstname-dc5b5291-157d-439e-b7d6-f0eee7bfbebf")).sendKeys("Tester");
		
		driver.findElement(By.id("lastname-dc5b5291-157d-439e-b7d6-f0eee7bfbebf")).sendKeys("Test");
		
		driver.findElement(By.id("email-dc5b5291-157d-439e-b7d6-f0eee7bfbebf")).sendKeys("test@xoxoday.com");
		
		WebElement dropDown1 = driver.findElement(By.id("demographics-dc5b5291-157d-439e-b7d6-f0eee7bfbebf"));
		
		Select select1 = new Select(dropDown1);
		
		select1.selectByVisibleText("Americas");
		
		WebElement dropDown2 = driver.findElement(By.id("phone_ext-dc5b5291-157d-439e-b7d6-f0eee7bfbebf"));
		
		Select select2 = new Select(dropDown2);
		
		select2.selectByValue("AS");
		
		WebElement dropDown3 = driver.findElement(By.id("numemployees-dc5b5291-157d-439e-b7d6-f0eee7bfbebf"));
		
		Select select3 = new Select(dropDown3);
		
		select3.selectByVisibleText("0 - 50");
		
		WebElement dropDown4 = driver.findElement(By.id("what_you_would_like_to_use_plum_for_-dc5b5291-157d-439e-b7d6-f0eee7bfbebf"));
		
		Select select4 = new Select(dropDown4);
		
		select4.selectByVisibleText("Rewards APIs (Gift cards, Prepaid cards, and more) ");
		
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\screenshot\\form.png"));
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
