package RSA.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import RSA.AbstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css="[placeholder='Select Country']") WebElement CountryDd;
	//@FindBy(css="button.ta-item") WebElement SelectBtn;
	By SelectBtn = By.cssSelector("button.ta-item");
	@FindBy(xpath="//button[contains(@class,'ta-item')][2]") WebElement SelectCountry;
	
	public void CountrySelectDD(String Country)
	{
		CountryDd.sendKeys(Country);
		waitForElementToAppear(SelectBtn);
		SelectCountry.click();
	}
	
	public ConfirmationPage PlaceOrderButton()
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		WebElement placeOrder=driver.findElement(By.xpath("//*[@class='actions']//a"));
		js.executeScript("arguments[0].click();", placeOrder);
		
		return new ConfirmationPage(driver);
	
	}
	
}
