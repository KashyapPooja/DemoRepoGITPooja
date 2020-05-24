package XMLdemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class xmldemo1 {
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"Browser","URL"})
	
	public void setenv(String Browser, String URL)
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
	@Parameters({"username"})
	
	public void loginyahoo(String username) throws Exception
	{
		driver.findElement(By.id("login-username")).sendKeys("username");
		Thread.sleep(5000);
		System.out.println("Usernmae enter");
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}

}
