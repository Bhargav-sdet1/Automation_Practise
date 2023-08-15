package RSA.SeleniumFrameworkDesign;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Standalone {
	
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();		
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Login
		driver.findElement(By.id("userEmail")).sendKeys("nov9@yopmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Asdfg1@34");
		driver.findElement(By.name("login")).click();
		
	}

}
