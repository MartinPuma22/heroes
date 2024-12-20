package org.example.commons.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReaderUtil {
    public static final String BASE_FILE_PATH = "./src/main/resources/";
    public static final String FILE_NAME = "application.properties";

    public static String getProperty(String propertyKey){
        String property;
        try {
            FileInputStream inputStream = new FileInputStream(BASE_FILE_PATH.concat(FILE_NAME));
            Properties properties = new Properties();
            properties.load(inputStream);
            property = properties.getProperty(propertyKey);

        } catch (IOException exception){
            throw new RuntimeException("Error reading properties", exception);
        }
        return property;
    }
}
