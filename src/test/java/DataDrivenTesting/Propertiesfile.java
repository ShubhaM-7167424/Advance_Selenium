package DataDrivenTesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Propertiesfile {

	public static void main(String[] args) throws IOException {
//		Reads the .properties file from the ConfigData folder. This file contains key-value pairs like Browser, url, etc.
		FileInputStream fis = new FileInputStream("./ConfigData/ninzaCrmCommondata.properties");
//		create object of properties file
		Properties prop = new Properties();
//		A Properties object is created to hold the data, and all keys from the file are loaded into memory.
		prop.load(fis);
//		Extracts individual values from the properties file
		String BROWSER = prop.getProperty("Browser");
		String URL = prop.getProperty("url");
		String USERNAME = prop.getProperty("Username");
		String PASSWORD = prop.getProperty("Password");
		
//		 Initializes a WebDriver variable to be used later.		
		WebDriver driver = null;

//		 Depending on the value of BROWSER (from the properties file), it launches the appropriate browser.
		if(BROWSER.equals("Edge")) {
			driver = new EdgeDriver();
		}
		if(BROWSER.equals("Chrome")) {
			driver = new ChromeDriver();
		}
		if(BROWSER.equals("Firefox")) {
			driver = new FirefoxDriver();
		}
		
//		actual script
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(URL);
		driver.findElement(By.id("username")).sendKeys(USERNAME);
		driver.findElement(By.id("inputPassword")).sendKeys(PASSWORD);
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		
	}

}
