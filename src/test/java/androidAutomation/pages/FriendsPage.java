package androidAutomation.pages;

import androidAutomation.ILocators;
import net.serenitybdd.core.pages.PageObject;

import static androidAutomation.MyAndroidDriver.getElementById;

public class FriendsPage extends PageObject {

    public void clickOnFriendsButton() throws Exception {
        getElementById(ILocators.friends_button).tap(1, 1);
    }

    public void clickOnTheNewChatButton() throws Exception {
        getElementById(ILocators.new_chat_button).tap(1, 1);
    }
}
