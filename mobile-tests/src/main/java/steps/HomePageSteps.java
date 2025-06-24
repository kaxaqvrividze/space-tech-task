package steps;

import Elements.HomePageElements;

import static base.SetupAppium.findElement;

public class HomePageSteps extends HomePageElements {

    public HomePageSteps clickProfileAvatarButton(){
        findElement(profileAvatarButton).click();
        return this;
    }
    public HomePageSteps clickSettingsButton(){
        findElement(settingsButton).click();
        return this;
    }

    public HomePageSteps clickHomePageSearchButton(){
        findElement(homePageSearchButton).click();
        return this;
    }

    public HomePageSteps homePageSearchField(String text){
        findElement(homePageSearchField).sendKeys(text);
        return this;
    }


    public HomePageSteps clickFirstSuggestSearchedContent(){
        findElement(suggestSearchedContent).click();
        return this;
    }
  public HomePageSteps clickFirstSearchedContent(){
        findElement(firstSearchedContent).click();
        return this;
    }
  public HomePageSteps clickUpVoteButton(){
        findElement(upVoteButton).click();
        return this;
    }


    public HomePageSteps clickCreatePostButton(){
        findElement(createPostButton).click();
        return this;
    }

}
