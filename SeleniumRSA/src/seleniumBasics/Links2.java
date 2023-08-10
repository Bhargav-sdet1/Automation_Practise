package seleniumBasics;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Links2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement footerOne=driver.findElement(By.xpath("//div[@id='gf-BIG']//td[1]//ul"));
		int FooterOneSize=footerOne.findElements(By.tagName("a")).size();
		System.out.println(FooterOneSize);
		for(int i=1;i<FooterOneSize;i++)
		{
			String keysControl=Keys.chord(Keys.CONTROL,Keys.ENTER);
			footerOne.findElements(By.tagName("a")).get(i).sendKeys(keysControl);	
			Thread.sleep(3000);
		}
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			System.out.println(driver.getTitle());
		}
		driver.close();
	}

}
