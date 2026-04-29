package finance.ddf_files;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Write_Data_Into_Excel {

	public static <fileoutputstream> void main(String[] args) throws IOException {
		// first create aa file input steam to eclispe 
         FileInputStream fis = new FileInputStream("F:\\All Downloads\\write_data_into_excel.xls");
         
        // create a workbook for the xls file
         HSSFWorkbook readable_workbook = new HSSFWorkbook(fis);
        
        // access the specified name by sheet 
         HSSFSheet readable_sheet = readable_workbook.getSheet("Sheet3");
         
                System.out.println("excecution started for the row 1");
          
         
                                                                   //  create the first row and set headers
         HSSFRow row0= readable_sheet.createRow(0);
         														   // wirte the data in the first cell (set header for first coloumn)
         HSSFCell r0c0 = row0.createCell(0);    // first create the cell 
         		  r0c0.setCellValue("Emd ID");  // secound write in the cell 
         HSSFCell r0c1 = row0.createCell(1);    // first create the cell
         		  r0c1.setCellValue("NAME");    // secound write in the cell
         HSSFCell r0c2 = row0.createCell(2);	// first create the cell
         		  r0c2.setCellValue("AGE");		// secound write in the cell
        
         		 System.out.println("excecution started for the row 2");       
         															// create the secound row and set the values
         HSSFRow row1 = readable_sheet.createRow(1);
         															// wirte the data in the first cell (set header for first coloumn)
         HSSFCell r1c0 = row1.createCell(0);    // first create the cell
                  r1c0.setCellValue("1000001"); // secound write in the cell
         HSSFCell r1c1 = row1.createCell(1);    // first create the cell      
                  r1c1.setCellValue("vinay");	// secound write in the cell
         HSSFCell r1c2 = row1.createCell(2);    // first create the cell     
           		  r1c2.setCellValue("30");		// secound write in the cell
           		  
           		System.out.println("excecution started for the row 3");
           		   													// create the third row and set the values
         HSSFRow  row2 = readable_sheet.createRow(2);           		   
         											         		// wirte the data in the first cell (set header for first coloumn)
         HSSFCell r2c0 = row2.createCell(0);    // first create the cell  
           		  r2c0.setCellValue("1000002"); // secound write in the cell
         HSSFCell r2c1 = row2.createCell(1);  	// first create the cell	   
           		  r2c1.setCellValue("sai");     // secound write in the cell
         HSSFCell r2c2 = row2.createCell(2);    // first create the cell
           		  r2c2.setCellValue("22"); 		// secound write in the cell
           		  
          		                                                    // create a fileoutstream to write the updated workbook back to the same file 
         FileOutputStream fos = new FileOutputStream("F:\\All Downloads\\write_data_into_excel.xls");		  
         
         															// write the changes to workbook 
         readable_workbook.write(fos);
                                                                    // close the output outpit stream and the workbook
         fos.close();
         fis.close();
         readable_workbook.close();
                                                                    // print confirmation message
         System.out.println("save the fis to fos");
         
         
         
	}

}
