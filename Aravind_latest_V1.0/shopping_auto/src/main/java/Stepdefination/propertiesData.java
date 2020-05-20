package Stepdefination;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class propertiesData {
	
	static File source = new File("C:\\Users\\metrouser\\eclipse-workspace\\shopping_auto\\DataFile.properties");
	static FileInputStream dataInput;
	static Properties prop = new Properties();
	
	public static void propertyData() throws IOException {
		dataInput = new FileInputStream(source);
		prop.load(dataInput);
	}
	
	public static String username() {
		String data = prop.getProperty("username");
		return data;
		
	}
	
	public static String password() {
		String data = prop.getProperty("password");
		return data;
		
	}
	
	public static String company() {
		String data = prop.getProperty("company");
		return data;
		
	}
	
	public static String address1() {
		String data = prop.getProperty("Address");
		return data;
		
	}
	
	public static String address2() {
		String data = prop.getProperty("Address2");
		return data;
		
	}
	
	public static String city() {
		String data = prop.getProperty("City");
		return data;
		
	}
	  
	
	
	
}
