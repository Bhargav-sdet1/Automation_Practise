package RSA.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
		
		List<WebElement> allProducts=driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod=allProducts.stream()
				.filter(product->product
				.findElement(By.cssSelector("b"))
				.getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".w-10")).click();
		
	}

}
