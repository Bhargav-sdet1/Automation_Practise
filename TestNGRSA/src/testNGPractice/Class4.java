package testNGPractice;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Class4 {
	
	@Test(dataProvider="LoginData")
	public void getData(String Uname, String Pwd)
	{
		System.out.println(Uname);
		System.out.println(Pwd);
	}
	
	@DataProvider()
	public Object[][] LoginData()
	{
		Object[][] data = new Object[3][2];
		
		data[0][0]="UName1";
		data[0][1]="Pwd1";
		
		data[1][0]="UName2";
		data[1][1]="Pwd2";
		
		data[2][0]="UName3";
		data[2][1]="Pwd3";
		return data;
	}
}
