package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddProduct {
//	WebDriver is used to control the browser.
	WebDriver driver;
	
//	The constructor connects the browser (driver) to this class.
	public AddProduct(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
//		PageFactory.initElements(...) helps Selenium find elements on the page and link them to the fields below.
	}
	@FindBy (name = "productId")
	private WebElement productid;
	
	@FindBy (name = "productName")
	private WebElement productName;
	
	@FindBy (name = "productCategory")
	private WebElement productCategory;
	
	@FindBy (name = "quantity")
	private WebElement quantity;
	
	@FindBy (name = "price")
	private WebElement price;
	
	@FindBy (name = "vendorId")
	private WebElement vendorId;
	
	@FindBy (xpath = "//button[text()='Add']")
	private WebElement addprodBtn;
	
//	This method gives access to the Product ID field so we can type in it from the test script.
	public WebElement getProductid() {
		return productid;
	}

	public WebElement getProductName() {
		return productName;
	}

	public WebElement getProductCategory() {
		return productCategory;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddprodBtn() {
		return addprodBtn;
	}
	
	
}
