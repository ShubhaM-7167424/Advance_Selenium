package ProrpertiesFileUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtility {
	public String getdatafrompropertiesfile(String key) throws IOException {
//		Open the properties file using FileInputStream
		FileInputStream fis = new FileInputStream("./ConfigData/ninzaCrmCommondata.properties");
//		 Create an object of Properties class
		Properties  prop = new Properties();
//		Load the file data into the Properties object
		prop.load(fis);
//		Get the values using keys from the file
		String value = prop.getProperty(key);
		
		return value;
		
				
		
	}
}
