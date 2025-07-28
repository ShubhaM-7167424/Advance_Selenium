package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		 Opens the Excel file from your system so Java can read and edit it.
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\shubh\\OneDrive\\Desktop\\SELENIUM FILES\\instagram.xlsx");
//		 Converts the Excel file into a Workbook object (the entire Excel file)
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet("Sheet2");

//	     Check if row exists. If not, create it.
		Row row = sheet.getRow(5);
		if (row == null) {
			row = sheet.createRow(5);
			System.out.println(row);
		}
		Cell cell = row.createCell(10);
		cell.setCellValue("Samu");

//		 Prepares to save/write changes back to the original Excel file
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\shubh\\OneDrive\\Desktop\\SELENIUM FILES\\instagram.xlsx");
//		 Actually writes all changes into the Excel file.
		wb.write(fos);
		wb.close();
	}

}
