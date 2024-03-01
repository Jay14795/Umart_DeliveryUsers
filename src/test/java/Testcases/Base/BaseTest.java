package Testcases.Base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BaseTest {
    protected AppiumDriver<MobileElement> driver;

    @BeforeMethod
    public void setUp() {
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("deviceName", "Galaxy A12");
        dc.setCapability("platformName", "Android");
        dc.setCapability("UDID", "RZ8R20ZZKWP");
        dc.setCapability("platformVersion", "12");
        dc.setCapability("app","D:\\Automated Projects\\Umart_DeliveryUsers\\src\\test\\java\\Apps\\Umart_DeliveryusersDev\\app-release.apk");
        dc.setCapability("appPackage", "com.umart.driver");
        dc.setCapability("appActivity", "com.umart.driver.MainActivity");
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("newCommandTimeout", 7200); // 2 hours
        dc.setCapability("autoDismissAlerts", true);
        dc.setCapability("autoDismissKeyguard", true);
        dc.setCapability("locationServicesAuthorized", true);
        dc.setCapability("autoGrantPermissions", true);
        dc.setCapability("enableAdbShell", true);
        dc.setCapability("allow-cors", true);

        try {
            //URL: 127.0.0.1
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), dc);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Implicit wait
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected boolean isPermissionPopupDisplayed() {
        try {
            return driver.findElement(By.id("com.android.permissioncontroller:id/permission_message")).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    protected void allowPermission() throws InterruptedException {
        driver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button")).click();
        Thread.sleep(3000);
    }
}
