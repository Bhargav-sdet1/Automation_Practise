package RSA.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {

	public void getJsonDataToMap() throws IOException
	{
		FileUtils.readFileToString(new File 
		(System.getProperty("user.dir"+"\\src\\test\\java\\RSA\\Data\\PurchaseOrder.json")),
		StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		
		
	
	}
}
