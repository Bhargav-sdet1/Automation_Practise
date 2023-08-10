package seleniumBasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class AutomationExercise {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//*[@id='checkBoxOption3']")).click();
		String Option3=driver.findElement(By.xpath("//*[@id='checkBoxOption3']")).getAttribute("value");
		System.out.println(Option3);
		
		driver.findElement(By.xpath("//*[@id='dropdown-class-example']")).click();
		WebElement ele=driver.findElement(By.xpath("//*[@id='dropdown-class-example']"));
		Select sel= new Select(ele);
		sel.selectByValue(Option3);
		
		driver.findElement(By.xpath("//*[@id='name']")).sendKeys(Option3);
		
		driver.findElement(By.xpath("//*[@value='Alert']")).click();
		String alertmsg=driver.switchTo().alert().getText();
		System.out.println(alertmsg);
		String[] split=alertmsg.split(" ");
		System.out.println(split[1].trim());
		String[] out=split[1].split(",");
		System.out.println(out[0]);
		driver.switchTo().alert().accept();
		Assert.assertEquals(Option3, out[0]);				
	}

}
