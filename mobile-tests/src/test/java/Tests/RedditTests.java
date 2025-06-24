package Tests;

import data.ProjectProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.HomePageSteps;
import steps.OnBoardingLoginPageSteps;
import steps.PostPageSteps;
import steps.SettingsPageSteps;
import utils.Scroll;
import base.SetupAppium;
import java.time.Duration;

public class RedditTests extends SetupAppium {

    private OnBoardingLoginPageSteps onBoardingLoginPageSteps;
    private HomePageSteps homePageSteps;
    private SettingsPageSteps settingsPageSteps;
    private PostPageSteps postPageSteps;

    @BeforeMethod
    public void setUp() {
        androidDriverSetUp();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        onBoardingLoginPageSteps = new OnBoardingLoginPageSteps();
        homePageSteps = new HomePageSteps();
        settingsPageSteps = new SettingsPageSteps();
        postPageSteps = new PostPageSteps();


//შესაძლოა ყველა ტესტზე ზოგადად არ იყოს საჭირო Login და აქ იმიტო არ გამაქვს
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }


    }

    @Test(priority = 1,description = "სისტემაში შესვლა/გამოსვლა")
    public void loginLogOutTest() {
        onBoardingLoginPageSteps.clickOnLogIn()
                .fillUserEmail(ProjectProperties.USERNAME)
                .fillUserPass(ProjectProperties.PASSWORD)
                .continueToLogIn();
        homePageSteps.clickProfileAvatarButton()
                .clickSettingsButton();
        settingsPageSteps.clickAccountSettings()
                .clickSwitchAccountsButton()
                .clickRemoveAccountButton()
                .clickLogOutButton();
        onBoardingLoginPageSteps .checkUserLogOut();
    }

    @Test(priority = 2,description = "დაპოსტვა")
    public void loginCreatePost() {
        onBoardingLoginPageSteps.clickOnLogIn()
                .fillUserEmail(ProjectProperties.USERNAME)
                .fillUserPass(ProjectProperties.PASSWORD)
                .continueToLogIn();
        homePageSteps.clickCreatePostButton();
        postPageSteps.clickSelectACommunityDropDownButton()
                .searchTestCommunity()
                .clickCommunityField()
                .fillPostTitle()
                .fillPostBody()
                .clickPostButton();
    }

    @Test(priority = 3,description = "მოძებნე/დააკლიკე upvote-ს")
    public void SearchAndUpVotePost() {
        onBoardingLoginPageSteps.clickOnLogIn()
                .fillUserEmail(ProjectProperties.USERNAME)
                .fillUserPass(ProjectProperties.PASSWORD)
                .continueToLogIn();
        homePageSteps.clickHomePageSearchButton()
                .homePageSearchField("merab dvalishvili")
                .clickFirstSuggestSearchedContent()
                .clickFirstSearchedContent()
                .clickUpVoteButton()
                .clickUpVoteButton();


    }
    @Test(priority = 4,description = "Brain Rot Scroll")
    public void brainRotScroll() {
        onBoardingLoginPageSteps.clickOnLogIn()
                .fillUserEmail(ProjectProperties.USERNAME)
                .fillUserPass(ProjectProperties.PASSWORD)
                .continueToLogIn();
              Scroll.scrollUntilVisible(5);



    }
}
