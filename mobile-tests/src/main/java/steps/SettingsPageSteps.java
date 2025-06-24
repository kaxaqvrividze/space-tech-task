package steps;
import Elements.SettingsPageElements;
import static base.SetupAppium.findElement;
public class SettingsPageSteps  extends SettingsPageElements {





    public SettingsPageSteps clickAccountSettings(){
        findElement(accountSettings).click();
        return this;
    }
    public SettingsPageSteps clickSwitchAccountsButton(){
        findElement(switchAccountsButton).click();
        return this;
    }
    public SettingsPageSteps clickRemoveAccountButton(){
        findElement(removeAccountButton).click();
        return this;
    }

    public SettingsPageSteps clickLogOutButton(){
        findElement(LogOutButton).click();
        return this;
    }
}
