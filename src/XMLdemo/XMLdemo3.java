package XMLdemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class XMLdemo3 {
	
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


	@Test
	
	public void gettetxtmethod()
	{
		String id = driver.getWindowHandle();
		
		System.out.println("WIndow id is " +id);
	}
	
	@Test
	
	public void totallink()
	{
		List<WebElement> L1 = driver.findElements(By.tagName("a"));
		
	int len = 	L1.size();
	System.out.println("count is " +len);
	
	for(int i = 0; i<len; i++)
	{
		System.out.println(L1.get(i).getText());
	}
	}
	
	@Test(expectedExceptions  = Exception.class)
	
	public void getattribute()
	{
		driver.findElement(By.xpath("//*[@id = 'email'")).click();
		System.out.println("This should be passed");
	}
	
	@Test
	public void TestAssert()
	{
		WebElement signin = driver.findElement(By.xpath("//input[@id = 'login-signin']"));
		
	String Actual = 	signin.getText();
	
	System.out.println("NExt valie is " +Actual);
	
	
		Assert.assertEquals(Actual, "Next");
	}
	
@AfterMethod
	
	public void teardown()
	{
		driver.quit();
	}
}
