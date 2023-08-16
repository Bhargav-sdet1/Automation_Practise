package RSA.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RSA.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".infoWrap") List<WebElement> cartProducts;
	@FindBy(css=".totalRow .btn-primary") WebElement checkoutele;
	
	public boolean VerifyProductDisplay(String ProductName)
	{
		Boolean match = cartProducts.stream().anyMatch(product->product.getText()
				.equalsIgnoreCase(ProductName));
		return match;
	}
	
	public CheckoutPage CheckoutButton()
	{
		checkoutele.click();
		CheckoutPage checkoutPage = new CheckoutPage(driver);
		return checkoutPage;
	}
	
}
