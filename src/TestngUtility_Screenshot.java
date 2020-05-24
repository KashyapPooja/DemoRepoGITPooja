import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class TestngUtility_Screenshot {
	
	
	public void Utitlitysc(WebDriver driver,String Screenshotname ) throws Exception
	{
		TakesScreenshot scrshot = ((TakesScreenshot) driver);
		
		File Source_file = scrshot.getScreenshotAs(OutputType.FILE);
		
		File DEstination = new File("./SCreenshotCapture/" +Screenshotname+ ".png");
		
		FileHandler.copy(Source_file, DEstination);
	}

}
