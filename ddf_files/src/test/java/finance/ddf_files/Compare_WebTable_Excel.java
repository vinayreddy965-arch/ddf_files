package finance.ddf_files;





                    //vinay 



import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Compare_WebTable_Excel {
	WebDriver driver;
	
	@BeforeClass
	public void openBrowser() {
	// open the browser 
	driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
    driver.get("https://letcode.in/dropdowns?utm_source=chatgpt.com");
}
	
	
	@Test
	public void RunProgram() {
		
		// here first we need to find the dropdown 
		WebElement dropdown = driver.findElement(By.id("fruits"));
		
		// now we need to find the dropdown list
		List<WebElement> dropdowncount = dropdown.findElements(By.tagName("option"));
		
		// from the dropdown i need to print hte list 
		System.out.println(dropdowncount.size()); //6
		
		String filepath = "F:\\All Downloads\\vinay.xlsx";
		
		try (FileInputStream fis = new FileInputStream(filepath)){
			System.out.println("File loaded successfully!");
			
			// if we are woking with the xls then go for the hssf , get the work book from the excel
		    XSSFWorkbook workbook = new XSSFWorkbook(fis);
			workbook.close();
			//get the sheet from the workbook
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			// here we need to take the last row number
		    int  total_rows = sheet.getLastRowNum()+1;
		    
		    System.out.println("line no 57  "+total_rows);
			System.out.println("just to know how many physical rows it will print :-              "+sheet.getPhysicalNumberOfRows());
			// we need to create the memery space so that we can store the excel data to arraylist
			// create array list in browser application 
						ArrayList<String> ddvalues = new ArrayList<String>();
									for (int j=0; j<dropdowncount.size(); j++)
									
						{
										ddvalues.add(dropdowncount.get(j).getText());			
									
						}
			
			// create array list values for excel sheet 
			ArrayList<String> excelvalues = new ArrayList<String>();
						for (int i=0; i<total_rows; i++)
			{
				// read the data from the excel sheet,,,,,,,, here to that memory space we need to add the data from excel and compare with the application
				excelvalues.add(sheet.getRow(i).getCell(i).getStringCellValue());
				
				
			}
						System.out.println("line no 69 "+excelvalues);
			
			            
			if (total_rows ==dropdowncount.size())
			
			{
				for (int k=0; k<total_rows; k++) {
					
					  for (int l=0; l<dropdowncount.size(); l++) {
						  
						  if (excelvalues.get(k).equals(ddvalues.get(l))) {
							  
							  System.out.println(excelvalues.get(k)+   "is matching with the application data");
							  
							  break;
							  
						  }
					  }		
				}	
			}
			}
		catch (IOException e)
		
		{
			System.out.println("File not loaded !"+ e.getMessage());	
		}
		
	}	
	// here we need to use thissssssssssss
	
	@AfterClass
     public void CloseBrowser() {
		
		driver.close();	
		// hai
		
	}

}











