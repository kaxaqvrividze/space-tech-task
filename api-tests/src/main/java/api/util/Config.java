package api.util;

import lombok.SneakyThrows;

import java.io.InputStream;
import java.util.Optional;
import java.util.Properties;

public class Config {

    public static final String BASE_URI;
    public static final String API_KEY;
    private static final Properties properties = new Properties();

  static {
      loadProperties();

      BASE_URI = getProperty("base.url");
      API_KEY = getProperty("api.key.value");




  }

  @SneakyThrows
  private static void loadProperties(){
      InputStream inputStream = Config.class.getClassLoader().getResourceAsStream("config.properties");
    properties.load(inputStream);

  }


  private static String getProperty(String key){
      return Optional.ofNullable(System.getProperty(key))
              .or(() -> Optional.ofNullable(properties.getProperty(key)))
              .filter(value -> !value.trim().isEmpty())
              .orElseThrow(() -> new IllegalStateException("Missing Value for key: " +key));
  }
}
