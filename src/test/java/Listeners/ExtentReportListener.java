package Listeners;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import java.util.Date;
public class ExtentReportListener implements ITestListener {
    private static ExtentReports extent = ExtentManager.createInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    private static ThreadLocal<Date> startTime = new ThreadLocal<>();


    @Override
    public synchronized void onStart(ITestContext context) {
    }

    @Override
    public synchronized void onFinish(ITestContext context) {
        extent.flush();
    }


    @Override
    public synchronized void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
        test.set(extentTest);

        // Adding project metadata
        extentTest.assignAuthor("Created by: Jay Gandhi");
        extentTest.assignDevice("Samsung M12");
        extentTest.assignCategory("App Version: V12.0");
        extentTest.assignCategory("Network Information: Wifi");
        extentTest.getModel().setStartTime(new Date(result.getStartMillis()));
    }

    @Override
    public synchronized void onTestSuccess(ITestResult result) {
        test.get().log(Status.PASS, MarkupHelper.createLabel(result.getName() + " - Test Case Passed", ExtentColor.GREEN));
        calculateDuration();

    }

    @Override
    public synchronized void onTestFailure(ITestResult result) {
        test.get().log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));

        WebDriver driver = ((WebDriver) result.getTestContext().getAttribute("driver"));
        String base64Screenshot = "data:image/png;base64," + ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
        test.get().addScreenCaptureFromBase64String(base64Screenshot);

        test.get().fail(result.getThrowable()); // Log exception stack trace
        calculateDuration();

    }

    @Override
    public synchronized void onTestSkipped(ITestResult result) {
        test.get().log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.ORANGE));
        calculateDuration();

    }

    @Override
    public synchronized void onTestFailedButWithinSuccessPercentage(ITestResult result) {
    }

    private synchronized void calculateDuration() {
        Date start = startTime.get();
        if (start != null) {
            long duration = new Date().getTime() - start.getTime();
            test.get().getModel().getEndTime().setTime(start.getTime() + duration);
        }
    }
}
