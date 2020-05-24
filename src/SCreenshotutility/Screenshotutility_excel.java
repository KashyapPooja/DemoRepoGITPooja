package SCreenshotutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public  class Screenshotutility_excel {
	
	
	
	public static void captureScreenshot(WebDriver driver,String Screenshotname)
	{
	try {
		TakesScreenshot TSC = 	((TakesScreenshot) driver);
		
		File filescrn = TSC.getScreenshotAs(OutputType.FILE);
		
		File Destination = new File("./Screenshotcapture_ExcelFailedtestcase"  +Screenshotname+ ".png");
		
		FileHandler.copy(filescrn, Destination);
		
	} 
	
	catch (IOException  e) {
		
		e.printStackTrace();
		System.out.println(e.getMessage());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}

}
