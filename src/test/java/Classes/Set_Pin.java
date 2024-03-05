package Classes;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

public class Set_Pin {
    public static void pin_add(AppiumDriver<MobileElement> driver) throws InterruptedException {
        {
            Classes.OTP_Verify.OTP(driver);
            add_pin(driver);
            Thread.sleep(3000);
            add_pin(driver);
            Thread.sleep(3000);
            driver.findElementByAccessibilityId("Confirm PIN").click();
            Thread.sleep(5000);

        }
    }

    public static void add_pin(AppiumDriver<MobileElement> driver){

        final var finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        var tapPoint = new Point(82, 493);
        var tap = new Sequence(finger1, 1);
        tap.addAction(finger1.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new PointerInput(PointerInput.Kind.TOUCH, "finger1").createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        final var finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger2");
        tapPoint = new Point(66, 1072);
        tap = new Sequence(finger2, 1);
        tap.addAction(finger2.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger2.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new PointerInput(PointerInput.Kind.TOUCH, "finger2").createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        final var finger3 = new PointerInput(PointerInput.Kind.TOUCH, "finger3");
        tapPoint = new Point(278, 1078);
        tap = new Sequence(finger3, 1);
        tap.addAction(finger3.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger3.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new PointerInput(PointerInput.Kind.TOUCH, "finger3").createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        final var finger4 = new PointerInput(PointerInput.Kind.TOUCH, "finger4");
        tapPoint = new Point(443, 1075);
        tap = new Sequence(finger4, 1);
        tap.addAction(finger4.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger4.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new PointerInput(PointerInput.Kind.TOUCH, "finger4").createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));

        final var finger5 = new PointerInput(PointerInput.Kind.TOUCH, "finger5");
        tapPoint = new Point(85, 1198);
        tap = new Sequence(finger5, 1);
        tap.addAction(finger5.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), tapPoint.x, tapPoint.y));
        tap.addAction(finger5.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(new PointerInput(PointerInput.Kind.TOUCH, "finger5").createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }
}
