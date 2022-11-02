package com.example.swip2;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestSwip {
   /* private String reportDirectory = "reports";
    private String reportFormat = "xml";
    private String testName = "Untitled";*/
    protected AndroidDriver<AndroidElement> driver = null;

    DesiredCapabilities dc = new DesiredCapabilities();


    @BeforeEach
    public void setUp() throws MalformedURLException {
        //dc.setCapability("reportDirectory", reportDirectory);
        //dc.setCapability("reportFormat", reportFormat);
        //dc.setCapability("testName", testName);
        dc.setCapability("deviceName", "Pixel_5_API_30");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion", "11");
        dc.setCapability(MobileCapabilityType.UDID, "emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.it.swip");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".ui.activity.LauncherActivity");
        //dc.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".ui.activity.LauncherActivity");
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }
    @AfterEach
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        driver = null;
    }

    @Test
    public void testUntitled() throws InterruptedException {
        driver.context("NATIVE_APP");
        driver.findElement(By.xpath("//*[@resource-id='com.it.swip:id/welcome_next']")).click();
        Thread.sleep(2000);
        driver.getKeyboard().releaseKey("79999999070");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@resource-id='com.it.swip:id/next_button']")).click();
        Thread.sleep(2000);
        driver.getKeyboard().releaseKey("6666");
        Thread.sleep(4000);

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\"com.it.swip:id/loyalty_cards_pager\")).setMaxSearchSwipes(1).setAsHorizontalList().scrollIntoView("
                        + "new UiSelector().descriptionContains(\"Loyalty\"))"));
        driver.findElement(By.xpath("//*[@class='android.view.ViewGroup']")).click();
        Thread.sleep(1500);
        //сначала обновляет экран???, а потом спускается вниз
        driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.it.swip:id/bg\")).scrollIntoView("
                + "new UiSelector().descriptionContains(\"Store\"))"));
        Thread.sleep(1000);
        driver.findElementByImage("//*[@knownSuperClass='android.widget.ImageButton']").click();
        Thread.sleep(2000);
    }
}