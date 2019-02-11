package androidAutomation.pages;

import androidAutomation.ILocators;
import androidAutomation.MyAndroidDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.actions.Enter;

import static androidAutomation.MyAndroidDriver.driver;
import static androidAutomation.pages.JsonParse.*;
import static androidAutomation.MyAndroidDriver.getElementById;

public class ChatPage extends PageObject {

    public void enterTheReceiver(String arg0) throws Exception {
        getElementById(ILocators.Receiver).sendKeys(arg0+"\n");
    }

    public void clickOnTheChatButton() throws Exception {
        getElementById(ILocators.start_chat).tap(1, 1);
    }

    public void enterTextMessage() throws Exception {
        JsonParse.parseJson();
        getElementById(ILocators.password_field).sendKeys("This is an info about random user from (https://randomuser.me/api/) resource:" +"\n"+
                "User email: " + email + "\n" + "Description: " + description);
    }

    public void clickSendButton() throws Exception{
//        driver.pressKeyCode(MyAndroidDriver.AndroidKeys.ENTER);
        waitABit(1000);
    }
}
