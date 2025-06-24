package Elements;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;

public class HomePageElements {

    public static By profileAvatarButton = AppiumBy.xpath("//android.view.View[@resource-id=\"avatar\"]/android.widget.Button");
    public static By settingsButton = AppiumBy.xpath("//android.widget.Button[@resource-id=\"com.reddit.frontpage:id/drawer_nav_settings\"]");
    public static By  createPostButton = AppiumBy.xpath("//android.widget.TextView[@resource-id=\"bottom_nav_button_label\" and @text=\"Create\"]");
    public static By  homePageSearchButton = AppiumBy.xpath("//android.view.View[@resource-id=\"main_top_app_bar_search\"]/android.view.View/android.view.View/android.widget.Button");
    public static By   homePageSearchField = AppiumBy.xpath("//android.widget.EditText[@resource-id=\"com.reddit.frontpage:id/search\"]");
    public static By suggestSearchedContent = AppiumBy.xpath("//android.view.View[@resource-id=\"feed_lazy_column\"]/android.view.View[1]");
    public static By   firstSearchedContent = AppiumBy.xpath("(//android.view.View[@resource-id=\"search_post_section\"])[1]");
    public static By   upVoteButton = AppiumBy.xpath("//android.view.View[@resource-id=\"voteButtonGroup_upvote\"]/android.widget.Button");

}
