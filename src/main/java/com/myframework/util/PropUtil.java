package com.fasttrack22.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropUtil {

	public String getValue(String filePath,String key) {
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filePath);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.err.println("File not found:"+filePath);
		}
		
		Properties prop=new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.err.println("Unable to load properties file"+filePath);
		}
		
		String loctypevalue= prop.getProperty(key);
		return loctypevalue;
	}
	
	/**
	 * This method can be used on OR.properties file only
	 * @param key for which we want the locator
	 * @return The locator value in the form of {@code String}
	 */
	public String[] getLocator(String key) {
		
		String baseDir=System.getProperty("user.dir");
		String path=baseDir+"\\src\\main\\resources\\OR.properties";
		System.out.println("Path========="+path);
		String typevalue=getValue(baseDir+"\\src\\main\\resources\\OR.properties",key);
		return typevalue.split("##");
	}
}
