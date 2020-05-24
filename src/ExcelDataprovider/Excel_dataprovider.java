package ExcelDataprovider;

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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import SCreenshotutility.Screenshotutility_excel;
import TestUtility.newutilexcel;

public class Excel_dataprovider {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void Setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(40,TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			driver.get("https://www.excelsioramericanschool.in/?utm_source=Excelsior&utm_medium=google&utm_campaign=Search&gclid=CjwKCAjw7LX0BRBiEiwA__gNw2rAwDCRFBAH-NlPtqSIkYwI-Us_--fyj04zCYzUV1gW8H3Ek0rUjRoC9TEQAvD_BwE");
			
		
			}
	
	@Test(dataProvider= "Schooldata1" )
	
	public void Schooldatainfo(String Name, String Email_id , String phonenumber, String City, String childname, String Standard)
	{
		
		driver.findElement(By.name("name")).sendKeys(Name);
		
		driver.findElement(By.id("email")).sendKeys(Email_id);
		
		driver.findElement(By.name("phone_number")).sendKeys(phonenumber);
		
		driver.findElement(By.id("city")).sendKeys(City);
			
		driver.findElement(By.id("name_of_your_child")).sendKeys(childname);
		
		driver.findElement(By.id("class_of_the_child")).sendKeys(Standard);
		
		driver.findElement(By.xpath("//span[contains(text(),'Submit')]")).click();
		
		System.out.println("Data submitted");
		
		String PageTitle = driver.getTitle();
		System.out.println("Title of page is " +PageTitle);
		
		Assert.assertEquals(PageTitle, "Excelsior Admissions","Please enter correct data");
		
	}
	
	@Test(dataProvider = "Enquirydata")
	
	public void Exceldata_enquiry(String Name, String Email, String Phone, String City, String Child_Name,  String Child_class)
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
	

	@DataProvider(name = "Enquirydata")
	public Object[][] dataexcel() throws Exception 
	{
		
		//C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\TestDataExcel\\School_Enquiry.xlsx");
		
		newutilexcel con = new newutilexcel("C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\TestDataExcel\\School_Enquiry.xlsx");
		
		int count = con.ROwcount(0);
		Object[][] arrdata = new Object[count][5];
		
		for(int i = 0; i<count; i++)
		{
			arrdata[i][0] = con.getexceldata(0, i, 0);
			arrdata[i][1] = con.getexceldata(0, i, 1);
			
		}
		
	
		return arrdata;
		
	
	
		
		
	}
	
	@DataProvider(name = "Schooldata1" )
	public Object[][] enquirydata()
	
	{
		
		
		
		Object[][] arrdata = new Object[3][6];
		
	arrdata[0][0] = "Pooja";
		arrdata[0][1] =  "pooja@gmail.com";
		arrdata[0][2] = "9999777474";
	arrdata[0][3] = "Gurugram";
		arrdata[0][4] = "Dev";
		arrdata[0][5] = "Ist";
		
	arrdata[1][0] = "Neha";
		arrdata[1][1] =  "Neha@gmail.com";
		arrdata[1][2] = "8888888474";
		arrdata[1][3] = "Bangalore";
		arrdata[1][4] = "Will";
		arrdata[1][5] = "2nd";
		
		
		arrdata[2][0] = "Nisha";
		arrdata[2][1] =  "Nisha@gmail.com";
		arrdata[2][2] = "7777778474";
		arrdata[2][3] = "Nasik";
		arrdata[2][4] = "Judy";
		arrdata[2][5] = "3rd";
		
		return arrdata;
	}
	
	
	@AfterMethod
	
	public void teardown(ITestResult result)
	{
		if(result.FAILURE == result.getStatus())
		{
			Screenshotutility_excel.captureScreenshot(driver, result.getName());
		}
		driver.quit();
		
		
		
		
	}

	

}
