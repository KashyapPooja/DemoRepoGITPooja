package DemoQAProject;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import SCreenshotutility.SCreenshotcapture;

public class DemoQA {
	
	WebDriver driver;
	
	@BeforeMethod
	
	public void Setup()
	{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\chromedriver\\chromedriver.exe");
		
		 driver = new ChromeDriver();
		
		//To maximize window
		driver.manage().window().maximize();
		
		//To give the pageload Time
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		//TO delete all browser cookies
		driver.manage().deleteAllCookies();
		
		//To launch URL
		driver.get("https://demoqa.com/");
	}
	
	@Test(enabled = false)
	
	public void FilltheForm()
	{
    driver.findElement(By.linkText("Automation practice form")).click();
		
		//To verify the exact  page opened or not.
		String PageTitle = 	driver.getTitle();
	     System.out.println("Title of the page is " +PageTitle);
	     
	     if(PageTitle.contains("Automation practice form"))
	     {
	    	 System.out.println("Landed on correct page");
	     }
	     else
	     {
	    	 System.out.println("Page Title is not correct");
	     }
	     //To Verify the URL of Page.
	     String URLofPage =  driver.getCurrentUrl();
	     System.out.println("URL of page is " +URLofPage);
	     
	     //To enter Firstname
	     driver.findElement(By.name("firstname")).sendKeys("Pooja");
	     
	     //To Enter last Name
	     driver.findElement(By.id("lastname")).sendKeys("Kashyap");
	     
	     //To enter Gender
	     driver.findElement(By.id("sex-1")).click();
	     
	     //To select experience
	     driver.findElement(By.id("exp-6")).click();
	     
	     //TO enter date
	     driver.findElement(By.id("datepicker")).sendKeys("10/12/2000");
	     
	     //To enter profession
	     
	     driver.findElement(By.xpath("//label[contains(text(),' Automation Tester')]")).click();
	     
	     //TO Uplaod picture
	     
	     driver.findElement(By.id("photo")).sendKeys("C:\\Users\\DELL\\Desktop\\tfn.xlsx");
	     
	     //To click on Automation tool
	    driver.findElement(By.xpath("//input[@value = 'Selenium Webdriver' and @type = 'checkbox']")).click();
	    
	    //To select continents from drop down
	    
	    Select sel = new Select(driver.findElement(By.id("continents")));
	    sel.selectByVisibleText("Australia");
	    
	    //To check how many value exist in dropdown
	    
	   List<WebElement> Continents =  sel.getOptions();
	   
	   int sizeofdropdown = Continents.size();
	   
	   System.out.println("Size of dropdown is " +sizeofdropdown);
	   
	   //To get all the value of dropdown
	   
	   for(int i = 0; i<sizeofdropdown;i++)
	   {
		   System.out.println(Continents.get(i).getText());
	   }
	    
	   //TO verify dropdown is multiselected or not
	   
	boolean Multiselected =   sel.isMultiple();
    System.out.println("Drop down is multiselected " +Multiselected);
    
    //TO select multiple dropdown
    
    Select selectmul =  new Select(driver.findElement(By.id("continentsmultiple")));
    selectmul.selectByVisibleText("Europe");
    selectmul.selectByVisibleText("Asia");
    
    //To select Multiple dropdown from selenium command
    
   WebElement SeleniumCommand =  driver.findElement(By.name("selenium_commands"));
   Select sel2 = new Select(SeleniumCommand);
   //Verify dropdown is multiselect or not
   
   boolean Multistatus = sel2.isMultiple();
   System.out.println("This is " +Multistatus+  " :multiselected");
   sel2.selectByVisibleText("Navigation Commands");
   sel2.selectByVisibleText("Switch Commands");
   
   
  //Find size of drop drown
   
  List<WebElement> listdropdown =  sel2.getOptions();
 int sizeofdrop =  listdropdown.size();
 System.out.println("Size of new dropdown is " +sizeofdrop);
 
 //Iterate the dropdown
 
 for (int j = 0; j<sizeofdrop;j++)
 {
	 System.out.println(listdropdown.get(j).getText());
 }
 
	}
	
	@Test(enabled = false)
	
	public void SelectMenu()
	{
		driver.findElement(By.linkText("Selectmenu")).click();
		
		//To check the corrrect page or not
		
		String Expectedvalue = "Selectmenu – ToolsQA – Demo Website to Practice Automation";
	   String Titlepage = 	driver.getTitle();
	   System.out.println("Title of page is " +Titlepage);
		Assert.assertEquals(Titlepage, Expectedvalue);
		
		//To select the speed
		
		WebElement Speedcheck = driver.findElement(By.xpath("//select[@name = 'speed']"));
		
		Select Selspeed = new Select(Speedcheck);
				Selspeed.selectByVisibleText("Medium");
		
		//TO find the size of dropdown
		
		List<WebElement> Speedlist = Selspeed.getOptions();
		
		int sizeofspeedlist = Speedlist.size();
		
		System.out.println("Size of Sppedlist is " +sizeofspeedlist);
		
		//Iterate the speedlist
		
		for(int k = 0; k<sizeofspeedlist; k++)
		{
			System.out.println(Speedlist.get(k).getText());
			//System.out.println("List iterate");
		}
		
		System.out.println("List iterate");
		
		
		//TO find the file
		
		WebElement files = driver.findElement(By.xpath("//select[@name = 'files' and @id = 'files']"));
		
		Select selfile = new Select(files);
		selfile.selectByVisibleText("Some unknown file");
		
		// TO find the size of dropdown
		
		List<WebElement> filelist = selfile.getOptions();
		
		int sizeoflistfile = filelist.size();
		
		System.out.println("Size of file is " +sizeoflistfile);
		
		//Iterate file list
		
	for (int f = 0; f<sizeoflistfile;f++)
	{
		System.out.println(filelist.get(f).getText());
	}
	}
	
	
	@Test(enabled = false)
	
	//Window Switch
	
	public void Switchwindows() throws Exception
	{
		driver.findElement(By.linkText("Automation Practice Switch Windows")).click();
		
		String CurrentURL = driver.getCurrentUrl();
		System.out.println("Current URL of page " +CurrentURL);
		
		//Find the Title of page
		String Titleofswitchpage = driver.getTitle();
		System.out.println("Title of page is "+Titleofswitchpage);
		
		//Click on button1
		
		driver.findElement(By.xpath("//button[text() = 'New Browser Window']")).click();
		
		Thread.sleep(4000);
		
		//for switching one window to another window we have a windowhandles method
		
		Set<String> Windowhandler = driver.getWindowHandles();
		
	Iterator<String> itr =	Windowhandler.iterator();
	
	String PArentwindow = itr.next();
	
	System.out.println("Parent  window id is " +PArentwindow);
	
	String Childwindow = itr.next();
		
	System.out.println("Childwindow id is " +Childwindow);
	
	//Now switch from parent window to child window
	
	driver.switchTo().window(Childwindow);
	Thread.sleep(3000);
	
String Titleofpage = 	driver.getTitle();
System.out.println("Title of page is " +Titleofpage);

String CurrntURL = driver.getCurrentUrl();
	
System.out.println("Currnet URL of page is " +CurrntURL);

driver.switchTo().window(PArentwindow);

String Titleis = driver.getTitle();
System.out.println("Title of page is " +Titleis);

String URLis =driver.getCurrentUrl();
System.out.println("URL of page is " +URLis);



	}
	
	@Test(enabled = false)
	
	// Switch to new browser Tab
	
	public void SwitchTab() throws InterruptedException
	
	
	
	{
		
		driver.findElement(By.linkText("Automation Practice Switch Windows")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[text() = 'New Browser Tab']")).click();
		Thread.sleep(3000);
		//User driver .getwindowhandles method to get the window id
		
	Set<String> Swicchtab = 	driver.getWindowHandles();
	Iterator<String> itr1 = Swicchtab.iterator();
	
	String Parentid = itr1.next();
	System.out.println("PArnet id is " +Parentid);
	
String childid = 	itr1.next();
System.out.println("Child id is " +childid);

driver.switchTo().window(childid);

String NewTitle = driver.getTitle();

System.out.println("Title is  " +NewTitle);

//switch to parent window

driver.switchTo().window(Parentid);

String URLnew = driver.getCurrentUrl();

System.out.println("New URL is " +URLnew);
	
	
	}
	
	
	@Test(enabled = false)
	//Javascript alert
	public void javaaler() throws Exception
	{
	
	driver.findElement(By.linkText("Automation Practice Switch Windows")).click();
	Thread.sleep(3000);
	
	driver.findElement(By.xpath("//button[text() = 'Alert Box']")).click();
	
	// To switch on alert we have a method stitch to aler
	
	Alert alt = driver.switchTo().alert();
	//Now get the text of alert box
	
	String AlertText = alt.getText();
	System.out.println("Alert text is " +AlertText);
	
	//To accept the alert
	
	//alt.accept();
	
	alt.dismiss();
	
	System.out.println("Alert not accepted");
	
	
	
	
	
	
	}
	
	@Test(enabled = false)
	
	public void Iframeswitch() throws Exception
	{
		driver.findElement(By.linkText("IFrame practice page")).click();
		
		String URLofPageis = driver.getCurrentUrl();
		System.out.println("URL of page is "+URLofPageis);
		
	String Titleofpageis =	driver.getTitle();
	
	System.out.println("Title of page is "+Titleofpageis);
	
Thread.sleep(2000);

driver.switchTo().frame(0);

driver.findElement(By.xpath("//span[text() = 'Katalon Studio Tutorial']")).click();

System.out.println("Click done");

driver.switchTo().defaultContent();

System.out.println(driver.getTitle());
	
	
	}
	
	
	@Test(enabled = false)
	
	//Right click, double click,Tooltip
	
	public void clickaction()
	{
		driver.findElement(By.linkText("Tooltip and Double click")).click();
		//title of page
		
	String	Titleofpage = driver.getTitle();
	System.out.println("Title of page is " +Titleofpage);
	
	//URL of page
	
	String URLofpage =driver.getCurrentUrl();
	System.out.println("URL of page is " +URLofpage);
	
	WebElement doubleclick = driver.findElement(By.id("doubleClickBtn"));
	
	Actions act = new Actions(driver);
	
	act.doubleClick(doubleclick).perform();
	
	System.out.println("Button is doubled clicked");
	
	Alert alrt = driver.switchTo().alert();
	String Textalert = alrt.getText();
	System.out.println("Text alert is " +Textalert);
	
	alrt.accept();
	
	System.out.println("Alert accepted");
	
	//Rightclick
	
	WebElement Rightclk = driver.findElement(By.id("rightClickBtn"));
	
	act.contextClick(Rightclk).perform();
	
	WebElement clickonedit = driver.findElement(By.xpath("//div[@id='rightclickItem']/div[1]"));
	
	clickonedit.click();
	
	System.out.println("Edit click done");
	
	Alert alertedit =driver.switchTo().alert();
	
	String EditText = alertedit.getText();
	
	System.out.println("Edit alert text is " +EditText);
	
	alertedit.accept();
	System.out.println("Accepted edit");
	
	//Mousehover Tooltip
	
	WebElement Tooltipdemo = driver.findElement(By.id("tooltipDemo"));
	
	act.moveToElement(Tooltipdemo).build().perform();
	String Gettextoftooltip = Tooltipdemo.getText();
	
	System.out.println("Tooltip text is " +Gettextoftooltip);
	
	
	
	
	
	
	}
	
	@Test(enabled = false)
	
	public void Tooltip() throws Exception
	{
		driver.findElement(By.linkText("Tooltip")).click();
		Thread.sleep(3000);
		
		Actions act1 = new Actions(driver);
		
		WebElement tootltipele = driver.findElement(By.id("age"));
		
		String tootltipat = tootltipele.getAttribute("title");
		
		System.out.println("Tool tip is " +tootltipat);
		
		//Assert.assertEquals(tootltipat, "Tool tip is We ask for your age only for statistical purposes.");
		System.out.println("Assertion passed");
	}
	
	
	@Test(enabled = false)
	
	public void DragDrop()
	{
		driver.findElement(By.linkText("Draggable")).click();
		
String Titleofpageis = 	driver.getTitle();

System.out.println("Title of page is "+Titleofpageis);

driver.findElement(By.linkText("Droppable")).click();

String NewTitle = driver.getTitle();

System.out.println("Title is " +NewTitle);

WebElement  Dragelement =driver.findElement(By.xpath("//p[text() = 'Drag me to my target']"));

WebElement Dropelement = driver.findElement(By.id("droppable"));

Actions actnew = new Actions(driver);

actnew.clickAndHold(Dragelement).dragAndDrop(Dragelement, Dropelement).build().perform();

System.out.println("Drag and drop done");

     
	}
	
	@Test(enabled = false)
	
	//C:\Users\DELL\eclipse-workspace\TestNGProject\SCreenshotCapture
	public void MenuSelect()
	{
		driver.findElement(By.linkText("Menu")).click();
		
	String Titleofpage = 	driver.getTitle();
	
	System.out.println("Title is " +Titleofpage);
	
	driver.findElement(By.xpath("//div[contains(text(),'Books')]")).click();
	System.out.println("Books clicked");
	
	WebElement Electronics = driver.findElement(By.xpath("//div[contains(text(),'Electronics')]"));
	
	Actions act = new Actions(driver);
	
	act.moveToElement(Electronics).build().perform();
	
	System.out.println("Move to electronis done");
	
	driver.findElement(By.xpath("//div[contains(text(),'Utilities')]")).click();
	
	System.out.println("Car hi fi done");
	
	
	}
	
	
	@Test(enabled = false)
	
	public void Screenshotverify() throws InterruptedException, Exception
	{
		driver.findElement(By.linkText("Dialog")).click();
		Thread.sleep(2000);
		
	//	Typecast webdriver instance to screenshot
		
		TakesScreenshot srcshot =((TakesScreenshot) driver);
		
		//call method getscreehsotas and save into File
		
		File Srcfile = srcshot.getScreenshotAs(OutputType.FILE);
		
		//where need to save that  screenshot
		
		File destfile = new File("C:\\Users\\DELL\\eclipse-workspace\\TestNGProject\\SCreenshotCapture.png");
		
		FileHandler.copy(Srcfile, destfile);
		
		
		
		
	}
	@Test
	
	public void Screenshotfailes() throws Exception
	
	{
		driver.findElement(By.linkText("Controlgroup")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.linkText("label")).click();
	}
	
	
	@Test
	
	public void Exceldataconnectivity()
	{
		
	}
	

	
	@AfterMethod(enabled = true)
	
	public void teardown(ITestResult result)
	{
		
		if(ITestResult.FAILURE == result.getStatus())
		{
			SCreenshotcapture.Screenhsotutil(driver, result.getName());
		}
		
		
		driver.close();
	}

}
