package Listenersdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

@Listeners(Listenersdemo.listernertestng.class)

public class demoqatest {
	
	
	WebDriver driver;
	
	@BeforeTest
	@Parameters({"Browser","URL"})
	public void setup(String Browser, String URL)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
			
			 driver = new ChromeDriver();
			 
		}
		
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);
	}
	
	@Test
	
	public void titletest()
	{
		String titlepage = driver.getTitle();
		
		System.out.println("Title is " +titlepage);
	}
	
	@Test
	
	public void testURL()
	{
		String URLis = driver.getCurrentUrl();
		
		System.out.println("URL is " +URLis);
		Assert.assertTrue(false);
	}
	
	
	
	
	
	

}
