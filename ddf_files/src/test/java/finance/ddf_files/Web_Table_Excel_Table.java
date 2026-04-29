package finance.ddf_files;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Web_Table_Excel_Table 
{   WebDriver driver;
	@BeforeClass
	public void openbrowser()
	{
	// open the browser 
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		driver.get("https://www.techlistic.com/2017/02/automate-demo-web-table-with-selenium.html");
		
	}
	@Test
	public void verify_webtable_data () throws IOException 
	{
	
															//HERE FIRST WE NEED TO IDENTIFY THE WEBTABLE AND GET THE SIZE OF WEB TABLE 
		
    // get total rows in the webtable 
        int W_totalrows = driver.findElements(By.xpath("//table[@id='customers']//tr")).size();
		System.out.println("total no of rows "+ W_totalrows);
		
	// get total coloumns in the webtable 	
		int W_totalcoloumns = driver.findElements(By.xpath("//table[@id='customers']//th")).size();
		System.out.println("total no of coloumns "+ W_totalcoloumns);		
		
	                                                        // SECOUND WE NEED TO READ THE EXCEL AND GET THE SIZE OF EXCEL TABLE
	// read the excel file
		
		FileInputStream	fis = new FileInputStream("F:\\All Downloads\\webtable.xlsx");
	
	// now get the workbook from file input steam
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("Sheet1");
	
	// get total no of rows and coloumns from the excel sheet
		
		int E_rows = sheet.getPhysicalNumberOfRows();
		int E_coloumns = sheet.getRow(0).getLastCellNum();
		System.out.println("total no of rows in excel sheet "+ E_rows);
		System.out.println("total no of coloumns in excel sheet "+E_coloumns);
		int E_totalrowscoloumns =  E_rows*E_coloumns;
		System.out.println("total no of rows and coloumns in excel sheet "+E_totalrowscoloumns);
		
															// NOW WE NEED TO CREATE THE ARRAYLIST(MEMORY SPACE) FOR EXCEL VALUES AND WEB TABLE
		
	// create an array list 
		
		ArrayList<String>  webtable = new ArrayList<String>();
		ArrayList<String>  exceltable = new ArrayList<String>();
		
	// read and store excel data in the array list 
		
		for (int i=0; i< E_rows; i++) 
		{
			for (int j=0; j< E_coloumns; j++) 
			{
				String exceldata = sheet.getRow(i).getCell(j).getStringCellValue();
			    exceltable.add(exceldata);
			    System.out.println("data present in the excel   "+exceldata);
			    
			}
		}
	// read and store web table data in the array list
		
		String cellxpath; //✅ declare first 
		
		
		for (int k=1; k<= W_totalrows; k++) 
		{
			for (int l=1; l<= W_totalcoloumns; l++) 
			{
				if (k == 1) 
				{
					 cellxpath = "//*[@id=\"customers\"]/tbody/tr["+k+"]/th["+l+"]";
				}else 
				{
					cellxpath = "//*[@id=\"customers\"]/tbody/tr["+k+"]/td["+l+"]";
				}
				
				String webdata = driver.findElement(By.xpath(cellxpath)).getText();
				webtable.add(webdata);
				System.out.println("data present in the webtable=  "+webtable);
			}
		}
		
	
															// COMPARE WEB TABLE WITH EXCEL DATA 
		
	// now we need to compare the webtable with excel data 
		
		System.out.println("******************************** compare webtable data with excel data table************************************");
		 
		
		int webtotaltablecount = W_totalrows*W_totalcoloumns; 
		System.out.println("*total count in the web table *=  "+ webtotaltablecount);
     
		for (int m=0; m< webtotaltablecount;  m++) 
		{
			if (webtable.get(m).equals(exceltable.get(m))) 
			{
				System.out.println(webtable.get(m)+"     MATCHED      "+exceltable.get(m) );
			}else 
			     {
				System.out.println(webtable.get(m)+"    NOT MATCHED    "+exceltable.get(m) ); 
			     }
			
		}
	// close the workbook 	
		workbook.close();
		fis.close();
	}
	@AfterClass
	public void closebrowser() 
	{
		driver.quit();
	}
}
