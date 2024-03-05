package Testcases.Tests;

import Classes.OTP_Verify;
import Classes.Set_Pin;
import Testcases.Base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class Pin_Set extends BaseTest {
    public void setPin() throws InterruptedException {
        Set_Pin.pin_add(driver);

        if (driver.findElement(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.View/android.view.View/android.view.View/android.view.View")).isDisplayed()){
            Assert.assertTrue(true);
        }
    }
}
