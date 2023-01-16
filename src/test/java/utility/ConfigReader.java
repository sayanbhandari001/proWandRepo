package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class ConfigReader {
	public static Properties getPropertyObject() throws IOException
	{
		File file = new File("config.properties"); 
		FileInputStream fp = new FileInputStream(file);
		 Properties prop = new Properties();
		 prop.load(fp);
		 return prop;
	}
	
	public static String getUrl() throws IOException {
		return getPropertyObject().getProperty("url");
	}
	
	public static String getUsername() throws IOException {
		return getPropertyObject().getProperty("username");
	}
	
	public static String getPassword() throws IOException {
		return getPropertyObject().getProperty("password");
	}
	
	public static String getprojectData() throws IOException {
		return getPropertyObject().getProperty("getprojectTaskData");
	}
	WebDriver driver;
	
}

