package testcases;

import org.apache.poi.EncryptedDocumentException;
import org.checkerframework.framework.qual.FromByteCode;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import ExcelFileUtility.ExcelUtility;
import JavaUtility.JavaUtility;
import POM.CampaignPage;
import POM.HomePage;
import POM.LoginPage;
import ProrpertiesFileUtility.PropertiesUtility;
import WebDriverUtility.WebDriverUtility;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;
@Listeners(listenersUtility.ListenersImplementation.class)
public class CreateCampaignTest extends BaseClass {
	@Test (groups = "Smoke")
	public void createcampaign() throws EncryptedDocumentException, IOException, InterruptedException {

		ExcelUtility eutil = new ExcelUtility();
		WebDriverUtility wutil = new WebDriverUtility();
		JavaUtility jutil = new JavaUtility();

//		 Reading data From excel
		String campname = eutil.getDataFromExcel("Campaign", 1, 2);
		String size = eutil.getDataFromExcel("Campaign", 1, 3);
//		int ran = jutil.getRandomNumber();
		String  CampaignName = campname;
		
//		Click on create campaign button
		HomePage hp = new HomePage(driver);
		hp.getCreatecampaign().click();
		
//		enter mandatory fields
		CampaignPage cp = new CampaignPage(driver);
		cp.getCampaignName().sendKeys(CampaignName);
		cp.getTargetsizeTF().sendKeys(size);
		cp.getCreatecampaignSubmitBtn().click();

//        validation
		Thread.sleep(2000);
		WebElement toast = driver.findElement(By.xpath("//div[@role='alert']"));
		Thread.sleep(2000);
		
		wutil.waitforVisibilityofElement(driver, toast);
		
		String msg = toast.getText();

//		if (msg.contains(campname)) {
//			System.out.println("campaign is created");
//		} else {
//			System.out.println("campaign is not created");
//		}
		
		Assert.assertEquals(msg, "Campaign " + CampaignName + " Successfully Added");
//		Assert.assertTrue(msg.contains(campname));
		driver.findElement(By.xpath("//button[@aria-label='close']")).click();

	}
}
