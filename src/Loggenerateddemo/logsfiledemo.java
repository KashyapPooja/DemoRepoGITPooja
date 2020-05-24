package Loggenerateddemo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class logsfiledemo {
	
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void setup()
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
	
	 driver = new ChromeDriver();
	
	driver.manage().window().maximize();

	
	driver.navigate().refresh();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	driver.get("https://demoqa.com/");
	}
	
	@Test
	
	public void Pagetitle()
	{
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		String titleofpage = jse.executeScript("return document.title;").toString();
		//driver.getTitle();
		System.out.println("Title of page is " +titleofpage);
	}
	
	@Test
	
	public void Totallink()
	{
		List<WebElement> L1 =driver.findElements(By.tagName("a"));
		int sizeoflist = L1.size();
		System.out.println("Size of list is " +sizeoflist);
		
	for(int i = 0; i<sizeoflist; i++)
	{
		System.out.println(L1.get(i).getText());
	}
		
	}

	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
}
