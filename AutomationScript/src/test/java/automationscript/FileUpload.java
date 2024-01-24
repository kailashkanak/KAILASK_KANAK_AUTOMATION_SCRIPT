package automationscript;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class FileUpload {
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
		
		driver.get("https://www.xoxoday.com/company/careers");
	}
	
	@Test
	public void fileUpload()
	{
		driver.findElement(By.xpath("//a[@class='button load-3rd orange secondry-brn w-button']")).click();
		
		driver.findElement(By.xpath("//a[@href='/careers/senior-backend-developer']")).click();
		
		String actual_title = driver.getTitle();
		
		String expected_title = "Senior Backend Developer (Nodejs) Job Opening at Xoxoday";
		
		Assert.assertEquals(actual_title, expected_title);
		
		System.out.println("We are about to fill the job application form");
		
		driver.findElement(By.xpath("//a[@href='#apply']")).click(); //clicking apply button
		
		driver.findElement(By.id("First-Name")).sendKeys("Tester");
		
		driver.findElement(By.id("Last-Name")).sendKeys("Test");
		
		driver.findElement(By.id("Email")).sendKeys("Tester@xoxoday.com");
		
		driver.findElement(By.id("Phone-Number")).sendKeys("1234567890");
		
		driver.findElement(By.id("Location")).sendKeys("Bangalore");
		
		driver.findElement(By.id("Current-Salary")).sendKeys("800000");
		
		WebElement upload = driver.findElement(By.xpath("//div[contains(text(),'Upload resume')]"));
		
		upload.sendKeys("C:\\Users\\KAILASH KANAK\\OneDrive\\Desktop\\anisble_install_cmd.txt");
		
	}
	
	@AfterMethod
	public void takeScreenshotOfFailedTestCase(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("D:\\SeleniumScript\\KAILASK_KANAK_AUTOMATION_SCRIPT\\AutomationScript\\screenshot\\upload.png"));
		}
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}


