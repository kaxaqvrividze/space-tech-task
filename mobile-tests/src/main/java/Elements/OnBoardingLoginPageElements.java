package Elements;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class OnBoardingLoginPageElements {
    public static By login = AppiumBy.xpath("//android.widget.Button[@content-desc=\"Use email or username\"]");
    public static By userEmail = AppiumBy.xpath("//android.widget.EditText[@resource-id='text_auto_fill']");
    public static By userPass = AppiumBy.xpath("//android.view.View[@resource-id=\"password_text_field\"]/android.widget.EditText[@resource-id=\"text_auto_fill\"]");
    public static By log_in = AppiumBy.xpath("//android.view.View[@resource-id=\"continue_button\"]");
}
