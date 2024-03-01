package Testcases.Tests;

import Classes.OTP_Verify;
import Testcases.Base.BaseTest;
import io.appium.java_client.MobileElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OTP_Verification extends BaseTest
{
    @Test
    public void Check_With_valid_OTP() throws InterruptedException {
        MobileElement PhoneNumber = driver.findElementByClassName("android.widget.EditText");
        PhoneNumber.click();
        PhoneNumber.sendKeys("8567567567");
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("Verify").click();
        Thread.sleep(4000);
        OTP_Verify.OTP(driver);
        driver.findElementByAccessibilityId("Verify & Continue").click();
        Thread.sleep(10000);
        if(driver.findElementByAccessibilityId("Set 4 digit PIN").isDisplayed()){
            Assert.assertTrue(true);
        }
    }
}
