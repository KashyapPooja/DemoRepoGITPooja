package TestNGPackage;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNGclassfirst {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
      driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		driver.get("https://www.bigbasket.com/");
		
		driver.manage().window().maximize();
		
		
	}
	
  @Test(priority = 2)
  public void TitleofPage()
  {
	 String Titleofpage =  driver.getTitle();
	  
	  System.out.println("Title of page is " +Titleofpage);
  }
  
  @Test(priority = 1, invocationCount = 3)
  
  public void URLofPage()
  {
	  String PageURL = driver.getCurrentUrl();
	  
	  System.out.println("Page URL is " +PageURL);
  }
  
  @Test(priority = 4,groups = "HOME",dependsOnMethods =  "movetoshopbycategory")
  public void linkcount()
  {
	  List<WebElement> LinkeList = driver.findElements(By.tagName("a"));
	  
	int Sizeoflist =   LinkeList.size();
	

	
	System.out.println("Size of link " +Sizeoflist);
	
	for(int i = 0; i<LinkeList.size();i++)
	{
		System.out.println("Linktext is " +LinkeList.get(i).getText());
	}
  }
  
  @Test(priority = 3 , groups = "HOME")
  public void movetoshopbycategory()
  {
	  Actions act = new Actions(driver);
	  
	  act.moveToElement(driver.findElement(By.xpath("//a[contains(text(),' Shop by Category ')]"))).build().perform();
	  
	  System.out.println("Element moved");
	  //driver.findElement(By.xpath("//a[contains(text(),'Beauty & Hygiene')]")).click();
  }
  
  @Test(expectedExceptions=NumberFormatException.class)
  
  public void numberexception()
  {
	  String Number = "100S";
	  
	int Newnumber =   Integer.parseInt(Number);
	
	System.out.println("New Number is " +Newnumber);
			  
  }
  
  
  @AfterMethod
  
  public void teardown()
  {
	  driver.quit();
  }
}
