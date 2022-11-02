package com.example.swip2;

import java.util.*;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.*;
//import org.openqa.selenium.devtools.SeleniumCdpConnection;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.JavascriptException;
import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.service.local.*;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.junit.jupiter.api.*;
import java.net.URL;
import java.net.MalformedURLException;
import java.util.logging.Level;

public class Calc {
    private AppiumDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName","Pixel_5_API_30");
        dc.setCapability("platformName", "Android");
        dc.setCapability("platformVersion","11.0 (R) - API 30");
        dc.setCapability(MobileCapabilityType.UDID,"emulator-5554");
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.android.calculator2");
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.calculator2.Calculator");
        driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"), dc);
        driver.setLogLevel(Level.INFO);
    }
    @Test
    public void testApp() {
        WebElement buttonTwo = driver.findElement(By.id("com.android.calculator2:id/digit_2"));
        buttonTwo.click();
        driver.findElement(By.id("com.android.calculator2:id/op_add")).click();
        driver.findElement(By.id("com.android.calculator2:id/digit_3")).click();
        WebElement result = driver.findElement(By.id("com.android.calculator2:id/result"));
        Assert.assertEquals("Result should be equals 5","5", result.getText());
    }
    @After
    public void teardown() {driver.quit();}
}