package testcases;

import java.io.IOException;
import java.time.Duration;

import org.apache.commons.compress.archivers.cpio.CpioArchiveEntry;
import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.AddProduct;
import POM.HomePage;
import POM.LoginPage;
import ProrpertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;
@Listeners(listenersUtility.ListenersImplementation.class)

public class CreateProductTest extends BaseClass{
	@Test
	public void createProduct() throws InterruptedException, EncryptedDocumentException, IOException {
	
		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();
		
//		Reading data From excel
		String pname = eutil.getDataFromExcel("Product", 1, 2);
		String psize = eutil.getDataFromExcel("Product", 1, 3);
		String pprice = eutil.getDataFromExcel("Product", 1, 4);
//		int ran = jutil.getRandomNumber();
		String  ProductName = pname ;

//		click on create product button
		HomePage hp = new HomePage(driver);
		hp.getProducts().click();
		Thread.sleep(2000);
		hp.getAddProduct().click();


		AddProduct ap = new AddProduct(driver);
		ap.getProductid();
		
		ap.getProductName().sendKeys(ProductName);
		ap.getQuantity().clear();
		ap.getQuantity().sendKeys(psize);
		ap.getPrice().clear();
		ap.getPrice().sendKeys(pprice);
		
		wutil.select(ap.getProductCategory(), 2);
		wutil.select(ap.getVendorId(), 3);
		ap.getAddprodBtn().click();
		
		Thread.sleep(2000);
//		close the toast message
		hp.getClosemsg().click();
		

	}

}
