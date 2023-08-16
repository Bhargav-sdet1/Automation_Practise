package RSA.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import RSA.pageObjects.CartPage;
import RSA.pageObjects.CheckoutPage;
import RSA.pageObjects.ConfirmationPage;
import RSA.pageObjects.LoginPage;
import RSA.pageObjects.ProductCatalog;

public class SubmitOrderTest {
	
	public static void main(String[] args) throws InterruptedException
	{
		String ProductName="ADIDAS ORIGINAL";
		String Country="India";
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//Login
		LoginPage loginpage= new LoginPage(driver);
		loginpage.goTo();
		ProductCatalog productCatalog=loginpage.loginMeth("ram@yopmail.com", "Asdfg1@34");
		
		List<WebElement> Products=productCatalog.getProductList();
		productCatalog.addProductToCart(ProductName);
		Thread.sleep(3000);
		CartPage cartPage=productCatalog.goToCart();
		
		Boolean match=cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.CheckoutButton();
		checkoutPage.CountrySelectDD(Country);
		ConfirmationPage confirmationpage=checkoutPage.PlaceOrderButton();
		String ConfirmMsg=confirmationpage.GetConfirmMsg();
		Assert.assertTrue(ConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
		driver.close();	
		
	}

}
