package steps;

import Elements.OnBoardingLoginPageElements;
import org.testng.Assert;

import static base.SetupAppium.findElement;


public class OnBoardingLoginPageSteps  extends OnBoardingLoginPageElements {
    public OnBoardingLoginPageSteps clickOnLogIn(){
        findElement(login).click();
        return this;
    }

    public OnBoardingLoginPageSteps checkUserLogOut(){
        Assert.assertFalse(findElement(login).isDisplayed());
        return this;
    }


    public OnBoardingLoginPageSteps fillUserEmail(String email){
        findElement(userEmail).sendKeys(email);
        return this;
    }

    public OnBoardingLoginPageSteps fillUserPass(String pass){
        findElement(userPass).sendKeys(pass);
        return this;
    }

    public OnBoardingLoginPageSteps continueToLogIn()  {
        findElement(log_in).click();
        return this;
    }


}
