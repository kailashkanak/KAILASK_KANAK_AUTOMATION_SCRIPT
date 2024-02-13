package locators;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class LocatorsDemo {
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
		
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
	}
	
	@Test
	public void locators() throws InterruptedException
	{
		WebElement userName = driver.findElement(By.id("inputUsername"));
		
		WebElement passWord = driver.findElement(By.xpath("//input[@type='password']"));
		
		userName.sendKeys("kailash");
		
		passWord.sendKeys("kanak");
		
		WebElement checkBox1 = driver.findElement(By.id("chkboxOne"));
		
		WebElement checkBox2 = driver.findElement(By.id("chkboxTwo"));
		
		checkBox1.click();
		
		checkBox2.click();
		
		WebElement btnClick = driver.findElement(By.xpath("//button[@class='submit signInBtn']"));
		
		btnClick.click();
		
		WebElement forgotPassword = driver.findElement(By.linkText("Forgot your password?"));
		
		forgotPassword.click();
		
		WebElement userName1 = driver.findElement(By.xpath("//input[@placeholder='Name']"));
		
		userName1.sendKeys("kailash kanak");
		
		WebElement password1 = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		
		password1.sendKeys("kanak");
		
		WebElement phoneNumber = driver.findElement(By.xpath("//input[@placeholder='Phone Number']"));
		
		phoneNumber.sendKeys("9102832728");
		
		//WebElement clickMe = driver.findElement(By.xpath("//button[@class='reset-pwd-btn']"));
		
		WebElement clickMe = driver.findElement(By.xpath("//button[contains(text(),'Reset Login')]"));
		
		Thread.sleep(2000);
		
		clickMe.click();
		
		WebElement message = driver.findElement(By.xpath("//p[@class='infoMsg']"));
		
		String str = message.getText();
		
		System.out.println(str);
		
		String[] pwd = str.split(" ");
		
		for(int i=0;i<pwd.length;i++)
		{
			System.out.println(pwd[i]);
		}
		
		pwd[4]=pwd[4].replace("'", "");
		
		String newPassword = pwd[4];
		
		System.out.println("Password = "+pwd[4]);
		
		//clicking on Go To Login Button
		
		WebElement goToButton = driver.findElement(By.xpath("//button[contains(text(),'Go to Login')]"));
		
		goToButton.click();
		
		
		WebElement userName11 = driver.findElement(By.id("inputUsername"));
		
		WebElement passWord11 = driver.findElement(By.xpath("//input[@type='password']"));
		
		userName11.sendKeys("kailash kanak");
		
		passWord11.sendKeys(newPassword);
		
		Thread.sleep(2000);
		
		btnClick.click();
		
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException
	{
		if(ITestResult.FAILURE==result.getStatus())
		{
			File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			
			Files.copy(f, new File("C:\\Users\\KAILASH PRASAD KANAK\\eclipse-workspace\\Kailash_Project\\screenshot\\img1.png"));
		}
	}
	
	//@AfterMethod
	public void closeBrowser()
	{
		driver.close();
	}

}
