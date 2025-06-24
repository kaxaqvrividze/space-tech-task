package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesReader {
    private static PropertiesReader instance;
    private final Properties properties;

    private PropertiesReader() {
        properties = new Properties();
        String propFile = System.getProperty("user.dir") + "/src/main/resources/configuration.properties";
        try (FileInputStream fis = new FileInputStream(propFile)) {
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file: " + propFile);
        }
    }

    public static synchronized PropertiesReader getInstance() {
        if (instance == null) {
            instance = new PropertiesReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
