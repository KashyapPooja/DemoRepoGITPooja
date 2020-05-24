package Library;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

public class utitlty {
	
	public static void Screenshotcapture_Utility(WebDriver driver,String ScreenshotName)
	{
		try {
			TakesScreenshot TS = 	(TakesScreenshot)driver;
			
			File Source = TS.getScreenshotAs(OutputType.FILE);
			
			FileHandler.copy(Source, new File("./SCreenshotCapture/" +ScreenshotName+ ".png"));
		} 
		
		catch (Exception e) {
			
			e.printStackTrace();
			
			System.out.println("Screenshot captured " +e.getMessage());
	
		
	}
	}

}
