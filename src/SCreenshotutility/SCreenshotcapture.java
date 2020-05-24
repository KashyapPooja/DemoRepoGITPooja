package SCreenshotutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class SCreenshotcapture {
	

	
	public static  void Screenhsotutil(WebDriver driver,String Screenshotname)
	
	{
		//C:\Users\DELL\eclipse-workspace\TestNGProject\SCreenshotCapture
		try {
	TakesScreenshot scr = 	((TakesScreenshot) driver);
	
File source = scr.getScreenshotAs(OutputType.FILE);

File Destination = new File("./SCreenshotCapture/" +Screenshotname+ ".png");

FileHandler.copy(source, Destination);
		}
		
catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	
	System.out.println(e.getMessage());
}
		
	}

}
