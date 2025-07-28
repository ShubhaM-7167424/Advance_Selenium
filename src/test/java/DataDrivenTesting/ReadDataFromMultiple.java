package DataDrivenTesting;

import java.io.FileInputStream;

import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromMultiple {

	public static void main(String[] args) throws IOException {
//		 Opens the Excel file located in the TestData folder.
		FileInputStream fis = new FileInputStream("./TestData/MultipleRowsData.xlsx");
//		 Reads the Excel file into a Java object called wb (Workbook = whole Excel file).
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		int rowcount = sh.getLastRowNum();
		System.out.println(rowcount);
		for (int row = 1; row <= rowcount; row++) {
			String productcategory = sh.getRow(row).getCell(0).getStringCellValue();
			String productname = sh.getRow(row).getCell(1).getStringCellValue();
			
			System.out.println(productcategory + "===" + productname);
		}
		
	}

}
