package androidAutomation;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

public class MyAndroidDriver implements DriverSource {

    public static AndroidDriver driver;

    @Override
    public AndroidDriver newDriver() {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("appium-version", "1.6.0");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Nexus 5");
        capabilities.setCapability("platformVersion", "8.0");

        String userDir = System.getProperty("user.dir");
        String localApp = "Snapchat.apk";
        String appPath = Paths.get(userDir, localApp).toAbsolutePath().toString();
        capabilities.setCapability("app", appPath);
        capabilities.setCapability("appPackage", "com.allrecipes.spinner.free");
        capabilities.setCapability("appActivity", "com.allrecipes.spinner.free.MainActivity");
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
        public static int ENTER = 66;
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

    public static void getAdvTopYCoordinate() throws Exception {
        advTopYCoordinate = getElementById(androidAutomation.ILocators.APP_ADV).getLocation().y;
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

    public static AndroidElement getLastAppInRecentApps() throws Exception {
        List<AndroidElement> titlesListOfRecentApps = driver.findElements(By.xpath(androidAutomation.ILocators.EMULATOR_TITLES_OF_RECENT_APPS));
        AndroidElement lastRecentApp = titlesListOfRecentApps.get(0);
        for (AndroidElement androidElement : titlesListOfRecentApps) {
            if (androidElement.getLocation().getY() > lastRecentApp.getLocation().getY()) {
                lastRecentApp = androidElement;
            }
        }
        return lastRecentApp;
    }


}