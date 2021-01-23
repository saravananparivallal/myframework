package com.sample.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sample.enums.DriverType;

public class ConfigFileReader {
private Properties properties;
private final String  propertyfilepath = "./utilities//Environment.Properties";

public ConfigFileReader() {
	BufferedReader reader;
	try {
		reader = new BufferedReader(new FileReader(propertyfilepath));
		properties = new Properties();
		properties.load(reader);
		reader.close();
	} catch(IOException e) {
		e.printStackTrace();
	}
}
public String getDriverPath() {
	String driverpath = properties.getProperty("driverpath");
	if(driverpath != null)
	return driverpath;
	else
		throw new RuntimeException("Driver path is not present");
}

public DriverType getBrowser() {
	String browserName =properties.getProperty("browser");
	if(browserName != null && browserName.equalsIgnoreCase("chrome")) {
		return DriverType.CHROME;
	}else if (browserName != null && browserName.equalsIgnoreCase("ie")) {
			return DriverType.IE;
		} else {
			throw new RuntimeException("browser is not there");
	}
}

public String getURL() {
	String url = properties.getProperty("url");
	if (url == null) 
		throw new RuntimeException("url is not mentioned");
	return url;
}

public String getHeadlessMode() {
	return properties.getProperty("browserHeadlessMode");
	
}


}
