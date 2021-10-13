package com.vyomlabs.backup.generics;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFile {

	public static String getPropertyFileData(String filePath, String key)
	{
		String data=null;
		try
		{
			FileInputStream file = new  FileInputStream("./resources/config.properties");
			Properties prop = new Properties();
			prop.load(file);
			data = prop.getProperty(key);
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return data;
	}
}


