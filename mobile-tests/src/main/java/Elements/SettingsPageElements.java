package Elements;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class SettingsPageElements {

    public static By accountSettings = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"android:id/title\" and contains(@text, \"Account settings\")]");
    public static By switchAccountsButton = AppiumBy.xpath("//android.widget.Button[contains(@content-desc, \"Switch accounts\")]\n");
    public static By removeAccountButton = AppiumBy.xpath("//android.widget.ImageButton[@content-desc=\"Remove account\"]");
    public static By LogOutButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/confirm_remove_account_logout\"]");

}
