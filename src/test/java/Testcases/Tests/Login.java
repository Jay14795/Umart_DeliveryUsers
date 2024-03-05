package Testcases.Tests;

import Network_Test.NetworkTest;
import Testcases.Base.BaseTest;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class Login extends BaseTest
{
    @Test(priority = 1)
    public void login_withoutInternet() throws InterruptedException {
        NetworkTest.turnOffWiFi();
        Thread.sleep(5000);
        Classes.Login.login(driver);

        try {
            // Wait for the element to be present and visible
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Please verify your number!")));

            if (element.isDisplayed()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Element is not visible");
            }
        } catch (TimeoutException e) {
            // If element is not found within the specified wait time, assert false
            Assert.fail("Element is not visible");
        }
    }
    @Test(priority = 2)
    public void login_withAirplaneModeTrue() throws InterruptedException {
        Classes.Login.login(driver);
        NetworkTest.toggleAirplaneMode(true);
        Thread.sleep(5000);

        try {
            // Wait for the element to be present and visible
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Please verify your number!")));

            if (element.isDisplayed()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Element is not visible");
            }
        } catch (TimeoutException e) {
            // If element is not found within the specified wait time, assert false
            Assert.fail("Element is not visible");
        }
    }

    @Test(priority = 3)
    public void login_withInternet() throws InterruptedException {
        NetworkTest.turnOnWiFi();
        Thread.sleep(6000);
        Classes.Login.login(driver);
        try {
            // Wait for the element to be present and visible
            WebDriverWait wait = new WebDriverWait(driver, 10);
            MobileElement element = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Please verify your number!")));

            if (element.isDisplayed()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Element is not visible");
            }
        } catch (TimeoutException e) {
            // If element is not found within the specified wait time, assert false
            Assert.fail("Element is not visible");
        }
    }
}
