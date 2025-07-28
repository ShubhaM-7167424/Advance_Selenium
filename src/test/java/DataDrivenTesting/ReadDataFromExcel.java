package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.sql.RowId;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromExcel {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
//		 This line opens the Excel file located in the TestData folder
		FileInputStream fis = new FileInputStream("./TestData/TestScriptDataAdv.xlsx");
//		Creates a Workbook object to access Excel content. WorkbookFactory.create() handles both .xls and .xlsx formats.
		Workbook wb = WorkbookFactory.create(fis);
		
		Sheet sh = wb.getSheet("Sheet1");
		Row row = sh.getRow(1);
		String Campname = row.getCell(2).getStringCellValue();
		String size = row.getCell(3).getStringCellValue();
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.get("https://www.instagram.com/");
//		driver.findElement(By.name("username")).sendKeys(UN);
//		driver.findElement(By.name("password")).sendKeys(PW);
		
	}	
}
