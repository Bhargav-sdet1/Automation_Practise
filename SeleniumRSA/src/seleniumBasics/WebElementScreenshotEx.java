package seleniumBasics;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class WebElementScreenshotEx {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		
		WebElement ele=driver.findElement(By.xpath("//*[@id='autocomplete']"));
		ele.sendKeys("India");
		
		File file=ele.getScreenshotAs(OutputType.FILE);	
		Files.copy(file,new File("C:\\Bhargav\\Automation_Practise\\SeleniumRSA\\Screenshot\\logo.png"));

	}

}
