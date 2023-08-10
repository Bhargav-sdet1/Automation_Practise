package seleniumBasics;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class BrokenLinksEx {

	public static void main(String[] args) throws IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/AutomationPractice/#");
		driver.manage().window().maximize();
		
		SoftAssert sa = new SoftAssert();
		List<WebElement> links=driver.findElements(By.xpath("//div[@id='gf-BIG']//a"));
		for(WebElement lin:links)
		{
			String urlLi =lin.getAttribute("href");
			HttpURLConnection conn = (HttpURLConnection)new URL(urlLi).openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int resCode=conn.getResponseCode();
			System.out.println(resCode);
			sa.assertTrue(resCode<400, urlLi+"is broken");			
		}		
		sa.assertAll();
	}

}
