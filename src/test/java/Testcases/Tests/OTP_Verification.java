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
        OTP_Verify.OTP(driver);
        if(driver.findElementByAccessibilityId("Set 4 digit PIN").isDisplayed()){
            Assert.assertTrue(true);
        }
    }
}
