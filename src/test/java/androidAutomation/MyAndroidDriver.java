package androidAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver implements DriverSource {

    public static AndroidDriver driver;

    @Override
    public AndroidDriver newDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Galaxy Note8");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("appPackage", "com.snapchat.android");
        capabilities.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.ENABLE_PROFILING_CAPABILITY,true);
        capabilities.setCapability("autoAcceptAlerts", "true");
        capabilities.setCapability("android.permission.READ_PROFILE","PROTECTION_NORMAL");
        capabilities.setCapability("android.permission.CAMERA","PROTECTION_NORMAL");
        capabilities.setCapability("android.permission.RECORD_AUDIO","PROTECTION_NORMAL");
        capabilities.setCapability("android.permission.READ_EXTERNAL_STORAGE","PROTECTION_NORMAL");
        try {
            driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @Override
    public boolean takesScreenshots() {
        return false;
    }

    public static Dimension screenDimensions;
    public static int appTopYCoordinate;
    public static int advTopYCoordinate;

    public static class AndroidKeys {
        public static int BACK = 4;
        public static int BACKSPACE = 67;
        public static int DEL = 67;
//        public static int ENTER = 66;
        public static int HOME = 3;
        public static int MENU = 82;
        public static int SETTINGS = 176;
        public static int SPACE = 62;
        public static int RECENT_APPS = 187;
    }

    public static void getDimensions() throws Exception {
        screenDimensions = driver.manage().window().getSize();
    }

    public static void getAppTopYCoordinate() throws Exception {
        appTopYCoordinate = getElementByClassName("android.widget.FrameLayout").getLocation().y;
    }



    public static void swipeDown() throws Exception {
        driver.swipe(screenDimensions.getWidth() / 2, screenDimensions.getHeight() / 2,
                screenDimensions.getWidth() / 2, screenDimensions.getHeight() - 100, 750);
    }

    private static void swipeUp() {
        driver.swipe(screenDimensions.getWidth() / 2, screenDimensions.getHeight() / 2 + 200,
                screenDimensions.getWidth() / 2, appTopYCoordinate, 500);
    }

    public static void swipeRightToOpenMenu() {
        driver.swipe(50, screenDimensions.getHeight() / 2,
                screenDimensions.getWidth() - 100, screenDimensions.getHeight() / 2, 750);
    }

    public static AndroidElement getElementByMatchingVisibleText(String text) throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                return (AndroidElement) driver.findElementByAndroidUIAutomator("new UiSelector().descriptionMatches(\"" + text + "\").instance(0);" +
                        "new UiSelector().textMatches(\"" + text + "\").instance(0);");
            } catch (NotFoundException e) {
                if (i == 0) {
                    System.out.println("Without any swipes element hasn't been found.");
                } else {
                    System.out.println("After " + i + " swipes element wasn't found.");
                }
                swipeUp();
            }
        }
        throw new Exception("Element was not found by matching description or text after 10 swipes.");
    }

    public static AndroidElement getElementByPartOfVisibleText(String text) throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                return (AndroidElement) driver.findElementByAndroidUIAutomator("new UiSelector().descriptionContains(\"" + text + "\").instance(0);" +
                        "new UiSelector().textContains(\"" + text + "\").instance(0);");
            } catch (NotFoundException e) {
                if (i == 0) {
                    System.out.println("Without any swipes element hasn't been found.");
                } else {
                    System.out.println("After " + i + " swipes element wasn't found.");
                }
                swipeUp();
            }
        }
        throw new Exception("Element was not found by part of description or text after 10 swipes.");
    }

    public static AndroidElement getElementById(String id) throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                return (AndroidElement) driver.findElementByAndroidUIAutomator("new UiSelector().resourceId(\"" + id + "\").instance(0);");

            } catch (NotFoundException e) {
                if (i == 0) {
                    System.out.println("Without any swipes element hasn't been found.");
                } else {
                    System.out.println("After " + i + " swipes element wasn't found.");
                }
                swipeUp();
            }
        }
        throw new Exception("Element was not found by id after 10 swipes.");
    }

    public static AndroidElement getElementByClassName(String className) throws Exception {
        for (int i = 0; i < 10; i++) {
            try {
                return (AndroidElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"" + className + "\").instance(0);");
            } catch (NotFoundException e) {
                if (i == 0) {
                    System.out.println("Without any swipes element hasn't been found.");
                } else {
                    System.out.println("After " + i + " swipes element wasn't found.");
                }
                swipeUp();
            }
        }
        throw new Exception("Element was not found by classname after 10 swipes.");
    }




}