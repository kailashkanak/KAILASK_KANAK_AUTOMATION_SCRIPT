package automationscript;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DropDown {
WebDriver driver;
	
	@BeforeTest
	public void startBrowser()
	{
		driver=new ChromeDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.xoxoday.com/plum/demo");
		
		Date d = new Date();
		
		System.out.println("Test Execution Date : "+d.toString());
	}
	
	@Test
	public void dropDown()
	{
		WebElement dropDown1 = driver.findElement(By.id("demographics-dc5b5291-157d-439e-b7d6-f0eee7bfbebf"));
		
		Select select = new Select(dropDown1);
		
		select.selectByVisibleText("Americas");
		
		List<WebElement> dropdownList = select.getOptions();
		
		List<String> dropDownItems = new ArrayList<String>();
		
		for(WebElement e:dropdownList)
		{
			dropDownItems.add(e.getText());
		}
		
		System.out.println(dropDownItems);
	}

}
