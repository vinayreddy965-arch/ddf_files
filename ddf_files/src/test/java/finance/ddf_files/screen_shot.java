package finance.ddf_files;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;


public class screen_shot {

	public static void main(String[] args) throws IOException{
		// open browser
				 
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));		  
		// navigate to URL
		  
		  driver.get("https://www.youtube.com/");
		  
		// create screenshot location where our screenshot need to be generated  
		  
		// create an object for where our screenshots need to generate
		  String path = "F:\\All Downloads\\vinayimage.jpg";
		  
		  File desired_location = new File(path);
		  
	    //  take the screenshot when ever the teat case is failed
		 
		  File copy_screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		  
		// screenshot should saved to the desired location
		 
		  FileHandler.copy(copy_screenshot, desired_location);
		  System.out.println("screenshot taken");
		  driver.close();
	}

}
