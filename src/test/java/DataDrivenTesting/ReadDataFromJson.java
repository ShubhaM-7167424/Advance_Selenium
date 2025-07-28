package DataDrivenTesting;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadDataFromJson {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
		// TODO Auto-generated method stub
		//Parse the Json Physical file into Java object notation
		// parser class, Helps read JSON file
//		Creates a parser object. This helps convert the JSON file into a Java-readable format.
		JSONParser parser = new JSONParser();
		
//		Opens and reads JSON file
//		Reads the DataProperties.json file (from the ConfigData folder) and parses it into a generic Java object.
		Object obj = parser.parse(new FileReader("./ConfigData/DataProperties.json"));
		
		//Convert the java object into json object (type casting)
		JSONObject obj1 = (JSONObject)obj;
		
		//read the data using get() by passing key
		System.out.println(obj1.get("Browser"));
		System.out.println(obj1.get("Url"));
		System.out.println(obj1.get("Username"));
		System.out.println(obj1.get("Password"));
		String Browser =obj1.get("Browser").toString();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(obj1.get("Url").toString());
		
		
	}

}
