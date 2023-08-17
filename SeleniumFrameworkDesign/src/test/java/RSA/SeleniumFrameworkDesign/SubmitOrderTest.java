package RSA.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import RSA.TestComponents.BaseTest;
import RSA.pageObjects.CartPage;
import RSA.pageObjects.CheckoutPage;
import RSA.pageObjects.ConfirmationPage;
import RSA.pageObjects.LoginPage;
import RSA.pageObjects.ProductCatalog;

public class SubmitOrderTest extends BaseTest{
	
	@Test
	public void SubmitOrder() throws InterruptedException, IOException
	{
		String ProductName="ADIDAS ORIGINAL";
		String Country="India";
		LoginPage loginpage=LauchApplication();
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
