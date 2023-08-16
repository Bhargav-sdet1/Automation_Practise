package RSA.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import RSA.AbstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents{
	WebDriver driver;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="li .infoWrap") List<WebElement> cartProducts;
	@FindBy(css=".totalRow .btn-primary") WebElement checkoutele;
	By productTxt = By.cssSelector("li .infoWrap h3");
	
	public Boolean VerifyProductDisplay(String ProductName)
	{
		Boolean match=cartProducts.stream().anyMatch(pro->pro.findElement(productTxt)
				.getText().equals(ProductName));
		return match;
	}
	
	public CheckoutPage CheckoutButton()
	{
		checkoutele.click();
		return new CheckoutPage(driver);
	}
	
}
