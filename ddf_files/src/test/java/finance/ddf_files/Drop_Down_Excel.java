package finance.ddf_files;





               //  chat gpt 




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

public class Drop_Down_Excel {
    WebDriver driver;

    @BeforeClass
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        driver.get("https://letcode.in/dropdowns?utm_source=chatgpt.com");
    }

    @Test
    public void RunProgram() {
        WebElement dropdown = driver.findElement(By.id("fruits"));
        List<WebElement> dropdownOptions = dropdown.findElements(By.tagName("option"));

        System.out.println("Dropdown options count: " + dropdownOptions.size());

        String filepath = "F:\\All Downloads\\vinay.xlsx";  // Make sure it's .xlsx, not .xls

        try (FileInputStream fis = new FileInputStream(filepath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            System.out.println("File loaded successfully!");

            XSSFSheet sheet = workbook.getSheet("Sheet1"); 
            int totalRows = sheet.getLastRowNum() + 1;

            System.out.println("Total rows in Excel: " + totalRows);

            // Read dropdown values from browser
            ArrayList<String> ddValues = new ArrayList<>();
                        for (WebElement option : dropdownOptions)
            	
            {
                ddValues.add(option.getText().trim());
                
            }

            // Read Excel values
            ArrayList<String> excelValues = new ArrayList<>();
            for (int i = 0; i < totalRows; i++) {
                if (sheet.getRow(i) != null && sheet.getRow(i).getCell(0) != null) {
                    String cellValue = sheet.getRow(i).getCell(0).getStringCellValue().trim();
                    excelValues.add(cellValue);
                } else {
                    System.out.println("Skipping empty or null row at index: " + i);
                }
            }

            System.out.println("Excel values: " + excelValues);

            // Compare dropdown and Excel values
            if (excelValues.size() == ddValues.size()) {
                for (String excelVal : excelValues) {
                    if (ddValues.contains(excelVal)) {
                        System.out.println(excelVal + " is matching with the application data.");
                    } else {
                        System.out.println(excelVal + " is NOT matching with the application data.");
                    }
                }
            } else {
                System.out.println("Mismatch in count: Excel(" + excelValues.size() + ") vs Dropdown(" + ddValues.size() + ")");
            }

        } catch (IOException e) {
            System.out.println("File not loaded! " + e.getMessage());
        }
    }

    @AfterClass
    public void CloseBrowser() {
        //driver.quit();
    }
}
