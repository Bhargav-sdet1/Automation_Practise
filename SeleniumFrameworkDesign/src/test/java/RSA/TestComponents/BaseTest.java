package RSA.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import RSA.pageObjects.LoginPage;

public class BaseTest {

	public WebDriver driver;
	public LoginPage loginpage;

	public WebDriver InitializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\RSA\\resources\\GlobalData.Properties");
		prop.load(fis);

		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();			
		}
		driver.manage().window().maximize();		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		return driver;
	}
	
	@BeforeMethod
	public LoginPage LauchApplication() throws IOException
	{

		driver=InitializeDriver();
		loginpage= new LoginPage(driver);
		loginpage.goTo();
		return loginpage;
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
