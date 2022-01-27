package com.sample.dataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.sample.enums.DriverType;
import com.sample.enums.EnvironmentType;

public class ConfigFileReader {
    private Properties properties;
    private final String propertyfilepath = "./utilities//Environment.Properties";

    public ConfigFileReader() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(propertyfilepath));
            properties = new Properties();
            properties.load(reader);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getDriverPath() {
        String driverpath = properties.getProperty("driverpath");
        if (driverpath != null)
            return driverpath;
        else
            throw new RuntimeException("Driver path is not present");
    }

    public DriverType getBrowser() {
        String browserName = properties.getProperty("browser");
        if (browserName != null && browserName.equalsIgnoreCase("chrome")) {
            return DriverType.CHROME;
        } else if (browserName != null && browserName.equalsIgnoreCase("ie")) {
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

    public EnvironmentType getEnvironment() {
        String environmentName = properties.getProperty("environment");
        if (environmentName == null || environmentName.equalsIgnoreCase("local")) return EnvironmentType.LOCAL;
        else if (environmentName.equals("remote")) return EnvironmentType.REMOTE;
        else
            throw new RuntimeException("Environment Type Key value in Configuration.properties is not matched : " + environmentName);
    }

    public long getImplicitlyWait() {
        String implicitlyWait = properties.getProperty("implicitlyWait");
        if (implicitlyWait != null) {
            try {
                return Long.parseLong(implicitlyWait);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
            }
        }
        return 30;
    }


}
