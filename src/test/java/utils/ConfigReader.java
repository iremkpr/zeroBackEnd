package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.FileNotFoundException;

public class ConfigReader {
	private static Properties prop;	/**
		 * This method will read the properties file
		 * 
		 * @param filePath
		 */
		public static void readProperties(String filePath) {
			FileInputStream fis;
			try {
				fis = new FileInputStream(filePath);
				prop = new Properties();
				prop.load(fis);
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}	/**
		 * This method will return the value for a specific key
		 * 
		 * @param String key
		 * @return String value
		 */
		public static String getProperty(String key) {
			return prop.getProperty(key);
	
}
}