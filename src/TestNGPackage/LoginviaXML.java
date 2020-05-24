package TestNGPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class LoginviaXML {
	
  @Test
  @Parameters({"URL","username"})
  public void login(String URL, String username)
  {
	  

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
	WebDriver driver = 	new ChromeDriver();
	
	driver.get(URL);
	
	driver.findElement(By.id("login-username")).sendKeys("username");
	
	System.out.println("done");
	  
  }
}
