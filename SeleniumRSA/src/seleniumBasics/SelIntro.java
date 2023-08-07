package seleniumBasics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelIntro {

	public static void main(String[] args) {
		
		//WebDriver driver = new ChromeDriver();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/");
		driver.manage().window().maximize();
		System.out.println(driver.getTitle());
		driver.close();
	}

}
