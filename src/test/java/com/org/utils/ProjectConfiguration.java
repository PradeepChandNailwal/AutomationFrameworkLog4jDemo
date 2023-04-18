package com.org.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ProjectConfiguration {
	
	public static Properties props = new Properties();
	
	static {
		File file = new File(
				"C:\\Users\\thaku\\eclipse-workspace\\24thAutomationFrameworkDemo\\config\\ProjectConfiguraton.properties");
		try {
			FileInputStream fis = new FileInputStream(file);			
			props.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {		
		System.out.println(ProjectConfiguration.props.getProperty("username"));
	}

}
