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
	
	public static String from_hh() throws IOException{
		return getPropertyObject().getProperty("from_hh");
	}
	
	public static String from_mm() throws IOException{
		return getPropertyObject().getProperty("from_mm");
	}
	
	public static String from_a() throws IOException{
		return getPropertyObject().getProperty("from_a");
	}
	
	public static String to_hh() throws IOException{
		return getPropertyObject().getProperty("to_hh");
	}
	
	public static String to_mm() throws IOException{
		return getPropertyObject().getProperty("to_mm");
	}
	
	public static String to_a() throws IOException{
		return getPropertyObject().getProperty("to_a");
	}

	public static String confirmDialogMessage() throws IOException{
		return getPropertyObject().getProperty("confirmDialogMessage");
	}
	
	public static String confirmDialogTitle() throws IOException{
		return getPropertyObject().getProperty("confirmDialogTitle");
	}

	public static String alertDialogMessage() throws IOException{
		return getPropertyObject().getProperty("alertDialogMessage");
	}
	
	public static String alertDialogTitle() throws IOException{
		return getPropertyObject().getProperty("alertDialogTitle");
	}

	WebDriver driver;
	
}

