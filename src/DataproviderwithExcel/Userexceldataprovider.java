	package DataproviderwithExcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Userexceldataprovider {
	
	WebDriver driver;

	@Test(dataProvider = "empinfp")
	public void Newdatatest(String name, String email, String phone,String City, String Childname, String childclass)
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
		
	driver = new ChromeDriver();
	
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
	
	
	@DataProvider(name = "empinfp")
	
	public Object[][] dataempnewinfo()
	
	
	{
		
		Dataproviderwithexcel  newconfig = new Dataproviderwithexcel("C:\\Users\\DELL\\Desktop\\testapachePOI.xlsx");
		
		int count = newconfig.rowcount(2);
		

		
		Object[][] Arr = new Object[count][5];
		
		for(int i = 0; i<count;i++)
		{
			Arr[i][0] = newconfig.data(2, i, 0);
		Arr[i][1]	 = newconfig.data(2, i, 1);
		}
		
		
		
		return Arr;
		
		
	}
	
}
