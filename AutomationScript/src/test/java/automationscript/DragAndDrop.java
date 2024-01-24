package automationscript;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DragAndDrop {
	WebDriver driver;
	
	@BeforeTest
	public void launchBrowser()
	{
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://jqueryui.com/droppable/");
	}
	
	@Test
	public void dragAndDrop() throws InterruptedException
	{
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.id("draggable"));
		
		WebElement target = driver.findElement(By.id("droppable"));
		
		Thread.sleep(2000);
		
		Actions action = new Actions(driver);
		
		action.clickAndHold(source).moveToElement(target).release().build().perform();
	}
	
	@AfterTest
	public void closeBrowser()
	{
		driver.close();
	}

}
