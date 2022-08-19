package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider {
	Properties pro;
	public ConfigDataProvider() {
		File src=new File("./Config/Config.properties");
		try {
			FileInputStream fis=new FileInputStream(src);
		    pro=new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to read config file>>"+e.getMessage());
		}
	}
	
	public String getBrowser() {
		return pro.getProperty("browser");
	}
	
	public String getStagingUrl() {
		return pro.getProperty("appURL");
	}
	
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
}
