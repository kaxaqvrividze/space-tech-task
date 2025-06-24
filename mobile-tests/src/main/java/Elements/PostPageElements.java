package Elements;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class PostPageElements {
    public static By selectACommunityDropDownButton = AppiumBy.xpath("//android.view.View[@content-desc=\"Post to Select a community\"]");
    public static By searchCommunityField =AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.reddit.frontpage:id/search_view\"]");
    public static By testersCommunity = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.reddit.frontpage:id/community_name\" and @text=\"r/testTaSpace\"]");
    public static By postTitle = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"post_title_field\"]");
    public static By postBody = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"post_body_field\"]");
    public static By postButton = AppiumBy.xpath("//android.view.View[@resource-id=\"action_button\"]/android.view.View/android.view.View/android.widget.Button");

}
