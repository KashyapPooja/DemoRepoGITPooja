package Navigatetoback;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class NAvigation {
	
WebDriver driver;

@BeforeMethod
	
	public void setup()
	{
	
	System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe" );
	
	 driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	System.out.println("Chrome launched");
	//String URLis = prop.getProperty("URL");
	driver.get("https://demoqa.com/");
	//System.out.println("URL is " +URLis)

}

@Test

public void NAvigationcheck() throws Exception
{
	driver.findElement(By.linkText("HTML contact form")).click();
String Titleofpageis =	driver.getTitle();

System.out.println("Title of page is " +Titleofpageis);

driver.findElement(By.linkText("Google Link")).click();
Thread.sleep(2000);

String pagetitlegoogle = driver.getTitle();
System.out.println("Title of page is " +pagetitlegoogle);



driver.navigate().back();
String titleisold = driver.getTitle();
Thread.sleep(2000);
System.out.println("Titlei si " +titleisold);

driver.navigate().forward();

String Titleofpageisgoogle = driver.getTitle();

System.out.println("Title is " +Titleofpageisgoogle);

Thread.sleep(2000);


}

@Test

public void NavigationURL() throws Exception
{
	driver.navigate().to("https://www.amazon.com/");
	Thread.sleep(4000);
	
	String Titleofpage = driver.getTitle();
	
	System.out.println("Title of page is " +Titleofpage);
	
	driver.navigate().back();
	
	Thread.sleep(2000);
	
	String Titleofnewpage = driver.getTitle();
	
	System.out.println("Titile of page is "+Titleofnewpage);
	
	driver.navigate().forward();
	
	Thread.sleep(2000);
	
	String titlenew = driver.getTitle();
	
	System.out.println("Title of page is "+titlenew);
	System.out.println("This is demo GIT");
}
@AfterMethod

public void teardown()
{
	driver.quit();
}
}
