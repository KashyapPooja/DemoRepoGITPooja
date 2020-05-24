package TestNGPackage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class NewTest {
	 WebDriver driver;
	
  @BeforeTest
  public void setup() {
	  
	 
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
	  
	driver =  new ChromeDriver();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
	
	driver.get("https://www.excelsioramericanschool.in/?utm_source=Excelsior&utm_medium=google&utm_campaign=Search&gclid=CjwKCAjw7LX0BRBiEiwA__gNw2rAwDCRFBAH-NlPtqSIkYwI-Us_--fyj04zCYzUV1gW8H3Ek0rUjRoC9TEQAvD_BwE");
	
	
	driver.manage().window().maximize();
	
  }
  
  @Test
  
  public void TitleofPage()
  {
	  String TitleofPage = driver.getTitle();
	  
	  System.out.println("Title of page is " +TitleofPage);
  }
  
  
}
