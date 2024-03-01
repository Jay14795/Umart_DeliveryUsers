package Network_Test;
import java.io.IOException;

public class NetworkTest {

    public static void turnOnWiFi() {

        try {
            Runtime.getRuntime().exec("adb shell svc wifi enable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void turnOffWiFi() {
        // Execute ADB command to disable Wi-Fi
        try {
            Runtime.getRuntime().exec("adb shell svc wifi disable");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toggleAirplaneMode(boolean enable) {
        // Execute ADB command to toggle airplane mode
        try {
            if (enable) {
                Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 1");
            } else {
                Runtime.getRuntime().exec("adb shell settings put global airplane_mode_on 0");
            }
            // Broadcast an intent to inform the system about the airplane mode change
            Runtime.getRuntime().exec("adb shell am broadcast -a android.intent.action.AIRPLANE_MODE --ez state " + enable);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
