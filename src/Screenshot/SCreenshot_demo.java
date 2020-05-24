package Screenshot;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Library.utitlty;

public class SCreenshot_demo {

	

	 WebDriver driver ;
	 
	 @BeforeMethod
	 
	 public void setup()
	 {
		 System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
			
		 driver = new ChromeDriver();
		 
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	 }

	@Test 
	
	public void openingCOA() throws Exception
	{
		//System.setProperty("Webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		
		// driver = new ChromeDriver();
		
		driver.get("https://facebook.com");
		
		TakesScreenshot TS = (TakesScreenshot)driver;
		
		File source = TS.getScreenshotAs(OutputType.FILE);
		
		FileHandler.copy(source,new File("./SCreenshotCapture/facebook.png"));
		
		System.out.println("SCreenshot captured");
		
	
	}
	
	@Test
	
public void Amazon()
	
{
	//	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://Amazon.com");
		
		Select sel = new Select(driver.findElement(By.xpath("//select[@title = 'Search in']")));
		
		sel.selectByValue("Books");
		
		System.out.println("Book selected");
		
		
		//utitlty.Screenshotcapture_Utility(driver,"Amazonname");
//System.out.println("SCreenshot captured Amazon");
		
	
		
		
}
	
	@Test
	
	public void Logoverify()
	{
//System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		
		//WebDriver driver = new ChromeDriver();
	
	//	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		
		//driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get("https://Amazon.com");
		
		Select sel1 = new Select(driver.findElement(By.xpath("//a[@id= 'nav-hamburger-menu']")));
		
		sel1.selectByValue("new");
		
		
		
	}
	
@AfterMethod

public void teardown(ITestResult result)
{
	if(ITestResult.FAILURE == result.getStatus())
	{
		utitlty.Screenshotcapture_Utility(driver,result.getName());
		
	}
	
	driver.quit();
}
	
	

}
