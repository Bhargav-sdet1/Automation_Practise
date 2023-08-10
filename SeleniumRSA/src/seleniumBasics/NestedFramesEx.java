package seleniumBasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NestedFramesEx {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://the-internet.herokuapp.com/nested_frames");
		driver.manage().window().maximize();
		driver.switchTo().frame("frame-top");
		Thread.sleep(1000);
		driver.switchTo().frame("frame-middle");
		String text=driver.findElement(By.xpath("//div[@id='content']")).getText();
		System.out.println(text);
		driver.close();
	}

}
