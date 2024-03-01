package Testcases.Tests;

import Network_Test.NetworkTest;
import Testcases.Base.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

public class Login extends BaseTest
{
    @Test(priority = 1)
    public void login_withoutInternet() {
        MobileElement PhoneNumber = driver.findElementByClassName("android.widget.EditText");
        PhoneNumber.click();
        PhoneNumber.sendKeys("8567567567");
        NetworkTest.turnOffWiFi();
        driver.findElementByAccessibilityId("Verify").click();
        try {
            // Try to find the element by its accessibility ID
            driver.findElementByAccessibilityId("Please verify your number!");
            Assert.assertTrue(true, "Element is visible");
        } catch (NoSuchElementException e) {
            // If element is not found, assert false
            Assert.fail("Element is not visible");
        }
    }

    @Test(priority = 2)
    public void login_withAirplaneModeTrue() {
        MobileElement PhoneNumber = driver.findElementByClassName("android.widget.EditText");
        PhoneNumber.click();
        PhoneNumber.sendKeys("8567567567");
        driver.findElementByAccessibilityId("Verify").click();
        NetworkTest.toggleAirplaneMode(true);
        try {
            // Try to find the element by its accessibility ID
            driver.findElementByAccessibilityId("Please verify your number!");
            Assert.assertTrue(true, "Element is visible");
        } catch (NoSuchElementException e) {
            // If element is not found, assert false
            Assert.fail("Element is not visible");
        }
    }

    @Test(priority = 3)
    public void login_withInternet() throws InterruptedException {
        NetworkTest.turnOnWiFi();
        MobileElement PhoneNumber = driver.findElementByClassName("android.widget.EditText");
        PhoneNumber.click();
        PhoneNumber.sendKeys("8567567567");
        Thread.sleep(3000);

        driver.findElementByAccessibilityId("Verify").click();
        Thread.sleep(4000);
        try {
            // Try to find the element by its accessibility ID
            driver.findElementByAccessibilityId("Please verify your number!");
            Assert.assertTrue(true, "Element is visible");
        } catch (NoSuchElementException e) {
            // If element is not found, assert false
            Assert.fail("Element is not visible");
        }
    }
}
