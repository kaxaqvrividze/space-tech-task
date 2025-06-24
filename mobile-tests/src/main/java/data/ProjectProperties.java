package data;

import utils.PropertiesReader;

public class ProjectProperties {

    public static final String APPIUM_URL = PropertiesReader.getInstance().getProperty("appium.server");
    public static final String PLATFORM_NAME = PropertiesReader.getInstance().getProperty("platform.name");
    public static final String DEVICE_NAME = PropertiesReader.getInstance().getProperty("device.name");
    public static final String AUTOMATION_NAME = PropertiesReader.getInstance().getProperty("automation.name");
    public static final String APP_PACKAGE = PropertiesReader.getInstance().getProperty("app.package");
    public static final String APP_ACTIVITY = PropertiesReader.getInstance().getProperty("app.activity");
    public static final String APP_WAIT_ACTIVITY = PropertiesReader.getInstance().getProperty("app.wait.activity");
    public static final Boolean AUTO_GRANT_PERMISSIONS = Boolean.valueOf(PropertiesReader.getInstance().getProperty("auto.grant.permissions"));
    public static final String APP = PropertiesReader.getInstance().getProperty("app");

    public static final String USERNAME = PropertiesReader.getInstance().getProperty("user.username");
    public static final String PASSWORD = PropertiesReader.getInstance().getProperty("user.password");
}
