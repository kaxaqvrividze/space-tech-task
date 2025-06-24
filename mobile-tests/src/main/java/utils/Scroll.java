package utils;

import base.SetupAppium;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class Scroll {

    public static void scrollUntilVisible(int postViewCount) {
        AndroidDriver driver = SetupAppium.driver;



        int maxScrolls = 10;
        int alreadyScrolled = 0;

        var size = driver.manage().window().getSize();
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);
        int startX = size.width / 2;

        while (alreadyScrolled < maxScrolls) {
            List<WebElement> postFooters = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(d -> d.findElements(By.xpath("//android.view.View[@resource-id='post_footer']")));

            System.out.println("Scroll #" + (alreadyScrolled + 1) + ": found " + postFooters.size() + " posts");

            if (postFooters.size() >= postViewCount) {
                System.out.println("✅ Reached desired post count: " + postFooters.size());
                return;
            }

            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);

            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), startX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

            driver.perform(List.of(swipe));

            alreadyScrolled++;
        }

        throw new RuntimeException("Could not find enough posts after scrolling");
    }


}
