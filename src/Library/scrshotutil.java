package Library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class scrshotutil {
	
	public static void ScreenshotUtil(WebDriver driver,String Screenshotname) throws Exception
	{
		TakesScreenshot tsc = ((TakesScreenshot) driver);
		
		File srcfile = tsc.getScreenshotAs(OutputType.FILE);
		
		File destination = new File("./SCreenshotCapture" +Screenshotname+ ".png");
		
		FileHandler.copy(srcfile, destination);
	}

}
