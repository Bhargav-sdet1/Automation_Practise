package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSTableExample {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		
		int colSize=driver.findElements(By.xpath("//table[@name='courses']//th")).size();
		int rowSize=driver.findElements(By.xpath("//table[@name='courses']//tr")).size();
		System.out.println(colSize);
		System.out.println(rowSize);
		WebElement secondRow =driver.findElement(By.xpath("//table[@name='courses']//tr[3]"));
		System.out.println(secondRow.getText());
	}

}
