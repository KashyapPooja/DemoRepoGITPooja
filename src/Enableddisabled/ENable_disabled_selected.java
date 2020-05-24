package Enableddisabled;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import configdata.setup;

public class ENable_disabled_selected {
	
	WebDriver driver;
	@BeforeMethod
	
	public void Setup() 
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
	
	@Test(priority = 1)
	public void pageTitle()
	{
		String pagetitle = driver.getTitle();
		
		System.out.println("Title of page is " +pagetitle);
	}
	
	@Test(priority = 2)
	
	public void Isdisplayedmethod() throws Exception
	{
		boolean displayedstatus = driver.findElement(By.linkText("Controlgroup")).isDisplayed();
		
		System.out.println("Is displayed method " +displayedstatus);
		
		if (displayedstatus == true)
		{
			driver.findElement(By.linkText("Controlgroup")).click();
			Thread.sleep(5000);
		}
		else
		{
			System.out.println("Element not visible");
		}
		
	}
	
	
	@Test(priority = 3)
	
	public void Ienabledmethod() throws Exception
	
	{
		
		 driver.findElement(By.linkText("Checkboxradio")).click();
		 Thread.sleep(4000);
		 
		boolean Isselectedstatus =  driver.findElement(By.xpath("//label[contains(text(),'New York')]")).isSelected();
		System.out.println("Is selected status is " +Isselectedstatus);
		
		if(Isselectedstatus == false)
		{
			driver.findElement(By.xpath("//label[contains(text(),'New York')]")).click();
			Thread.sleep(5000);
		}
		
		else
		{
			System.out.println("not found");
		}
		
		boolean currectstatus = driver.findElement(By.xpath("//label[contains(text(),'New York')]")).isSelected();
		System.out.println("Is selected status is " +currectstatus);
	}
	
	@Test(priority = 4)
	
	public void Isenabledmethod() throws Exception
	{
		driver.findElement(By.linkText("HTML contact form")).click();
		Thread.sleep(2000);
		boolean Isenablesstatus = driver.findElement(By.xpath("//input[@value = 'Submit']")).isEnabled();
		
		System.out.println("Is enabled sttatus is " +Isenablesstatus);
		
		if(Isenablesstatus==true)
		{
			driver.findElement(By.xpath("//input[@value = 'Submit']")).click();
			Thread.sleep(2000);
			String pagetitle = driver.getTitle();
			System.out.println("Page title is " +pagetitle);
		}
		else
		{
			System.out.println("Page not found error");
		}
	}
	
	
	@AfterMethod
	
	public void teardown()
	
	{
		driver.quit();
	}
	
	

}
