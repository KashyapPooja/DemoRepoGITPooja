package assertion;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HArdsoftassert {
	
	WebDriver driver;
	
	@BeforeMethod
	@Parameters({"Browser","URL"})
	
	public void setup(String Browser,String URL)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
			
		driver = 	new ChromeDriver();
		
		}
		
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\geckodriver\\geckodriver.exe");
			
		driver = 	new FirefoxDriver();
		}
		
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(URL);
	}
	
	@Test
	
	public  void Assertdemo()
	{
		driver.findElement(By.linkText("Automation Practice Switch Windows")).click();
		
	String titlepage  = 	driver.getTitle();
	System.out.println("Title of page is" +titlepage);
	
	String Expected = "Automation Practice Switch Windows – ToolsQA – Demo Website to Practice ";
	//HArd Assert
	//Automation
	Assert.assertEquals(titlepage, Expected,"Title is not correect");
	
	
		
		
	}
	
	@Test
	
	public void toollink()
	{
		driver.findElement(By.linkText("Tooltip and Double click")).click();
		
		System.out.println("Clicked on title");
		
		String Actualtitle = driver.getTitle();
		System.out.println("Title of page is " +Actualtitle);

	}
	
	@Test
	
	public void soft()
	{
		driver.findElement(By.linkText("Tooltip and Double click")).click();
		
		System.out.println("Clicked on title");
		
		String Actualtitle = driver.getTitle();
		System.out.println("Title of page is " +Actualtitle);
		String Expected = "Tooltip and Double click – ToolsQA – Demo Website to Practice ";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(Actualtitle, Expected);
		softAssert.assertAll();
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.quit();
	}
	
	

}
