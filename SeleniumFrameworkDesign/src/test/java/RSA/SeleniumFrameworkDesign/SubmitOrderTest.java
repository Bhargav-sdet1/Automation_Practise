package RSA.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RSA.pageObjects.CartPage;
import RSA.pageObjects.CheckoutPage;
import RSA.pageObjects.LoginPage;
import RSA.pageObjects.ProductCatalog;

public class SubmitOrderTest {
	
	public static void main(String[] args) throws InterruptedException
	{
		String ProductName="ADIDAS ORIGINAL";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Login
		LoginPage loginpage= new LoginPage(driver);
		loginpage.goTo();
		ProductCatalog productCatalog=loginpage.loginMeth("ram@yopmail.com", "Asdfg1@34");
		Thread.sleep(2000);
		List<WebElement> Products=productCatalog.getProductList();
		productCatalog.addProductToCart(ProductName);
		Thread.sleep(2000);
		CartPage cartPage=productCatalog.goToCart();
		
		//CartPage cartPage= new CartPage(driver);
		boolean match=cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.CheckoutButton();

		
		driver.findElement(By.cssSelector("[placeholder='Select Country']")).sendKeys("India");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.ta-item")));
	
		
		driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		WebElement placeOrder=driver.findElement(By.xpath("//*[@class='actions']//a"));
		js.executeScript("arguments[0].click();", placeOrder);
		
		String ConfirmMsg=driver.findElement(By.xpath("//td/h1")).getText();
		Assert.assertTrue(ConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		
		driver.close();	
		
	}

}
