package XMLdemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class xmldemo2 {
	
WebDriver driver;
	
	@BeforeMethod
	@Parameters({"Browser","URL"})
	
	public void setenv(String Browser, String URL)
	{
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("Browser is chrome");
		}
		
		else if(Browser.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.get(URL);

}
	
	
	@Test(invocationCount = 3)
	
public void gettitle()
{
		String tItlepfpage = driver.getTitle();
		System.out.println("Title of page is " +tItlepfpage);
}
	
	@Test(dependsOnMethods = "gettitle")
	
	public void pagesourcemethod()
	
	{
		String Pagesourceis = driver.getPageSource();
		
		System.out.println("Pagesource is " +Pagesourceis);
	}
	
@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
}
