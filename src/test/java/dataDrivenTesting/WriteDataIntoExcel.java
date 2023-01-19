package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		 Row r = sh.getRow(3);
		 //creates new cell by deleting older data from the cell
		Cell c= r.createCell(1);
		
		//writes data into the cell
		c.setCellValue("Hi");
		
		//saves data into excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testscriptdata.xlsx");
		 
		wb.write(fos);
		wb.close();
		
	}

}
