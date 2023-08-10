package seleniumBasics;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LinksPractice {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		int linksCount=driver.findElements(By.tagName("a")).size();
		System.out.println(linksCount);
		Assert.assertEquals(linksCount, 27);
		int footerLinks=driver.findElements(By.xpath("//div[@id='gf-BIG']//a")).size();
		System.out.println(footerLinks);
	}
}
