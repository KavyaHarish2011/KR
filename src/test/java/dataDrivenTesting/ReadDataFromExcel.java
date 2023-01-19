package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step 1: Convert physical file to java readable object
		FileInputStream fis= new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		
		//step 2: Open the Excel workbook
		//Import workbook from org.apache.poi.ss.usermodel
		//the below statement throws EncryptedDocumentException and IOException
		Workbook wb = WorkbookFactory.create(fis);
		
		//step 3: Get control over specific sheet
		Sheet s = wb.getSheet("Sheet1");
		
		//step 4: Get control over specific row
		Row r = s.getRow(0);
		
		//step 5: Get control over specific cell
		Cell c = r.getCell(1);
		
		//step 6: Fetch Data from cell
		System.out.println(c.getStringCellValue());
		
		//step 7: close workbook
		wb.close();
		
	}

}
