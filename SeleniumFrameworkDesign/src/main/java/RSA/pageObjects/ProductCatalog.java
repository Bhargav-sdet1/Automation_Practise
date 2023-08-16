package RSA.pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents{
	
	WebDriver driver;
	
	public ProductCatalog(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(css=".mb-3") List<WebElement> Products;
	@FindBy(css=".ng-animating") WebElement spinner;
	
	By productsBy=By.cssSelector(".mb-3");
	By addToCart= By.cssSelector(".w-10");
	By toastMsg=By.cssSelector("#toast-container");
	
	public List<WebElement> getProductList()
	{
		waitForElementToAppear(productsBy);
		return Products;
	}
	
	public WebElement getProductByName(String ProductName)
	{
		WebElement prod=getProductList().stream()
				.filter(product->product
				.findElement(By.cssSelector("b"))
				.getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	public void addProductToCart(String ProductName)
	{
		WebElement prod=getProductByName(ProductName);
		prod.findElement(addToCart).click();
		
		waitForElementToAppear(toastMsg);
		//waitForElementToDisappear(spinner);
		
		
	}
	

	

}
