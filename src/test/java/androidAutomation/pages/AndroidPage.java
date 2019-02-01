package androidAutomation.pages;

import androidAutomation.ILocators;
import androidAutomation.MyAndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import static androidAutomation.MyAndroidDriver.*;

public class AndroidPage extends PageObject {

    public void setScreenOrientationAsValue(String arg0) {
        switch (arg0) {
            case "LANDSCAPE":
                driver.rotate(ScreenOrientation.LANDSCAPE);
                break;
            case "PORTRAIT":
                driver.rotate(ScreenOrientation.PORTRAIT);
                break;
        }
        waitABit(1500);
    }

    public void clickOnTheDeviceNameButton(String arg0) {
        switch (arg0.toUpperCase()) {
            case "BACK":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.BACK);
                waitABit(1000);
                break;
            case "BACKSPACE":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.BACKSPACE);
                waitABit(1000);
                break;
            case "DEL":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.DEL);
                waitABit(1000);
                break;
            case "ENTER":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.ENTER);
                waitABit(1000);
                break;
            case "HOME":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.HOME);
                waitABit(1000);
                break;
            case "MENU":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.MENU);
                waitABit(1000);
                break;
            case "SETTINGS":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.SETTINGS);
                waitABit(1000);
                break;
            case "SPACE":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.SPACE);
                waitABit(1000);
                break;
            case "RECENT APPS":
                driver.pressKeyCode(MyAndroidDriver.AndroidKeys.RECENT_APPS);
                waitABit(1000);
                break;
        }
    }

    public boolean checkThatAppsButtonIsEnabled() throws Exception {
        return getElementByMatchingVisibleText("Apps").isEnabled();
    }

    public void openNotifications() throws Exception {
        driver.openNotifications();
        waitFor(ExpectedConditions.visibilityOf(getElementById(ILocators.EMULATOR_CLOCK)));
    }

    public void clickOnTheHeader() throws Exception {
        getElementById(ILocators.EMULATOR_HEADER).tap(1, 1);
    }

    public void clickOnTheOptionInTheNotifications(String arg0) throws Exception {
        getElementByMatchingVisibleText(arg0).tap(1, 1);
    }

    public void setDontDisturbValueAs(String arg0) throws Exception {
        getElementByMatchingVisibleText(arg0).tap(1, 1);
        Serenity.getCurrentSession().put("DontDisturb", getElementByMatchingVisibleText(arg0).getText().replace("\n", " "));
    }

    public void setDontDisturbValueForTime(String timeEnd) throws Exception {
        int curTimeInt;
        if (getElementByPartOfVisibleText("For").getText().split(" ")[1].equalsIgnoreCase("one")){
            curTimeInt = 1;
        }
        else {
            curTimeInt = Integer.parseInt(getElementByPartOfVisibleText("For").getText().split(" ")[1]);
        }
        if (getElementByPartOfVisibleText("For").getText().split(" ")[2].contains("hour")) {
            curTimeInt *= 60;
        }
        int timeEndInt = Integer.parseInt(timeEnd.split(" ")[1]);
        if (timeEnd.split(" ")[2].contains("hour")) {
            timeEndInt *= 60;
        }

        if (timeEndInt < curTimeInt) {
            while (!getElementByPartOfVisibleText("For").getText().contains(Integer.toString(timeEndInt))) {
                getElementByMatchingVisibleText("Less time.").tap(1, 1);
            }
        } else if (timeEndInt > curTimeInt) {
            while (!getElementByPartOfVisibleText("For").getText().contains(Integer.toString(timeEndInt))) {
                getElementByMatchingVisibleText("More time.").tap(1, 1);
            }
        }
        getElementByMatchingVisibleText("Done").tap(1, 1);
    }

    public boolean checkThatNecessaryOptionInNotificationsIsTurnedOn() throws Exception {
        return getElementByMatchingVisibleText((String) Serenity.getCurrentSession().get("DontDisturb")).isEnabled();
    }

    public boolean checkThatRecentAppsAreEnabled() throws Exception {
        return getElementById(ILocators.EMULATOR_RECENT_VIEW).isEnabled();
    }

    public void dropLastApplicationFromRecentApps() throws Exception {
        AndroidElement lastRecentApp = getLastAppInRecentApps();
        Serenity.getCurrentSession().put("DroppedApp", lastRecentApp.getText());
        //  drop app by swiping
        driver.swipe(lastRecentApp.getLocation().getX(), lastRecentApp.getLocation().getY(),
                screenDimensions.getWidth() - 100, lastRecentApp.getLocation().getY(), 750);
        //  drop app by tapping close button
//        waitFor(ExpectedConditions.elementToBeClickable(getElementByPartOfVisibleText("Dismiss " + lastRecentApp.getText())));
//        getElementByPartOfVisibleText("Dismiss " + lastRecentApp.getText()).tap(1, 1);
    }

    public boolean isAppDroppedFromRecentApps() throws Exception {
        try {
            return driver.findElementByAndroidUIAutomator("new UiSelector().descriptionMatches(\"Your recent screens appear here\").instance(0);" +
                    "new UiSelector().textMatches(\"Your recent screens appear here\").instance(0);").isEnabled();
        }
        catch (NotFoundException e) {
            return !getLastAppInRecentApps().getText().equalsIgnoreCase(Serenity.getCurrentSession().get("DroppedApp").toString());
        }
    }

    public void openLastRecentApp() throws Exception {
        getLastAppInRecentApps().tap(1, 1);
    }

    public void turnWiFi(String arg0) throws Exception {
        if (arg0.equalsIgnoreCase("off")) {
            if (!driver.findElement(By.xpath(ILocators.EMULATOR_NOTIFICATIONS_WIFI_LABEL)).getText().equalsIgnoreCase("Wi-Fi")) {
                driver.tap(1, driver.findElement(By.xpath(ILocators.EMULATOR_NOTIFICATIONS_WIFI_ICO)), 1);
            }
        }
        else {
            if (!driver.findElement(By.xpath(ILocators.EMULATOR_NOTIFICATIONS_WIFI_LABEL)).getText().equalsIgnoreCase("WiredSSID")) {
                driver.tap(1, driver.findElement(By.xpath(ILocators.EMULATOR_NOTIFICATIONS_WIFI_ICO)), 1);
            }
        }
    }

    public void printDeviceSettings() throws Exception {
        String DeviceName = getDeviceName();
        System.out.println("Device name is: " + DeviceName);

        String productModel = getProductModel(DeviceName);
        System.out.println("Product model is: " + productModel);
    }

    private String getDeviceName() {
        String[] st = String.valueOf(driver.getCapabilities()).split(", ");
        for (String s : st){
            if (s.contains("DeviceName")){
                return s.split("=")[1];
            }
        }
        return "Can't find DeviceName";
    }

    private String getProductModel(String DeviceName) {
        executeCommand("/opt/genymobile/genymotion/tools/adb start-server");
        String output = executeCommand("/opt/genymobile/genymotion/tools/adb -s " + DeviceName + " shell getprop ro.product.model");
        String[] s = output.split("\n");
        return s[s.length - 1];
    }

    private String executeCommand(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output.toString();
    }

    public void openNotificationsOnSamsungS5() throws Exception {
        driver.openNotifications();
        waitFor(ExpectedConditions.visibilityOf(getElementById(ILocators.SANSUNGS5_CLOCK)));
    }

    public void openAllSettingsInNotificationsOnSamsungS5() throws Exception {
        getElementById(ILocators.SAMSUNGS5_SETTINGS_ICO).tap(1, 1);
    }

    public void turnDonTDisturbOptionOnSamsungS5(String arg0) throws Exception {
        if (arg0.equalsIgnoreCase("on")) {
            if (!getElementByPartOfVisibleText("Do not disturb").getAttribute("name").split(" ")[4].contains("enabled")) {
                getElementByMatchingVisibleText("Do not\ndisturb").tap(1, 1);
            }
        }
        else {
            if (!getElementByPartOfVisibleText("Do not disturb").getAttribute("name").split(" ")[4].contains("disabled")) {
                getElementByMatchingVisibleText("Do not\ndisturb").tap(1, 1);
            }
        }
        Serenity.getCurrentSession().put("DontDisturb", "Do not disturb");
    }

    public boolean checkThatNecessaryOptionInNotificationsIsTurnedOnOnSamsungS5() throws Exception {
        return getElementByPartOfVisibleText(Serenity.getCurrentSession().get("DontDisturb").toString()).getAttribute("name").split(" ")[4].contains("enabled");
    }

    public boolean isAppDroppedFromRecentAppsOnSamsungS5() throws Exception {
        try {
            return driver.findElementByAndroidUIAutomator("new UiSelector().descriptionMatches(\"No recently used apps\").instance(0);" +
                    "new UiSelector().textMatches(\"No recently used apps\").instance(0);").isEnabled();
        }
        catch (NotFoundException e) {
            return !getLastAppInRecentApps().getText().equalsIgnoreCase(Serenity.getCurrentSession().get("DroppedApp").toString());
        }
    }

    public void turnWiFiOnSamsungS5(String arg0) throws Exception {
        if (arg0.equalsIgnoreCase("on")) {
            if (!getElementByPartOfVisibleText("Wi-Fi").getAttribute("name").split(" ")[2].contains("enabled")) {
                driver.tap(1, getElementByPartOfVisibleText("Wi-Fi"), 1);
            }
        }
        else {
            if (!getElementByPartOfVisibleText("Wi-Fi").getAttribute("name").split(" ")[2].contains("disabled")) {
                driver.tap(1, getElementByPartOfVisibleText("Wi-Fi"), 1);
            }
        }
    }

    public void turnOffDonTDisturbOption() throws Exception {
        getElementByMatchingVisibleText("Total silence").tap(1, 1);
    }

    public void clickOnThePhoneButton() throws Exception {
        getElementByMatchingVisibleText("Phone").tap(1, 1);
    }
}