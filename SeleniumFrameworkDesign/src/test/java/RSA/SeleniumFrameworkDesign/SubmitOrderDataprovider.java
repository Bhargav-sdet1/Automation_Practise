package RSA.SeleniumFrameworkDesign;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RSA.TestComponents.BaseTest;
import RSA.pageObjects.CartPage;
import RSA.pageObjects.CheckoutPage;
import RSA.pageObjects.ConfirmationPage;
import RSA.pageObjects.LoginPage;
import RSA.pageObjects.ProductCatalog;

public class SubmitOrderDataprovider extends BaseTest{
		
	@Test(dataProvider="setData",groups= {"Regression"})
	public void SubmitOrder(HashMap<String,String> input) throws InterruptedException, IOException
	{
		String ProductName=input.get("email");
		String Country="India";
		ProductCatalog productCatalog=loginpage.loginMeth(input.get("email"), input.get("password"));
		
		List<WebElement> Products=productCatalog.getProductList();
		productCatalog.addProductToCart(input.get("product"));
		Thread.sleep(3000);
		CartPage cartPage=productCatalog.goToCart();
		
		Boolean match=cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.CheckoutButton();
		checkoutPage.CountrySelectDD(Country);
		ConfirmationPage confirmationpage=checkoutPage.PlaceOrderButton();
		String ConfirmMsg=confirmationpage.GetConfirmMsg();
		Assert.assertTrue(ConfirmMsg.equalsIgnoreCase("THANKYOU FOR THE ORDER."));	
	}
	
	@DataProvider
	public Object[][] setData()
	{
		/*
		 * HashMap<String, String> map = new HashMap<String,String>(); map.put("email",
		 * "ram@yopmail.com"); map.put("password", "Asdfg1@34"); map.put("product",
		 * "ADIDAS ORIGINAL");
		 * 
		 * HashMap<String, String> map1 = new HashMap<String,String>();
		 * map1.put("email", "nov9@yopmail.com"); map1.put("password", "Asdfg1@34");
		 * map1.put("product", "ZARA COAT 3"); return Object[][] {{map},{map1}};
		 */
		 return new Object[][]{{"ram@yopmail.com","Asdfg1@34","ADIDAS ORIGINAL"},{"nov9@yopmail.com","Asdfg1@34","ZARA COAT 3"}};
	}
	//

}
