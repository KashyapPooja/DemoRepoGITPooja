package CrossBrowser;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowser_Test {
	
	WebDriver driver;
	
	
	@Parameters("Browser")
	@BeforeMethod
	
	public void Setup(@Optional("Chrome")String Browsername)
	{
		if(Browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		
		else if(Browsername.equalsIgnoreCase("Firefox"))
		{
			
			System.setProperty("webdriver.firefox.driver", "C:\\Users\\DELL\\Desktop\\geckodriver\\geckodriver.exe");
			 driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://demoqa.com/");
		String pageTitle = driver.getTitle();
		System.out.println("Title of page is " +pageTitle);
	}
	
	@Test
	
	public void Automationpractiseform() throws Exception
	{
		driver.findElement(By.linkText("Automation practice form")).click();
		Thread.sleep(2000);
		String Titleis = driver.getTitle();
		System.out.println("Title of page is " +Titleis);
		
	}
	
	@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
	


}
