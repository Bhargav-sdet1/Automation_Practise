package RSA.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RSA.AbstractComponents.AbstractComponents;

public class LoginPage extends AbstractComponents{
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail") WebElement Uname;
	@FindBy(id="userPassword") WebElement Upassword;
	@FindBy(id="login") WebElement LoginButton;
	@FindBy(css="[class*='flyInOut']") WebElement ErrorLogin;

	
	public ProductCatalog loginMeth(String UserEmail, String UserPassword)
	{
		Uname.sendKeys(UserEmail);
		Upassword.sendKeys(UserPassword);
		LoginButton.click();
		ProductCatalog productCatalog= new ProductCatalog(driver);
		return productCatalog;
	}
	public void goTo()
	{
		driver.get("https://rahulshettyacademy.com/client/");

	}
	
	public String getErrorMsg()
	{
		waitForElementToAppear(ErrorLogin);
		return ErrorLogin.getText();
	}
	

}
