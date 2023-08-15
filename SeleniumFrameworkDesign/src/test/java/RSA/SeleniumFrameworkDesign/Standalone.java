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

public class Standalone {
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Login
		driver.findElement(By.id("userEmail")).sendKeys("ram@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Asdfg1@34");
		driver.findElement(By.name("login")).click();
		
		//Locating all products
		
		//List<WebElement> allProducts=driver.findElements(By.xpath("//div[contains(@class,'mb-3')]"));
		
		/*WebElement prod=allProducts.stream()
		.filter(product->product
		.findElement(By.xpath("//div[contains(@class,'mb-3')]//b"))
		.getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);*/
		//prod.findElement(By.xpath("//button[contains(@class,'w-10')]")).click();
		String addedProduct="ADIDAS ORIGINAL";
		List<WebElement> allProducts=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=allProducts.stream()
				.filter(product->product
				.findElement(By.cssSelector("b"))
				.getText().equals(addedProduct)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".w-10")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
		
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		
		List<WebElement> cartItems=driver.findElements(By.cssSelector(".infoWrap"));
		Boolean bool=cartItems.stream().anyMatch(pro->pro.findElement(By.cssSelector("h3")).getText().equals(addedProduct));
		Assert.assertTrue(bool);
		driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
		
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
