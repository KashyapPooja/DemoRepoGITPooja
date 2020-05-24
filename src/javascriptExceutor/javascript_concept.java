package javascriptExceutor;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class javascript_concept {

	public static void main(String[] args) {
		
		
   System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
WebDriver driver =  new ChromeDriver();	

driver.manage().window().maximize();

driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

driver.navigate().refresh();

driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);

driver.manage().deleteAllCookies();

driver.get("https://demoqa.com/");

driver.findElement(By.linkText("HTML contact form")).click();


//TO scolldown fully by usind Javascripexecutor

JavascriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("window.scrollTo(0,document.body.scrollHeight)");

WebElement Submittbutton = driver.findElement(By.xpath("//input[@type = 'submit']"));


		
		
		//To scrollfor a particular height

js.executeScript("arguments[0].scrollIntoView(true);",Submittbutton);


//click by java script executor

js.executeScript("arguments[0].click();", Submittbutton);

//Get title of page by using javascripe executor

String titlepage = js.executeScript("return document.title;").toString();
System.out.println(titlepage);
		

	}

}
