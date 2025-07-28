package WebDriverUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;
import java.util.logging.FileHandler;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
//	WebDriver driver = new EdgeDriver();
	
	public void waitForPageToLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}	
	public void waitforVisibilityofElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void switchToFrame(WebDriver driver, int index) {
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver, String nameorId) {
		driver.switchTo().frame(nameorId);
	}
	public void switchToFrame(WebDriver driver, WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public void switchToAlertAndAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void switchToAlertAndDismiss(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String switchToAlertAndgetText(WebDriver driver) {
		String text = driver.switchTo().alert().getText();
		return text;
	}
	public void switchToAlertAndSendKeys(WebDriver driver, String text) {
		driver.switchTo().alert().sendKeys(text);
	}
	public void select(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void select(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void select( String text,WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);;
	}
	public void mouseHoverOnWebElement(WebDriver driver, WebElement element) {
		Actions  actions = new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void clickOnWebElement(WebDriver driver, WebElement element) {
		Actions  actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
	}
	public void doubleclickOnWebElement(WebDriver driver, WebElement element) {
		Actions  actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void rightclickOnWebElement(WebDriver driver, WebElement element) {
		Actions  actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void passInput(WebDriver driver, WebElement element, String text) {
		Actions  actions = new Actions(driver);
		actions.click(element).sendKeys(text).perform();
	}
	public void switchToWindow(WebDriver driver) {
		Set<String> allWindowId = driver.getWindowHandles();
		for (String id : allWindowId) {
			driver.switchTo().window(id);
		}
	}
	public void takesScreenshot(WebDriver driver, String filename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		 File temp = ts.getScreenshotAs(OutputType.FILE);
		 File perm = new File("./errorShots" + filename + ".png");
		 org.openqa.selenium.io.FileHandler.copy(temp, perm);
	}
	public void toscrollby(WebDriver driver, int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("Windows.scrollBy("+x+" ," +y+")");
	}
	
}
