package automationscript;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ReadAndWriteData {
	@Test
	public void readAndWriteData() throws FileNotFoundException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().deleteAllCookies();
		
		FileInputStream fs = new FileInputStream("D:\\xoxoday.xlsx");
		
		XSSFWorkbook
	}

}
