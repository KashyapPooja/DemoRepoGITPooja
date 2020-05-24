package configdata;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class setup {
	static  WebDriver driver;

	public  static void envsetup() throws Exception
	{
		Properties prop = new Properties();
		
		FileInputStream fis =  new FileInputStream("C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\src\\configdata\\configprop_envsetup");
		prop.load(fis);
		
		String Browsername = prop.getProperty("Browser");
		
		System.out.println("Browser name is " +Browsername);
		
		if (Browsername.equalsIgnoreCase("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe" );
			
			 driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			System.out.println("Chrome launched");
			//String URLis = prop.getProperty("URL");
			driver.get("https://demoqa.com/");
			//System.out.println("URL is " +URLis);
		}
		
		else if(Browsername.equalsIgnoreCase("Firefox"))
		{
	System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\gecko.exe" );
			
			WebDriver driver = new FirefoxDriver();
			
			driver.manage().window().maximize();
			
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			System.out.println("Firefox launched");
		}
		
		
		
	
	}
}
