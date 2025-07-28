package ExcelFileUtility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

//Getting data from single row
public class ExcelUtility {
	public String getDataFromExcel(String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
//		 Create an object of FileInputStream to read the Excel file
		FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
//		"Now take the opened file (Excel) and convert it into a Java object called Workbook, so that I can easily work with sheets, rows, and cells in it."
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		wb.close();
		return data;
	}

//Getting data from multiple row	
	public int togetRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./TestData/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowcount;
	}
}
