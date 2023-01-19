package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataCompletelyIntoNewRow {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		
		//Creates new row by deleting older values
		 Row r = sh.createRow(4);
		 
		 //creates new cell by deleting older data from the cell
		Cell c= r.createCell(0);
		
		//writes data into the cell
		c.setCellValue("Hi");
		
		//saves data into excel
		FileOutputStream fos = new FileOutputStream("./src/test/resources/testscriptdata.xlsx");
		 
		wb.write(fos);
		wb.close();
		
	}
}
