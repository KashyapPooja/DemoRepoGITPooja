package DataprovidewithoutExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovidernoexcel {
	WebDriver driver;
	
	@Test(dataProvider = "Schooldata")
	
	public void Schoolinfo(String name, String email, String phone,String City, String Childname, String childclass)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver.exe");
		
	driver = 	new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
	driver.get("https://www.excelsioramericanschool.in/?utm_source=Excelsior&utm_medium=google&utm_campaign=Search&gclid=CjwKCAjw7LX0BRBiEiwA__gNw2rAwDCRFBAH-NlPtqSIkYwI-Us_--fyj04zCYzUV1gW8H3Ek0rUjRoC9TEQAvD_BwE");
	
	driver.findElement(By.name("name")).sendKeys(name);
	
	driver.findElement(By.name("email")).sendKeys(email);
	
	driver.findElement(By.name("phone_number")).sendKeys(phone);
	
	driver.findElement(By.name("city")).sendKeys(City);
	
	driver.findElement(By.name("name_of_your_child")).sendKeys(Childname);
	
	driver.findElement(By.name("class_of_the_child")).sendKeys(childclass);
	
	driver.findElement(By.id("lp-pom-button-66")).click();
	
	String Titleofpage = driver.getTitle();
	
	System.out.println("Titleofpage is " +Titleofpage );
	
	Assert.assertTrue(Titleofpage.contains("Admissions"), "Not registered");
	
	System.out.println("Registered successfully, our team will conr=tact you");
	
	driver.close();
	}
	

	
	@DataProvider(name = "Schooldata")
	
	public Object[][] data()
	{
		
		Object[][]  Arr = new Object[2][6];
		
		Arr[0][0] = "Pooja";
		Arr[0][1] = "pooja@gmail.com";
		Arr[0][2] = "98765574";
		Arr[0][3] = "Delhi";
		Arr[0][4] = "Dev";
		Arr[0][5] = "2nd";
		
		Arr[1][0] = "Neha";
		Arr[1][1] = "Neha@gmail.com";
		Arr[1][2] = "4212222";
		Arr[1][3] = "bng";
		Arr[1][4] = "nia";
		Arr[1][5] = "1st";
		
		
	
		return Arr;
		
	}
	
	

}
