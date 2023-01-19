package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel2 {
public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		//step 1: Convert physical file to java readable object
		FileInputStream fis= new FileInputStream("./src/test/resources/testscriptdata.xlsx");
		
		//step 2: Open the Excel workbook
		//Import workbook from org.apache.poi.ss.usermodel
		//the below statement throws EncryptedDocumentException and IOException
		Workbook wb = WorkbookFactory.create(fis);
		System.out.println(wb.getSheet("Sheet1").getRow(3).getCell(0).getNumericCellValue());
		//step 3: single line statement to read the data
		String data = wb.getSheet("Sheet1").getRow(0).getCell(1).getStringCellValue();
		System.out.println(data);
		
		//step 4: close workbook
		wb.close();
}

}
