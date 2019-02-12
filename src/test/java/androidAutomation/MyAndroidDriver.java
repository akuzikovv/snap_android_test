package androidAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;

public class MyAndroidDriver implements DriverSource {

    public static AndroidDriver driver;
    public static Dimension screenDimensions;
    public static int appTopYCoordinate;
    public static int advTopYCoordinate;

    @Override
    public AndroidDriver newDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Enter device Name");
        capabilities.setCapability("platformVersion", "enter platform version like 7.1.0");
        capabilities.setCapability("appPackage", "com.snapchat.android");
        capabilities.setCapability("appActivity", "com.snapchat.android.LandingPageActivity");
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