package automationscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonWebsiteAutomation {
	
	WebDriver driver;
	
	@BeforeTest
	public void setUpBrowser()
	{
		driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.amazon.in/");
	}
	
	@Test
	public void amazonWebsite()
	{
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		
		searchBox.sendKeys("iphone 15", Keys.ENTER);
		
		WebElement minPrice = driver.findElement(By.xpath("//input[@id='low-price']"));
		
		minPrice.sendKeys("80000");
		
		WebElement clickBtn = driver.findElement(By.xpath("//input[@class='a-button-input']"));
		
		clickBtn.click();
	}
	
	//@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
