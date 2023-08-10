package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDropdownEx {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//*[@id='autocomplete']"));
		ele.click();
		ele.sendKeys("Ind");
		
		List<WebElement> dropEle=driver.findElements(By.xpath("//li[@class='ui-menu-item']"));
		for(WebElement x:dropEle)
		{
			System.out.println(x.getText());
			Thread.sleep(3000);
			if(x.getText()=="India")
			{
				x.click();
			}
		}
		
	}

}
