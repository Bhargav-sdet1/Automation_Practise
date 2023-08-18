package RSA.SeleniumFrameworkDesign;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.Test;
import RSA.TestComponents.BaseTest;
import RSA.pageObjects.ProductCatalog;

public class ErrorLoginTest extends BaseTest{
	
	@Test
	public void SubmitOrder() throws InterruptedException, IOException
	{
		
		ProductCatalog productCatalog=loginpage.loginMeth("ra@yopmail.com", "Adfg1@34");
		Assert.assertEquals("Incorrect email or password.", loginpage.getErrorMsg());
		

		
	}

}
