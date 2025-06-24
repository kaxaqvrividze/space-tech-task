package steps;

import Elements.PostPageElements;

import static base.SetupAppium.*;

public class PostPageSteps extends PostPageElements {

    public PostPageSteps clickSelectACommunityDropDownButton(){

        findElement(selectACommunityDropDownButton).click();
        return this;

    }

    public PostPageSteps searchTestCommunity(){
        findElement(searchCommunityField).sendKeys("test");
        return this;

    }
    public PostPageSteps clickCommunityField(){
        findElement(testersCommunity).click();
        return this;
    }

    public PostPageSteps fillPostTitle(){
        findElement(postTitle).sendKeys("Space Interview");
        return this;
    }


    public PostPageSteps fillPostBody(){
        findElement(postBody).sendKeys("Passed");
        return this;
    }

    public PostPageSteps clickPostButton(){
        findElement(postButton).click();
        return this;
    }








}
