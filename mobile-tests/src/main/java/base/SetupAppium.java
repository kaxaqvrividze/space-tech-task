package base;

import data.ProjectProperties;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import java.net.MalformedURLException;
import java.net.URL;



public class SetupAppium {

    public static AndroidDriver driver;


    public static WebElement findElement(By element) {
        return driver.findElement(element);
    }

    @BeforeSuite
    public void androidDriverSetUp() {
        try {
            UiAutomator2Options capabilities = new UiAutomator2Options();
            capabilities.setPlatformName(ProjectProperties.PLATFORM_NAME);
            capabilities.setDeviceName(ProjectProperties.DEVICE_NAME);
            capabilities.setAutomationName(ProjectProperties.AUTOMATION_NAME);
            capabilities.setAppPackage(ProjectProperties.APP_PACKAGE);
            capabilities.setAppActivity(ProjectProperties.APP_ACTIVITY);
            capabilities.setAppWaitActivity(ProjectProperties.APP_WAIT_ACTIVITY);
            capabilities.setAutoGrantPermissions(ProjectProperties.AUTO_GRANT_PERMISSIONS);
            capabilities.setApp(ProjectProperties.APP);
            capabilities.setFullReset(true);

            driver = new AndroidDriver(new URL(ProjectProperties.APPIUM_URL), capabilities);



        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
