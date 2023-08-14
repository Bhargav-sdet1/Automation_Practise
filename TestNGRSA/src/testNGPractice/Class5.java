package testNGPractice;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Class5 {
	
	@Parameters({"URL"})
	@Test
	public void param(String UrlName)
	{
		System.out.println(UrlName);
	}
}
