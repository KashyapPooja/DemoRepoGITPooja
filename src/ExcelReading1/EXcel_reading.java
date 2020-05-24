package ExcelReading1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Library.Excelutility;
import Library.scrshotutil;

public class EXcel_reading {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void Setupenv()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
		
	 driver = 	new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	
	driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	
	driver.get("\"https://www.excelsioramericanschool.in/?utm_source=Excelsior&utm_medium=google&utm_campaign=Search&gclid=CjwKCAjw7LX0BRBiEiwA__gNw2rAwDCRFBAH-NlPtqSIkYwI-Us_--fyj04zCYzUV1gW8H3Ek0rUjRoC9TEQAvD_BwE");
	}
	
	
	@Test(dataProvider = "Schoolenqinfo")
	
	public void SchoolEnquiry(String Name, String Email, String Phone,String City,String Child_Name,String Child_class )
	{
driver.findElement(By.name("name")).sendKeys(Name);
		
		driver.findElement(By.id("email")).sendKeys(Email);
		
		driver.findElement(By.name("phone_number")).sendKeys(Phone);
		
		driver.findElement(By.id("city")).sendKeys(City);
			
		driver.findElement(By.id("name_of_your_child")).sendKeys(Child_Name);
		
		driver.findElement(By.id("class_of_the_child")).sendKeys(Child_class);
		
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		
		System.out.println("Data submitted");
		
		String PageTitle = driver.getTitle();
		System.out.println("Title of page is " +PageTitle);
		
		Assert.assertEquals(PageTitle, "Excelsior Admissions","Please enter correct data");
	}
	
	
	
	@DataProvider(name = "Schoolenqinfo")
	
	public Object[][]schoolenqinfo() throws Exception
	
	{
		
		Excelutility obj = new Excelutility("C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\TestDataExcel\\School_Enquiry.xlsx");
		 int rownumner = obj.rownumbercalc(0);
		 
		 Object[][] arraydata =  new Object[rownumner][6];
		 
		 for(int i = 0; i<rownumner;i++)
		 {
			 arraydata[i][0] = obj.getexceldata(0, i, 0);
			 
			 arraydata[i][1] = obj.getexceldata(0, i, 1);
		 }
		 
		return arraydata;
		
	
	
	
	
		
	
		
		
	}
	
	@AfterMethod
	
	public void teardown(ITestResult  result) throws Exception
	{
		if(ITestResult.FAILURE == result.getStatus())
		{
			scrshotutil.ScreenshotUtil(driver, result.getName());
		}
		
		driver.quit();
	}

}
