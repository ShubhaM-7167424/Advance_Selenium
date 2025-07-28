package testcases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Facebook {
	public static void main(String[] args) throws IOException, InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		for(int i=1; i<=3; i++)
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File("./screenshots/facebook_" + i + ".png");
			FileHandler.copy(src, dest);
		
	        System.out.println("Screenshot " + i + " taken");
			
			Thread.sleep(3000);
		}
		driver.quit();
		
	}
}
