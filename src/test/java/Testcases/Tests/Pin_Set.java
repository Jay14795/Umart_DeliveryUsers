package Testcases.Tests;

import Classes.OTP_Verify;
import Classes.Set_Pin;
import Testcases.Base.BaseTest;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Pin_Set extends BaseTest {
    public void setPin() throws InterruptedException {
        MobileElement PhoneNumber = driver.findElementByClassName("android.widget.EditText");
        PhoneNumber.click();
        PhoneNumber.sendKeys("8567567567");
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Verify").click();
        Thread.sleep(4000);
        OTP_Verify.OTP(driver);

        driver.findElementByAccessibilityId("Verify & Continue").click();
        Thread.sleep(5000);
        Set_Pin.pin_add(driver);
        Thread.sleep(3000);
        Set_Pin.pin_add(driver);
        driver.findElementByAccessibilityId("Confirm PIN").click();
        Thread.sleep(5000);

        if (driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View")).isDisplayed()){
            Assert.assertTrue(true);
        }

    }
}
