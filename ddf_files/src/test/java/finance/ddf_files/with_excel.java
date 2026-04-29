package finance.ddf_files;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class with_excel {
	WebDriver driver;
	@BeforeClass
	public void OpenBrowser() {
	// open the browser 
				driver = new ChromeDriver();
	            driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
	            driver.get("https://www.saucedemo.com/");
	            
	            
	}            
	@Test
	public void LoginWithExccelData() throws IOException {
		// file inptu stream is used to access the excel file to eclipse
		String filepath = "F:\\All Downloads\\vinay.xls";
		
		
		try (FileInputStream fis = new FileInputStream(filepath))													// fileinputstream?
		{    
			System.out.println("File loaded successfully!");
			
			// get the workbook from excel (HSSF means 'horrible spread sheet format')
			
			HSSFWorkbook workbook = new HSSFWorkbook(fis);	// if we are working with the xlsx fole we need to change the (HSSFworkbook) to (Xssfworkbook)														// HSSF ?
			
			// get the sheet from the workbook 
			
			HSSFSheet sheet = workbook.getSheet("Sheet1"); // here also we need to chage 																// getsheetat()
			
			// get the data from the excel cells   1 st row 
			
			String   username = sheet.getRow(1).getCell(0).getStringCellValue();    /* if there is aa value in cell ---> it is (abcd)       then getStringCellValue();
																					 if there is aa value in cell ---> it is (1234) 		then getintegerCellValue();
									 												 if there is aa value in cell ---> it is (abcd1234)     then getStringCellValue();
																					 if there is aa value in cell ---> it is (true)		    then getbooleancellvalue();
																					 if there is aa value in cell ---> it is (20/11/1994) 	then getdatecellvelue();
																				    */
			// get the data from the excel cells  2 nd row
			String   password = sheet.getRow(1).getCell(1).getStringCellValue();
			
			
            
            // enter the username
            driver.findElement(By.id("user-name")).sendKeys(username);
            
            // enter the password
            driver.findElement(By.id("password")).sendKeys(password);
            
            // Click on Login button
            driver.findElement(By.id("login-button")).click();
            
            
            workbook.createSheet("vinay"); 
            workbook.close();
            
		}catch (FileNotFoundException e) {
			System.out.println(e);
  	}
		
		
	
		
		
}
	@AfterClass	
	public void close() {
	   
	        driver.quit();
	   
	}

	}